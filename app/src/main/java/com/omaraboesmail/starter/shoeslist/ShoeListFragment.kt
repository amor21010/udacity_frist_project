package com.omaraboesmail.starter.shoeslist

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.omaraboesmail.starter.R
import com.omaraboesmail.starter.ShoeListViewModel
import com.omaraboesmail.starter.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {


    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.shoeListViewModel = viewModel
        (requireActivity() as AppCompatActivity).supportActionBar?.show()

        getData()
inflateMenu()
        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        return binding.root
    }

    private fun inflateMenu() {

        val menuHost: MenuHost = requireActivity()


        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout_menu,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId== R.id.share)
                    findNavController().popBackStack()
                else
                    binding.root.findNavController().navigateUp()
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED )

    }


    private fun getData() {

        viewModel.shoesList.observe(viewLifecycleOwner) { list ->
            Log.e("TAG", "onCreateView:  ($list) ")
            if (list.isNotEmpty()) {
                for (e in list) {
                    val text = TextView(requireContext())
                    text.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                    binding.shoeList.addView(text)
                    text.text = e.name
                }
            } else {
                val text = TextView(requireContext())
                text.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                text.text = "There are no shoes in the list"
                binding.shoeList.addView(text)
            }

        }
    }

}