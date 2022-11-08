package com.hwan3434.gplapplication.tab.notifications

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, GpViewModel>(
    R.layout.fragment_notifications,
) {

    override val viewModel: GpViewModel by activityViewModels()

    override fun initStartView(savedInstanceState: Bundle?) {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

        binding.personBtn.setOnClickListener {

        }

        binding.personBtn2.setOnClickListener {


        }

    }


}