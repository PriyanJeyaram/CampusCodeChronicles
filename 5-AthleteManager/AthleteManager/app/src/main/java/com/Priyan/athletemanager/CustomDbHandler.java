package com.Priyan.athletemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//The class must extend SQLiteOpenHelper
public class CustomDbHandler extends SQLiteOpenHelper {

    private static final int DB_Version = 1;
    private static final String DB_Name = "AthleteChain";
    private static final String TABLE_Name = "details";
    private static final String KEY_Id = "id";
    private static final String KEY_Name = "name";
    private static final String KEY_Age = "age";
    private static final String KEY_Height = "height";
    private static final String KEY_Weight = "weight";
    private static final String KEY_Game = "gamename";

//    Needs a super call that contains 4 params: context, dbName, cursorFactory, version
    public CustomDbHandler(Context context) {
        super(context, DB_Name, null, DB_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        Create the table
        String createTableQueryString = new StringBuilder()
                .append("CREATE TABLE IF NOT EXISTS ").append(TABLE_Name).append(" (\n")
                .append(KEY_Id).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n")
                .append(KEY_Name).append(" VARCHAR(25) NOT NULL,\n")
                .append(KEY_Age).append(" INTEGER NOT NULL,\n")
                .append(KEY_Height).append(" DOUBLE NOT NULL,\n")
                .append(KEY_Weight).append(" DOUBLE NOT NULL,\n")
                .append(KEY_Game).append(" VARCHAR(25) NOT NULL\n);").toString();
//        Execute the Query by execSQL(query)
        sqLiteDatabase.execSQL(createTableQueryString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

//        String dropTableQueryString = " DROP TABLE IF EXISTS " + TABLE_Name + ";";
        String dropTableQueryString = new StringBuilder().append("DROP TABLE IF EXISTS ")
                .append(TABLE_Name).append(";").toString();
        sqLiteDatabase.execSQL(dropTableQueryString);
        onCreate(sqLiteDatabase);
    }

//    insert method
    public boolean addAthlete(String name, int age, double height, double weight, String gameName) {
        ContentValues values = new ContentValues();
        values.put(KEY_Name, name);
        values.put(KEY_Age, age);
        values.put(KEY_Height, height);
        values.put(KEY_Weight, weight);
        values.put(KEY_Game, gameName);
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TABLE_Name, null, values) != -1; //Returns -1 on insertion failure
    }

//    Get All Athlete Data from the TABLE
    public Cursor getAllAthletes() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_Name, null);
    }

//    update the values
    boolean updateAthlete(int id, String name, int age, double height, double weight, String gameName) {
        ContentValues values = new ContentValues();
        values.put(KEY_Name, name);
        values.put(KEY_Age, age);
        values.put(KEY_Height, height);
        values.put(KEY_Weight, weight);
        values.put(KEY_Game, gameName);
        SQLiteDatabase db = getWritableDatabase();
        return db.update(TABLE_Name, values, KEY_Id + "=?", new String[] {String.valueOf(id)}) == 1;
    }

    boolean deleteAthlete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_Name, KEY_Id + "=?", new String[] {String.valueOf(id)}) == 1;
    }
}
