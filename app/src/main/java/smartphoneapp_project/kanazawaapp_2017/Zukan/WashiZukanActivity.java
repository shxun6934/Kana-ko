package smartphoneapp_project.kanazawaapp_2017.Zukan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import smartphoneapp_project.kanazawaapp_2017.Event.EventActivity;
import smartphoneapp_project.kanazawaapp_2017.R;

public class WashiZukanActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zukan_washi);

        ImageView washibutton = (ImageView) findViewById(R.id.washi_image);
        ImageView hidariyajirusibutton = (ImageView) findViewById(R.id.yajirusi_hidari_image);
        ImageView migiyajirusibutton = (ImageView) findViewById(R.id.yajirusi_migi_image);
        ImageView backbutton = (ImageView) findViewById(R.id.back);

        washibutton.setOnClickListener(this);
        hidariyajirusibutton.setOnClickListener(this);
        migiyajirusibutton.setOnClickListener(this);
        backbutton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent detailszukan = new Intent(WashiZukanActivity.this, DetailsZukanActivity.class);
        Intent kagayasaizukan2 = new Intent(WashiZukanActivity.this, KagayasaiZukan2Activity.class);
        Intent kagayasaizukan1 = new Intent(WashiZukanActivity.this, KagayasaiZukan1Activity.class);
        Intent map = new Intent(WashiZukanActivity.this, EventActivity.class);
        switch (v.getId()){
            case R.id.washi_image:
                detailszukan.putExtra("key",19);
                startActivity(detailszukan);
                break;

            case R.id.yajirusi_hidari_image:
                startActivity(kagayasaizukan2);
                overridePendingTransition(R.animator.slide_out_right, R.animator.slide_in_left);
                break;

            case R.id.yajirusi_migi_image:
                startActivity(kagayasaizukan1);
                overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                break;

            case R.id.back:
                startActivity(map);
                break;
        }
    }
}
