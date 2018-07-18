package adapter;

import java.util.ArrayList;

import com.example.mymeinv.R;


import android.content.Context;
import android.graphics.Bitmap;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class MyGridViewAdapter extends BaseAdapter {

	ArrayList<Bitmap> chunkedImages;
	Context context;
	
	public MyGridViewAdapter(Context context, ArrayList<Bitmap> chunkedImages){
		this.context = context;
		this.chunkedImages = chunkedImages;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//Log.d("hello", "get count -- ");
		return chunkedImages.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return chunkedImages.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//ViewHolder viewHolder = null;
		Log.d("hello", "get view  " + position);
        //if (contentView == null) {
            contentView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
            
            ImageView smallimg = (ImageView)contentView.findViewById(R.id.smallImg);
            smallimg.setImageBitmap(chunkedImages.get(position));
            
        //}
        
      
        return contentView;
	}
	
}
