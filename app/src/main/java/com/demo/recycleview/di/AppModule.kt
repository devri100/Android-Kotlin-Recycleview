package com.demo.recycleview.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.demo.recycleview.Constants.BASE_URL
import com.demo.recycleview.api.AppService
import com.demo.recycleview.api.BooleanTypeAdapter
import com.demo.recycleview.db.AppDb
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): AppService{
        return retrofit.create(AppService::class.java)
    }

    @Singleton
    @Provides
    fun providerGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .registerTypeAdapter(Boolean::class.java, BooleanTypeAdapter())
            //.registerTypeAdapter(Boolean::class.java, BooleanTypeAdapter())
            //.excludeFieldsWithoutExposeAnnotation()
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun providerRetrofit(gson: Gson): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            //.addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()


    }

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDb {
        return Room.databaseBuilder(app, AppDb::class.java, "appDB")
            .fallbackToDestructiveMigration()
            //.allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideApplicationContext(app: Application): Context = app.applicationContext



}