package dev.jai.billgenerator.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry
import android.support.annotation.NonNull


open class BaseViewModel : ViewModel(), Observable {
    @Transient
    private var mCallbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    override fun addOnPropertyChangedCallback(@NonNull callback: Observable.OnPropertyChangedCallback) {
        synchronized(this) {
            if (mCallbacks == null) {
                mCallbacks = PropertyChangeRegistry()
            }
        }
        mCallbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(@NonNull callback: Observable.OnPropertyChangedCallback) {
        synchronized(this) {
            if (mCallbacks == null) {
                return
            }
        }
        mCallbacks.remove(callback)
    }


}