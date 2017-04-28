package zeven.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.util.List;

import zeven.demos.R;
import zeven.vo.MainItemViewVO;


/**
 * Created by zeven on 15/10/30.
 */
public class MainListViewAdater extends AbsCommomAdapter<MainItemViewVO> {
    public MainListViewAdater(Context context, List<MainItemViewVO> datas, int resourceID) {
        super(context, datas, resourceID);
    }

    @Override
    protected void injectData(ViewHolder holder, MainItemViewVO mainItemViewVO) {
        holder.setTextViewText(R.id.name, mainItemViewVO.getName());
        holder.setTextViewText(R.id.function, mainItemViewVO.getFunction());
        final Class clazz = mainItemViewVO.getClassName();
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainListViewAdater.this.context, clazz);
                MainListViewAdater.this.context.startActivity(intent);
            }
        });

    }
}
