package zeven.eventbus;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.Random;

import zeven.demos.R;
import zeven.utils.ViewFinders;

public class TraditionalWayActivity extends Activity implements OnClickListener {
	public static Handler mHandler;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tradition);
		ViewFinders.findView(R.id.button_first, this).setOnClickListener(this);
		text = ViewFinders.findView(R.id.text_first, this);
		mHandler = new Handler() {

			@Override
			public void dispatchMessage(Message msg) {
				// TODO Auto-generated method stub
				String ans = (String) msg.obj;
				text.setText(ans);
			}
		};

	}

	@Override
	public void onClick(View v) {
		// Intent intent = new Intent(this,TraditionalWayActivity2.class);
		// intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		// getApplicationContext().startActivity(intent);
		Random random = new Random(System.currentTimeMillis());
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		String content = "content";
		Intent i = new Intent(this, TraditionalWayActivity2.class);
		// 将消息处理方法的实现类也传过去
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent contentIntent = PendingIntent.getActivity(this, random.nextInt(), i, PendingIntent.FLAG_UPDATE_CURRENT);

		Notification.Builder builder = new Notification.Builder(this);
		// 设定默认提醒声音 默认震动
		builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
		builder.setTicker(content);
		builder.setWhen(System.currentTimeMillis());
		builder.setAutoCancel(true);
		builder.setSmallIcon(R.mipmap.ic_launcher);
		// Notification
		builder.setContentText(content).setContentTitle(content).setContentIntent(contentIntent);
		notificationManager.notify(random.nextInt(), builder.build());
	}
}
