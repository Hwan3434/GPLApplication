package com.hwan3434.gplapplication.tab.person

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.FragmentPersonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonBottomSheet constructor(val person: PersonEntity): BottomSheetFragment<FragmentPersonBinding, PersonViewModel>(
    R.layout.fragment_person
) {
    override val viewModel: PersonViewModel by activityViewModels()

    override fun initStartView(savedInstanceState: Bundle?) {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }


}