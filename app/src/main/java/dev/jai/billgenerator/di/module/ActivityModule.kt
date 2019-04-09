package dev.jai.billgenerator.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.jai.billgenerator.di.annotaton.ActivityScope
import dev.jai.billgenerator.ui.activity.main.MainActivity

@Module
interface ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector()
    fun contributeMainActivity(): MainActivity
}