package com.example.myproject.ui.information_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myproject.Event
import com.example.myproject.domain.use_cases.GetInformationByIdUseCase
import com.example.myproject.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class InformationViewModel @Inject constructor(
    private val getInformationByIdUseCase: GetInformationByIdUseCase,
    ) : BaseViewModel() {
        private val compositeDisposable: CompositeDisposable = CompositeDisposable()

        private var id: String = "key_id"
        fun setId(id: String) {
            this.id = id
        }

        private val _event = MutableLiveData<Event?>()
        val event: LiveData<Event?>
            get() = _event

        fun fetchInfo() {
            compositeDisposable.add(
                getInformationByIdUseCase(id)
                    .subscribe({
                        _event.value = Event.FetchedInfo(it)
                    }, {
                        Log.d("tag", "error")
                    })
            )

        }
    }
