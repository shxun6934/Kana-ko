package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
        TextView textView = (TextView) findViewById(R.id.yasai_name);
        TextView textView_description = (TextView) findViewById(R.id.description);
        ImageView yasai_syasinn = (ImageView) findViewById(R.id.yasai);
        Button button = (Button) findViewById(R.id.next_button);
        Intent intent = getIntent();


        kotae = intent.getStringExtra("answer");
        textView.setText(kotae);

        switch (kotae) {
            case "かがふときゅうり":
                textView_description.setText(R.string.hutokyuuri_description);
                yasai_syasinn.setImageResource(R.drawable.kyuuri800_sironuki);
                break;

            case "かなざわいっぽんふとねぎ":
                textView_description.setText(R.string.hutonegi_description);
                yasai_syasinn.setImageResource(R.drawable.negi);
                break;

            case "かがれんこん":
                textView_description.setText(R.string.rennkonn_description);
                break;

            case "きんじそう":
                textView_description.setText(R.string.kinnzisou_description);
                yasai_syasinn.setImageResource(R.drawable.kinnzisou);
                break;
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Kaga2ActivityHazure.this, Kaga1Activity.class);
                startActivity(intent1);
            }
        });
    }
}
