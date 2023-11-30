package com.example.paymentsapp.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Payments
import com.example.paymentsapp.databinding.ItemPaymentBinding
import java.util.Date

class PaymentViewHolder(
    private val binding: ItemPaymentBinding
) : RecyclerView.ViewHolder(
    binding.root
) {
    fun bind(item:Payments) {
        binding.tvTitle.text = item.title
        binding.tvAmount.text = item.amount.toString()
        binding.tvDate.text = item.created?.run{
            Date(this.toLong()).toString()
        }
    }
}