package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MizuameActivity extends Activity implements View.OnTouchListener {

    private Rect rect = new Rect();
    private ImageView nabeView;
    private ImageView komeView;
    private ImageView mugiView;
    private ImageView nabe_afterView;
    private TextView materialTextView;
    private TextView titleTextView;
    private int oldX;
    private int oldY;
    int x;
    int y;
    int kome = 0;
    int mugi = 0;

    ViewGroup.MarginLayoutParams startmarginkome;
    ViewGroup.MarginLayoutParams startmerginmugi;

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

        this.komeView.setOnTouchListener(this);
        this.mugiView.setOnTouchListener(this);

        startmarginkome = (ViewGroup.MarginLayoutParams) komeView.getLayoutParams();
        startmerginmugi = (ViewGroup.MarginLayoutParams) mugiView.getLayoutParams();

        nabe_afterView.setVisibility(nabe_afterView.INVISIBLE);
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
                        }
                    } else {
                        mugiView.setLayoutParams(startmerginmugi);
                    }
                }
                break;
        }
        return true;
    }

}

