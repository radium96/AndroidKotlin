package com.naca.loafavor.ui.eudia

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
import com.naca.loafavor.databinding.FragmentEudiaBinding
import com.naca.loafavor.ui.adapter.NPCAdapter
import com.naca.loafavor.ui.arthemis.EudiaViewModel
import java.util.*

class EudiaFragment : Fragment() {

    private lateinit var eudiaViewModel: EudiaViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentEudiaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_eudia, container, false)
        binding.setLifecycleOwner(this)

        eudiaViewModel = ViewModelProvider(this).get(EudiaViewModel::class.java)

        var view : View = binding.root

        var NPCList = LinkedList<NPC>()
        NPCList.add(eudiaViewModel.Thunder.value!!)
        NPCList.add(eudiaViewModel.Morina.value!!)
        NPCList.add(eudiaViewModel.Urere.value!!)


        binding.eudiaRecy.layoutManager = LinearLayoutManager(activity)
        binding.eudiaRecy.setHasFixedSize(true)

        var mAdapter = NPCAdapter(NPCList)


        binding.eudiaRecy.adapter = mAdapter

        return view
    }

}