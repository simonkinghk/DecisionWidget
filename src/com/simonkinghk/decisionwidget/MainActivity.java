package com.simonkinghk.decisionwidget;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener, OnItemSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Spinner spinSelect = (Spinner) findViewById(R.id.spn_totalSelector);
		Button buttonClick = (Button) findViewById(R.id.selectRandom);
		spinSelect.setOnItemSelectedListener(this);
		buttonClick.setOnClickListener(this);
		
		spinSelect.setSelection(SharePreferenceInstance.getInstance().getPreference()-2); // get user preference and set default value
	}

	@Override
	public void onClick(View v) {
		final Button x = (Button) v;
		x.setText(getResources().getString(R.string.generating));
		
		// Delay to show generated number
		Handler handlerTimer = new Handler();
		handlerTimer.postDelayed(new Runnable(){
			public void run() {
				String showedText = SharePreferenceInstance.getInstance().generateRandomNumber(SharePreferenceInstance.getInstance().getPreference())+ "";
				x.setText(showedText);          
			}}, 1000);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		SharePreferenceInstance.getInstance().setPreference((int) id + 2);
		String showText = getResources().getString(R.string.toast_showsaved).replace("xx", id+2+"");
		Toast.makeText(getApplicationContext(), showText, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// this will not be called
	}
	

}
