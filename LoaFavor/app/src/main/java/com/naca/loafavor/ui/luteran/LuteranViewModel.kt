package com.naca.loafavor.ui.luteran

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naca.loafavor.data.NPC

class LuteranViewModel : ViewModel() {

    private val _Syllian = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 600, 2000, 7100, 11000, 12000, 15000, 15000, 15000, -1)

        val temp : NPC = NPC("실리안", "루테란 성", array)
        value = temp
    }

    private val _Carles = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 600, 2000, 7100, 11000, 12000, 15000, 15000, 15000, -1)

        val temp : NPC = NPC("칼스", "갈기파도 항구", array)
        value = temp
    }

    private val _Neria1 = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 400, 1100, 3400, 5200, 6800, 7000, 7000, 7000, -1)

        val temp : NPC = NPC("네리아", "루테란 성", array)
        value = temp
    }

    private val _Neria2 = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 400, 1100, 3400, 5200, 6800, 7000, 7000, 7000, -1)

        val temp : NPC = NPC("네리아", "갈기파도 항구", array)
        value = temp
    }

    private val _Bibian = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("비비안", "루테란 성", array)
        value = temp
    }

    private val _Elize_Ronaun = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("엘리제 로나운", "디오리카 평원", array)
        value = temp
    }

    private val _Noringtun_Ronaun = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("노링턴 로나운", "디오리카 평원", array)
        value = temp
    }

    private val _Tunner = MutableLiveData<NPC>().apply {
        var array : IntArray = intArrayOf(0, 100, 200, 500, 700, 800, 900, 1200, 1500, -1)

        val temp : NPC = NPC("수습 대장장이 터너", "디오리카 평원", array)
        value = temp
    }

    val Syllian: LiveData<NPC> = _Syllian
    val Carles: LiveData<NPC> = _Carles
    val Neria1: LiveData<NPC> = _Neria1
    val Neria2: LiveData<NPC> = _Neria2
    val Bibian: LiveData<NPC> = _Bibian
    val Elize_Ronaun: LiveData<NPC> = _Elize_Ronaun
    val Noringtun_Ronaun: LiveData<NPC> = _Noringtun_Ronaun
    val Tunner: LiveData<NPC> = _Tunner


}