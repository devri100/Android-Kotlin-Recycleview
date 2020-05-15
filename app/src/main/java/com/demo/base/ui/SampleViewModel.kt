package com.demo.base.ui

import androidx.lifecycle.ViewModel
import com.demo.base.models.Sample
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    val sample: Sample
): ViewModel(){
}