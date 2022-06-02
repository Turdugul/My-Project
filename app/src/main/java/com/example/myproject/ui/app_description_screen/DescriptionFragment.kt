package com.example.myproject.ui.app_description_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.myproject.MediatorBetweenFragments
import com.example.myproject.databinding.FragmentDescriptionBinding
import com.example.myproject.ui.base.BaseFragment
import com.example.myproject.ui.main_screen.MainFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DescriptionFragment : BaseFragment<DescriptionViewModel, FragmentDescriptionBinding>(
    DescriptionViewModel::class.java,
    {
        FragmentDescriptionBinding.inflate(it)
    }
) {
    private lateinit var listener: MediatorBetweenFragments

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDesc.setOnClickListener {
            listener.openFragment(MainFragment())
        }

    }
    companion object {
        fun newInstance(): DescriptionFragment {
            return DescriptionFragment()
        }
    }
}