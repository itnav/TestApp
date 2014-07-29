package jp.itnav.testapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MyActivity extends Activity {
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;

	private EditText editText;

	private static final String key = "key";
	private static final String data_key = "data_key";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);

		sharedPreferences = getSharedPreferences(key, MODE_PRIVATE);

		editText = (EditText) findViewById(R.id.editText);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my, menu);
		return true;
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

	public void saveText(View v) {
		editor = sharedPreferences.edit();
		editor.putString(data_key, editText.getText().toString());
		editor.commit();
	}

	public void roadText(View v) {
		editText.setText(sharedPreferences.getString(data_key, ""));
	}
}
