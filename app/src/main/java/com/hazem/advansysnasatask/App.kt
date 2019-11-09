package com.hazem.advansysnasatask

import android.app.Application
import com.hazem.advansysnasatask.data.network.ApiService
import com.hazem.advansysnasatask.data.network.NetworkDataSource
import com.hazem.advansysnasatask.data.network.NetworkDataSourceImpl
import com.hazem.advansysnasatask.data.network.interceptor.ConnectivityInterceptor
import com.hazem.advansysnasatask.data.network.interceptor.ConnectivityInterceptorImpl
import com.hazem.advansysnasatask.data.repo.RepositoryApi
import com.hazem.advansysnasatask.data.repo.RepositoryApiImpl
import com.hazem.advansysnasatask.ui.fragments.home.HomeListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*

class App : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@App))
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApiService(instance()) }
        bind<NetworkDataSource>() with singleton { NetworkDataSourceImpl(instance()) }
        bind<RepositoryApi>() with singleton { RepositoryApiImpl(instance()) }
        bind() from provider { HomeListViewModelFactory(instance()) }
    }


}