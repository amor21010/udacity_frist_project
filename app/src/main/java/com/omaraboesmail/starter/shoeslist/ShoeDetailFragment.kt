package com.omaraboesmail.starter.shoeslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.omaraboesmail.starter.R
import com.omaraboesmail.starter.ShoeListViewModel
import com.omaraboesmail.starter.databinding.FragmentShoeDetailBinding
import com.omaraboesmail.starter.models.Shoe

class ShoeDetailFragment : Fragment() {


    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        var name: String
        var company: String
        var size: Double
        var description: String


        binding.add.setOnClickListener {

            try {
                name = binding.name.editText?.text.toString()
                company = binding.company.editText?.text.toString()
                description = binding.description.editText?.text.toString()
                size = binding.size.editText?.text.toString().toDouble()
                createShoe(name, company, size, description)
            } catch (e: java.lang.Exception) {
                binding.size.error = "enter valid size"
            }


        }
        return binding.root
    }



    private fun createShoe(name: String, company: String, size: Double, description: String) {
        val shoe = Shoe(name, size, company, description)

        addShoeToList(shoe)
        findNavController().navigate(
            ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        )
    }

    private fun addShoeToList(shoe: Shoe) {
        viewModel.addShoeToList(shoe)
    }


}