package com.naca.loafavor.data;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NPCRepository {

    private final String TABLE_NAME = "NPC_List";
    private SQLiteDatabase db;
    private NPCDBHelper dbHelper;

    public NPCRepository(Application application){
        dbHelper = new NPCDBHelper(application);
    }

    public Cursor getCursor() {
        db = dbHelper.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

//    public String getData(int idx){
//        Cursor c = getCursor();
//    }
}
