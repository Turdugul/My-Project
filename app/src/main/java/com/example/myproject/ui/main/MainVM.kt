package com.example.myproject.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myproject.domain.models.User
import com.example.myproject.domain.use_cases.GetUserUseCase
import com.example.myproject.ui.base.BaseEvent
import com.example.myproject.ui.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainVM @Inject constructor(
    private val getUserUseCase: GetUserUseCase
): BaseVM() {

    private val _user =  MutableLiveData<List<User>>()
    val user: LiveData<List<User>>
        get() = _user

    fun getUser(){
        disposable.add(
            getUserUseCase()
                .subscribe({
                    _user.value = it
                },{
                    _event.value = BaseEvent.ShowToast(it.message ?: "")
                })
        )
    }
}