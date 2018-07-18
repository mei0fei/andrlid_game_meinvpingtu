package adapter;

import com.example.mymeinv.ImageFragment;
import com.example.mymeinv.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;


//https://blog.csdn.net/harvic880925/article/details/38453725

public class MyAdapter extends  FragmentPagerAdapter{

	
	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	
	 // Returns total number of pages
    @Override
    public int getCount() {
        return 10;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
    	Log.d("hello--", position+"");
        switch (position) {
        case 0: 
            return ImageFragment.newInstance(0, R.drawable.a0);
        case 1:
        	return ImageFragment.newInstance(0, R.drawable.a1);
        case 2:
        	return ImageFragment.newInstance(0, R.drawable.a2);
        case 3:
        	return ImageFragment.newInstance(0, R.drawable.a3);
        case 4:
        	return ImageFragment.newInstance(0, R.drawable.a4);
        case 5:
        	return ImageFragment.newInstance(0, R.drawable.a5);
        case 6:
        	return ImageFragment.newInstance(0, R.drawable.a6);
        case 7:
        	return ImageFragment.newInstance(0, R.drawable.a7);
        case 8:
        	return ImageFragment.newInstance(0, R.drawable.a8);
        case 9:
        	return ImageFragment.newInstance(0, R.drawable.a9);
        default:
            return null;
        }
    }

    

}
