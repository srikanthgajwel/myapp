package com.srisqlite.sqliteinsert;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		//Add Product Button
        Button addButton = (Button) findViewById(R.id.addProdBtn);
       
        
        addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				startActivity(new Intent("com.srisqlite.sqliteinsert.PRODUCTADD"));
				//mpButton.start();
			}
		});
		
        // Billing Button
        Button billButton = (Button) findViewById(R.id.billProdBtn);
        
        
        billButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				startActivity(new Intent("com.srisqlite.sqliteinsert.BILLING"));
				
			}
		});
        
	}
	
	
	

}
