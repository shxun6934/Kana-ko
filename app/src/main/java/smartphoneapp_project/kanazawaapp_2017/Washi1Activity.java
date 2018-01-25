package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
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



public class Washi1Activity extends Activity  {

    private Button button_segue;

/*
    public  void  onClick(View v){

        Intent intent = new Intent(Washi1Activity.this,Washi.class);
        startActivity(intent);
    }
  */




    private static final String LOG_TAG = "WASHI1";

    private JayroMovableLayout jayroMovableLayout;
    private SensorManager sensorManager;

    private JayroMovableLayout.SensorListenerUnregister unregister;

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





        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        jayroMovableLayout = (JayroMovableLayout) findViewById(R.id.jayro_movable_layout);

        ImageView washiView = new ImageView(this);
        washiView.setId(View.generateViewId());
        washiView.setImageResource(R.drawable.kami2);
        washiView.setScaleType(ImageView.ScaleType.FIT_XY);
        washiView.setScaleX(2);
        washiView.setScaleY(2);
        jayroMovableLayout.addView(washiView, 16.0f);
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
    }
}