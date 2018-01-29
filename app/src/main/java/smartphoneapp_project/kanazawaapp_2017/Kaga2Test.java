package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Yuta on 2017/12/07.
 */

public class Kaga2Test extends Activity{

    ArrayList<String> yasai = new ArrayList<String>();
    static ArrayList<String> mondai = new ArrayList<String>();
    int i =0;
    static int a;
    String nanmonme;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kagayasai2_test);


        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        TextView textView = (TextView)findViewById(R.id.yasai_text);

        //ArrayListに文字を入れる
        yasai.add(getString(R.string.hutokyuuri));
        yasai.add(getString(R.string.hutonegi));
        yasai.add(getString(R.string.kinnzisou));
        yasai.add(getString(R.string.rennkonn));

        mondai.add(getString(R.string.hutokyuuri));
        mondai.add(getString(R.string.hutonegi));
        mondai.add(getString(R.string.kinnzisou));
        mondai.add(getString(R.string.rennkonn));


        //ArrayListをシャッフル
        Collections.shuffle(yasai);
        Collections.shuffle(mondai);

        textView.setText(mondai.get(0));

        button1.setText(yasai.get(0));
        button2.setText(yasai.get(1));
        button3.setText(yasai.get(2));
        button4.setText(yasai.get(3));


        button1.setOnClickListener(Click);
        button2.setOnClickListener(Click);
        button3.setOnClickListener(Click);
        button4.setOnClickListener(Click);
    }
    public View.OnClickListener Click=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // ボタンの文字と問題文の文字が同じかどうかで正解不正解を判定
            switch (view.getId()){
                case R.id.button1: //ボタン1を押したときの処理
                    Button button1 = (Button)findViewById(R.id.button1);
                    CharSequence aiueo = button1.getText();
                    if (aiueo == mondai.get(i)){
                        Intent intent=new Intent(Kaga2Test.this,Kaga2Activity.class);
                        intent.putExtra("kotae",mondai.get(i));
                        startActivityForResult(intent,0);
                        //kotaeに問題文をいれて正解画面にとぶ
                    }else{
                        Intent intent=new Intent(Kaga2Test.this,Kaga2ActivityHazure.class);
                        intent.putExtra("kotae",mondai.get(i));
                        startActivity(intent);
                        //kotaeに問題文をいれて不正解画面にとぶ
                    }
                    break;

                case R.id.button2://ボタン2を押したときの処理
                    Button button2=(Button)findViewById(R.id.button2);
                    CharSequence kakiku=button2.getText();
                    if (kakiku==mondai.get(i)){
                        Intent intent=new Intent(Kaga2Test.this,Kaga2Activity.class);
                        intent.putExtra("kotae",mondai.get(i));
                        startActivityForResult(intent,0);
                    }else {
                        Intent intent=new Intent(Kaga2Test.this,Kaga2ActivityHazure.class);
                        intent.putExtra("kotae",mondai.get(i));
                        startActivity(intent);
                    }
                    break;
                case R.id.button3://ボタン3を押したときの処理
                    Button button3=(Button)findViewById(R.id.button3);
                    CharSequence sasisu=button3.getText();
                    if (sasisu==mondai.get(i)){
                        Intent intent=new Intent(Kaga2Test.this,Kaga2Activity.class);
                        intent.putExtra("kotae",mondai.get(i));
                        startActivityForResult(intent,0);
                    }else {
                        Intent intent=new Intent(Kaga2Test.this,Kaga2ActivityHazure.class);
                        intent.putExtra("kotae",mondai.get(i));
                        startActivity(intent);
                    }
                    break;
                case R.id.button4://ボタン4を押したときの処理
                    Button button4=(Button)findViewById(R.id.button4);
                    CharSequence tatitu=button4.getText();
                    if (tatitu==mondai.get(i)){
                        Intent intent=new Intent(Kaga2Test.this,Kaga2Activity.class);
                        intent.putExtra("kotae",mondai.get(i));
                        startActivityForResult(intent,0);
                    }else {
                        Intent intent=new Intent(Kaga2Test.this,Kaga2ActivityHazure.class);
                        intent.putExtra("kotae",mondai.get(i));
                        startActivity(intent);
                    }
                    break;


            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case(0):
                if (resultCode==RESULT_OK){

                    //画面が戻ってきたときの処理

                    TextView textView=(TextView)findViewById(R.id.yasai_text);

                    i=data.getIntExtra("nextQ",0);
                    textView.setText(mondai.get(i));

                    Button button1 = (Button)findViewById(R.id.button1);
                    Button button2 = (Button)findViewById(R.id.button2);
                    Button button3 = (Button)findViewById(R.id.button3);
                    Button button4 = (Button)findViewById(R.id.button4);

                    button1.setOnClickListener(Click);
                    button1.setOnClickListener(Click);
                    button2.setOnClickListener(Click);
                    button3.setOnClickListener(Click);
                    button4.setOnClickListener(Click);

                }
        }
    }
}


