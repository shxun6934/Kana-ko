package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;



public class Washi1Activity extends Activity implements SensorEventListener  {

    private Button button_segue;

/*
    public  void  onClick(View v){

        Intent intent = new Intent(Washi1Activity.this,Washi.class);
        startActivity(intent);
    }
  */




    private static final String LOG_TAG = "WASHI1";

    private SensorManager sensorManager;
    private SensorView sensorView;

    private static int screenWidth;
    private static int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_washi1);
        Button button = (Button)findViewById(R.id.test);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Washi1Activity.this, Washi.class);
                startActivity(intent);
            }
        });





        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();

        Point realSize = new Point();
        disp.getRealSize(realSize);

        screenWidth = realSize.x;
        screenHeight = realSize.y;

        sensorView = new SensorView(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // 加速度センサー
        List<Sensor> sensors = sensorManager
                .getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) {
            sensorManager.registerListener(this, sensors.get(0),
                    SensorManager.SENSOR_DELAY_GAME);
        }

        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.kami_container);
        frameLayout.addView(sensorView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(final Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onSensorChanged(final SensorEvent event) {
        Sensor sensor = event.sensor;
        switch (sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
//                 Log.d(LOG_TAG, "ACCELEROMETER : " + event.values[0] + ","
//                 + event.values[1] + "," + event.values[2]);
                sensorView.move(event.values[0], event.values[1]);

                break;
            default:
                break;
        }
    }

    class SensorView extends ImageView {
        private static final int WASHI_SIZE = 50;
        private float x;
        private float y;

        private int parentWidth;
        private int parentHeight;

        public SensorView(Context context) {
            super(context);
            Bitmap washi1 = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.kami2);
            setImageBitmap(washi1);
        }

        public void move(float mx, float my) {
            if (parentWidth == 0 || parentHeight == 0) {
                return;
            }
            this.x -= (mx * 4);
            this.y += (my * 4);

            setLeft((int) x);
            setTop((int) y);

            invalidate();
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            parentWidth = right;
            parentHeight = bottom;
        }
    }
}