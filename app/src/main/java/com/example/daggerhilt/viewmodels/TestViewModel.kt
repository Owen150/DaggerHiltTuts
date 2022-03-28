package com.example.daggerhilt.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import javax.inject.Named

//With @ViewModelInject annotation, dagger hilt will create the view model factory in the background for us
//Injecting the dependencies into the constructor
class TestViewModel @ViewModelInject constructor(
    @Named("String2") testString2 : String
): ViewModel() {
    init {
        Log.d("ViewModel", "Test String from ViewModel : $testString2")
    }
}