package com.example.paymentsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.models.Payments
import com.example.paymentsapp.databinding.ItemPaymentBinding

class PaymentsAdapter: ListAdapter<Payments,
        PaymentViewHolder>(object : DiffUtil.ItemCallback<Payments>(){
    override fun areContentsTheSame(oldItem: Payments, newItem: Payments): Boolean {
        return oldItem==newItem
    }

    override fun areItemsTheSame(oldItem: Payments, newItem: Payments): Boolean {
        return oldItem==newItem
    }
        }
        ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        return PaymentViewHolder(ItemPaymentBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}