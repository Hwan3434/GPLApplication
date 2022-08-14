package com.hwan3434.gplapplication.tab.dashboard

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding , GpViewModel>(
    R.layout.fragment_dashboard
) {
    override val viewModel: GpViewModel by activityViewModels()

    override fun initStartView(savedInstanceState: Bundle?) {

        


    }

    override fun initDataBinding() {


        viewModel.person.observe(viewLifecycleOwner) { _personList ->


        }


    }

    override fun initAfterBinding() {
    }


}