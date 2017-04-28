package zeven.weixin;

import android.app.Service;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import zeven.demos.R;


/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：15/11/19 下午4:59
 */
public class ToolItemView extends RelativeLayout {

    private String code;
    private ImageView image ;
    private TextView textView;


    public ToolItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ToolItemView(Context context,String code,int id,int count) {
        super(context);
        this.code=code;
        init(context, id,count);
    }
    public ToolItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    private void init(Context context, int id,int count) {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(context).inflate(id, null);
        image = (ImageView) layout.findViewById(R.id.image);
        textView = (TextView) layout.findViewById(R.id.text_name);

        int width = ((WindowManager)context.getSystemService(Service.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        float dp = getResources().getDisplayMetrics().density;
        layout.setLayoutParams(new LayoutParams(width / count, (int) (dp*48)));

        addView(layout);

    }

    public void setImage(int imageID) {
        image.setBackgroundResource(imageID);
    }

    public void setTextView(String text) {
       textView.setText(text);
    }

    public String getCode() {
        return code;
    }

}
