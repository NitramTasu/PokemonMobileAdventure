package br.com.fiap.pokemonadventure

import android.app.Activity
import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import br.com.fiap.pokemonadventure.di.components.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class MyApplication : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        this.initDagger()
        Stetho.initializeWithDefaults(this);
    }

    private fun initDagger() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }


    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}