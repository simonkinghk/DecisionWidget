package com.simonkinghk.decisionwidget;

import java.util.Random;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceInstance{
	private static SharePreferenceInstance shareInstance;
	private SharedPreferences prefs;
	private String defaultKey = "com.simonkinghk.decisionwidget.totalnum";
	
	public static SharePreferenceInstance getInstance(){
		if (shareInstance == null) {
			shareInstance = new SharePreferenceInstance();
		}
		return shareInstance;
	}
	
	public SharePreferenceInstance() {
		prefs = MyApplication.getAppContext().getSharedPreferences("com.simonkinghk.decisionwidget", Context.MODE_PRIVATE);
	}
	
	public int getPreference(){
		return prefs.getInt(defaultKey, 2);
	}

	public void setPreference(int value){
		prefs.edit().putInt(defaultKey, value).apply();
	}
	
	public int generateRandomNumber(int max) {
		int min = 1;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
