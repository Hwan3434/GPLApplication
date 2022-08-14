package com.hwan3434.gplapplication.tab.person

import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import com.hwan3434.gplapplication.data.table.datainterface.PersonInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    // inject component
    private val personRepo: PersonInterface
) : BaseViewModel() {


}