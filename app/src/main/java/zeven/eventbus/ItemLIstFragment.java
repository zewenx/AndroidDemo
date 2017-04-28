package zeven.eventbus;

import android.app.ListFragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import zeven.demos.R;


public class ItemLIstFragment extends ListFragment{
	public static Handler mHandler;
	ArrayList<ItemVO> dataList = new ArrayList<ItemVO>();
	TextView text;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
		
		for (int i = 0; i < 100; i++) {
			dataList.add(new ItemVO().setMessage("item "+i));
		}
		
		setListAdapter(new ArrayAdapter<ItemVO>(getActivity(), R.layout.layout_detailfragment,R.id.fragment_detail_text,dataList));
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		EventBus.getDefault().post(dataList.get(position));
	}

	@Subscribe
	public void onEventMainThread(ItemVO item)
    {  
       
    } 
}
