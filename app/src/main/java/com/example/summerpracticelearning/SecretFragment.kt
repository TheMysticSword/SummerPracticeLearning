package com.example.summerpracticelearning

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.summerpracticelearning.databinding.FragmentSecretBinding
import com.google.android.material.snackbar.Snackbar

class SecretFragment : Fragment(R.layout.fragment_secret) {
    private var binding: FragmentSecretBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecretBinding.bind(view)

        val className = arguments?.getString(ARG_CLASSNAME)!!
        Snackbar.make(binding?.root!!, className, Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_CLASSNAME = "ARG_CLASSNAME"

        fun createBundle(className: String): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_CLASSNAME, className)
            return bundle
        }
    }
}