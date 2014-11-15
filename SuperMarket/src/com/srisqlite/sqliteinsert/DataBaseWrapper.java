package com.srisqlite.sqliteinsert;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DataBaseWrapper extends SQLiteOpenHelper {
	
	 public static final String PRODUCT_DETAILS = "Product_details";	 
	 public static final String SERIAL_NO = "serial_no";	 
	 public static final String PRODUCT_NAME = "product_name";
	 public static final String PRICE = "price";
     private static final String DATABASE_NAME = "SUPER_MARKET";
     private static final int DATABASE_VERSION = 1;

     
     // creation SQLite statement     
     private static final String DATABASE_CREATE =
    "create table " + PRODUCT_DETAILS+ "(" + SERIAL_NO + " integer primary key autoincrement, "     
                 + PRODUCT_NAME + " text not null,"+PRICE+ " double);";


     public DataBaseWrapper(Context context) {    	
    	   super(context, DATABASE_NAME, null, DATABASE_VERSION);
    	 
    	     }
    	 
    	     @Override
    	 
     public void onCreate(SQLiteDatabase db) {
 
         db.execSQL(DATABASE_CREATE);
   	     }

    	     @Override
    	 
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
         // you should do some logging in here 
         // .. 
         db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_DETAILS); 
         onCreate(db);
 
     }

	

}
