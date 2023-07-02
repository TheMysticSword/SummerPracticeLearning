package com.example.summerpracticelearning

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.summerpracticelearning.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null
    private var adapter: ItemEntryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = ItemEntryAdapter(
            ItemEntryRepository.list,
            Glide.with(this),
            onItemClick = { item ->
                findNavController().navigate(
                    R.id.action_mainFragment_to_infoFragment,
                    InfoFragment.createBundle(item.id)
                )
            }
        )
        binding?.rvItemList?.adapter = adapter
    }
}
