package zeven.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import java.util.List;

import zeven.demos.R;

public class GridViewAdaptor extends AbsCommomAdapter<Integer> {
	Activity rootview ;

	public GridViewAdaptor(Context context, List<Integer> datas,int resourceID) {
		super(context, datas,resourceID);
	}

	@Override
	protected void injectData(final ViewHolder holder, final Integer integer) {
		((ImageView)holder.getViewById(R.id.attachment_attend_imageview)).setImageResource(integer);
		holder.setOnClickListener(R.id.attachment_attend_imageview, new OnClickListener() {
			@Override
			public void onClick(View v) {
				((ImageView)rootview.findViewById(R.id.gridview_large)).setImageResource(integer);
			}
		});
		holder.getViewById(R.id.delete_photo_btn).setBackgroundResource(R.mipmap.icon_pause);
		holder.getViewById(R.id.delete_photo_btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				holder.getViewById(R.id.attachment_attend_imageview).setBackgroundColor(Color.GRAY);
			}
		});
	}

	public void setRootview(Activity rootview) {
		this.rootview = rootview;
	}
}
