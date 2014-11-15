package com.pdm.projeto2.activities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.projeto2.R;
import com.pdm.projeto2.gameManager.MyClientTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textResponse;
	EditText editTextAddress, editTextPort;
	Button buttonConnect, buttonClear;
	private boolean turn = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editTextAddress = (EditText) findViewById(R.id.address);
		editTextPort = (EditText) findViewById(R.id.port);
		buttonConnect = (Button) findViewById(R.id.connect);
		textResponse = (TextView) findViewById(R.id.response);
		buttonConnect.setOnClickListener(buttonConnectOnClickListener);
	}

	OnClickListener buttonConnectOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			MyClientTask myClientTask = new MyClientTask(MainActivity.this,
					editTextAddress.getText().toString(),
					Integer.parseInt(editTextPort.getText().toString()));
			myClientTask.execute();
		}
	};

	public void setResponse(String text){
		if(text.equalsIgnoreCase("ok")){
			Intent intent = new Intent(MainActivity.this, Game.class);
			startActivity(intent);
		}else{
			textResponse.setText(text);
		}
	}

}