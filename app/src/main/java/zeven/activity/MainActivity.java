package zeven.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import zeven.adapter.MainListViewAdater;
import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.eventbus.FragmentsActivity;
import zeven.vo.MainItemViewVO;


public class MainActivity extends BaseActivity {
    @Bind(R.id.main_list)
    ListView mainList;

    ArrayList<MainItemViewVO> dataList = new ArrayList<MainItemViewVO>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        showList();
        setStartActivity(BitmapShaderActivity.class);
    }
    public void setStartActivity(Class clazz){
        if (clazz != null) {
            Intent intent = new Intent(MainActivity.this, clazz);
            startActivity(intent);
        }
    }
    private void showList() {
        MainListViewAdater adater = new MainListViewAdater(this,dataList,R.layout.layout_main_listview);
        mainList.setAdapter(adater);
        adater.notifyDataSetChanged();
    }

    private void init() {
        MainItemViewVO vo = new MainItemViewVO();
        vo.setClassName(GifActivity.class);
        vo.setName("Gif");
        vo.setFunction("a self-defined gif view");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(CalendarDemoActivity.class);
        vo.setName("Calendar");
        vo.setFunction("gridView ,animation,ViewFlipper，OnGestureListener");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(CameraDemoActivity.class);
        vo.setName("Camera");
        vo.setFunction("shape,SurfaceView,camera");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(FlipperDemoActivity.class);
        vo.setName("Flipper");
        vo.setFunction("animation,ViewFlipper，OnGestureListener");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(GridViewLayoutActivity.class);
        vo.setName("GridView");
        vo.setFunction("layout of gridview");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(HorizontalListViewDemoActivity.class);
        vo.setName("Horizontal Scroll");
        vo.setFunction("imageView , scroll in horizontal direction");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(TitanicDemoActivity.class);
        vo.setName("Titanic Loading Animation");
        vo.setFunction("animation,shape");
        dataList.add(0,vo);


        vo = new MainItemViewVO();
        vo.setClassName(FragmentsActivity.class);
        vo.setName("Fragment");
        vo.setFunction("fragment eventbus");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(LoadingActivity.class);
        vo.setName("Loading");
        vo.setFunction("loading animation");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(WeixinAvtivity.class);
        vo.setName("WeiXinDemo");
        vo.setFunction("fragment animation");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(LayoutTestActivity.class);
        vo.setName("LayoutTestActivity");
        vo.setFunction("layoutinflator");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(FlowLayoutActivity.class);
        vo.setName("FlowLayoutActivity");
        vo.setFunction("onlayout,onmeasure");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(BallGameActivity.class);
        vo.setName("ball game");
        vo.setFunction("animation game");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(SurfaceViewActivity.class);
        vo.setName("surface");
        vo.setFunction("surfaceview");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(PicassoDemoActivity.class);
        vo.setName("picasso");
        vo.setFunction("picasso imageview demo");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(JavaScriptInteractionActivity.class);
        vo.setName("JavaScriptInteractionActivity");
        vo.setFunction("html5");
        dataList.add(0,vo);

        vo = new MainItemViewVO();
        vo.setClassName(BitmapShaderActivity.class);
        vo.setName("bitmapShader");
        vo.setFunction("bitmap shader");
        dataList.add(0,vo);
    }


}
