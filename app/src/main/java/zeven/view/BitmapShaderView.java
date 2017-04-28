package zeven.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import zeven.demos.R;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/21 上午10:21
 */
public class BitmapShaderView extends View {
    private BitmapShader shader;
    private ShapeDrawable shapeDrawable;
    private Bitmap bitmap;

    public BitmapShaderView(Context context) {
        super(context);
        init();
    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        bitmap = ((BitmapDrawable)getResources().getDrawable(R.mipmap.adorable)).getBitmap();
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        setLayoutParams(new LinearLayout.LayoutParams(bitmap.getWidth(),bitmap.getHeight()));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //构建ShapeDrawable对象并定义形状为椭圆
//        shapeDrawable = new ShapeDrawable(new OvalShape());
//        //得到画笔并设置渲染器
//        shapeDrawable.getPaint().setShader(shader);
//        //设置显示区域
//        shapeDrawable.setBounds(20, 20,bitmap.getWidth()-140,bitmap.getHeight());
        //绘制shapeDrawable
        Paint paint = new Paint();
        paint.setShader(shader);
        paint.setAntiAlias(true);
        canvas.drawOval(new RectF(0,0,bitmap.getWidth(),bitmap.getHeight()),paint);
    }
}
