package dev.jai.billgenerator.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dev.jai.billgenerator.app.BillGenerateApplication
import dev.jai.billgenerator.di.module.ActivityModule
import dev.jai.billgenerator.di.module.AppModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, ActivityModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BillGenerateApplication)
}