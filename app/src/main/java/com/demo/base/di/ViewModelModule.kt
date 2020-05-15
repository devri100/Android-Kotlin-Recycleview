package com.demo.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.base.ViewModelFactory
import com.demo.base.ui.SampleViewModel
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