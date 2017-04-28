package zeven.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.utils.ViewFinders;

public class HorizontalListViewDemoActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,  
                  WindowManager.LayoutParams. FLAG_FULLSCREEN);
		setContentView(R.layout.activity_horizontal);
		
		initViews();
	}
//	this.getWindowManager().getDefaultDisplay().getWidth()
	private void initViews() {
		int [] pics = {R.mipmap.p1,R.mipmap.p2,R.mipmap.p9,R.mipmap.p4,R.mipmap.p5,R.mipmap.p6,R.mipmap.p7,R.mipmap.p8,R.mipmap.p3,R.mipmap.p10,R.mipmap.p11,R.mipmap.p12,R.mipmap.p13,R.mipmap.p1,R.mipmap.p2,R.mipmap.p9,R.mipmap.p4,R.mipmap.p5,R.mipmap.p6,R.mipmap.p7,R.mipmap.p8,R.mipmap.p3,R.mipmap.p10,R.mipmap.p11,R.mipmap.p12,R.mipmap.p13};
		LinearLayout layout = ViewFinders.findView(R.id.gallery, this);
		for(int pic : pics){
			ImageView view = new ImageView(this);
			view.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT));
			if (BitmapFactory.decodeResource(getResources(), pic).getWidth()<this.getWindowManager().getDefaultDisplay().getWidth()) {
				view.setLayoutParams(new LayoutParams(this.getWindowManager().getDefaultDisplay().getWidth(),LayoutParams.MATCH_PARENT));
			}
			
			
//			view.setImageResource(pic);
			view.setBackgroundResource(pic);
			layout.addView(view);
		}
	}
	
}
