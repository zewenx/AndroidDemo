package zeven.activity;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import zeven.base.BaseActivity;
import zeven.demos.R;
import zeven.view.ButtonView;
import zeven.view.CameraSurfaceView;

public class CameraDemoActivity extends BaseActivity implements OnClickListener {
    @Bind(R.id.camera_frame)
    FrameLayout cameraFrame;
    @Bind(R.id.cancel_camera)
    ButtonView cancelCamera;
    @Bind(R.id.hit_camera)
    ButtonView hitCamera;
    @Bind(R.id.save_camera)
    ButtonView saveCamera;

    @Bind(R.id.switch_camera)
    Button switchCamera;

    int cameraNum=0;

    Camera camera;
    CameraSurfaceView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);
        initOldApi();


    }

    private void initOldApi() {
        hitCamera.setOnClickListener(this);
        saveCamera.setOnClickListener(this);
        cancelCamera.setOnClickListener(this);
        switchCamera.setOnClickListener(this);

        camera = Camera.open(cameraNum);
        initCamera(camera);

        view = new CameraSurfaceView(this, camera);
        cameraFrame.addView(view);
    }

    private void initCamera(Camera camera) {
        int w = getWindowManager().getDefaultDisplay().getWidth();
        int h = getWindowManager().getDefaultDisplay().getHeight();

        Camera.Parameters params = camera.getParameters();
//        params.setSceneMode(Camera.Parameters.FOCUS_MODE_AUTO);
        Camera.Size size = getOptimalPreviewSize(params.getSupportedPictureSizes(),w,h);
//        params.setPreviewSize(size.width,size.height);
        params.set("rotation","90");
        camera.setParameters(params);
    }

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> sizes, int w, int h) {
        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) w / h;
        if (sizes == null) return null;

        Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        // Try to find an size match aspect ratio and size
        for (Camera.Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        // Cannot find the one match the aspect ratio, ignore the requirement
        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Camera.Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }


    @Override
    public void onClick(View v) {
        if (v.equals(cancelCamera)) {
            this.finish();
        }else if(v.equals(switchCamera)){
            int size = Camera.getNumberOfCameras();
            cameraNum = (cameraNum+1)%size;
            camera.stopPreview();
            camera.release();
            camera = Camera.open(cameraNum);
            view.switchCamera(camera);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        camera.release();

    }
}
