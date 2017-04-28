package zeven.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/3/24 上午10:26
 */
public class FlowLinearlayout extends LinearLayout {

    public FlowLinearlayout(Context context) {
        super(context);
    }

    public FlowLinearlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLinearlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        int size = MeasureSpec.makeMeasureSpec(0,MeasureSpec.EXACTLY);
        for (int i = 0; i < getChildCount(); ++i) {
            final View child = getChildAt(i);
           if (child.getVisibility()==GONE){
               child.measure(size,size);
           }
        }
        super.measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int currentWidth = this.getMeasuredWidth();
        int rowCount = 0;
        int rowHeight = 0;
        int startLeft = 0;
        int widthTotal = 0;
        int starttop = 0;
        int measureTop = 0;
        int childCount = getChildCount();
        for (int i = 0;i<childCount;i++){
            View view = getChildAt(i);
            widthTotal+=view.getMeasuredWidth();

            ViewData data = new ViewData();
            if (widthTotal>currentWidth){
                widthTotal=view.getMeasuredWidth();
                startLeft=0;
                starttop+=measureTop;
                measureTop = Math.max(0,view.getMeasuredHeight());
            }else {
                startLeft = widthTotal - view.getMeasuredWidth();
                measureTop = Math.max(measureTop,view.getMeasuredHeight());
            }
            data.left = startLeft;
            data.top = starttop;
            view.setTag(data);

        }

        for (int i = 0;i<childCount;i++){
            View view = getChildAt(i);
            int currentl = 0,currentt = 0,currentr = 0,currentb = 0;
            ViewData data = (ViewData) view.getTag();
            currentl = data.left;
            currentt = data.top;
            currentr = currentl+view.getMeasuredWidth();
            currentb = currentt+view.getMeasuredHeight();
            view.layout(currentl ,currentt ,currentr,currentb );
        }
    }
    public class ViewData{
        public int left;
        public int top;

    }

}
