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
//We will define dependencies that live as long as our main activity does
@InstallIn(ActivityComponent::class)
object MainModule {

    //Use @activity scoped & not @singleton while dealing with Activity components i.e.
    //The string lives as long as the activity but we will only have a single instance of it
    @ActivityScoped
    @Provides
    @Named("String2")
    fun provideTestString2(
        //Passing the value of test string 1 in the AppModule as the input for test string 2
        //Will use the context that we can get from our application class i.e MyApplication.kt so as to be able to get our string from the string resources
        //Dagger hilt will figure out the order in which to provide the dependencies so that it can construct them in the right way
        @ApplicationContext context : Context,
        @Named("String1") testString1 : String
    ) = "${context.getString(R.string.string_to_inject)} - $testString1"
}