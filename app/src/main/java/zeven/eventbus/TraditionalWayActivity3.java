package zeven.eventbus;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import zeven.demos.R;
import zeven.utils.ViewFinders;

public class TraditionalWayActivity3 extends Activity implements OnClickListener{
	String Message = "message from activity2";
	Button mButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tradition2);
		mButton = ViewFinders.findView(R.id.button_second, this);
		mButton.setText("send message");
		mButton.setOnClickListener(this);
		Fragment s;
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
		Message msg = new Message();
		msg.obj = new String(Message);
		TraditionalWayActivity.mHandler.sendMessage(msg);
	}
}
