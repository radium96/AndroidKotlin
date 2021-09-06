package com.naca.loafavor.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NPCViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<NPC>> _NPCList = new MutableLiveData<ArrayList<NPC>>();

    public LiveData<ArrayList<NPC>> NPCList = _NPCList;

    NPCDBHelper dbHelper;

    public NPCViewModel(@NonNull Application application) {
        super(application);
        dbHelper = new NPCDBHelper(application);
    }

    public void setList(int start_idx, int end_idx){
        ArrayList<NPC> temp_list = dbHelper.getNPCList(start_idx, end_idx);
        _NPCList.setValue(temp_list);
    }

    public LiveData<ArrayList<NPC>> getNPCList() {
        return NPCList;
    }

    public void update(NPC npc) {
        dbHelper.update(npc.getStatus_int(), npc.getNowFigure(), npc.getId());
    }
}
