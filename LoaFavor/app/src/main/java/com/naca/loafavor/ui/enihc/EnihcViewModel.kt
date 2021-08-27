package com.naca.loafavor.ui.enihc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naca.loafavor.data.NPC

class EnihcViewModel : ViewModel() {

    private val _Yeoul = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 200, 500, 1400, 1900, 2300, 2700, 4000, 4800, -1)

        val temp : NPC = NPC("여울", "항구도시 창천", array)
        value = temp
    }

    private val _Sorang = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("소랑", "거울 계곡", array)
        value = temp
    }

    private val _Ryeun = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("처녀귀신 련", "소리의 숲", array)
        value = temp
    }

    val Yeoul: LiveData<NPC> = _Yeoul
    val Sorang: LiveData<NPC> = _Sorang
    val Ryeun: LiveData<NPC> = _Ryeun

}