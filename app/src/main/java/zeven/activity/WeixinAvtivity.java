package zeven.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.weixin.BaseFragment;
import zeven.weixin.ColleagueFragment;
import zeven.weixin.NetnodeFragment;
import zeven.weixin.SettingFragment;
import zeven.weixin.StatisticsFragment;
import zeven.weixin.ToolItemVO;
import zeven.weixin.ToolItemView;
import zeven.weixin.VisitFragment;
import zeven.weixin.WAGridView;
import zeven.weixin.WAGridViewAdapter;


/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：15/11/17 下午7:22
 */
public class WeixinAvtivity extends BaseActivity implements WAGridViewAdapter.ClickActionListener{

    Map<String, BaseFragment> fragments = new HashMap<String, BaseFragment>();
    List<ToolItemVO> items = new ArrayList<ToolItemVO>();
    @Bind(R.id.main_content)
    FrameLayout mainContent;
    @Bind(R.id.main_tools)
    WAGridView mainTools;
    BaseFragment previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin);
        ButterKnife.bind(this);
        initData();
        initView();
//        previous = fragments.get("visit");
//        mainContent.addView(previous.getView());
        setDefault(fragments.get("visit"));
    }



    private void initView() {
        WAGridViewAdapter adapter = new WAGridViewAdapter(this,items,this);
        adapter.notifyDataSetChanged();

        mainTools.setNumColumns(items.size());
        mainTools.setAdapter(adapter);

        Bundle bundle = new Bundle();
        VisitFragment visitFragment = new VisitFragment();
        bundle.putString("name",items.get(0).getName());
        visitFragment.setArguments(bundle);

        StatisticsFragment statisticsFragment = new StatisticsFragment();
        bundle.putString("name",items.get(3).getName());
        statisticsFragment.setArguments(bundle);

        SettingFragment settingFragment = new SettingFragment();
        bundle.putString("name",items.get(4).getName());
        settingFragment.setArguments(bundle);

        ColleagueFragment colleagueFragment = new ColleagueFragment();
        bundle.putString("name",items.get(2).getName());
        colleagueFragment.setArguments(bundle);

        NetnodeFragment netnodeFragment = new NetnodeFragment();
        bundle.putString("name",items.get(1).getName());
        netnodeFragment.setArguments(bundle);

        fragments.put("visit", visitFragment);
        fragments.put("statistics", statisticsFragment);
        fragments.put("setting", settingFragment);
        fragments.put("colleague", colleagueFragment);
        fragments.put("netnode", netnodeFragment);

    }

    private void initData() {

        ToolItemVO vo = new ToolItemVO();
        vo.setCode("CM01");
        vo.setName("拜访");
        items.add(vo);
        vo = new ToolItemVO();
        vo.setCode("CM02");
        vo.setName("网点");
        items.add(vo);
        vo = new ToolItemVO();
        vo.setCode("CM03");
        vo.setName("同事");
        items.add(vo);
        vo = new ToolItemVO();
        vo.setCode("CM04");
        vo.setName("报表");
        items.add(vo);
        vo = new ToolItemVO();
        vo.setCode("CM00");
        vo.setName("设置");
        items.add(vo);
    }

    private void setDefault(BaseFragment fragment) {
//        if (previous!= fragment) {
//            mainContent.addView(fragment.getView());
//            mainContent.setanim
//            mainContent.setInAnimation(this, R.anim.right_in);
//            mainContent.setOutAnimation(this, R.anim.right_out);
//            mainContent.showNext();
//            mainContent.removeViewAt(0);
//            previous = fragment;

            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.main_content, fragment);
            transaction.commit();
//        }
    }

    @Override
    public void OnClick(ToolItemView view) {
        switch (view.getCode()){
            case "CM00":
                setDefault(fragments.get("setting"));
                break;
            case "CM01":
                setDefault(fragments.get("visit"));
                break;
            case "CM02":
                setDefault(fragments.get("netnode"));
                break;
            case "CM03":
                setDefault(fragments.get("colleague"));
                break;
            case "CM04":
                setDefault(fragments.get("statistics"));
                break;
        }
    }
}
