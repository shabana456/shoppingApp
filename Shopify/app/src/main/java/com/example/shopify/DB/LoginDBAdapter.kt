package com.example.shopify.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.shopify.Bean.UserLogin
private val DB_NAME = "login.db"
private val DB_VERSION = 2
public class LoginDBAdapter(context: Context)
    :SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    val TAG = LoginDBAdapter::class.java.simpleName

    private val TABLE_LOGIN = "login"
    private val COLUMN_ID = "user_id"
    private val COLUMN_USERNAME = "username"
    private val COLUMN_PASSWORD = "password"

    private val createTable = ("CREATE TABLE " + TABLE_LOGIN + "" +
            "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_USERNAME + " TEXT NOT NULL, "
            + COLUMN_PASSWORD + " TEXT NOT NULL)")
    // drop table sql query
    private val dropTable = "DROP TABLE IF EXISTS $TABLE_LOGIN"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createTable)
        Log.v(TAG, "Table created")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(dropTable)//Drop User Table if exist
        Log.v(TAG, "Table Dropped")
        onCreate(db)// Create tables again
    }

    fun insertUser(userLogin: UserLogin) : Int {
        val returnCheck: Int
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_USERNAME, userLogin.username)
        values.put(COLUMN_PASSWORD, userLogin.password)
        // Inserting Row
        returnCheck = db.insert(TABLE_LOGIN, null, values).toInt()
        db.close()
        return returnCheck
    }
    fun displayUser(userID: String): UserLogin{

        // array of columns to fetch
        val columns = arrayOf(COLUMN_ID, COLUMN_USERNAME, COLUMN_PASSWORD)
        // selection argument
        val selectionArgs = arrayOf(userID)
        val db = this.readableDatabase
        println(userID)
        // query the user table
        val cursor = db.query(
            TABLE_LOGIN,                //Table to query
            columns,                    //columns to return
            "$COLUMN_ID = ?",  //columns for the WHERE clause
            selectionArgs,             //The values for the WHERE clause
            null,               //group the rows
            null,                //filter by row groups
            null                //The sort order
        )
        var user = UserLogin(id=-1,username = "",password = "")
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()

            user = UserLogin(id = cursor.getString(cursor.getColumnIndex(COLUMN_ID)).toInt(),
                username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)),
                password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)))
            cursor.close()
            db.close()

        }
        return user

    }
    fun updateUser(userLogin: UserLogin): Int{
        val db = this.writableDatabase
        var returnCheck: Int = -1
        val values = ContentValues()
        values.put(COLUMN_USERNAME, userLogin.username)
        values.put(COLUMN_PASSWORD, userLogin.password)
        // updating row
        returnCheck = db.update(
            TABLE_LOGIN, values, "$COLUMN_ID = ?",
            arrayOf(userLogin.id.toString())
        )

        db.close()
        return returnCheck
    }
    fun deleteUser(userID: String): Int {
        val db = this.writableDatabase
        var returnCheck: Int = -1
        // delete user record by id
        returnCheck = db.delete(TABLE_LOGIN, "$COLUMN_ID = ?", arrayOf(userID))
        db.close()
        return returnCheck
    }
}