package com.example.paymentsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.models.AuthArgs
import com.example.paymentsapp.R
import com.example.paymentsapp.databinding.FragmentAuthorizationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorizationFragment : Fragment(R.layout.fragment_authorization) {
    private val binding by viewBinding(FragmentAuthorizationBinding::bind)
    private val viewModel by viewModels<AuthorizationViewModel>()

    override fun onResume() {
        super.onResume()
        viewModel.checkAuth()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bLogin.setOnClickListener{
            val login = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.logIn(
                AuthArgs(
                    login,
                    password
                )
            )
        }

        viewModel.authorized.observe(viewLifecycleOwner) {
            if (it) findNavController()
                .navigate(R.id.action_authorizationFragment_to_paymentsFragment)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.pbLoading.isVisible = it
        }

        viewModel.error.observe(viewLifecycleOwner){
            if (it != null) Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }
}