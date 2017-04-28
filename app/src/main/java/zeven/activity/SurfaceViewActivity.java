package zeven.activity;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.Bind;
import butterknife.ButterKnife;
import zeven.base.BaseActivity;
import zeven.demos.R;

public class SurfaceViewActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.normal)
    Button normal;
    @Bind(R.id.surface)
    Button surface;
    @Bind(R.id.surface_animate)
    SurfaceView surfaceAnimate;
    @Bind(R.id.image_normal)
    ImageView imageNormal;

    ExecutorService executor;

    public static boolean exited = false;

    SurfaceHolder holder;
    DrawThread thread;
    int hei = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_surfaceview);

        ButterKnife.bind(this);
        init();
        holder = surfaceAnimate.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                executor.shutdownNow();
            }
        });
    }

    private void init() {
        surface.setOnClickListener(this);
        normal.setOnClickListener(this);
        executor = Executors.newFixedThreadPool(8);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(surface)) {
            for (int i = 0; i < 4; i++) {
                thread = new DrawThread(hei);
                hei += 25;
                executor.submit(thread);
            }
        } else if (v.equals(normal)) {
            normalDraw();
        }
    }

    private void normalDraw() {
        Bitmap bitmap = Bitmap.createBitmap(imageNormal.getMeasuredWidth(), imageNormal.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Paint p = new Paint();
        p.setStrokeWidth(3f);
        p.setColor(Color.GREEN);
        float x0 = 50, y0 = (float) Math.sin(x0 / 60) * 100 + hei, x1, y1;
        for (int i = 51; i < 1000; i++) {
            Canvas canvas = new Canvas(bitmap);
            x1 = i;
            y1 = (float) Math.sin(x1 / 60) * 100 + hei;
            canvas.drawLine(x0, y0, x1, y1, p);
            x0 = x1;
            y0 = y1;
            canvas.save();
            BitmapDrawable drawable = new BitmapDrawable(null, bitmap);
            imageNormal.setBackground(drawable);
            imageNormal.invalidate();
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    class DrawThread extends Thread {
        public float hei = 300;


        public DrawThread(float hei) {
            this.hei = hei;
        }

        @Override
        public void run() {
            int size = 0;
            Paint p = new Paint();
            p.setStrokeWidth(10f);
            p.setColor(Color.GREEN);
            float x0 = 50, y0 = (float) Math.sin(x0 / 60) * 100 + hei, x1, y1;
            for (int i = 51; i < 1000; i++) {
                x1 = i;
                y1 = (float) Math.sin(x1 / 60) * 100 + hei;
                Canvas c = holder.lockCanvas(new Rect((int) (x0 - size), 0, (int) (x1 + size), surfaceAnimate.getHeight()));
                c.drawLine(x0, y0, x1, y1, p);
                x0 = x1;
                y0 = y1;
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    holder.unlockCanvasAndPost(c);
                }
            }
        }
    }

}
