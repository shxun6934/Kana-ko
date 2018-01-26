package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;

public class Kaga1Activity extends Activity {

    ArrayList<String> yasainame = new ArrayList<String>();
    ArrayList<String> question = new ArrayList<String>();
    ArrayList<String> rump = new ArrayList<String>();

    ImageView imageView;

    int vegetable = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaga1);

        Button questionbutton1 =
                (Button)findViewById(R.id.button1);
        Button questionbutton2 =
                (Button)findViewById(R.id.button2);
        Button questionbutton3 =
                (Button)findViewById(R.id.button3);
        Button questionbutton4 =
                (Button)findViewById(R.id.button4);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageViewRump1);
        imageView1.setImageResource(R.drawable.kaga1_on_rump);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageViewRump2);
        imageView2.setImageResource(R.drawable.kaga1_off_rump);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageViewRump3);
        imageView3.setImageResource(R.drawable.kaga1_off_rump);

        question.add("きゅうり");
        question.add("きんじそう");
        question.add("ねぎ");
        question.add("れんこん");

        yasainame.add("きゅうり");
        yasainame.add("きんじそう");
        yasainame.add("ねぎ");
        yasainame.add("れんこん");

        Collections.shuffle(yasainame);
        questionbutton1.setText(yasainame.get(0));
        questionbutton2.setText(yasainame.get(1));
        questionbutton3.setText(yasainame.get(2));
        questionbutton4.setText(yasainame.get(3));

        imageView = (ImageView) findViewById(R.id.vegetableimageView);

        Collections.shuffle(question);
        setVegetable();

        questionbutton1.setOnClickListener(button1Click);
        questionbutton2.setOnClickListener(button1Click);
        questionbutton3.setOnClickListener(button1Click);
        questionbutton4.setOnClickListener(button1Click);
    }

    private void setVegetable(){
        switch (question.get(vegetable)) {
            case "きんじそう":
                imageView.setImageResource(R.drawable.kaga1_kinnzisou);
                break;

            case "ねぎ":
                imageView.setImageResource(R.drawable.kaga1_negi);
                break;

            case "れんこん":
                imageView.setImageResource(R.drawable.kaga1_renkon);
                break;

            case "きゅうり":
                imageView.setImageResource(R.drawable.kaga1_cucumber);
                break;

        }
    }

    public View.OnClickListener button1Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Button button1 = (Button) findViewById(R.id.button1);
                    CharSequence yasai1 = button1.getText();
                    if (yasai1 == question.get(vegetable)) {
                        Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                        intent.putExtra("answer", yasainame.get(vegetable));
                        startActivityForResult(intent,0);
                    } else {
                        Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                        startActivity(intent);
                    }
                    break;

                case R.id.button2:
                    Button button2 = (Button) findViewById(R.id.button2);
                    CharSequence yasai2 = button2.getText();
                    if (yasai2 == question.get(vegetable)) {

                        Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                        intent.putExtra("answer", yasainame.get(vegetable));
                        startActivityForResult(intent,0);
                    } else {
                        Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                        startActivity(intent);
                    }
                    break;

                case R.id.button3:
                    Button button3 = (Button) findViewById(R.id.button3);
                    CharSequence yasai3 = button3.getText();
                    if (yasai3 == question.get(vegetable)) {

                        Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                        intent.putExtra("answer", yasainame.get(vegetable));
                        startActivityForResult(intent,0);
                    } else {
                        Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                        startActivity(intent);
                    }
                    break;

                case R.id.button4:
                    Button button4 = (Button) findViewById(R.id.button4);
                    CharSequence yasai4 = button4.getText();
                    if (yasai4 == question.get(vegetable)) {

                        Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                        intent.putExtra("answer", yasainame.get(vegetable));
                        startActivityForResult(intent,0);
                    } else {
                        Intent intent = new Intent(Kaga1Activity.this, Kaga2Activity.class);
                        startActivity(intent);
                    }
                    break;

            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch ( (requestCode)){
            case (0):
                if (resultCode == RESULT_OK) {
                    vegetable = data.getIntExtra("question2",0);

                    setVegetable();
                    Button button1 = (Button)findViewById(R.id.button1);
                    Button button2 = (Button)findViewById(R.id.button2);
                    Button button3 = (Button)findViewById(R.id.button3);
                    Button button4 = (Button)findViewById(R.id.button4);

                    button1.setOnClickListener(button1Click);
                    button2.setOnClickListener(button1Click);
                    button3.setOnClickListener(button1Click);
                    button4.setOnClickListener(button1Click);
                }
        }
        switch ((vegetable)){

            case (1):
                ImageView imageView4 = (ImageView) findViewById(R.id.imageViewRump1);
                imageView4.setImageResource(R.drawable.kaga1_on_rump);
                ImageView imageView5 = (ImageView) findViewById(R.id.imageViewRump2);
                imageView5.setImageResource(R.drawable.kaga1_on_rump);
                ImageView imageView6 = (ImageView) findViewById(R.id.imageViewRump3);
                imageView6.setImageResource(R.drawable.kaga1_off_rump);
                break;
            case (2):
                ImageView imageView7 = (ImageView) findViewById(R.id.imageViewRump1);
                imageView7.setImageResource(R.drawable.kaga1_on_rump);
                ImageView imageView8 = (ImageView) findViewById(R.id.imageViewRump2);
                imageView8.setImageResource(R.drawable.kaga1_on_rump);
                ImageView imageView9 = (ImageView) findViewById(R.id.imageViewRump3);
                imageView9.setImageResource(R.drawable.kaga1_on_rump);
                break;

        }
    }


}
