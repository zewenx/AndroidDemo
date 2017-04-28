package zeven.weixin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：15/11/19 下午3:01
 */
public class WAGridView extends GridView {
    public WAGridView(Context context) {
        super(context);
    }

    public WAGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WAGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //禁用滑动
        if (ev.getAction() == MotionEvent.ACTION_MOVE)
            return true;
        return super.dispatchTouchEvent(ev);
    }
}
