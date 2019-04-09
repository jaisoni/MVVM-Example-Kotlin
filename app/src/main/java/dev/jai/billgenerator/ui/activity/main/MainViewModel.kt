package dev.jai.billgenerator.ui.activity.main

import android.databinding.ObservableField
import dev.jai.billgenerator.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    val title: ObservableField<String> = ObservableField()
}