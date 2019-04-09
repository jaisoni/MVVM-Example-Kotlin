package dev.jai.billgenerator.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dev.jai.billgenerator.di.annotaton.ApplicationContext
import dev.jai.billgenerator.ui.fragment.basket.BasketAdapter
import javax.inject.Singleton


@Module()
internal object AppModule {
    @Provides
    @Singleton
    @JvmStatic
    @ApplicationContext
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @JvmStatic
    fun provideBasketAdapter(): BasketAdapter {
        return BasketAdapter()
    }
}