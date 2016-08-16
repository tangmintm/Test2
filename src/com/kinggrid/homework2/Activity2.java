package com.kinggrid.homework2;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends Activity implements OnClickListener {
	private EditText tv1;
	private EditText tv2;
	private Button btn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_2);
		
		Intent intent = getIntent();
		String param1 = intent.getStringExtra("param1");
		String param2 = intent.getStringExtra("param2");
		
		tv1 = (EditText)findViewById(R.id.tv1);
		tv2 = (EditText)findViewById(R.id.tv2);
		
		tv1.setText(param1);
		tv2.setText(param2);
		
        intent.putExtra("callback","这是Activity2传回的值。");   
        Activity2.this.setResult(0, intent);
        
        btn1=(Button) findViewById(R.id.dBtn1); 
        btn1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.dBtn1:
			this.finish();
			intent.setAction("com.kinggrid.finishActivity");
			intent.putExtra("activityName", "Activity2");
			intent.putExtra("action", "com.kinggrid.finishActivity");
			Activity2.this.sendBroadcast(intent);
			//Context.sendBroadcast(intent);
		break;
		default:
		break;
		}
	}
}
