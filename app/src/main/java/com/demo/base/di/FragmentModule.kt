package com.demo.base.di

import com.demo.base.ui.SampleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeSampleFragment(): SampleFragment

}