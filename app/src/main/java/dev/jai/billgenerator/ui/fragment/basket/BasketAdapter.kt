package dev.jai.billgenerator.ui.fragment.basket

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.jai.billgenerator.R
import dev.jai.billgenerator.databinding.ItemBasketBinding
import dev.jai.billgenerator.model.Basket

class BasketAdapter : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {
    private val baskets: MutableList<Basket> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val binding: ItemBasketBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_basket, parent, false
        )
        return ViewHolder(binding, this)
    }

    override fun getItemCount(): Int {
        return baskets.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.basket = baskets[position]
        viewHolder.binding.ivClose.tag = position
        viewHolder.binding.spinnerCategory.setSelection(baskets[position].categoryId)
    }

    fun addItem(basket: Basket) {
        baskets.add(basket)
        notifyDataSetChanged()
    }

    fun getItems(): MutableList<Basket> {
        return baskets
    }

    fun removeItem(position: Int) {
        baskets.removeAt(position)
        notifyDataSetChanged()
    }

    class ViewHolder(binding: ItemBasketBinding, adapter: BasketAdapter) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemBasketBinding = binding
        val adapter: BasketAdapter = adapter

        init {
            binding.ivClose.setOnClickListener { v ->
                adapter.removeItem(v.tag as Int)
            }
        }
    }
}