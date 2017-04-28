package zeven.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
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
public class BallGameActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.ball2)
    TextView ball2;

    int height;
    int width;
    float speedx = 5f;
    float speedy = 5f;
    ValueAnimator animator;
    float pre = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_ballgame);

        ButterKnife.bind(this);
        init();
        ball2.setOnClickListener(this);

    }

    private void init() {
        width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        height = getWindow().getWindowManager().getDefaultDisplay().getHeight();
    }


    @Override
    public void onClick(View v) {
        animator = ObjectAnimator.ofFloat(0f, 300f);
        animator.setDuration(30000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float p = (float) animation.getAnimatedValue();
                if (p - pre > 5) {
                    if (Math.abs(speedx) < 60) {
                        speedx *= 1.1f;
                        speedy *= 1.1f;
                    }
                    pre = p;
                }
                float x = ball2.getX();
                float y = ball2.getY();
                int heightball = ball2.getWidth();
                int widthball = ball2.getWidth();
                if (x + speedx + widthball > width || x + speedx < 0) {
                    speedx = -speedx;
                }
                if (y + speedy + heightball > height || y + speedy < 0) {
                    speedy = -speedy;

                }
                x = x + speedx;
                y = y + speedy;
//                x += Math.random();
                ball2.setX(x);
                ball2.setY(y);
            }

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (animator != null)
            animator.cancel();
    }
}
