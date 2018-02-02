package smartphoneapp_project.kanazawaapp_2017.WashiGame;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Washi1Activity extends Activity implements SensorEventListener {

    private Button button_segue;

//    public  void  onClick(View v){
//
//        Intent intent = new Intent(Washi1Activity.this,Washi.class);
//        startActivity(intent);
//    }


    private static final String LOG_TAG = "WASHI1";

    private JayroMovableLayout jayroMovableLayout;
    private SensorManager sensorManager;

    private JayroMovableLayout.SensorListenerUnregister unregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_washi1);
        Button button = (Button) findViewById(R.id.test);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Washi1Activity.this, Washi.class);
                startActivity(intent);
            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        jayroMovableLayout = (JayroMovableLayout) findViewById(R.id.jayro_movable_layout);

        ImageView washiView = new ImageView(this);
        washiView.setId(View.generateViewId());
        washiView.setImageResource(R.drawable.kami2);
        washiView.setScaleType(ImageView.ScaleType.FIT_XY);
        washiView.setScaleX(2);
        washiView.setScaleY(2);
        jayroMovableLayout.addView(washiView, 16.0f);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onResume() {
        super.onResume();
        unregister = jayroMovableLayout.listenSensorListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (unregister != null) {
            unregister.unregister();
        }

        sensorManager.unregisterListener(this);
    }

    private int count;
    private int shaken;

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER) {
            return;
        }

        count += Math.abs(event.values[0]);
        count += Math.abs(event.values[1]);

        if (count > 500) {
            Toast.makeText(this, "ふって！", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, count + "");
            shaken++;

            if (shaken == 3) {
                Toast.makeText(this, "かんせい！！", Toast.LENGTH_SHORT).show();
                shaken = 0;
                Intent intent = new Intent(Washi1Activity.this, Washi2Activity.class);
                startActivity(intent);
            }
            count = 0;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}