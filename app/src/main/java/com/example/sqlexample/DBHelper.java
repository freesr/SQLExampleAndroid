package com.example.sqlexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private  static String CREATE_TABLE = "Create table "+ DatabaseSchema.TableDB.TABLE_NAME +" "+
            DatabaseSchema.TableDB._ID+ "INTEGER_PRIMARY_KEY " +" (" + DatabaseSchema.TableDB.COLUMN_FIRSTNAME+
            "TEXT, " + DatabaseSchema.TableDB.TABLE_NAME + "TEXT)";
   private static final int Databaseversion =1;
    private static final String DATABASE_NAME ="Name.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME,null,Databaseversion);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
