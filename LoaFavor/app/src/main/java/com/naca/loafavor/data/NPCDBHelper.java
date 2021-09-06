package com.naca.loafavor.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class NPCDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "NPC.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "NPC_List";
    private static final String TABLE_NAME_DEFAULT = "NPC_default";

    private Context context;
    private static String DATABASE_PATH = "";

    public NPCDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

        if(Build.VERSION.SDK_INT >= 17){
            DATABASE_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DATABASE_PATH ="/data/data/" + context.getPackageName() + "/databases/";
        }
        try {
            createDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDB() throws IOException{
        Log.d("CREATE", "CREATE");
        boolean isDbExist = databaseCheck();
        if(!isDbExist){
            this.getReadableDatabase();
            this.close();
            dbCopy();
            Log.d("DB_CREATE", "create");
        }
    }

    private boolean databaseCheck() {
        File dbFile = new File(DATABASE_PATH + DATABASE_NAME);
        return dbFile.exists();
    }

    private void dbCopy() throws IOException{
        InputStream in = context.getAssets().open(DATABASE_NAME);
        Log.d("COPY", "IN OPEN");

        String fileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream out = new FileOutputStream(fileName);
        Log.d("COPY", "OUT OPEN");

        byte[] buffer = new byte[1024];
        int length;
        while((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }
        out.flush();
        out.close();
        in.close();
        Log.d("COPY", "ALL CLOSE");

    }

    public void update(int _status, int _now, int _id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME +
                " SET COLUMN_STATUS='" + _status +
                "', COLUMN_NOW='" + _now +
                "' WHERE COLUMN_ID='" + _id + "'");
    }

    public ArrayList<NPC> getNPCList(int start_idx, int end_idx) {
        ArrayList<NPC> npcList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if(cursor.getCount() != 0) {
            for(int i = start_idx ; i<= end_idx;i++){
                cursor.moveToPosition(i);
                Log.d("POSITION", Integer.toString(i));
                int id = cursor.getInt(cursor.getColumnIndex("COLUMN_ID"));
                String name = cursor.getString(cursor.getColumnIndex("COLUMN_NAME"));
                String location = cursor.getString(cursor.getColumnIndex("COLUMN_LOCATION"));
                int rank = cursor.getInt(cursor.getColumnIndex("COLUMN_RANK"));
                int status = cursor.getInt(cursor.getColumnIndex("COLUMN_STATUS"));
                int now = cursor.getInt(cursor.getColumnIndex("COLUMN_NOW"));

                NPC temp_npc = new NPC(id, name, location, rank, status, now);
                npcList.add(temp_npc);
            }
        }

        return npcList;
    }

    public void reset(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME);
        db.execSQL("CREATE TABLE " + TABLE_NAME + " AS SELECT * FROM "+ TABLE_NAME_DEFAULT);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.disableWriteAheadLogging();
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
