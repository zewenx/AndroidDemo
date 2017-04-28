package zeven.activity;

import android.os.Bundle;

import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.imports.titanic.Titanic;
import zeven.imports.titanic.TitanicTextView;
import zeven.imports.titanic.Typefaces;


public class TitanicDemoActivity extends BaseActivity {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_titanic);

	        TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);

	        // set fancy typeface
	        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

	        // start animation
	        new Titanic().start(tv);
	    }
}
