package com.example.georgi.sqliteexample;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MyActivity extends Activity {

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        MehSQLiteHelper sqLiteHelper = new MehSQLiteHelper();
        database = sqLiteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Losers.TABLE.LOSERNAME.toString(), "gosho");
        database.insert(Losers.TABLE_NAME, null, contentValues);
        int position = 5;
        database.delete(Losers.TABLE_NAME, "id = ? AND ", new String[]{position + ""});

        Cursor c = database.rawQuery("SELECT ?,? FROM LOSERS;", new String[]{"LOSERNAME", "ID"});
        while (c.moveToNext()) {
            String losername = c.getString(Losers.TABLE.LOSERNAME.ordinal());
            int id = c.getInt(Losers.TABLE.ID.ordinal());

        }

        c.close();
        //DELETE FROM LOSERS;
//(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
        database.query(true,Losers.TABLE_NAME, null, "ID = ?", new String[] {3 + ""}, null, null, null, null );
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        contentValues.put(Losers.TABLE.LOSERNAME.toString(), "lucho");
        database.update(Losers.TABLE_NAME, contentValues, "id = ?", new String[] {3 + ""});
        new View(MyActivity.this).animate().x(500).y(600).start();
    }

    private class MehSQLiteHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "meh";

        public MehSQLiteHelper() {
            super(MyActivity.this, DB_NAME, null, 0);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE " + Losers.TABLE_NAME +
                            " ( " + Losers.TABLE.ID + " integer auto_increment primary key, "
                            + Losers.TABLE.LOSERNAME + " text " + " )");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
            sqLiteDatabase.execSQL("DROP DATABASE IF EXIST " + DB_NAME);
            onCreate(sqLiteDatabase);
        }
    }
}
