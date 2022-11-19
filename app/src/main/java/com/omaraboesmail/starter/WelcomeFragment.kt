package com.omaraboesmail.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.omaraboesmail.starter.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        return binding.root
    }


}