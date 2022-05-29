package sg.edu.np.mad.madpractical2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    Boolean boolVal;
    public static String DATABASE_NAME = "users.db";
    public static String ACCOUNTS = "Accounts";
    public static String COLUMN_NAME = "name";
    public static String COLUMN_DESCRIPTION = "description";
    public static Integer COLUMN_ID = 0;
    public static Integer COLUMN_FOLLOWED = 0;
    public static int DATABASE_VERSION = 1;

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super (context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String CREATE_ACCOUNT_TABLE = "CREATE TABLE " + ACCOUNTS + "(" + COLUMN_NAME + "TEXT," + COLUMN_DESCRIPTION + "TEXT" + COLUMN_ID + "0" + COLUMN_FOLLOWED + "0" + ")";
        db.execSQL(CREATE_ACCOUNT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + ACCOUNTS);
    }

    public void addUsers(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_DESCRIPTION, user.getDescription());
        values.put(String.valueOf(COLUMN_ID), user.getId());
        if (user.getFollowed()){
            values.put(String.valueOf(COLUMN_FOLLOWED), 1);
        }
        else {
            values.put(String.valueOf(COLUMN_FOLLOWED), 0);
        }

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ACCOUNTS, null, values);
        //db.close();
    }

    public ArrayList<User> findUser(String userName){
        String query = "SELECT * FROM " + ACCOUNTS + "WHERE " + COLUMN_NAME + "=\"" + userName + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<User> accountList = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                if (cursor.getInt(3) == 1){
                    boolVal = false;
                }
                else if (cursor.getInt(3) == 0){
                    boolVal = true;
                }
                User userData = new User();
                userData.name = cursor.getString(0);
                userData.description = cursor.getString(1);
                userData.id = cursor.getInt(2);
                userData.followed = boolVal;
                accountList.add(userData);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        //db.close();
        return accountList;
    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<User> userList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM User", null);
        if (cursor.moveToFirst()){
            do{
                User c = new User();
                c.name = cursor.getString(0);
                c.description = cursor.getString(1);
                c.id = cursor.getInt(2);
                if (cursor.getInt(3) == 1){
                    c.followed = false;
                }
                else if (cursor.getInt(3) == 0){
                    c.followed = true;
                }
                userList.add(c);
            }
            while (cursor.moveToNext());
        }
        return userList;
    }


    public void updateUser(User userDetails){
        SQLiteDatabase db = this.getWritableDatabase();
        if (userDetails.getFollowed() == true){
            String UPDATE_FOLLOWED = "UPDATE ACCOUNTS SET Followed = false WHERE Id = " + userDetails.getId();
            db.execSQL(UPDATE_FOLLOWED, null);
        }
    }
}
