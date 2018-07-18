package com.example.mymeinv;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment {
	
	int imgId;
	
	// newInstance constructor for creating fragment with arguments
    public static ImageFragment newInstance(int page, int imgId) {
    	ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt("imgId", imgId);
        //args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
        
        
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgId = getArguments().getInt("imgId", R.drawable.a0);
        //title = getArguments().getString("someTitle");
        
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        final ImageView iv = (ImageView) view.findViewById(R.id.imageView);
        iv.setImageResource(imgId);
        
        iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("hello--", "---------click-----------------");
				splitImage(iv, 9);
				
			}
		});
        
        return view;
    }
    
    private void splitImage(ImageView image, int chunkNumbers) { 
    	  
        //For the number of rows and columns of the grid to be displayed
        int rows,cols;
  
        //For height and width of the small image chunks 
        int chunkHeight,chunkWidth;
  
        //To store all the small image chunks in bitmap format in this list 
        
  
        Log.d("hello--", "---------click 2-----------------");
        
        //Getting the scaled bitmap of the source image
        BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
  
        rows = cols = (int) Math.sqrt(chunkNumbers);
        chunkHeight = bitmap.getHeight()/rows;
        chunkWidth = bitmap.getWidth()/cols;
  
        //xCoord and yCoord are the pixel positions of the image chunks
        GameActivity.chunkedImages.clear();
        
        int yCoord = 0;
        for(int x=0; x<rows; x++){
            int xCoord = 0;
            for(int y=0; y<cols; y++){
            	GameActivity.chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));
                xCoord += chunkWidth;
            }
            yCoord += chunkHeight;
        }
        
        /* Now the chunkedImages has all the small image chunks in the form of Bitmap class. 
         * You can do what ever you want with this chunkedImages as per your requirement.
         * I pass it to a new Activity to show all small chunks in a grid for demo.
         * You can get the source code of this activity from my Google Drive Account.
         */
        
        Collections.shuffle(GameActivity.chunkedImages);
        
        Log.d("hello--", "size = " + GameActivity.chunkedImages.size()+"");
        Log.d("hello--", "---------click 3-----------------");
        
        //Start a new activity to show these chunks into a grid 
        Intent intent = new Intent(this.getActivity(), ChunkedImageActivity.class);
        //intent.putParcelableArrayListExtra("imagechunks", chunkedImages);
        Log.d("hello--", "---------click 4-----------------");
        startActivity(intent);
    }

}
