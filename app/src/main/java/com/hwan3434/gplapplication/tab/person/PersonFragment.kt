package com.hwan3434.gplapplication.tab.person

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.hwan3434.gplapplication.GpActivity
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.databinding.FragmentPersonBinding
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import com.hwan3434.gplapplication.tab.person.list.PersonSonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

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
        lifecycleScope.launchWhenStarted {
            viewModel.viewPerson.collectLatest {
                binding.me = it

                binding.goMap.visibility = if (it.alive) View.GONE else View.VISIBLE

                var spouseVisible = View.GONE
                var fatherVisible = View.GONE
                var matherVisible = View.GONE
                val sonList = mutableListOf<PersonEntity>()
                activityViewModel.allInfo.value.persons.forEach { person ->
                    when (person.personKey) {
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
                    if (person.father == myPerson.personKey || person.mather == myPerson.personKey) {
                        sonList.add(person)
                    }
                }
                binding.spouseView.visibility = spouseVisible
                binding.fatherView.visibility = fatherVisible
                binding.matherView.visibility = matherVisible
                if (sonList.isNotEmpty()) {
                    viewModel.updateViewModelSon(sonList)
                } else {
                    viewModel.updateViewModelSon(listOf())
                }
            }

        }

        lifecycleScope.launchWhenStarted {
            viewModel.viewSpouse.collectLatest {
                binding.spouse = it
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.viewFather.collectLatest {
                binding.father = it
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.viewMather.collectLatest {
                binding.mather = it
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.viewSon.collectLatest {
                personAdapter.insertData(it.sortedBy { p ->
                    p.generator + if(p.gender) 0.1 else -0.1
                })
            }
        }

    }

    override fun initAfterBinding() {

        binding.spouseView.setOnClickListener{
            myPerson = viewModel.viewSpouse.value
            viewModel.updateViewModelPerson(myPerson)
        }

        binding.fatherLayout.setOnClickListener {
            myPerson = viewModel.viewFather.value
            viewModel.updateViewModelPerson(myPerson)
        }

        binding.matherLayout.setOnClickListener {
            myPerson = viewModel.viewMather.value
            viewModel.updateViewModelPerson(myPerson)
        }

        binding.goMap.setOnClickListener {
            activityViewModel.updateMap(myPerson)
            parentFragmentManager.popBackStack()
        }

        binding.backBtn.setOnClickListener{
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
        (activity as GpActivity).visibleNavi(View.INVISIBLE)
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as GpActivity).visibleNavi(View.VISIBLE)
    }


}