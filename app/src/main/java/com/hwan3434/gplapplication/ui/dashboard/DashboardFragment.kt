package com.hwan3434.gplapplication.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.base.mvvm.BaseFragment
import com.hwan3434.gplapplication.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding , DashboardViewModel>(
    R.layout.fragment_dashboard
) {

    override val viewModel: DashboardViewModel by viewModels()

    override fun initStartView(savedInstanceState: Bundle?) {

    }

    override fun initDataBinding() {
        viewModel.text.observe(viewLifecycleOwner) { text ->
            binding.textDashboard.text = text;
        }
    }

    override fun initAfterBinding() {
    }


}