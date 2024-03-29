package smartphoneapp_project.kanazawaapp_2017.KagaYasaiQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import smartphoneapp_project.kanazawaapp_2017.R;

import static smartphoneapp_project.kanazawaapp_2017.KagaYasaiQuiz.Kaga1Activity.answer;

//正解画面
public class Kaga2Activity extends Activity {
    private String kotae;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaga2);

        ImageView yasai_syasinn = findViewById(R.id.vegetable_correct);

        TextView textView = findViewById(R.id.vegetable_name_correct);
        TextView textView_description = findViewById(R.id.description);

        Button button = findViewById(R.id.quiz_nextbutton);

        if (answer >= 2) {
            button.setText("おわり");
        }

        final Intent intent = getIntent();
        kotae = intent.getStringExtra("answer");
        //送られてきたkotaeでどの画像を表示するか判定
        switch (kotae) {
            case "きゅうり":
                textView_description.setText(R.string.hutokyuuri_description);
                yasai_syasinn.setImageResource(R.drawable.kaga_kyuuri);
                textView.setText("かがふときゅうり");
                break;
            case "ねぎ":
                textView_description.setText(R.string.hutonegi_description);
                yasai_syasinn.setImageResource(R.drawable.kaga_negi);
                textView.setText("かなざわいっぽんふとねぎ");
                break;
            case "れんこん":
                textView_description.setText(R.string.rennkonn_description);
                yasai_syasinn.setImageResource(R.drawable.kaga_renkon);
                textView.setText("かがれんこん");
                break;
            case "きんじそう":
                textView_description.setText(R.string.kinnzisou_description);
                yasai_syasinn.setImageResource(R.drawable.kaga_kinzisou);
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

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}

