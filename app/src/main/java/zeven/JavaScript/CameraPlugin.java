package zeven.JavaScript;

import android.content.Intent;

import org.json.JSONArray;

import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.StandardFeature;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/15 上午10:49
 */
public class CameraPlugin extends StandardFeature {
    public void CameraFunction(IWebview webview, JSONArray array) {


        Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        webview.getContext().startActivity(i);

    }
}
