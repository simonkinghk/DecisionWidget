package com.simonkinghk.decisionwidget;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity implements OnClickListener, OnItemSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Spinner spinSelect = (Spinner) findViewById(R.id.spn_totalSelector);
		Button buttonClick = (Button) findViewById(R.id.selectRandom);
		spinSelect.setOnItemSelectedListener(this);
		buttonClick.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String showedText = SharePreferenceInstance.getInstance().generateRandomNumber(SharePreferenceInstance.getInstance().getPreference())+ "";
		((Button) v).setText(showedText);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		SharePreferenceInstance.getInstance().setPreference((int) id + 2);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// this will not be called
	}

}
