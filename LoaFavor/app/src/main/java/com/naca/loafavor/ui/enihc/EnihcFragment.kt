package com.naca.loafavor.ui.enihc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naca.loafavor.R
import com.naca.loafavor.data.NPC
import com.naca.loafavor.databinding.FragmentEnihcBinding
import com.naca.loafavor.ui.adapter.NPCAdapter
import java.util.*

class EnihcFragment : Fragment() {

    private lateinit var enihcViewModel: EnihcViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentEnihcBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_enihc, container, false)
        binding.setLifecycleOwner(this)

        enihcViewModel = ViewModelProvider(this).get(EnihcViewModel::class.java)

        var view : View = binding.root

        var NPCList = LinkedList<NPC>()

        NPCList.add(enihcViewModel.Yeoul.value!!)
        NPCList.add(enihcViewModel.Sorang.value!!)
        NPCList.add(enihcViewModel.Ryeun.value!!)
        binding.enihcRecy.layoutManager = LinearLayoutManager(activity)
        binding.enihcRecy.setHasFixedSize(true)

        var mAdapter = NPCAdapter(NPCList)

        binding.enihcRecy.adapter = mAdapter

        return view
    }

}