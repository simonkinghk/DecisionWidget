package com.simonkinghk.decisionwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

public class AppWidgetMain extends AppWidgetProvider {
	
	public static String ACTION_CLICK = "ACTION_CLICK";

	/** Called when the activity is first created. */
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_main);
		
		// add widget button action
		Intent intent = new Intent(context, WidgetService.class);
		intent.setAction(ACTION_CLICK);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		views.setOnClickPendingIntent(R.id.showButton, pendingIntent);

		appWidgetManager.updateAppWidget(appWidgetIds, views);
	}
}
