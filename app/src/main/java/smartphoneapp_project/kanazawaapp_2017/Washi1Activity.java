package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.List;

public class Washi1Activity extends Activity implements SensorEventListener {
    private static final String LOG_TAG = "WASHI1";

    private SensorManager sensorManager;
    private SensorView sensorView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        sensorView = new SensorView(this);
//        setContentView(sensorView);
        setContentView(R.layout.activity_washi1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // 加速度センサー
        List<Sensor> sensors = sensorManager
                .getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) {
            sensorManager.registerListener(this, sensors.get(0),
                    SensorManager.SENSOR_DELAY_GAME);
        }
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
                // Log.d(LOG_TAG, "ACCELEROMETER : " + event.values[0] + ","
                // + event.values[1] + "," + event.values[2]);
                sensorView.move(event.values[0], event.values[1]);

                break;
            default:
                break;
        }
    }


    class SensorView extends View {
        private static final int WASHI_SIZE = 50;
        private Bitmap washi1;
        private int w;
        private int h;
        private float x;
        private float y;

        public SensorView(Context context) {
            super(context);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            washi1 = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.kami2);
        }


        public void move(float mx, float my) {
            this.x -= (mx * 4f);
            this.y += (my * 4f);

            if (this.x < 0) {
                this.x = 0;
            } else if ((this.x + WASHI_SIZE) > this.w) {
                this.x = this.w - WASHI_SIZE;
            }

            if (this.y < 0) {
                this.y = 0;
            } else if ((this.y + WASHI_SIZE) > this.h) {
                this.y = this.h - WASHI_SIZE;
            }

            invalidate();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            this.w = w;
            this.h = h;
            this.x = (w - WASHI_SIZE) / 2f;
            this.y = (h - WASHI_SIZE) / 2f;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(washi1, x, y, null);
        }

    }
}