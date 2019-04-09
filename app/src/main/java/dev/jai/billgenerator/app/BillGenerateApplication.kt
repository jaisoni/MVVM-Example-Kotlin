package dev.jai.billgenerator.app

import android.app.Activity
import android.support.multidex.MultiDexApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dev.jai.billgenerator.di.component.DaggerAppComponent
import javax.inject.Inject


class BillGenerateApplication : MultiDexApplication(),
    HasActivityInjector{

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }


    override fun onCreate() {
        super.onCreate()
        initializeComponent();
    }

    private fun initializeComponent() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this);
    }
}