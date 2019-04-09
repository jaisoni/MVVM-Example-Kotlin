package dev.jai.billgenerator.model

import android.os.Parcel
import android.os.Parcelable

data class Basket(var productName: String, var price: String, var quantity: String, var categoryId: Int, var isImported: Boolean) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte())

    fun setCategory( position: Int) {
        categoryId = position
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productName)
        parcel.writeString(price)
        parcel.writeString(quantity)
        parcel.writeInt(categoryId)
        parcel.writeByte(if (isImported) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Basket> {
        override fun createFromParcel(parcel: Parcel): Basket {
            return Basket(parcel)
        }

        override fun newArray(size: Int): Array<Basket?> {
            return arrayOfNulls(size)
        }
    }



}