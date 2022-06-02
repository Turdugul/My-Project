package com.example.myproject

import androidx.annotation.StringRes
import com.example.myproject.data.models.InformationEntity

sealed class Event(){
    class ShowToast(@StringRes val resId: Int): Event()
    class FetchedInfo(val info: InformationEntity): Event()
}