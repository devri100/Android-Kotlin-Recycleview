package com.demo.base.di

import com.demo.base.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector (modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity

}