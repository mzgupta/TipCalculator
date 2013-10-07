package com.github.mzgupta.tipcalculator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		final CalculatorActivity calculatorActivity=this;
		EditText etAmountText = (EditText) findViewById(R.id.etAmount);
		etAmountText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				calculatorActivity.resetColor();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

	public void calculateTip (View v) {
		float tipFraction=getTipFraction(v.getId());
		
		EditText etAmountText = (EditText) findViewById(R.id.etAmount);
		
		String value = etAmountText.getText().toString();
		
		if (value == null ||  value.equals("") || value.length() == 0){
			etAmountText.setText("0");
			value = "0";
		}
		
		Float amount = Float.parseFloat(value);
		
		if (amount == null){
			return;
		}
		TextView tipAmountView = (TextView) findViewById(R.id.tvLabel);
		
		float tipAmount = tipFraction*amount ;
		
		tipAmountView.setText("Tip is:       $"+tipAmount);
		
	}

	private float getTipFraction(int id) {
		float tipFraction=0F;
		resetColor();
		Button btn = (Button) findViewById(id);
		btn.setTextColor(Color.YELLOW);

		switch (id) {
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
		return tipFraction;
	}

	private void resetColor() {
		Button btnTip10 = (Button) findViewById(R.id.btnTip10);
		Button btnTip15 = (Button) findViewById(R.id.btnTip15);
		Button btnTip20 = (Button) findViewById(R.id.btnTip20);
		
		btnTip10.setTextColor(Color.BLACK);
		btnTip15.setTextColor(Color.BLACK);
		btnTip20.setTextColor(Color.BLACK);
		

	}
}
