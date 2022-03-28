package com.example.daggerhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Hilt inherits from the application class
@HiltAndroidApp
class MyApplication : Application()