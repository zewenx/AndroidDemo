package zeven.eventbus;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import zeven.demos.R;


public class DetailFragment extends Fragment {
	public static Handler mHandler;
	TextView text;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_detailfragment, container);
		text = (TextView) view.findViewById(R.id.fragment_detail_text);
		return view;
	}

	@Subscribe
	public void onEventMainThread(ItemVO item) {
		// TODO Auto-generated method stub
		text.setText(item.getMessage());
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
}
