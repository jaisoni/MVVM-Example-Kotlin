package dev.jai.billgenerator.ui.fragment.bill

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import dev.jai.billgenerator.R
import dev.jai.billgenerator.model.Basket
import dev.jai.billgenerator.ui.base.BaseFragment
import dev.jai.billgenerator.utils.Utils
import java.util.*

class BillFragment : BaseFragment<dev.jai.billgenerator.databinding.FragmentBillBinding, BillViewModel>() {
    private lateinit var baskets: ArrayList<Basket>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baskets = arguments!!.getParcelableArrayList(PARAM_LIST)
        mViewModel = BillViewModel()
        mBinding.viewModel = mViewModel
        calculateTax(baskets)
        mViewModel.adapter.addItems(baskets)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_bill
    }

    private fun calculateTax(list: List<Basket>) {
        var totalPrice = 0F
        var totalSalesTax = 0F
        for (basket: Basket in list) {
            var price = basket.price.toFloat() * basket.quantity.toInt();
            var salesTax = 0F

            if (basket.categoryId == 3) {
                salesTax = Utils.getSalesTax(price)
            }

            if (basket.isImported) salesTax += Utils.getImportDuty(price)
            totalPrice += price + salesTax
            totalSalesTax += salesTax
            basket.price = Utils.formatDecimal(price + salesTax)
        }
        mViewModel.totalPrice.set(Utils.formatDecimal(totalPrice))
        mViewModel.salesTax.set(Utils.formatDecimal(totalSalesTax))
    }

    companion object {
        const val PARAM_LIST: String = "BasketList"
    }
}