package com.demo.recycleview.di

import com.demo.recycleview.ui.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeSampleFragment(): ListFragment

}