package com.sivananda.sharedprefenceexample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText et1, et2;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		sp = getSharedPreferences("UserDetails", MODE_WORLD_WRITEABLE); // SharedPreference object
	}

	public void save(View v) {
		Editor editor = sp.edit();   // Editor object
		editor.putString("user", et1.getText().toString());  // put the data in Editor Object
		editor.putString("pass", et2.getText().toString());
		editor.commit(); // save the data into SharedPreference Object
		et1.setText("");
		et2.setText("");
	}
	
	public void load(View v) {
		String userName = sp.getString("user", "No User");
		String password = sp.getString("pass", null);
		et1.setText(userName);
		et2.setText(password);
	}
}
