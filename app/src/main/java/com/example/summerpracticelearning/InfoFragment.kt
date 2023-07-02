package com.example.summerpracticelearning

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.summerpracticelearning.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {
    private var binding: FragmentInfoBinding? = null
    private var adapter: ItemEntryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)

        val entryID = arguments?.getInt(ARG_ENTRYID)!!
        val entry = ItemEntryRepository.list.find{
            it.id == entryID
        }
        if (entry != null) {
            binding!!.tvItemName.text = entry.name
            binding!!.tvItemDesc.text = entry.desc
            Glide.with(this)
                .load(entry.url)
                .placeholder(R.drawable.ic_baseline_settings_24)
                .error(R.drawable.bolt_48px)
                .into(binding!!.ivIcon)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ENTRYID = "ARG_ENTRYID"

        fun createBundle(entryID: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(ARG_ENTRYID, entryID)
            return bundle
        }
    }
}
