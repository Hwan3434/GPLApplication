package com.hwan3434.gplapplication

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hwan3434.gplapplication.appbase.BaseActivity
import com.hwan3434.gplapplication.databinding.ActivityGpBinding
import com.hwan3434.gplapplication.model.Person
import com.hwan3434.gplapplication.tab.person.PersonBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GpActivity : BaseActivity<ActivityGpBinding, GpViewModel>(
    R.layout.activity_gp
) {

    override val viewModel : GpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_gp)

        // 앱 상위 네이밍
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun initStartView(savedInstanceState: Bundle?) {
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {

    }

    fun openPerson(person: Person){
        val frag= PersonBottomSheet()
        frag.show(supportFragmentManager, frag.tag)
    }
}