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

public class KagayasaiZukan2Activity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zukan_kagayasai2);
        ImageView hidariyajirusibutton = (ImageView) findViewById(R.id.yajirusi_hidari_image);
        ImageView migiyajirusibutton = (ImageView) findViewById(R.id.yajirusi_migi_image);
        ImageView backbutton = (ImageView) findViewById(R.id.map_back_button);

        hidariyajirusibutton.setOnClickListener(this);
        migiyajirusibutton.setOnClickListener(this);
        backbutton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent detailszukan = new Intent(KagayasaiZukan2Activity.this, DetailsZukanActivity.class);
        Intent kagayasaizukan1 = new Intent(KagayasaiZukan2Activity.this, KagayasaiZukan1Activity.class);
        Intent washizukan = new Intent(KagayasaiZukan2Activity.this, WashiZukanActivity.class);
        Intent map = new Intent(KagayasaiZukan2Activity.this, MapActivity.class);
        switch (v.getId()){

            case R.id.yajirusi_hidari_image:
                startActivity(kagayasaizukan1);
                overridePendingTransition(R.animator.slide_out_right, R.animator.slide_in_left);
                break;

            case R.id.yajirusi_migi_image:
                startActivity(washizukan);
                overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                break;

            case R.id.map_back_button:
                startActivity(map);
                break;
        }
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

}
