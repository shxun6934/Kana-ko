package smartphoneapp_project.kanazawaapp_2017.KagaYasaiQuiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;

import smartphoneapp_project.kanazawaapp_2017.R;

public class Kaga1Activity extends Activity {

    static ArrayList<String> yasainame = new ArrayList<String>();
    static ArrayList<String> question = new ArrayList<String>();
    ArrayList<String> rump = new ArrayList<String>();

    ImageView imageView;

    static int answer = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaga1);
        answer = 0;

        yasainame = new ArrayList<String>();
        question = new ArrayList<String>();

        Button questionbutton1 =
                (Button) findViewById(R.id.quiz_button1);
        Button questionbutton2 =
                (Button) findViewById(R.id.quiz_button2);
        Button questionbutton3 =
                (Button) findViewById(R.id.quiz_button3);
        Button questionbutton4 =
                (Button) findViewById(R.id.quiz_button4);

        ImageView imageView1 = (ImageView) findViewById(R.id.quiz_Rump1);
        imageView1.setImageResource(R.drawable.kaga1_on_rump);
        ImageView imageView2 = (ImageView) findViewById(R.id.quiz_Rump2);
        imageView2.setImageResource(R.drawable.kaga1_off_rump);
        ImageView imageView3 = (ImageView) findViewById(R.id.quiz_Rump3);
        imageView3.setImageResource(R.drawable.kaga1_off_rump);

        yasainame.add("きゅうり");
        yasainame.add("きんじそう");
        yasainame.add("ねぎ");
        yasainame.add("れんこん");

        question.add("きゅうり");
        question.add("きんじそう");
        question.add("ねぎ");
        question.add("れんこん");

        Collections.shuffle(yasainame);

        questionbutton1.setText(yasainame.get(0));
        questionbutton2.setText(yasainame.get(1));
        questionbutton3.setText(yasainame.get(2));
        questionbutton4.setText(yasainame.get(3));
        Log.d("アイウエオ",yasainame.get(0));
        Log.d("ア",yasainame.get(1));
        Log.d("アイ",yasainame.get(2));
        Log.d("アイウ",yasainame.get(3));

        imageView = (ImageView) findViewById(R.id.vegetable);

        Collections.shuffle(question);
        setVegetable();

        questionbutton1.setOnClickListener(button1Click);
        questionbutton2.setOnClickListener(button1Click);
        questionbutton3.setOnClickListener(button1Click);
        questionbutton4.setOnClickListener(button1Click);
    }

    private void setVegetable() {
        switch (question.get(answer)) {
            case "きんじそう":
                imageView.setImageResource(R.drawable.kaga_kinzisou);
                break;

            case "ねぎ":
                imageView.setImageResource(R.drawable.kaga_negi);
                break;

            case "れんこん":
                imageView.setImageResource(R.drawable.kaga_renkon);
                break;

            case "きゅうり":
                imageView.setImageResource(R.drawable.kaga_kyuuri);
                break;

        }
    }

    public View.OnClickListener button1Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isCollect(v.getId())) {
                Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                intent.putExtra("answer",question.get(answer));
                startActivityForResult(intent, 0);
            }else{
                Intent intent = new Intent(Kaga1Activity.this, Kaga2ActivityHazure.class);
                intent.putExtra("answer",question.get(answer));
                startActivity(intent);
            }
        }
    };

    private boolean isCollect(int buttonId) {
        Button button = (Button) findViewById(buttonId);
        String yasai = button.getText().toString();
        return yasai.equals(question.get(answer));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case (0):
                if (resultCode == RESULT_OK) {
                    answer = data.getIntExtra("nextQ", 0);

                    setVegetable();
                    Button button1 = (Button) findViewById(R.id.quiz_button1);
                    Button button2 = (Button) findViewById(R.id.quiz_button2);
                    Button button3 = (Button) findViewById(R.id.quiz_button3);
                    Button button4 = (Button) findViewById(R.id.quiz_button4);

                    button1.setOnClickListener(button1Click);
                    button2.setOnClickListener(button1Click);
                    button3.setOnClickListener(button1Click);
                    button4.setOnClickListener(button1Click);
                }

        }
        switch ((answer)) {

            case (1):
                ImageView imageView4 = (ImageView) findViewById(R.id.quiz_Rump1);
                imageView4.setImageResource(R.drawable.kaga1_on_rump);
                ImageView imageView5 = (ImageView) findViewById(R.id.quiz_Rump2);
                imageView5.setImageResource(R.drawable.kaga1_on_rump);
                ImageView imageView6 = (ImageView) findViewById(R.id.quiz_Rump3);
                imageView6.setImageResource(R.drawable.kaga1_off_rump);
                break;
            case (2):
                ImageView imageView7 = (ImageView) findViewById(R.id.quiz_Rump1);
                imageView7.setImageResource(R.drawable.kaga1_on_rump);
                ImageView imageView8 = (ImageView) findViewById(R.id.quiz_Rump2);
                imageView8.setImageResource(R.drawable.kaga1_on_rump);
                ImageView imageView9 = (ImageView) findViewById(R.id.quiz_Rump3);
                imageView9.setImageResource(R.drawable.kaga1_on_rump);
                break;

        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        if(event.getAction() == KeyEvent.ACTION_UP){
            switch (event.getKeyCode()){
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }


}
