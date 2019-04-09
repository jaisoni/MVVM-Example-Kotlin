package dev.jai.billgenerator.ui.fragment.basket

import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import dev.jai.billgenerator.R
import dev.jai.billgenerator.ui.activity.main.MainActivity
import dev.jai.billgenerator.ui.base.BaseFragment

class BasketFragment : BaseFragment<dev.jai.billgenerator.databinding.FragmentBasketBinding, BasketViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = BasketViewModel()
        mBinding.viewModel = mViewModel
        mViewModel.addRow()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_basket
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(dev.jai.billgenerator.R.menu.menu_basket, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == R.id.action_done) {
            validateFields()
            true
        } else
            super.onOptionsItemSelected(item)
    }

    private fun validateFields() {
        val count = mViewModel.adapter.getItems().filter { t ->
            TextUtils.isEmpty(t.price) ||
                    TextUtils.isEmpty(t.quantity) || TextUtils.isEmpty(t.productName)
        }.count()

        if (count > 0) {
            Toast.makeText(activity, getString(R.string.error_mendatory_field), Toast.LENGTH_LONG).show();
        } else {
            (activity as MainActivity).showBill(mViewModel.adapter.getItems())
        }
    }
}