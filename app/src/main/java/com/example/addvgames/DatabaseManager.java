package com.example.addvgames;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context) {
        super(context, "GamesDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "create table GamerTable( ";
        sql += "id integer primary key autoincrement, ";
        sql += "title text, director text, year text)";
        db.execSQL(sql);
    }

    public void insert(String movieName, String directorName, String yearName) {
        SQLiteDatabase db =getWritableDatabase();
        String sql = "insert into GamerTable values(";
        sql += "null, '"+movieName+"', '"+directorName+"', '"+yearName+"')";
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<String> getTitles() {
        ArrayList<String> listed = new ArrayList<String>();
        SQLiteDatabase dbg = getWritableDatabase();
        String sql = "select * from GamerTable";
        Cursor curse = dbg.rawQuery(sql, null);
        while(curse.moveToNext()) {
            String game = curse.getString(1);
            listed.add(game);
        }
        dbg.close();
        return listed;
    }

    public String[] get(String gameTitle) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from GamerTable where title = '"+gameTitle+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String[3];
        if (cursor.moveToFirst()) {
            String game = cursor.getString(1);
            String studio = cursor.getString(2);
            String year = cursor.getString(3);
            entry[0] = game;
            entry[1] = studio;
            entry[2] = year;
        }
        db.close();
        return entry;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}