package com.example.myproject.ui.welcome_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.myproject.MediatorBetweenFragments
import com.example.myproject.databinding.FragmentWelcomeBinding
import com.example.myproject.ui.app_description_screen.DescriptionFragment
import com.example.myproject.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class WelcomeFragment: BaseFragment<WelcomeViewModel, FragmentWelcomeBinding>(
    WelcomeViewModel::class.java,
    {
        FragmentWelcomeBinding.inflate(it)
    }
) {
    private lateinit var listener: MediatorBetweenFragments

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGet1.setOnClickListener {
            listener.openFragment(DescriptionFragment())
        }
    }

}