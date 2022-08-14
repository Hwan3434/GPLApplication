package com.hwan3434.gplapplication.appbase

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import kotlin.system.exitProcess

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutResourceId: Int
) : AppCompatActivity() {

    lateinit var binding: B
    /**
     * viewModel 로 쓰일 변수.
     */
    abstract val viewModel: VM

    private var _tedPermission: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    var tedPermission: LiveData<Boolean> = _tedPermission


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResourceId)
        binding.lifecycleOwner = this

        initStartView(savedInstanceState)
        initDataBinding()
        initAfterBinding()

    }


    /**
     * 레이아웃을 띄운 직후 호출.
     * 뷰나 액티비티의 속성 등을 초기화.
     * ex) 리사이클러뷰, 툴바, 드로어뷰..
     */
    abstract fun initStartView(savedInstanceState: Bundle?)

    /**
     * 두번째로 호출.
     * 데이터 바인딩 및 rxjava 설정.
     * ex) rxjava observe, databinding observe..
     */
    abstract fun initDataBinding()

    /**
     * 바인딩 이후에 할 일을 여기에 구현.
     * 그 외에 설정할 것이 있으면 이곳에서 설정.
     * 클릭 리스너도 이곳에서 설정.
     */
    abstract fun initAfterBinding()



    fun onPermission() {
        onPermissions(object : PermissionListener {
            override fun onPermissionGranted() {
                _tedPermission.value = true
            }

            override fun onPermissionDenied(deniedPermissions: List<String>) {
                exitProcess(0)
            }
        })

    }

    fun onPermissions(lis: PermissionListener){
        TedPermission.create()
            .setPermissionListener(lis)
            .setDeniedMessage("권한을 거부하셨습니다. 설정에서 권한을 수락해주세요.")
            .setPermissions(
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            .check()
    }


    fun showKeyboard(){
        val imm = getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun hideKeyboard() {
            val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val currentFocusedView = currentFocus
            if (currentFocusedView != null) {
                inputManager.hideSoftInputFromWindow(currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
    }



}