package com.example.daggerhilt.activities

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Hilt inherits from the application class
@HiltAndroidApp
class MyApplication : Application()