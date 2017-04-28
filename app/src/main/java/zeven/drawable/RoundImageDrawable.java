package zeven.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/21 下午1:28
 */
public class RoundImageDrawable extends AbsCustomDrawable {
    protected RectF rectF;

    public RoundImageDrawable(Bitmap bitmap) {
       super(bitmap);
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        rectF = new RectF(left, top, right, bottom);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(rectF, 100, 100, mPaint);
    }


}
