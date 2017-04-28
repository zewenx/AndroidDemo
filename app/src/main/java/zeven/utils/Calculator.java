package zeven.utils;

import android.content.Context;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/19 下午4:31
 */
public class Calculator {
    private static Calculator instance;
    Context context;
    private Calculator(Context context) {
        this.context = context;
    }

    public static void init(Context context){
        if (instance==null)
            instance = new Calculator(context);
    }
    public static int dp2px(int s){
        float density = instance.context.getResources().getDisplayMetrics().density;
        return (int) (density*s);
    }
}
