package zeven.eventbus;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import zeven.demos.R;
import zeven.utils.ViewFinders;


public class TraditionalWayActivity2 extends Activity implements OnClickListener{
	String Message = "message from activity2";
	Button mButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tradition2);
		mButton = ViewFinders.findView(R.id.button_second, this);
		mButton.setText("jump to 3");
		mButton.setOnClickListener(this);
		Fragment s;
	}

	@Override
	public void onClick(View v) {
//		Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
//		Message msg = new Message();
//		msg.obj = new String(Message);
//		TraditionalWayActivity.mHandler.sendMessage(msg);
		Intent intent = new Intent(this, TraditionalWayActivity3.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getApplicationContext().startActivity(intent);
	}
}
