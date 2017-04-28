package zeven.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Timer;
import java.util.TimerTask;

import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.utils.ViewFinders;

public class FlipperDemoActivity extends BaseActivity implements OnGestureListener {
	ViewFlipper flipper;
	TextView text1, text2;
	Timer timer = new Timer();
	TimerTask task;
	GestureDetector myGestureDetector = new GestureDetector(this);
	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				flipper.showNext();
				break;
case 1:
	flipper.showPrevious();
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filp_demo);
		flipper = ViewFinders.findView(R.id.trans, this);
		initViews();
	}

	private void initViews() {
		text1 = new TextView(this);
		text1.setText("1234");
		text1.setTextColor(Color.BLUE);
		text1.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		text1.setTextSize(40.0f);

		text2 = new TextView(this);
		text2.setText("5678");
		text2.setTextColor(Color.YELLOW);
		text2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		text2.setTextSize(40.0f);

		text1.setGravity(Gravity.CENTER);
		text2.setGravity(Gravity.CENTER);

		flipper.addView(text1);
		flipper.addView(text2);

	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		timer.cancel();
		timer = new Timer();

		// left

		if (e1.getX() - e2.getX() > 80) {

			flipper.setInAnimation(this, R.anim.left_in);
			flipper.setOutAnimation(this, R.anim.left_out);

			task = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					handler.sendEmptyMessage(0);
				}
			};
			timer.schedule(task, 0, 1000);

			// changeView();
			return true;
			// rights
		} else if (e2.getX() - e1.getX() > 80) {
			flipper.setInAnimation(this, R.anim.right_in);
			flipper.setOutAnimation(this, R.anim.right_out);

			task = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					handler.sendEmptyMessage(1);
				}
			};
			timer.schedule(task, 0, 1000);
			// changeView();
			return true;
		}
		return false;
	}

	private void changeView() {
		if (text1.getParent() == flipper) {
			flipper.removeView(text1);
			flipper.addView(text2);
		} else if (text2.getParent() == flipper) {
			flipper.removeView(text2);
			flipper.addView(text1);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return myGestureDetector.onTouchEvent(event);
	}
}
