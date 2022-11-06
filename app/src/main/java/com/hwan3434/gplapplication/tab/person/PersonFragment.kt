package com.hwan3434.gplapplication.tab.person

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.hwan3434.gplapplication.GpActivity
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.log.logd
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.FragmentPersonBinding
import com.hwan3434.gplapplication.tab.dashboard.list.DashBoardRecyclerAdapter
import com.hwan3434.gplapplication.tab.person.list.PersonSonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonFragment : BaseFragment<FragmentPersonBinding, PersonViewModel>(
    R.layout.fragment_person,
) , PersonSonAdapter.OnSonClickListsner{

    private val activityViewModel: GpViewModel by activityViewModels()
    override val viewModel: PersonViewModel by viewModels()

    private var myPerson : PersonEntity = PersonEntity()

    private val personAdapter: PersonSonAdapter by lazy {
        PersonSonAdapter(this)
    }

    override fun initStartView(savedInstanceState: Bundle?) {
        viewModel.updateViewModelPerson(myPerson)
        binding.sonRecycler.adapter = personAdapter
    }

    override fun initDataBinding() {
        viewModel.viewPerson.observe(viewLifecycleOwner) {
            binding.me = it

            binding.goMap.visibility = if(it.alive) View.GONE else View.VISIBLE

            activityViewModel.personData.value?.let { persons ->
                var spouseVisible = View.GONE
                var fatherVisible = View.GONE
                var matherVisible = View.GONE
                val sonList = mutableListOf<PersonEntity>()
                persons.forEach { person ->
                    when(person.personKey) {
                        myPerson.spouse -> {
                            spouseVisible = View.VISIBLE
                            viewModel.updateViewModelSpouse(person)
                        }
                        myPerson.father -> {
                            fatherVisible = View.VISIBLE
                            viewModel.updateViewModelFather(person)
                        }
                        myPerson.mather -> {
                            matherVisible = View.VISIBLE
                            viewModel.updateViewModelMather(person)
                        }
                    }
                    if(person.father == myPerson.personKey || person.mather == myPerson.personKey){
                        sonList.add(person)
                    }
                }
                binding.spouseView.visibility = spouseVisible
                binding.fatherView.visibility = fatherVisible
                binding.matherView.visibility = matherVisible
                if(sonList.isNotEmpty()){
                    viewModel.updateViewModelSon(sonList)
                }else {
                    viewModel.updateViewModelSon(listOf())
                }
            }
        }
        viewModel.viewSpouse.observe(viewLifecycleOwner) {
            binding.spouse = it
        }
        viewModel.viewFather.observe(viewLifecycleOwner) {
            binding.father = it
        }
        viewModel.viewMather.observe(viewLifecycleOwner) {
            binding.mather = it
        }
        viewModel.viewSon.observe(viewLifecycleOwner) {
            personAdapter.insertData(it)
        }
    }

    override fun initAfterBinding() {

        binding.spouseView.setOnClickListener{
            viewModel.viewSpouse.value?.let {
                myPerson = it
                viewModel.updateViewModelPerson(myPerson)
            }
        }

        binding.fatherLayout.setOnClickListener {
            viewModel.viewFather.value?.let {
                myPerson = it
                viewModel.updateViewModelPerson(myPerson)
            }
        }

        binding.matherLayout.setOnClickListener {
            viewModel.viewMather.value?.let {
                myPerson = it
                viewModel.updateViewModelPerson(myPerson)
            }
        }

        binding.goMap.setOnClickListener {
            activityViewModel.updateMap(myPerson)
            parentFragmentManager.popBackStack()
        }

    }

    override fun onSonClick(person: PersonEntity) {
        myPerson = person
        viewModel.updateViewModelPerson(myPerson)
    }

    fun updatePerson(person: PersonEntity){
        myPerson = person
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as GpActivity).visibleNavi(View.GONE)
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as GpActivity).visibleNavi(View.VISIBLE)
    }


}