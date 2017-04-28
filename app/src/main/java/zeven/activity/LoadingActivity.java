package zeven.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zeven.base.BaseActivity;
import zeven.demos.R;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：15/11/17 下午7:30
 */
public class LoadingActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.loading_start)
    Button loadingStart;
    @Bind(R.id.ball1)
    TextView ball1;
    @Bind(R.id.ball2)
    TextView ball2;
    @Bind(R.id.ball3)
    TextView ball3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        ButterKnife.bind(this);


        loadingStart.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ball1, "", 30.0f, -30f)
                .setDuration(20000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
        final int position = (int) ball1.getX();
        final float base = 0.76f;

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float x = (float) animation.getAnimatedValue();
                ball1.setX((float) Math.cos(x * Math.PI / 3.0f) * 150 + position);
                ball1.setAlpha((float) Math.sin(Math.PI / 3.0f * x) / 5 + base);
                ball1.setScaleX((float) Math.sin(Math.PI / 3.0f * x) / 5 + base);
                ball1.setScaleY((float) Math.sin(Math.PI / 3.0f * x) / 5 + base);

                x=-x;
                ball2.setX((float) Math.cos((x-2) * Math.PI / 3.0f) * 150 + position);
                ball2.setAlpha((float) Math.sin(Math.PI / 3.0f * (x-2)) / 5 + base);
                ball2.setScaleX((float) Math.sin(Math.PI / 3.0f * (x-2)) / 5 + base);
                ball2.setScaleY((float) Math.sin(Math.PI / 3.0f * (x-2)) / 5 + base);

                ball3.setX((float) Math.cos((x+2) * Math.PI / 3.0f) * 150 + position);
                ball3.setAlpha((float) Math.sin(Math.PI / 3.0f * (x+2)) / 5 + base);
                ball3.setScaleX((float) Math.sin(Math.PI / 3.0f * (x+2)) / 5 + base);
                ball3.setScaleY((float) Math.sin(Math.PI / 3.0f * (x+2)) / 5 + base);
//                System.out.println( x);
            }
        });
    }
}
