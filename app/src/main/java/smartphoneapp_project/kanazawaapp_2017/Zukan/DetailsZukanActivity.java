package smartphoneapp_project.kanazawaapp_2017.Zukan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import smartphoneapp_project.kanazawaapp_2017.R;

public class DetailsZukanActivity extends Activity implements View.OnClickListener{

    String[] kagayasainame = {null,"いっぽんふとねぎ", "かがふときゅうり", "きんじそう", "かがれんこん"};
    String[] kagayasaidescription = {null,
            "かなざわいっぽんねぎは、ふつうのねぎよりもやわらかい。\nふゆになるほどあまくなり、\nすきやきやなべにいれる。",
            "かがふときゅうりは、おもさがふつうのきゅうりよりおもい。\nやわらかくあまい。\nかわをむいてあんかけにするなどしてたべる。",
            "きんじそうは、はのうらがきんときいものいろににているからきんじそうとよばれている。\nそのははすこしあまい。",
            "かがれんこんは、ふつうのれんこんよりねばりがつよい。\nれんこんをむしたり、もちにしてたべるのがおすすめ。"};

    String[] washiname = {"わし"};
    String[] washidescription = {".........."};

    private static int key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zukan_details);

        ImageView imageview = (ImageView) findViewById(R.id.image);
        TextView nametext = (TextView) findViewById(R.id.name);
        TextView descriptiontext = (TextView) findViewById(R.id.description);
        ImageView backbutton = (ImageView) findViewById(R.id.back);
        backbutton.setOnClickListener(this);
        Intent intent = getIntent();
        key = intent.getIntExtra("key",0);

        switch (key){
            case 1:
                imageview.setImageResource(R.drawable.zukan_negi2);
                nametext.setText(kagayasainame[1]);
                descriptiontext.setText(kagayasaidescription[1]);
                break;

            case 2:
                imageview.setImageResource(R.drawable.zukan_kyuri2);
                nametext.setText(kagayasainame[2]);
                descriptiontext.setText(kagayasaidescription[2]);
                break;

            case 3:
                imageview.setImageResource(R.drawable.zukan_kinjisou2);
                nametext.setText(kagayasainame[3]);
                descriptiontext.setText(kagayasaidescription[3]);
                break;

            case 4:
                imageview.setImageResource(R.drawable.zukan_renkon2);
                nametext.setText(kagayasainame[4]);
                descriptiontext.setText(kagayasaidescription[4]);
                break;

            case 19:
                imageview.setImageResource(R.drawable.zukan_washi1);
                nametext.setText(washiname[0]);
                descriptiontext.setText(washidescription[0]);
                break;
        }
    }

    public void onClick(View v) {
        Intent kagayasaizukan1 = new Intent(DetailsZukanActivity.this, KagayasaiZukan1Activity.class);
        Intent kagayasaizukan2 = new Intent(DetailsZukanActivity.this, KagayasaiZukan2Activity.class);
        Intent washizukan = new Intent(DetailsZukanActivity.this, WashiZukanActivity.class);
        Intent intent = getIntent();
        int i = intent.getIntExtra("key",0);

        if(1 <= i && i <= 9){
            startActivity(kagayasaizukan1);
        }else if(10 <= i && i <= 18){
            startActivity(kagayasaizukan2);
        }else if(19 <= i && i <= 28) {
            startActivity(washizukan);
        }
    }
}
