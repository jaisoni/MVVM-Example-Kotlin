package dev.jai.billgenerator.ui.activity.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dev.jai.billgenerator.R
import dev.jai.billgenerator.databinding.ActivityMainBinding
import dev.jai.billgenerator.model.Basket
import dev.jai.billgenerator.ui.base.BaseActivity
import dev.jai.billgenerator.ui.fragment.basket.BasketFragment
import dev.jai.billgenerator.ui.fragment.bill.BillFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        mViewModel = MainViewModel()
        mBinding.viewModel = mViewModel
        showBasket()
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    fun showBasket() {
        showFragment(BasketFragment())
        mViewModel.title.set(getString(R.string.title_bucket));

    }

    fun showBill(items: MutableList<Basket>) {
        val fragment = BillFragment()
        val bundle = Bundle()
        bundle.putParcelableArrayList(BillFragment.PARAM_LIST, items.toCollection(ArrayList()))
        fragment.arguments = bundle
        showFragment(fragment)
        mViewModel.title.set(getString(R.string.title_bill));
    }

    private fun showFragment(fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        manager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }
}
