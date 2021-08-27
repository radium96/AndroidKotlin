package com.naca.loafavor.ui.arthemis

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
import com.naca.loafavor.databinding.FragmentArthemisBinding
import com.naca.loafavor.ui.adapter.NPCAdapter
import java.util.*

class ArthemisFragment : Fragment() {

    private lateinit var arthemisViewModel: ArthemisViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentArthemisBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_arthemis, container, false)
        binding.setLifecycleOwner(this)

        arthemisViewModel = ViewModelProvider(this).get(ArthemisViewModel::class.java)

        var view : View = binding.root

        var NPCList = LinkedList<NPC>()
        NPCList.add(arthemisViewModel.Neria.value!!)
        NPCList.add(arthemisViewModel.Siria.value!!)
        NPCList.add(arthemisViewModel.Beatrice.value!!)


        binding.arthemisRecy.layoutManager = LinearLayoutManager(activity)
        binding.arthemisRecy.setHasFixedSize(true)

        var mAdapter = NPCAdapter(NPCList)


        binding.arthemisRecy.adapter = mAdapter

        return view
    }

}