package com.simonkinghk.decisionwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.RemoteViews;

public class AppWidgetMain extends AppWidgetProvider {
	
	public static String WIDGET_ACTION = "WidgetOnClickAction";

	/** Called when the activity is first created. */
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		final int IDs = appWidgetIds.length;
		
		for (int i = 0; i < IDs; i++) {
			int appWidgetId = appWidgetIds[i];
			updateAppWidget(context, appWidgetManager, appWidgetId);
		}
	}

	public void onDeleted(Context context, int[] appWidgetIds) {

	}

	private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
		// add widget button action
		Intent intent = new Intent(context, AppWidgetMain.class);
		intent.setAction(WIDGET_ACTION);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_main);
		views.setOnClickPendingIntent(R.id.showButton, pendingIntent);

		//views.setTextViewText(R.id.HelloTextView01, text);
		appWidgetManager.updateAppWidget(appWidgetId, views);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		if (intent.getAction().equals(WIDGET_ACTION)) {
			//do widget action here
			final AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
			final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_main);
			final ComponentName watchWidget = new ComponentName(context, AppWidgetMain.class);

			Handler handlerTimer = new Handler();
			handlerTimer.postDelayed(new Runnable(){
				public void run() {
					remoteViews.setTextViewText(R.id.showButton, SharePreferenceInstance.getInstance().generateRandomNumber(SharePreferenceInstance.getInstance().getPreference()) + "");
					appWidgetManager.updateAppWidget(watchWidget, remoteViews);          
				}}, 1000);
			remoteViews.setTextViewText(R.id.showButton, MyApplication.getAppContext().getResources().getString(R.string.generating_widget));
			appWidgetManager.updateAppWidget(watchWidget, remoteViews);
		}
	}
}
