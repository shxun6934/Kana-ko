package smartphoneapp_project.kanazawaapp_2017;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;




public class Washi1Activity extends Activity implements SensorEventListener,View.OnClickListener {

    private static final String LOG_TAG = "WASHI1";
    private JayroMovableLayout jayroMovableLayout;
    private SensorManager sensorManager;

    private JayroMovableLayout.SensorListenerUnregister unregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_washi1);

        TextView imageButton = (TextView) findViewById(R.id.difficulty_back_button);
        imageButton.setOnClickListener(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        jayroMovableLayout = (JayroMovableLayout) findViewById(R.id.jayro_movable_layout);

        ImageView washiView = new ImageView(this);
        washiView.setId(View.generateViewId());
        washiView.setImageResource(R.drawable.kami2);
        washiView.setScaleType(ImageView.ScaleType.FIT_XY);
        washiView.setScaleX(2);
        washiView.setScaleY(2);
        jayroMovableLayout.addView(washiView, 16.0f);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);

    }

    public void onClick(View v) {
        //Log.d("aaa","aaaaaaa");
        Intent intent = new Intent(getApplicationContext(),MapActivity.class);
        startActivity(intent);
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
        if(sensorManager!=null) {
            sensorManager.unregisterListener(this);
        }
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