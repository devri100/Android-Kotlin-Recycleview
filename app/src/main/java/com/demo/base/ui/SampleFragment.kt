package com.demo.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.demo.base.MainActivity
import com.demo.base.R
import com.demo.base.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SampleFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SampleViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        (requireContext() as MainActivity).sample.value = "Activity"
        Toast.makeText(context, viewModel.sample.value, Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

}
