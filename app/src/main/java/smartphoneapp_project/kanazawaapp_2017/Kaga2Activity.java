package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import static smartphoneapp_project.kanazawaapp_2017.Kaga1Activity.answer;

//正解画面
public class Kaga2Activity extends Activity {
    String kotae;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaga2);

        ImageView yasai_syasinn = (ImageView) findViewById(R.id.vegetable_correct);
        TextView textView = (TextView) findViewById(R.id.vegetable_name_correct);
        TextView textView_description = (TextView) findViewById(R.id.description);
        Button button = (Button) findViewById(R.id.quiz_nextbutton);

        final Intent intent = getIntent();
        kotae = intent.getStringExtra("answer");
        //送られてきたkotaeでどの画像を表示するか判定
        switch (kotae) {
            case "きゅうり":
                textView_description.setText(R.string.hutokyuuri_description);
                yasai_syasinn.setImageResource(R.drawable.kyuuri800_sironuki);
                textView.setText("かがふときゅうり");
                break;

            case "ねぎ":
                textView_description.setText(R.string.hutonegi_description);
                yasai_syasinn.setImageResource(R.drawable.negi);
                textView.setText("かなざわいっぽん");
                break;

            case "れんこん":
                textView_description.setText(R.string.rennkonn_description);
                yasai_syasinn.setImageResource(R.drawable.kaga1_renkon);
                textView.setText("かがれんこん");
                break;

            case "きんじそう":
                textView_description.setText(R.string.kinnzisou_description);
                yasai_syasinn.setImageResource(R.drawable.kaga1_kinzisou);
                textView.setText("きんじそう");
                break;
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("nextQ", "nimonme");
                //問題番号を増やす
                answer++;

                if (answer < 3) {
                    intent.putExtra("nextQ", answer);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Intent intent = new Intent(Kaga2Activity.this, Kaga2ActivityCongrats.class);
                    startActivity(intent);

                }
            }
        });
    }
}

