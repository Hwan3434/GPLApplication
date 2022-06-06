package com.hwan3434.gplapplication.tab.dashboard

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding , DashboardViewModel>(
    R.layout.fragment_dashboard
) {
    override val viewModel: DashboardViewModel by viewModels()

    override fun initStartView(savedInstanceState: Bundle?) {

    }

    override fun initDataBinding() {
        viewModel.text.observe(viewLifecycleOwner) { text ->

        }
    }

    override fun initAfterBinding() {
    }


}