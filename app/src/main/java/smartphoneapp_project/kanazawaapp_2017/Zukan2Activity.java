package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.data;
import static android.R.attr.id;

/**
 * Created by fumiyatakahashi on 2017/11/16.
 */

public class Zukan2Activity extends Activity {

    String[] name = {"かなざわ","いっぽんふとねぎ", "かがふときゅうり", "きんじそう", "Strawberry"};
    String[] description = {null,
            "かなざわいっぽんねぎはふつうのねぎよりもやわらかい。ふゆになるほどあまくなり、すきやきやねべにいれる",
            "かがふときゅうりはおもさがふつうのきゅうりよりおもい。やわらかくあまい。かわをむいてあんかけにするなどしてたべる",
            "きんじそうは、はのうらがきんときいものいろににているからきんじそうとよばれている。そのははすこしあまい。", "Strawberry"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zukan2);
        ImageView imageview = (ImageView) findViewById(R.id.image);
        TextView textView1 = (TextView) findViewById(R.id.name);
        TextView textView2 = (TextView) findViewById(R.id.description);
        Intent intent=getIntent();
        int i=intent.getIntExtra("key",0);

        switch (i){
            case 0:
                imageview.setImageResource(R.drawable.negi);
                textView1.setText(name[0] + "\n" + name[1]);
                textView2.setText(description[1]);
                break;

            case 1:
                imageview.setImageResource(R.drawable.kyuri);
                textView1.setText(name[2]);
                textView2.setText(description[2]);
                break;

            case 2:
                imageview.setImageResource(R.drawable.kinjisou);
                textView1.setText(name[3]);
                textView2.setText(description[3]);
                break;
        }
    }
}
