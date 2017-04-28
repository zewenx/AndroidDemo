package zeven.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/21 下午1:28
 */
public abstract class AbsCustomDrawable extends Drawable {
    protected Bitmap mBitmap;
    protected Paint mPaint;


    public AbsCustomDrawable(Bitmap bitmap) {
        mBitmap = bitmap;
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        mPaint = new Paint();
        mPaint.setShader(shader);
        mPaint.setAntiAlias(true);
    }


    //wrap_content 提供尺寸
    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    //wrap_content 提供尺寸
    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
