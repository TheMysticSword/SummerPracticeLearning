package com.example.summerpracticelearning

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpracticelearning.databinding.FragmentQuitBinding

class QuitFragment : Fragment(R.layout.fragment_quit) {
    private var binding: FragmentQuitBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuitBinding.bind(view)

        binding?.run {
            buttonToSecret.setOnClickListener {
                findNavController().navigate(
                    R.id.action_quitFragment_to_secretFragment,
                    SecretFragment.createBundle("QuitFragment")
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}