package zeven.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import zeven.utils.TagUtil;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/13 上午11:21
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stateMessage("onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        stateMessage("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        stateMessage("onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stateMessage("onDestroy");
    }

    private void stateMessage(String s){
        Log.i(TagUtil.generateALCTag(this),s);
    }

    public void toastText(int id) {
        toastText(this.getResources().getString(id));

    }

    public void toastText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
