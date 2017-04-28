package zeven.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.FrameLayout;

import io.dcloud.EntryProxy;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.feature.internal.sdk.SDK;
import zeven.JavaScript.CoreStatusListener;
import zeven.base.BaseActivity;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/15 上午10:00
 */
public class JavaScriptInteractionActivity extends BaseActivity  {
    EntryProxy mEntryProxy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mEntryProxy== null){
            FrameLayout rootView = new FrameLayout(this);
            // 创建5+内核运行事件监听
            CoreStatusListener wm = new CoreStatusListener(this,rootView);
            // 初始化5+内核
            mEntryProxy = EntryProxy.init(this,wm);
            // 启动5+内核，并指定内核启动类型
            mEntryProxy.onCreate(savedInstanceState, SDK.IntegratedMode.WEBVIEW,null);
            setContentView(rootView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return mEntryProxy.onActivityExecute(this, ISysEventListener.SysEventType.onCreateOptionMenu, menu);
    }
    @Override
    public void onPause() {
        super.onPause();
        mEntryProxy.onPause(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mEntryProxy.onResume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEntryProxy.onStop(this);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        int temp = this.getResources().getConfiguration().orientation;
        if(mEntryProxy != null){
            mEntryProxy.onConfigurationChanged(this, temp);
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean ret = mEntryProxy.onActivityExecute(this, ISysEventListener.SysEventType.onKeyDown, new Object[]{ keyCode, event});
        return ret ? ret : super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        boolean ret = mEntryProxy.onActivityExecute(this, ISysEventListener.SysEventType.onKeyLongPress, new Object[]{ keyCode, event});
        return ret ? ret : super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean ret = mEntryProxy.onActivityExecute(this, ISysEventListener.SysEventType.onKeyUp, new Object[]{ keyCode, event});
        return ret ? ret : super.onKeyUp(keyCode, event);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mEntryProxy.onActivityExecute(this, ISysEventListener.SysEventType.onActivityResult, new Object[] { requestCode, resultCode, data });
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent.getFlags() != 0x10600000){
            mEntryProxy.onNewIntent(this, intent);
        }
    }
}
