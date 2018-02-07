package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MizuameActivity extends Activity implements View.OnTouchListener, RotationGestureDetector.OnRotationGestureListener {

    private Rect rect = new Rect();
    private ImageView nabeView;
    private ImageView komeView;
    private ImageView mugiView;
    private ImageView nabe_afterView;
    private TextView materialTextView;
    private TextView titleTextView;
    private Button cancelButton;
    private int oldX;
    private int oldY;
    int x;
    int y;
    int kome = 0;
    int mugi = 0;

    ViewGroup.MarginLayoutParams startmarginkome;
    ViewGroup.MarginLayoutParams startmerginmugi;

    RotationGestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mizuame);

        nabeView = (ImageView) findViewById(R.id.mizuame_nabe_imageview);
        nabe_afterView = (ImageView) findViewById(R.id.mizuame_nabe_after_imageview);
        komeView = (ImageView) findViewById(R.id.mizuame_kome_imageview);
        mugiView = (ImageView) findViewById(R.id.mizuame_mugi_imageview);
        materialTextView = (TextView) findViewById(R.id.mizuame_material_textview);
        titleTextView = (TextView) findViewById(R.id.mizuame_title_textview);
        cancelButton = (Button) findViewById(R.id.mizuame_cancel_button);

        this.komeView.setOnTouchListener(this);
        this.mugiView.setOnTouchListener(this);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MizuameActivity.this, DifficultyActivity.class);
                startActivity(intent);
            }
        });

        startmarginkome = (ViewGroup.MarginLayoutParams) komeView.getLayoutParams();
        startmerginmugi = (ViewGroup.MarginLayoutParams) mugiView.getLayoutParams();

        nabe_afterView.setVisibility(nabe_afterView.INVISIBLE);

        detector = new RotationGestureDetector((RotationGestureDetector.OnRotationGestureListener) this);

        ViewTreeObserver.OnGlobalLayoutListener listener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                detector.setCenterX(nabe_afterView.getPivotX() + nabe_afterView.getLeft());
                detector.setCenterY(nabe_afterView.getPivotY() + nabe_afterView.getTop());
                nabe_afterView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                if (count == 5) {
                    count = 0;
                    Intent intent = new Intent(MizuameActivity.this, MapActivity.class);
                    startActivity(intent);
                }
            }
        };

        nabe_afterView.getViewTreeObserver().addOnGlobalLayoutListener(listener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.mizuame_kome_imageview:
                x = (int) event.getRawX();
                y = (int) event.getRawY();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    int diffX = komeView.getLeft() + (x - oldX);
                    int diffY = komeView.getTop() + (y - oldY);

                    komeView.layout(diffX, diffY, diffX + komeView.getWidth(), diffY + komeView.getHeight());

                    oldX = x;
                    oldY = y;
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    oldX = x;
                    oldY = y;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    nabeView.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        komeView.setVisibility(komeView.GONE);
                        kome = 1;
                        if (mugi == 1) {
                            nabeView.setVisibility(nabeView.GONE);
                            nabe_afterView.setVisibility(nabe_afterView.VISIBLE);
                            materialTextView.setVisibility(materialTextView.INVISIBLE);
                            titleTextView.setText("かきまぜよう！！");
                            Log.d("1","回せ");
                        }
                    } else {
                        komeView.setLayoutParams(startmarginkome);
                    }
                }
                break;
            case R.id.mizuame_mugi_imageview:
                x = (int) event.getRawX();
                y = (int) event.getRawY();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    int diffX = mugiView.getLeft() + (x - oldX);
                    int diffY = mugiView.getTop() + (y - oldY);

                    mugiView.layout(diffX, diffY, diffX + mugiView.getWidth(), diffY + mugiView.getHeight());

                    oldX = x;
                    oldY = y;
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    oldX = x;
                    oldY = y;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    nabeView.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        mugiView.setVisibility(mugiView.GONE);
                        mugi = 1;
                        if (kome == 1) {
                            nabeView.setVisibility(nabeView.GONE);
                            nabe_afterView.setVisibility(nabe_afterView.VISIBLE);
                            materialTextView.setVisibility(materialTextView.INVISIBLE);
                            titleTextView.setText("かきまぜよう！！");

                            Log.d("1","回せ");
                        }
                    } else {
                        mugiView.setLayoutParams(startmerginmugi);
                    }
                }
                break;
        }
        return true;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        if(event.getAction() == KeyEvent.ACTION_UP){
            switch (event.getKeyCode()){
                case KeyEvent.KEYCODE_BACK:
                    //ダイアログ表示などの処理を行う時はここに記述する
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private float initialAngle = -1;
    private int checkPointPassed = 0;
    private int count;

    @Override
    public void onRotate(float angle) {
        if (initialAngle == -1) {
            initialAngle = angle;
        }

        switch (checkPointPassed) {
            case 0:
                if (Math.abs(angle - angleValidate(initialAngle)) > 90) {
                    checkPointPassed++;
                    Log.d("90", "90ど");
                }
                break;
            case 1:
                if (Math.abs(angle - angleValidate(initialAngle)) > 180) {
                    checkPointPassed++;
                    Log.d("180", "180ど");
                }
                break;
            case 2:
                if (Math.abs(angle - angleValidate(initialAngle)) > 270) {
                    checkPointPassed++;
                    Log.d("270", "270ど");
                }
                break;
            case 3:
                if (Math.abs(angle - angleValidate(initialAngle)) < 90) {
                    Toast.makeText(this, ++count + "周", Toast.LENGTH_SHORT).show();
                    initialAngle = -1;
                    checkPointPassed = 0;
                    Log.d("2","周");
                }
                break;
        }
    }

    private float angleValidate(float angle) {
        if (angle >= 360) {
            return angle - 360;
        }
        return angle;
    }
}

