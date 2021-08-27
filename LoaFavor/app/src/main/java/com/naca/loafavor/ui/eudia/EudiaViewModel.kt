package com.naca.loafavor.ui.arthemis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naca.loafavor.data.NPC

class EudiaViewModel : ViewModel() {

    private val _Thunder = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 400, 1100, 3400, 5200, 6800, 7000, 7000, 7000, -1)

        val temp : NPC = NPC("소금사막의 천둥", "살란드 구릉지", array)
        value = temp
    }

    private val _Morina = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("모리나", "오즈혼 구릉지", array)
        value = temp
    }

    private val _Urere = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 600, 2000, 7100, 11000, 12000, 15000, 15000, 15000, -1)

        val temp : NPC = NPC("장인 우르르", "레이크바", array)
        value = temp
    }

    val Thunder: LiveData<NPC> = _Thunder
    val Morina: LiveData<NPC> = _Morina
    val Urere: LiveData<NPC> = _Urere

}