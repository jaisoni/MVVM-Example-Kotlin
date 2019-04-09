package dev.jai.billgenerator.binding

import android.databinding.BindingAdapter
import android.widget.TextView
import dev.jai.billgenerator.model.Basket

class TextBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("android:text")
        fun TextView.setText(basket: Basket) {
            text = String.format(
                "%s %s: %s",
                basket.quantity, basket.productName, basket.price
            )
        }
    }
}