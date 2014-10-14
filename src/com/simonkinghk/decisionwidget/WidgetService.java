package com.simonkinghk.decisionwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class WidgetService extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("ACTION_CLICK")) {
//			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
//			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_main);
//			ComponentName watchWidget = new ComponentName(context, AppWidgetMain.class);
//			Handler handlerTimer = new Handler();
//			handlerTimer.postDelayed(new Runnable(){
//				public void run() {
//					remoteViews.setTextViewText(R.id.showButton, SharePreferenceInstance.getInstance().generateRandomNumber(SharePreferenceInstance.getInstance().getPreference()) + "");
//					appWidgetManager.updateAppWidget(watchWidget, remoteViews);          
//				}}, 1000);
//			remoteViews.setTextViewText(R.id.showButton, MyApplication.getAppContext().getResources().getString(R.string.generating_widget));
//			appWidgetManager.updateAppWidget(watchWidget, remoteViews);
			
			Toast.makeText(MyApplication.getAppContext(), "Generated number: "+ SharePreferenceInstance.getInstance().generateRandomNumber(SharePreferenceInstance.getInstance().getPreference()) +" of "+SharePreferenceInstance.getInstance().getPreference(), Toast.LENGTH_LONG).show();
		}	
	}
}