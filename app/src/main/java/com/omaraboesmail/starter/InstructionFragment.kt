package com.omaraboesmail.starter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.omaraboesmail.starter.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

private lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_instruction, container, false)
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }
        return binding.root
    }



}