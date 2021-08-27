package com.naca.loafavor.ui.arthemis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naca.loafavor.data.NPC

class ArthemisViewModel : ViewModel() {

    private val _Neria = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 400, 1100, 3400, 5200, 6800, 7000, 7000, 7000, -1)

        val temp : NPC = NPC("네리아", "레온하트", array)
        value = temp
    }

    private val _Siria = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("시리아", "레온하트", array)
        value = temp
    }

    private val _Beatrice = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 600, 2000, 7100, 11000, 12000, 15000, 15000, 15000, -1)

        val temp : NPC = NPC("베아트리스", "트리시온", array)
        value = temp
    }

    val Neria: LiveData<NPC> = _Neria
    val Siria: LiveData<NPC> = _Siria
    val Beatrice: LiveData<NPC> = _Beatrice

}