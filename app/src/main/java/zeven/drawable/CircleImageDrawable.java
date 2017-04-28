package zeven.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/21 下午1:28
 */
public class CircleImageDrawable extends AbsCustomDrawable {

    float radius = 0;
    float x,y;

    public CircleImageDrawable(Bitmap bitmap) {
        super(bitmap);
    }


    public CircleImageDrawable setRadius(float radius) {
        this.radius = radius;
        return this;
    }
    public CircleImageDrawable setXY(float x,float y ){
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public void draw(Canvas canvas) {
        if (radius == 0) {
            radius = Math.min(mBitmap.getHeight(),mBitmap.getWidth())/2;
        }
        if (x == 0){
            x = mBitmap.getWidth()/2;
        }
        if (y==0){
            y = mBitmap.getHeight()/2;
        }

        canvas.drawCircle(x , y , radius, mPaint);
    }
}
