package smartphoneapp_project.kanazawaapp_2017.KagaYasaiQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import smartphoneapp_project.kanazawaapp_2017.MapActivity;
import smartphoneapp_project.kanazawaapp_2017.R;

import static smartphoneapp_project.kanazawaapp_2017.KagaYasaiQuiz.Kaga1Activity.question;

/**
 * Created by Yuta on 2017/12/17.
 */

public class Kaga2ActivityCongrats extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaga2_congrats);

        ImageView seikaigazou0 = findViewById(R.id.correct_image1);
        ImageView seikaigazou1 = findViewById(R.id.correct_image2);
        ImageView seikaigazou2 = findViewById(R.id.correct_image3);

        Button tap = findViewById(R.id.tap);

        switch (question.get(0)) {
            case "きんじそう":
                seikaigazou0.setImageResource(R.drawable.kaga2_kinzisou_ira);
                break;
            case "きゅうり":
                seikaigazou0.setImageResource(R.drawable.kaga2_kyuuri_ira);
                break;
            case "ねぎ":
                seikaigazou0.setImageResource(R.drawable.kaga2_negi_ira);
                break;
            case "れんこん":
                seikaigazou0.setImageResource(R.drawable.kaga2_renkon_ira);
                break;
        }

        switch (question.get(1)) {
            case "きんじそう":
                seikaigazou1.setImageResource(R.drawable.kaga2_kinzisou_ira);
                break;
            case "きゅうり":
                seikaigazou1.setImageResource(R.drawable.kaga2_kyuuri_ira);
                break;
            case "ねぎ":
                seikaigazou1.setImageResource(R.drawable.kaga2_negi_ira);
                break;
            case "れんこん":
                seikaigazou1.setImageResource(R.drawable.kaga2_renkon_ira);
                break;
        }

        switch (question.get(2)) {
            case "きんじそう":
                seikaigazou2.setImageResource(R.drawable.kaga2_kinzisou_ira);
                break;
            case "きゅうり":
                seikaigazou2.setImageResource(R.drawable.kaga2_kyuuri_ira);
                break;
            case "ねぎ":
                seikaigazou2.setImageResource(R.drawable.kaga2_negi_ira);
                break;
            case "れんこん":
                seikaigazou2.setImageResource(R.drawable.kaga2_renkon_ira);
                break;
        }

        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Kaga2ActivityCongrats.this, MapActivity.class);
                intent1.putExtra("kind_game",5);
                startActivity(intent1);
            }
        });
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
