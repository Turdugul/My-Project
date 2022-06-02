package com.example.myproject

import androidx.fragment.app.Fragment

interface MediatorBetweenFragments {
    fun openFragment(fragment: Fragment, addToBackStack: Boolean? = true)
}