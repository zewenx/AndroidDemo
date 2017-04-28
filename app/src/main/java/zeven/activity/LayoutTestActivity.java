package zeven.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zeven.base.BaseActivity;
import zeven.demos.R;


/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：15/11/17 下午7:30
 */
public class LayoutTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_test);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_button,null);
        ViewGroup group = (ViewGroup) findViewById(R.id.activity_layout_test);
        group.addView(view);
    }



}
