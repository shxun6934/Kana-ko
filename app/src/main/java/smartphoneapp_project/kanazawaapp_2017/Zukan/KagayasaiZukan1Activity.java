package smartphoneapp_project.kanazawaapp_2017.Zukan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import smartphoneapp_project.kanazawaapp_2017.MapActivity;
import smartphoneapp_project.kanazawaapp_2017.R;

public class KagayasaiZukan1Activity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zukan_kagayasai1);

        ImageView negibutton = findViewById(R.id.negi_image);
        ImageView kyuributton = findViewById(R.id.kyuri_image);
        ImageView kinjisoubutton = findViewById(R.id.kinjisou_image);
        ImageView renkonbutton = findViewById(R.id.renkon_image);
        ImageView hidariyajirusibutton = findViewById(R.id.yajirusi_hidari_image);
        ImageView migiyajirusibutton = findViewById(R.id.yajirusi_migi_image);
        ImageView backbutton = findViewById(R.id.map_back_button);

        negibutton.setOnClickListener(this);
        kyuributton.setOnClickListener(this);
        kinjisoubutton.setOnClickListener(this);
        renkonbutton.setOnClickListener(this);
        hidariyajirusibutton.setOnClickListener(this);
        migiyajirusibutton.setOnClickListener(this);
        backbutton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent detailszukan = new Intent(KagayasaiZukan1Activity.this, DetailsZukanActivity.class);
        Intent washizukan = new Intent(KagayasaiZukan1Activity.this, WashiZukanActivity.class);
        Intent kagayasaizukan2 = new Intent(KagayasaiZukan1Activity.this, KagayasaiZukan2Activity.class);
        Intent map = new Intent(KagayasaiZukan1Activity.this, MapActivity.class);

        switch (v.getId()) {
            case R.id.negi_image:
                detailszukan.putExtra("key",1);
                startActivity(detailszukan);
                break;
            case R.id.kyuri_image:
                detailszukan.putExtra("key",2);
                startActivity(detailszukan);
                break;
            case R.id.kinjisou_image:
                detailszukan.putExtra("key",3);
                startActivity(detailszukan);
                break;
            case R.id.renkon_image:
                detailszukan.putExtra("key",4);
                startActivity(detailszukan);
                break;
            case R.id.yajirusi_hidari_image:
                startActivity(washizukan);
                overridePendingTransition(R.animator.slide_out_right, R.animator.slide_in_left);
                break;
            case R.id.yajirusi_migi_image:
                startActivity(kagayasaizukan2);
                overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                break;
            case R.id.map_back_button:
                startActivity(map);
                break;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    //ダイアログ表示などの処理を行う時はここに記述する
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}