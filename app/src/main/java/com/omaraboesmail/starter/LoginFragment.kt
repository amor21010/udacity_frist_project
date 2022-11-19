package com.omaraboesmail.starter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.omaraboesmail.starter.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }


    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        val action=LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)
        binding.signIn.setOnClickListener {

            findNavController().navigate(action)
        }
        binding.register.setOnClickListener {

            findNavController().navigate(action)
        }
        return binding.root
    }


}