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

    String[] kagayasainame = {"かなざわ","いっぽんふとねぎ", "かがふときゅうり", "きんじそう", "かがれんこん"};
    String[] kagayasaidescription = {null,
            "かなざわいっぽんねぎはふつうのねぎよりもやわらかい。ふゆになるほどあまくなり、すきやきやなべにいれる",
            "かがふときゅうりはおもさがふつうのきゅうりよりおもい。やわらかくあまい。かわをむいてあんかけにするなどしてたべる",
            "きんじそうは、はのうらがきんときいものいろににているからきんじそうとよばれている。そのははすこしあまい。",
            "かがれんこんはふつうのれんこんよりねばりがつよい。れんこんをむしたり、もちにしてたべるのがおすすめ。"};

    String[] washiname = {"わ"};
    String[] washidescription = {".........."};

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
        int i = intent.getIntExtra("key",0);

        switch (i){
            case 1:
                imageview.setImageResource(R.drawable.negi);
                nametext.setText(kagayasainame[0] + "\n" + kagayasainame[1]);
                descriptiontext.setText(kagayasaidescription[1]);
                break;

            case 2:
                imageview.setImageResource(R.drawable.kyuri);
                nametext.setText(kagayasainame[2]);
                descriptiontext.setText(kagayasaidescription[2]);
                break;

            case 3:
                imageview.setImageResource(R.drawable.kinjisou);
                nametext.setText(kagayasainame[3]);
                descriptiontext.setText(kagayasaidescription[3]);
                break;

            case 4:
                imageview.setImageResource(R.drawable.renkon);
                nametext.setText(kagayasainame[4]);
                descriptiontext.setText(kagayasaidescription[4]);
                break;

            case 19:
                imageview.setImageResource(R.drawable.washi);
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

        if(0 <= i && i <= 8){
            startActivity(kagayasaizukan1);
        }else if(10 <= i && i <= 18){
            startActivity(kagayasaizukan2);
        }else if(19 <= i && i <= 28) {
            startActivity(washizukan);
        }
    }
}
