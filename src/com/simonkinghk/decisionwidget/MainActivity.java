package com.simonkinghk.decisionwidget;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends ActionBarActivity  implements OnClickListener, SeekBar.OnSeekBarChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SeekBar buttonSelect = (SeekBar) findViewById(R.id.selectItems);
		Button buttonClick = (Button) findViewById(R.id.selectRandom);
	    buttonSelect.setOnClickListener(this);
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
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
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.selectItems:
				((Button) v).setText("1");
			break;
		}
	}
	
	private int generateRandomNumber(int totalNumbers){
		
		return 0;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) { }
}
