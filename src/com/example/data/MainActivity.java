package com.example.data;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Editor etUserName,etUserPass;
	CheckBox chk;
	SharedPreferences pref;
	Editor editor;
	//Button bt_
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	//	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
//		SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
//		Editor editor = pref.edit();
//		editor.putString("name", "张三");
//		editor.putInt("age", 30);
//		editor.putLong("time", System.currentTimeMillis());
//		editor.putBoolean("default", true);
//		editor.commit();
//		editor.remove("default");
//		editor.commit();
		etUserName = (Editor) findViewById(R.id.etuserName);
		etUserPass = (Editor) findViewById(R.id.etuPassword);
		chk = (CheckBox) findViewById(R.id.checkSaveName);
		pref = getSharedPreferences("UserInfo", MODE_PRIVATE);
		editor = pref.edit();
		String name = pref.getString("userName", "");
		if (name == null) {
			chk.setChecked(false);
			
		}else {
			chk.setChecked(true);
			((TextView) etUserName).setText(name);
		}
	}

	public void doClick(View v){
		switch (v.getId()) {
		case R.id.btnLogin:
			String name = ((TextView) etUserName).getText().toString().trim();
			String pass = ((TextView) etUserPass).getText().toString().trim();
			if ("admin".equals(name)&&"123456".equals(pass)) {
				if (chk.isChecked()) {
					editor.putString("userNmae", name);
					editor.commit();
					
				}else {
					editor.remove("userName");
					editor.commit();
				}
				Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
			}else {
				Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
			}
			break;

		
		}
	}
	
}
