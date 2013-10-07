package com.github.mzgupta.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

	public void calculateTip (View v) {
		float tipFraction=0F;
		switch (v.getId()) {
		case R.id.btnTip10:
			tipFraction = 0.1F;
			break;
		case R.id.btnTip15:
			tipFraction = 0.15F;
			break;
		case R.id.btnTip20:
			tipFraction = 0.2F;			
			break;
		default:
			break;
		}
		EditText etAmountText = (EditText) findViewById(R.id.etAmount);
		
		Float amount = Float.parseFloat(etAmountText.getText().toString());
		
		if (amount == null){
			return;
		}
		TextView tipAmountView = (TextView) findViewById(R.id.tvLabel);
		
		float tipAmount = tipFraction*amount ;
		
		tipAmountView.setText("Tip is:       $"+tipAmount);
		
	}
}
