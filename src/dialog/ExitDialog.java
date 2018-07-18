package dialog;

import com.example.mymeinv.R;
import com.example.mymeinv.R.layout;
import com.example.mymeinv.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Menu;
import android.view.Window;

public class ExitDialog extends Dialog {

	Context context;
	public ExitDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.exit_dialog);
	}
	

}
