package com.example.myproject.ui.main_screen

import androidx.lifecycle.LiveData
import com.example.myproject.data.models.InformationEntity
import com.example.myproject.domain.use_cases.GetAllInformationUseCase
import com.example.myproject.domain.use_cases.GetInformationAsLiveDataUseCase
import com.example.myproject.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllInformationUseCase: GetAllInformationUseCase,
    private val getInformationAsLiveDataUseCase: GetInformationAsLiveDataUseCase,
) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val weeksLiveData: LiveData<List<InformationEntity>> = getInformationAsLiveDataUseCase()

    init {
        getAllInformation()
    }

    fun getAllInformation() {
        compositeDisposable.add(
            getAllInformationUseCase()
                .subscribe()
        )
    }
}