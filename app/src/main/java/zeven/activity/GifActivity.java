package zeven.activity;

import android.os.Bundle;

import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.view.GifView;

public class GifActivity extends BaseActivity {
	 private GifView gif1, gif2;
	  
	    @Override  
	    public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.activity_gif);
	        gif1 = (GifView) findViewById(R.id.gif1);
	        // 设置背景gif图片资源  
	        gif1.setMovieResource(R.raw.demo);  
	       
	        // 设置暂停  
	        // gif2.setPaused(true);  
	  
	    }

}
