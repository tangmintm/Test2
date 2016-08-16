package com.kinggrid.homework2;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FinishActivityReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Toast.makeText(context, "activity name:"+bundle.get("activityName") + "  开发者: 唐敏 "+" action自定义: "+bundle.get("action"), Toast.LENGTH_LONG).show();//(CharSequence) bundle.get("activityName")
	}
}
