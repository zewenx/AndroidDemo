package zeven.weixin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import zeven.demos.R;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：15/11/19 下午4:53
 */
public class WAGridViewAdapter extends BaseAdapter {
    List<ToolItemVO> datas;
    List<ToolItemView> viewList = new ArrayList<ToolItemView>();
    ClickActionListener listener;

    public WAGridViewAdapter(Context context, List<ToolItemVO> datas, final ClickActionListener listener) {
        this.datas = datas;
        this.listener = listener;
        for (ToolItemVO vo : datas){
            ToolItemView view = new ToolItemView(context, vo.getCode(), R.layout.layout_toolitem,datas.size());
            view.setTextView(vo.getName());
            viewList.add(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnClick((ToolItemView)v);
                }
            });
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return viewList.get(position);
    }

    public interface ClickActionListener{
        public void OnClick(ToolItemView view);
    }
}
