package zeven.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.view.FlowLinearlayout;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/3/24 上午11:03
 */
public class FlowLayoutActivity extends BaseActivity implements OnClickListener {
    Random random = new Random(System.currentTimeMillis());
    @Bind(R.id.flowLayout)
    FlowLinearlayout flowLayout;
    int count = 0;
    Animation animationa;
    AnimationSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout);
        ButterKnife.bind(this);
        nextAnimation();
    }

    private void nextAnimation() {
        if (count > 127) return;
        TextView view = new TextView(this);
        view.setText("" + count++);
        view.setTextSize(20);
        view.setGravity(Gravity.CENTER);
        view.setBackgroundColor(getRandomint());
        view.setLayoutParams(new ViewGroup.LayoutParams(getRandomWidth(), getRandomHeight()));
        view.setOnClickListener(this);
        if (count==2)
            view.setVisibility(View.GONE);
        flowLayout.addView(view);
        animationa = new RotateAnimation(0f, 18000f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animationa.setDuration((long) (random.nextDouble() * 1500 + 500));
        animationa.setInterpolator(new DecelerateInterpolator());
        animationa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                nextAnimation();
               nextAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        set = new AnimationSet(true);

        TranslateAnimation animationb = new TranslateAnimation(200,1000,500,500);
        animationb.setDuration((long) (random.nextDouble() * 1500 + 5005));
        animationb.setInterpolator(new LinearInterpolator());
        set.addAnimation(animationa);
//        set.addAnimation(animationb);
        view.setAnimation(set);
        set.startNow();
    }

    private int getRandomint() {
        return (int) (random.nextDouble() * 0xffffff) + 0xff000000;
    }

    private int getRandomHeight() {

        return (int) (random.nextDouble() * 40 + 80);
    }

    private int getRandomWidth() {
        return (int) (random.nextDouble() * 60 + 100);
    }

    @Override
    public void onClick(View v) {
//        TextView view = new TextView(this);
//        view.setText("" + count);
//        view.setTextSize(20);
//        view.setGravity(Gravity.CENTER);
//        view.setBackgroundColor(getRandomint());
//        view.setLayoutParams(new ViewGroup.LayoutParams(getRandomWidth(), getRandomHeight()));
//        view.setOnClickListener(this);
//        flowLayout.addView(view);
//        flowLayout.invalidate();
//        count++;
        v.setVisibility(View.GONE);
        flowLayout.requestLayout();
    }
}
