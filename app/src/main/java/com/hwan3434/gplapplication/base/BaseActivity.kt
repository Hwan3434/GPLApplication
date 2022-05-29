package com.hwan3434.gplapplication.base

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlin.system.exitProcess

open class BaseActivity : AppCompatActivity() {

    private var _tedPermission: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    var tedPermission: LiveData<Boolean> = _tedPermission

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


}