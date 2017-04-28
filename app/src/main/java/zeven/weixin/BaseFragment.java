package zeven.weixin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：15/11/19 上午11:16
 */
public class BaseFragment extends Fragment{
    String name;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        name = (String) args.get("name");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView text = new TextView(getActivity());
        text.setText(name);
        text.setTextSize(20f);
        return text;
    }
}
