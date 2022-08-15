package com.hwan3434.gplapplication.tab.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.FragmentDashboardBinding
import com.hwan3434.gplapplication.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, GpViewModel>(
    R.layout.fragment_notifications
) {

    override val viewModel: GpViewModel by activityViewModels()

    override fun initStartView(savedInstanceState: Bundle?) {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

        binding.personBtn.setOnClickListener {

            var p = PersonEntity(
                personKey = "",
                alive = true,
                name = "",
                family = "",
                clan = "",
                generator = 33,
                gender = true,
                spouse = 0,
                dateDeath = "",
            )

            viewModel.insert(p)
        }

        binding.personBtn2.setOnClickListener {


        }

    }


}