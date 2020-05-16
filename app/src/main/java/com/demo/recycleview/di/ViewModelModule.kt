package com.demo.recycleview.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.recycleview.ViewModelFactory
import com.demo.recycleview.ui.SampleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("UNUSED")
@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    abstract fun bindBejelentkezesViewModel(viewModel: SampleViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}