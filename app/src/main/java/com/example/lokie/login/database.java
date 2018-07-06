package com.example.lokie.login;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    SQLiteDatabase sqdb;

    public database(Context context) {
        super(context, "User", null, 1);
        sqdb = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqldb) {
        sqldb.execSQL("create table appuser(name text,location text,age text,gender text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveappuser(String s1, String s2, String s3, String s4) {
        ContentValues cv = new ContentValues();
        cv.put("name", s1);
        cv.put("location", s2);
        cv.put("age", s3);
        cv.put("gender", s4);
        long a =sqdb.insert("appuser", null, cv);
        return a;

    }

    public String[] getuser(String s1, String s2) {

        String nm, lc, ag, gn;
        String ar[] = new String[5];
        ar[0]="hasData";
        Cursor getusr;
        getusr = sqdb.query("appuser", null, "name=? and Location=?", new String[]{s1, s2}, null, null, null);
        int a = getusr.getCount();
        if (getusr.getCount() < 1) {
            ar[0] = "empty";
        } else {
            getusr.moveToFirst();
            ar[1] = getusr.getString(getusr.getColumnIndex("name"));
            ar[2] = getusr.getString(getusr.getColumnIndex("location"));
            ar[3] = getusr.getString(getusr.getColumnIndex("age"));
            ar[4] = getusr.getString(getusr.getColumnIndex("gender"));
//            ar[1] = nm;
//            ar[2] = lc;
//            ar[3] = ag;
//            ar[4] = gn;
        }
        return ar;


    }
}
