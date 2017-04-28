package zeven.JavaScript;

import org.json.JSONArray;
import org.json.JSONException;

import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.StandardFeature;
import zeven.base.BaseActivity;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/15 上午10:49
 */
public class ToastPlugin extends StandardFeature {
    public void toastMessage(IWebview webview, JSONArray array) {

        try {
            ((BaseActivity)webview.getActivity()).toastText(array.get(0).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
