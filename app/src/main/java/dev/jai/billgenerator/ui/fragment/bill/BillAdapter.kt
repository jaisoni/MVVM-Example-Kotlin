package dev.jai.billgenerator.ui.fragment.bill

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.jai.billgenerator.R
import dev.jai.billgenerator.databinding.ItemBillBinding
import dev.jai.billgenerator.model.Basket

class BillAdapter : RecyclerView.Adapter<BillAdapter.ViewHolder>() {
    private val list: MutableList<Basket> = mutableListOf<Basket>();

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val binding: ItemBillBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_bill, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.basket = list.get(position)
    }

    fun addItems(list: List<Basket>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(binding: ItemBillBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemBillBinding = binding
    }
}