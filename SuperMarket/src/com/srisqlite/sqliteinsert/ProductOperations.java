package com.srisqlite.sqliteinsert;

import java.util.ArrayList;

import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ProductOperations {

 

    // Database fields

    private DataBaseWrapper dbHelper;

    private String[] PRODUCT_DETAILS_COLUMNS = { DataBaseWrapper.SERIAL_NO, DataBaseWrapper.PRODUCT_NAME, DataBaseWrapper.PRICE };

    private SQLiteDatabase database;
    
    public ProductOperations(Context context) {

        dbHelper = new DataBaseWrapper(context);
        Log.d("Proddd", "werwer");

    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
        Log.d("werwe", "open");

    } 

    public void close() {

        dbHelper.close();

    }

 

    public Product addStudent(String product_name, double price) {
		 

		ContentValues values = new ContentValues();
        values.put(DataBaseWrapper.PRODUCT_NAME, product_name);
        values.put(DataBaseWrapper.PRICE, price);
        long serialNo = database.insert(DataBaseWrapper.PRODUCT_DETAILS, null, values);
        // now that the student is created return it ...
        
        Cursor cursor = database.query(DataBaseWrapper.PRODUCT_DETAILS,
        		PRODUCT_DETAILS_COLUMNS, DataBaseWrapper.SERIAL_NO + " = "
                        + serialNo, null, null, null, null);
        cursor.moveToFirst();
        Product newComment = parseProduct(cursor);
        cursor.close();
        return newComment;

    }

 

    public void deleteStudent(Product comment) {

        /*
    	long id = comment.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DataBaseWrapper.STUDENTS, DataBaseWrapper.STUDENT_ID
                + " = " + id, null);
*/
    }

 
/*
    public List getAllStudents() {

        List students = new ArrayList();

 

        Cursor cursor = database.query(DataBaseWrapper.STUDENTS,

                STUDENT_TABLE_COLUMNS, null, null, null, null, null);

 

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            Product student = parseStudent(cursor);

            students.add(student);

            cursor.moveToNext();

        }

 

        cursor.close();

        return students;

    }*/

 

    private Product parseProduct(Cursor cursor) {

        Product product = new Product();

        product.setSerial_no((cursor.getInt(0)));
        product.setProduct_name(cursor.getString(1));
        product.setPrice(cursor.getDouble(2));

        return product;

    }
}
