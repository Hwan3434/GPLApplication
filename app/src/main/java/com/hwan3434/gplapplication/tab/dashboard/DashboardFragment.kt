package com.hwan3434.gplapplication.tab.dashboard

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.databinding.FragmentDashboardBinding
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import com.hwan3434.gplapplication.tab.dashboard.list.DashBoardRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding , GpViewModel>(
    R.layout.fragment_dashboard,
), DashBoardRecyclerAdapter.OnPersonClickListsner {

    override val viewModel: GpViewModel by activityViewModels()

    private val personAdapter: DashBoardRecyclerAdapter by lazy {
        DashBoardRecyclerAdapter(this)
    }

    override fun initStartView(savedInstanceState: Bundle?) {
        binding.dashboardRecyclerView.adapter = personAdapter
    }

    override fun initDataBinding() {
        lifecycleScope.launchWhenStarted {
            viewModel.personData.collectLatest { item ->
                personAdapter.insertData(item.sortedBy {
                    it.generator + if(it.gender) 0.1 else -0.1
                })
            }
        }
    }

    override fun initAfterBinding() {

    }

    override fun onPersonClick(person: PersonEntity) {
        super.openPersonView(person)
    }

}