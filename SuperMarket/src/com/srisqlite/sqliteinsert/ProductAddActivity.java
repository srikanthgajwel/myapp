package com.srisqlite.sqliteinsert;


import android.content.ContentValues;
import android.content.Context;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProductAddActivity extends ActionBarActivity{

 
    private ProductOperations studentDBoperation;
   
    EditText prodName;
    EditText price;
    
    Button btnAdd,btnDelete,btnView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);

        studentDBoperation = new ProductOperations(this);
        studentDBoperation.open();
        
         prodName = (EditText) findViewById(R.id.productName);
         price = (EditText) findViewById(R.id.price);
         
         btnAdd = (Button) findViewById(R.id.addBtn);

      }   
 
    public void addProd(View view) {
    	//view ="";
    //  ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
    	if(prodName.getText().toString().trim().length() == 0 || price.getText().toString().trim().length() == 0){
			
			showMessage("Error","Please enter the Product Name or Price");
			clearText();
			return;    			
		}

        Product stud = studentDBoperation.addStudent(prodName.getText().toString(), Double.parseDouble(price.getText().toString()));
        if(stud != null){
        	
        	Toast.makeText(getApplicationContext(), "Product Added Successfully", Toast.LENGTH_SHORT).show();
        }
      //  adapter.add(stud);

    }

   public void showMessage(String title, String message){
    	
    	Builder builder = new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
    }
    
   public void clearText(){
 	
 	
	   prodName.setText("");
	   prodName.requestFocus();
 }
    @Override
    protected void onResume() {
        studentDBoperation.open();
        super.onResume();

    }
    @Override

    protected void onPause() {
        studentDBoperation.close();
        super.onPause();

    }

	
	
}
