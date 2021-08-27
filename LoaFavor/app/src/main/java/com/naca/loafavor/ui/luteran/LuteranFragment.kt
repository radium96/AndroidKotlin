package com.naca.loafavor.ui.luteran

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
import com.naca.loafavor.databinding.FragmentLuteranBinding
import com.naca.loafavor.ui.adapter.NPCAdapter
import java.util.*

class LuteranFragment : Fragment() {

    private lateinit var luteranViewModel: LuteranViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentLuteranBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_luteran, container, false)
        binding.setLifecycleOwner(this)

        luteranViewModel = ViewModelProvider(this).get(LuteranViewModel::class.java)

        var view : View = binding.root

        var NPCList = LinkedList<NPC>()
        NPCList.add(luteranViewModel.Syllian.value!!)
        NPCList.add(luteranViewModel.Carles.value!!)
        NPCList.add(luteranViewModel.Neria1.value!!)
        NPCList.add(luteranViewModel.Neria2.value!!)
        NPCList.add(luteranViewModel.Bibian.value!!)
        NPCList.add(luteranViewModel.Elize_Ronaun.value!!)
        NPCList.add(luteranViewModel.Noringtun_Ronaun.value!!)
        NPCList.add(luteranViewModel.Tunner.value!!)

        binding.luteranRecy.layoutManager = LinearLayoutManager(activity)
        binding.luteranRecy.setHasFixedSize(true)

        var mAdapter = NPCAdapter(NPCList)

        binding.luteranRecy.adapter = mAdapter

        return view
    }

}