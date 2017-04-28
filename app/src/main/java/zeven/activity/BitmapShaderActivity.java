package zeven.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.drawable.CircleImageDrawable;
import zeven.drawable.RoundImageDrawable;
import zeven.utils.Calculator;
import zeven.view.BitmapShaderView;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/21 上午10:16
 */
public class BitmapShaderActivity extends BaseActivity implements OnClickListener {
    @Bind(R.id.layout_bitmap)
    LinearLayout layoutBitmap;
    @Bind(R.id.test_background)
    TextView testBackground;
    @Bind(R.id.test_imageView)
    ImageView testImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmapshader);
        ButterKnife.bind(this);
        Calculator.init(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.adorable);
        testBackground.setBackground(new RoundImageDrawable(bitmap));

        testImageView.setBackground(new CircleImageDrawable(bitmap).setRadius(Calculator.dp2px(150)).setXY(Calculator.dp2px(150),Calculator.dp2px(150)));

        ImageView iv = new ImageView(this);
        CircleImageDrawable drawable = new CircleImageDrawable(bitmap);
        iv.setImageDrawable(drawable);
        add(iv);

        TextView textView = new TextView(this);
        textView.setText("love is unreasonable");
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextColor(Color.YELLOW);
        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setBackground(new RoundImageDrawable(bitmap));
        add(textView);

        textView = new TextView(this);
        textView.setText("sunshine in the rain");
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.YELLOW);
        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setBackground(new CircleImageDrawable(bitmap));
        add(textView);

        iv = new ImageView(this);
        iv.setImageDrawable(new CircleImageDrawable(bitmap).setRadius(400));
        add(iv);

        BitmapShaderView view = new BitmapShaderView(this);
        add(view);
        view.setOnClickListener(this);
    }

    void add(View view) {
        layoutBitmap.addView(view);
    }

    @Override
    public void onClick(View v) {
        throw new NullPointerException();
    }
}
