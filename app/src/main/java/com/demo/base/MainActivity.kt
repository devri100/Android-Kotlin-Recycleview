package com.demo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.base.models.Sample
import com.demo.base.ui.SampleFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var sample: Sample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SampleFragment())
                .commit()
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector

}
