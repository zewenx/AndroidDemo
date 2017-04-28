package zeven.eventbus;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import zeven.demos.R;


public class FragmentsActivity extends Activity {
	public static Handler mHandler;
	TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
	}
}
