package com.example.daggerhilt.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.daggerhilt.R
import com.example.daggerhilt.viewmodels.TestViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

//To be able to inject dependencies into android components i.e activities, fragments, etc, use the annotation below
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Annotation will assign the value of the lateint variable behind the scenes for us i.e.,
    //Dagger hilt will search in all of its modules if it can find a string dependency and assign it to the lateint variable
    @Inject
    @Named("String1") //Showing that we want to inject string1 from the AppModule i.e differentiating the strings from each other
    lateinit var testString: String
    //Getting an instance from the Test View Model class
    private val viewModel : TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Test string from MainActivity: $testString")
        viewModel
    }
}