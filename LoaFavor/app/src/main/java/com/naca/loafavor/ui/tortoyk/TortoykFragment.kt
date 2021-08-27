package com.naca.loafavor.ui.tortoyk

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
import com.naca.loafavor.databinding.FragmentTortoykBinding
import com.naca.loafavor.ui.adapter.NPCAdapter
import java.util.*

class TortoykFragment : Fragment() {

    private lateinit var tortoykViewModel: TortoykViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentTortoykBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_tortoyk, container, false)
        binding.setLifecycleOwner(this)

        tortoykViewModel = ViewModelProvider(this).get(TortoykViewModel::class.java)

        var view : View = binding.root

        var NPCList = LinkedList<NPC>()

        NPCList.add(tortoykViewModel.Mocamoca.value!!)
        NPCList.add(tortoykViewModel.Dakuku.value!!)
        NPCList.add(tortoykViewModel.Totoma.value!!)
        binding.tortoykRecy.layoutManager = LinearLayoutManager(activity)
        binding.tortoykRecy.setHasFixedSize(true)

        var mAdapter = NPCAdapter(NPCList)

        binding.tortoykRecy.adapter = mAdapter

        return view
    }

}