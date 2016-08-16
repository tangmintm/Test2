package com.kinggrid.homework2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button btnA;
	private Button btnB;
	private Button btnC;
	private TextView tv;
	private final String param1="kinggrid1";
	private final String param2="kinggrid2";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		btnA = (Button) findViewById(R.id.button1);
		btnB = (Button) findViewById(R.id.button2);
		btnC = (Button) findViewById(R.id.button3);
		tv = (TextView) findViewById(R.id.textView1);
		
		btnA.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent itt = new Intent(MainActivity.this,Activity2.class);
				itt.putExtra("param2", param2);
				itt.putExtra("param1", param1);
				startActivity(itt);
			}
		});
		
		btnB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent itt = new Intent(MainActivity.this, Activity2.class);
				itt.putExtra("param2", param2);
				itt.putExtra("param1", param1); 
				startActivityForResult(itt, 0);
			}
		});
		
		btnC.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finishActivity(0);
				Intent intent = new Intent();
				intent.setAction("com.kinggrid.finishActivity");
				intent.putExtra("activityName", "MainActivity");
				intent.putExtra("action", "com.kinggrid.finishActivity");
				MainActivity.this.sendBroadcast(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, intent);
		if (requestCode == 0 && resultCode == 0) {
			Bundle bundleData = intent.getExtras();
			String resultCity = bundleData.getString("callback");
			tv.setText(resultCity);
		}
	}
}
