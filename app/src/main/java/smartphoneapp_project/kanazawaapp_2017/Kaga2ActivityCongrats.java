package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static smartphoneapp_project.kanazawaapp_2017.Kaga2Test.mondai;

/**
 * Created by Yuta on 2017/12/17.
 */

public class Kaga2ActivityCongrats extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaga2_congrats);
        ImageView seikaigazou0 = (ImageView) findViewById(R.id.seikai_gazou0);
        ImageView seikaigazou1 = (ImageView) findViewById(R.id.seikai_gazou1);
        ImageView seikaigazou2 = (ImageView) findViewById(R.id.seikai_gazou2);

        Button tap=(Button)findViewById(R.id.tap);


        switch (mondai.get(0)) {
            case "きんじそう":
                seikaigazou0.setImageResource(R.drawable.kinnzisou_ira);
                break;
            case "かがふときゅうり":
                seikaigazou0.setImageResource(R.drawable.kyuuri_ira);
                break;
            case "かなざわいっぽんふとねぎ":
                seikaigazou0.setImageResource(R.drawable.negi_ira);
                break;
            case "かがれんこん":
                seikaigazou0.setImageResource(R.drawable.rennkonn_ira);
                break;
        }

        switch (mondai.get(1)) {
            case "きんじそう":
                seikaigazou1.setImageResource(R.drawable.kinnzisou_ira);
                break;
            case "かがふときゅうり":
                seikaigazou1.setImageResource(R.drawable.kyuuri_ira);
                break;
            case "かなざわいっぽんふとねぎ":
                seikaigazou1.setImageResource(R.drawable.negi_ira);
                break;
            case "かがれんこん":
                seikaigazou1.setImageResource(R.drawable.rennkonn_ira);
                break;
        }

        switch (mondai.get(2)) {
            case "きんじそう":
                seikaigazou2.setImageResource(R.drawable.kinnzisou_ira);
                break;
            case "かがふときゅうり":
                seikaigazou2.setImageResource(R.drawable.kyuuri_ira);
                break;
            case "かなざわいっぽんふとねぎ":
                seikaigazou2.setImageResource(R.drawable.negi_ira);
                break;
            case "かがれんこん":
                seikaigazou2.setImageResource(R.drawable.rennkonn_ira);
                break;
        }
        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Kaga2ActivityCongrats.this,Kaga2Test.class);
                startActivity(intent1);
            }
        });

    }


}
