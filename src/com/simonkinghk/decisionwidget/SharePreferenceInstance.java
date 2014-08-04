package com.simonkinghk.decisionwidget;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceInstance {
	private static SharePreferenceInstance shareInstance;
	private Context context;
	private SharedPreferences prefs;
	private String defaultKey = "com.simonkinghk.decisionwidget.totalnum";
	
	public static SharePreferenceInstance getInstance(Context c){
		if (shareInstance == null) {
			shareInstance = new SharePreferenceInstance(c);
		}
		return shareInstance;
	}
	
	public SharePreferenceInstance(Context c){
		context = c;
		prefs = context.getSharedPreferences("com.simonkinghk.decisionwidget", Context.MODE_PRIVATE);
	}
	
	public int getPreference(){
		return prefs.getInt(defaultKey, 2);
	}

	public void setPreference(int value){
		prefs.edit().putInt(defaultKey, value).apply();
	}
}
