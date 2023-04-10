package com.example.sqlexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    DBHelper dbhelper  = new DBHelper(this);
    //dbhelper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhelper.getWritableDatabase();
        addTableEntry("vikas","sree");
    }

    private void addTableEntry(String firstname, String lastname){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(DatabaseSchema.TableDB.COLUMN_FIRSTNAME,firstname);
        values.put(DatabaseSchema.TableDB.COLUMN_LASTNAME,lastname);
        long rowId = db.insert(DatabaseSchema.TableDB.TABLE_NAME,null,values);
        Log.i("ID", String.valueOf(rowId));
    }

    private void readTableEntries(){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        String[] projections = {
                BaseColumns._ID,
                DatabaseSchema.TableDB.COLUMN_FIRSTNAME,
                DatabaseSchema.TableDB.COLUMN_LASTNAME
        };
        String selection = DatabaseSchema.TableDB.COLUMN_FIRSTNAME+ " = ?";
        String[] selectArgs = {"Vikas"};
        String sortOrder = DatabaseSchema.TableDB.COLUMN_FIRSTNAME + " DESC ";

        Cursor cursor = db.query(DatabaseSchema.TableDB.TABLE_NAME,projections,selection,selectArgs,null,null,sortOrder);
        while(cursor.moveToNext()){
            String[] names = cursor.getColumnNames();
            for(int i=0;i<names.length;i++){
                int index = cursor.getColumnIndex(names[i]);
                String value = cursor.getString(index);
                Log.i("values",value);

            }
        }
        cursor.close();
    }
}