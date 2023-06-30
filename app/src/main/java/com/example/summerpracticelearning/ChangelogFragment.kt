package com.example.summerpracticelearning

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpracticelearning.databinding.FragmentChangelogBinding

class ChangelogFragment : Fragment(R.layout.fragment_changelog) {
    private var binding: FragmentChangelogBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChangelogBinding.bind(view)

        binding?.run {
            buttonToSecret.setOnClickListener {
                findNavController().navigate(
                    R.id.action_changelogFragment_to_secretFragment,
                    SecretFragment.createBundle("ChangelogFragment")
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}