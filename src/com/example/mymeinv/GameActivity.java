package com.example.mymeinv;

import java.util.ArrayList;

import adapter.MyAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class GameActivity extends FragmentActivity  {
	
	public static ArrayList<Bitmap> chunkedImages = new ArrayList<Bitmap>();
	ViewPager viewpager;
	MyAdapter ada;
	
	int[] imageIDs = {R.drawable.a0,R.drawable.a1,R.drawable.a2,
			R.drawable.a3,R.drawable.a4,R.drawable.a5,
			R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		viewpager = (ViewPager)findViewById(R.id.viewpager);
		ada = new MyAdapter( getSupportFragmentManager() );
		viewpager.setAdapter( ada );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
