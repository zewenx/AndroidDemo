package zeven.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class HorizontalListViewAdapter extends BaseAdapter{

	int ids[];
	public void setImage(int ids[]) {
		this.ids = ids;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ids.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return ids[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
