package com.example.paymentsapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.paymentsapp.R
import com.example.paymentsapp.databinding.FragmentPaymentsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentsFragment : Fragment(R.layout.fragment_payments) {
    private val binding by viewBinding(FragmentPaymentsBinding::bind)
    private val viewModel by viewModels<PaymentsViewModel>()
    private lateinit var adapter: PaymentsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PaymentsAdapter().apply {
            binding.rvPayments.layoutManager = LinearLayoutManager(requireContext())
            binding.rvPayments.adapter = this
        }

        viewModel.items.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.pbLoading.isVisible = it
        }

        viewModel.error.observe(viewLifecycleOwner){
            if (it != null) Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }

        binding.bLogout.setOnClickListener {
            viewModel.logOut()
            findNavController().navigate(R.id.payments_popUpTo_authorizationFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadItems()
    }
}