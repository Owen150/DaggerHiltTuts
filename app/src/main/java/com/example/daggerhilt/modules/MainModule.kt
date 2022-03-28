package com.example.daggerhilt.modules

import android.content.Context
import com.example.daggerhilt.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object MainModule {
    //We will define dependencies that live as long as our main activity does
    //Use @ActivityScoped & not @Singleton while dealing with activity components i.e.
    //The string lives as long as the activity but we will only have a single instance of it
    @ActivityScoped
    @Provides
    @Named("String2")
    fun provideTestString2(
        //Passing the value of test string 1 which is located in the AppModule as the input for test string 2
        //Will use the context from our application class i.e MyApplication.kt
        //Dagger hilt will figure out the order in which to provide the dependencies so that it can construct them in the right way
        @ApplicationContext context : Context,
        @Named("String1") testString1 : String
    ) = "${context.getString(R.string.string_to_inject)} - $testString1"
}