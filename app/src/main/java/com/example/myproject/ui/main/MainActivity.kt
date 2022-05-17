package com.example.myproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myproject.databinding.ActivityMainBinding
import com.example.myproject.extensions.showToast
import com.example.myproject.ui.base.BaseActivity
import com.example.myproject.ui.base.BaseEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<MainVM, ActivityMainBinding>(
    MainVM::class.java,
    { ActivityMainBinding.inflate(it)}
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
        subscribeToLiveData()
    }

    private fun setupViews() {
        binding.run {
            button.setOnClickListener {
                vm.getUser()
            }
        }
    }

    private fun subscribeToLiveData() {
        vm.user.observe(this, {
            showToast(it.toString())
        })

        vm.event.observe(this, {
            when (it) {
                is BaseEvent.ShowToast -> showToast(it.message)
            }
        })
    }
}


