package com.jimmysapp.mybradapp;

/**
 * Created by Demetris on 15/04/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    private static final String TAG = "DBAdapter"; //used for logging database version changes

    // Field Names:
    public static final String ROWID = "_id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String CEMAIL = "cemail";

    public static final String[] ALL_KEYS = new String[] {ROWID, NAME, SURNAME,
            USERNAME, PASSWORD, EMAIL, CEMAIL};

    // DataBase info:
    public static final String DATABASE_NAME = "RegisterList";
    public static final String DATABASE_TABLE = "Users";
    public static final int DATABASE_VERSION = 1; // The version number must be incremented each time a change to DB structure occurs.

    //SQL statement to create database
    private static final String DATABASE_CREATE_SQL =
            "CREATE TABLE " + DATABASE_TABLE
                    + " (" + ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NAME + " TEXT NOT NULL, "
                    + SURNAME + " TEXT NOT NULL, "
                    + USERNAME + " TEXT NOT NULL, "
                    + PASSWORD + " TEXT NOT NULL, "
                    + EMAIL + " TEXT NOT NULL, "
                    + CEMAIL + " TEXT NOT NULL"
                    + ");";

    private final Context context;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;


    public DBAdapter(Context ctx) {
        this.context = ctx;
        myDBHelper = new DatabaseHelper(context);
    }

    // Open the database connection.
    public DBAdapter open() {
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    // Close the database connection.
    public void close() {
    myDBHelper.close();
}

    // Add a new set of values to be inserted into the database.
    public long insertRow(String name, String surname, String username,
                          String password, String email, String cemail) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(NAME, name);
        initialValues.put(SURNAME, surname);
        initialValues.put(USERNAME, username);
        initialValues.put(PASSWORD, password);
        initialValues.put(EMAIL, email);
        initialValues.put(CEMAIL, cemail);

        // Insert the data into the database.
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    // Delete a row from the database, by rowId (primary key)
    public boolean deleteRow(long rowId) {
        String where = ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE, where, null) != 0;
    }


    public void deleteAll() {
        Cursor c = getAllRows();
        long rowId = c.getColumnIndexOrThrow(ROWID);
        if (c.moveToFirst()) {
            do {
                deleteRow(c.getLong((int) rowId));
            } while (c.moveToNext());
        }
        c.close();
    }

    // Return all data in the database.
    public Cursor getAllRows() {
        String where = null;
        Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS,
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }


    // Check if the username and password exist in the database
    public boolean Login(String username, String password) throws android.database.SQLException
    {
        Cursor mCursor = db.rawQuery("SELECT * FROM " + DATABASE_TABLE +
                " WHERE username=? AND password=?", new String[]{username,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DATABASE_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading application's database from version " + oldVersion
                    + " to " + newVersion + ", which will destroy all old data!");

            // Destroy old database:
            _db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

            // Recreate new database:
            onCreate(_db);
        }
    }

}
