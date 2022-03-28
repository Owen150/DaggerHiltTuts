package com.example.daggerhilt.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
//We will define dependencies that live as long as our application does
@InstallIn(ApplicationComponent::class)
object AppModule {
    //We will only have a single instance of the below string i.e not recreating the object every time we initialize the application
    @Singleton
    @Provides
    @Named("String1")
    fun provideTestString1() = "This is a string we will inject"
}