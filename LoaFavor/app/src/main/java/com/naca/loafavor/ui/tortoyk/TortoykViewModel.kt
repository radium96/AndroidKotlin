package com.naca.loafavor.ui.tortoyk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naca.loafavor.data.NPC

class TortoykViewModel : ViewModel() {

    private val _Mocamoca = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 200, 500, 1400, 1900, 2300, 2700, 4000, 4800, -1)

        val temp : NPC = NPC("모카모카", "모코코 마을", array)
        value = temp
    }

    private val _Dakuku = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("다쿠쿠", "모코코 마을", array)
        value = temp
    }

    private val _Totoma = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("토토마", "모코코 마을", array)
        value = temp
    }

    val Mocamoca: LiveData<NPC> = _Mocamoca
    val Dakuku: LiveData<NPC> = _Dakuku
    val Totoma: LiveData<NPC> = _Totoma

}