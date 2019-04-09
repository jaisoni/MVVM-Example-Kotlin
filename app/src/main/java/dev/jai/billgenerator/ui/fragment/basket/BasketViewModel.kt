package dev.jai.billgenerator.ui.fragment.basket

import dev.jai.billgenerator.model.Basket
import dev.jai.billgenerator.ui.base.BaseViewModel

class BasketViewModel : BaseViewModel() {
    var adapter: BasketAdapter = BasketAdapter()

    fun addRow() {
        var bucket = Basket("", "", "", 3, false)
        adapter.addItem(bucket)
    }
}