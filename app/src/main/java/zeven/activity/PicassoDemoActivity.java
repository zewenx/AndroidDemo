package zeven.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import zeven.adapter.AbsCommomAdapter;
import zeven.adapter.ViewHolder;
import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.utils.FileUtil;
import zeven.vo.PicasooVO;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/12 下午2:49
 */
public class PicassoDemoActivity extends BaseActivity {
    @Bind(R.id.photo_list)
    ListView photoList;
    List<PicasooVO> urlList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        ButterKnife.bind(this);
        urlList = new ArrayList<>();

        byte[] datas = FileUtil.readFromAssetsFile(this,"urls");
        String s = new String(datas);
        String [] urls = s.split("\n");
        for (String ss : urls){
            PicasooVO vo = new PicasooVO();
            vo.setUrl(ss);
            urlList.add(vo);
        }

        photoList.setAdapter(new AbsCommomAdapter<PicasooVO>(this,urlList,R.layout.layout_picasso_item) {
            @Override
            protected void injectData(ViewHolder holder,final PicasooVO s) {
                final ImageView view = holder.getViewById(R.id.picasso_item);
                TextView link = holder.getViewById(R.id.link);
                Spannable sText = new SpannableString(s.getUrl());
                sText.setSpan(new BackgroundColorSpan(Color.RED),0,19,2);
                sText.setSpan(new BackgroundColorSpan(Color.YELLOW),10,14,0);
                sText.setSpan(new ForegroundColorSpan (Color.GREEN),2,7,0);
                sText.setSpan(new ForegroundColorSpan(Color.BLUE),14,s.getUrl().length(),0);
                sText.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),14,s.getUrl().length(),0);
                link.setText(sText);
//                if (!s.isClicked())
//                    view.setImageDrawable(null);
//                else
                    Picasso.with(PicassoDemoActivity.this).load(s.getUrl()).into(view);
                link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!s.isClicked())
                            Picasso.with(PicassoDemoActivity.this).load(s.getUrl()).into(view);
                        s.setClicked(true);
                    }
                });
            }
        });
    }
}
