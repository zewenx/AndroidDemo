package zeven.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/** 
* @ClassName: ButtonView 
* @Description: 自定义按钮，在一定时间内只能点击一次
* 				属性 IntervalTime 定义了时间间隔
* @author zeven
* @date 2015年8月25日 下午8:02:09 
*  
*/
public class ButtonView extends Button {
	/**
	 * @Fields lastClickTime :上次点击事件响应的事件
	 */
	private long lastClickTime = 0l;

	/**
	 * @Fields interval : 两次点击之间的间隔时间，默认是5秒
	 */
	private long interval = 5000l;

	public ButtonView(Context context) {
		super(context);
	}

	public ButtonView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttributes(attrs);

	}

	public ButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initAttributes(attrs);
	}

	private void initAttributes(AttributeSet attrs) {
		String time = attrs.getAttributeValue(null, "IntervalTime");
		if (time != null && time.length() > 0) {
			this.interval = Long.parseLong(attrs.getAttributeValue(null, "IntervalTime"));
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		int action = event.getAction();
		switch (action) {

		case MotionEvent.ACTION_DOWN:
			if (System.currentTimeMillis() - lastClickTime > interval) {
				lastClickTime = System.currentTimeMillis();
				return super.dispatchTouchEvent(event);
			} else {
				return true;
			}
		default:
			break;
		}

		return super.dispatchTouchEvent(event);
	}
}
