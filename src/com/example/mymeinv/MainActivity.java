package com.example.mymeinv;

import dialog.AboutDialog;
import dialog.ExitDialog;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btn_start, score_order, btn_setting, btn_about, btn_exit, btn_help;
	
	ExitDialog exitDialog;
	AboutDialog aboutDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		exitDialog = new ExitDialog(this);
		aboutDialog = new AboutDialog(this);
		
		
		btn_start = (Button)findViewById(R.id.btn_start);
		
		btn_start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Log.d("hello", "click button start");
				Intent intent;
				intent=new Intent();
				intent.setClass(MainActivity.this, GameActivity.class);
				startActivity(intent);
				
			}
		});
		
		score_order = (Button)findViewById(R.id.score_order);
		
		score_order.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("hello", "click score_order");
				
			}
		});
		
		btn_setting = (Button)findViewById(R.id.btn_setting);
		
		btn_setting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("hello", "click btn_setting");
				
			}
		});
		
		btn_about = (Button)findViewById(R.id.btn_about);
		
		btn_about.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Log.d("hello", "click btn_about");
				aboutDialog.show();
				Button btn_about_return =(Button) aboutDialog.findViewById(R.id.btn_about_return);
				btn_about_return.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						aboutDialog.cancel();
						
					}
				});
				
			}
		});
		
		btn_exit = (Button)findViewById(R.id.btn_exit_game);
		
		btn_exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Log.d("hello", "click btn_exit");
				exitDialog.show();
				Button btn_cancel = (Button)exitDialog.findViewById(R.id.btn_cancel);
				btn_cancel.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						exitDialog.cancel();
						
					}
				});
				Button btn_exit_game = (Button)exitDialog.findViewById(R.id.btn_exit_game);
				btn_exit_game.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						System.exit(0);
					}
				});
				
			}
		});
		
		btn_help = (Button)findViewById(R.id.btn_help);
		
		btn_help.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("hello", "click btn_help");
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
