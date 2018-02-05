package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Kaga2ActivityHazure extends Activity {
    String kotae;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaga2_hazere);

        TextView textView = (TextView) findViewById(R.id.vegtable_name_incorrect);
        TextView textView_description = (TextView) findViewById(R.id.description);
        ImageView yasai_syasinn = (ImageView) findViewById(R.id.vegetable_incorrect);
        Button button = (Button) findViewById(R.id.quiz_Backbutton);
        final Intent intent = getIntent();


        kotae = intent.getStringExtra("answer");
        textView.setText(kotae);

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
                Intent intent1 = new Intent(Kaga2ActivityHazure.this, DifficultyActivity.class);
                intent1.putExtra("kind_game",5);
                startActivity(intent1);
            }
        });
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
