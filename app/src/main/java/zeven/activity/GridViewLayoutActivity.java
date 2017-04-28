package zeven.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import zeven.adapter.GridViewAdaptor;
import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.utils.ViewFinders;

public class GridViewLayoutActivity extends BaseActivity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//没有标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//没有状态栏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_gridview);
		GridView grid = ViewFinders.findView(R.id.gridview_v1, this);
		ArrayList<Integer> dataList = new ArrayList<Integer>();
		dataList.add(R.mipmap.p2);
		dataList.add(R.mipmap.p3);
		dataList.add(R.mipmap.p4);
		dataList.add(R.mipmap.p5);
		dataList.add(R.mipmap.p6);
		dataList.add(R.mipmap.p7);
		dataList.add(R.mipmap.p8);
		dataList.add(R.mipmap.p9);
		dataList.add(R.mipmap.p5);
		GridViewAdaptor adapter = new GridViewAdaptor( this,dataList, R.layout.layout_attachment_attend);
		grid.setAdapter(adapter);
		adapter.setRootview(this);
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
	}
}
