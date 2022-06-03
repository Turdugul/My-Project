package com.example.myproject.ui.information_screen

import android.os.Bundle
import android.view.View
import com.example.myproject.Event
import com.example.myproject.data.models.InformationEntity
import com.example.myproject.databinding.FragmentInformationBinding
import com.example.myproject.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationFragment : BaseFragment<InformationViewModel, FragmentInformationBinding>(
    InformationViewModel::class.java,
    {
        FragmentInformationBinding.inflate(it)
    }
){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString(KEY_ID)?.let { viewModel.setId(it) }
        viewModel.fetchInfo()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }


    private fun subscribeToLiveData() {
        viewModel.event.observe(viewLifecycleOwner) {
            when (it) {
                is Event.FetchedInfo -> fillInformation(it.info)
            }
        }
    }

    private fun fillInformation(it: InformationEntity) {
        binding.txtInfo.text = it.info
    }


    companion object {
        const val KEY_ID = "key_id"
        fun newInstance(id: String): InformationFragment {
            val args = Bundle().apply { putString(KEY_ID, id) }
            return InformationFragment().apply { arguments = args }
        }
    }
}