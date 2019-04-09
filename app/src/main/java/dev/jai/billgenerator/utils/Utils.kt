package dev.jai.billgenerator.utils

import java.math.RoundingMode
import java.text.DecimalFormat

class Utils {
    companion object {
        private const val salesTax = 10.0F;
        private const val importDuty = 5.0F;

        fun getImportDuty(price: Float): Float {
            return (price * importDuty / 100)
        }

        fun getSalesTax(price: Float): Float {
            return (price * salesTax / 100)
        }

        fun formatDecimal(value: Float): String {
            val df = DecimalFormat("#,##,###.00")
            df.roundingMode = RoundingMode.CEILING
            return df.format(Math.round(value * 20.0) / 20.0)
        }
    }
}