package com.example.myproject.ui.main_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.MediatorBetweenFragments
import com.example.myproject.databinding.FragmentMainBinding
import com.example.myproject.ui.base.BaseFragment
import com.example.myproject.ui.information_screen.InformationFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>(
    MainViewModel::class.java,
    {
        FragmentMainBinding.inflate(it)
    }
){
    private lateinit var listener: MediatorBetweenFragments
    private lateinit var adapter: Adapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.getAllBooks()
        subscribeToLiveData()
        setUpViews()
    }

    private fun setUpViews(){
        val recycler = binding.recycler
        adapter = Adapter {
            listener.openFragment(InformationFragment.newInstance(it.objectId))
        }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

    }

    private fun subscribeToLiveData() {
        viewModel.weeksLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
