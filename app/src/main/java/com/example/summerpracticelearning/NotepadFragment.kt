package com.example.summerpracticelearning

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpracticelearning.databinding.FragmentNotepadBinding

class NotepadFragment : Fragment(R.layout.fragment_notepad) {
    private var binding: FragmentNotepadBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotepadBinding.bind(view)

        binding?.run {
            buttonToSecret.setOnClickListener {
                findNavController().navigate(
                    R.id.action_notepadFragment_to_secretFragment,
                    SecretFragment.createBundle("NotepadFragment")
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}