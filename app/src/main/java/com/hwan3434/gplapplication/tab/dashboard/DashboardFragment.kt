package com.hwan3434.gplapplication.tab.dashboard

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.log.logd
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding , GpViewModel>(
    R.layout.fragment_dashboard
) {
    override val viewModel: GpViewModel by activityViewModels()

    private val personAdapter: DashBoardRecyclerAdapter by lazy {
        DashBoardRecyclerAdapter()
    }

    override fun initStartView(savedInstanceState: Bundle?) {

        binding.dashboardRecyclerView.adapter = personAdapter

    }

    override fun initDataBinding() {

        viewModel.personData.observe(viewLifecycleOwner) { item ->
            logd("오호라! : ${item.size}")
            personAdapter.insertData(item)
        }


    }

    override fun initAfterBinding() {


    }


}