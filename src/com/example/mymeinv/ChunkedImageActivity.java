package com.example.mymeinv;

import java.util.ArrayList;
import java.util.Collections;

import adapter.MyGridViewAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class ChunkedImageActivity extends Activity {
	
	
	static Handler myHandler = new Handler(){ 
		@Override 
		public void handleMessage(Message msg){ 
			super.handleMessage(msg); 
			//doWork(); 
		} 
	};
	
	//ArrayList<Bitmap> chunkedImages;
	GridView gv;
	MyGridViewAdapter myGridViewAdapter;
	
	int firstClick, secondClick;
	View firstView, secondView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		firstClick = secondClick = -1;
		setContentView(R.layout.activity_chunked_image);
		 

		//chunkedImages = this.getIntent().getParcelableArrayListExtra("imagechunks");
		
		gv = (GridView)findViewById(R.id.gridView1);
		
		myGridViewAdapter = new MyGridViewAdapter(this, GameActivity.chunkedImages); 
		
		gv.setAdapter(myGridViewAdapter);
		
		gv.setOnItemClickListener(new GridView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				if(firstClick==-1){
					firstClick = position;
					firstView = view;
					
				}else if( firstClick!=-1 && secondClick==-1 && firstClick!= position ){
					secondClick = position;
					secondView = view;
					swapImage(firstClick, secondClick);
					firstClick = secondClick = -1;
					firstView = secondView = null;
				}
				
			}

		});
		
	}
	
	private void swapImage(int firstClick, int secondClick) {
		
		int[] first_location = new int[2];
		firstView.getLocationInWindow(first_location);
		int[] second_location = new int[2];
		secondView.getLocationInWindow(second_location);
		
		
		Log.d("hello", firstClick + "  " + secondClick);
		Collections.swap(GameActivity.chunkedImages, firstClick, secondClick);
		
		Animation firstTranslate = new TranslateAnimation(0f, second_location[0]-first_location[0], 0f , second_location[1]-first_location[1]);//移动动画
		firstView.setAnimation(firstTranslate);
		firstTranslate.setDuration(1000);		
		
		Animation secondTranslate = new TranslateAnimation(0, first_location[0]-second_location[0],0,first_location[1]-second_location[1]);//移动动画
		secondView.setAnimation(secondTranslate);
		secondTranslate.setDuration(1000);		
		
		firstTranslate.start();
		//secondTranslate.start();
		
		myHandler.postDelayed(new Runnable(){
			@Override
			public void run() {
				myGridViewAdapter.notifyDataSetChanged();	
			}	
		}, 1000);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chunked_image, menu);
		return true;
	}

}
