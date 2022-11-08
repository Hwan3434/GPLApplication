package com.hwan3434.gplapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.hwan3434.gplapplication.appbase.BaseActivity
import com.hwan3434.gplapplication.databinding.ActivityGpBinding
import com.hwan3434.gplapplication.tab.dashboard.DashboardFragment
import com.hwan3434.gplapplication.tab.home.HomeFragment
import com.hwan3434.gplapplication.tab.notifications.NotificationsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class GpActivity : BaseActivity<ActivityGpBinding, GpViewModel>(
    R.layout.activity_gp
) {

    override val viewModel : GpViewModel by viewModels()

    private val homeFragment = HomeFragment()
    private val dashboardFragment = DashboardFragment()
    private val notificationsFragment = NotificationsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = resources.getString(R.string.title_home)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_gp, homeFragment)
            .add(R.id.nav_host_fragment_activity_gp, dashboardFragment)
            .add(R.id.nav_host_fragment_activity_gp, notificationsFragment)
            .hide(dashboardFragment)
            .hide(notificationsFragment)
            .commitNow()

        binding.navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> {
                    supportActionBar?.title = resources.getString(R.string.title_home)
                    supportFragmentManager.beginTransaction()
                        .hide(dashboardFragment)
                        .hide(notificationsFragment)
                        .show(homeFragment)
                        .commitNow()
                }
                R.id.navigation_dashboard -> {
                    supportActionBar?.title = resources.getString(R.string.title_dashboard)
                    supportFragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(notificationsFragment)
                        .show(dashboardFragment)
                        .commitNow()
                }
                R.id.navigation_notifications -> {
                    supportActionBar?.title = resources.getString(R.string.title_notifications)
                    supportFragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .hide(dashboardFragment)
                        .show(notificationsFragment)
                        .commitNow()
                }
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment_activity_gp).navigateUp()

    override fun initStartView(savedInstanceState: Bundle?) {
    }

    override fun initDataBinding() {
        lifecycleScope.launchWhenStarted {
            viewModel.changedCamera.collectLatest {
                binding.navView.selectedItemId = R.id.navigation_home
            }
        }
    }

    override fun initAfterBinding() {

    }

    fun visibleNavi(visible: Int) {
        binding.navView.visibility = visible
    }


}