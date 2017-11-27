package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class Kaga1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_kaga1);

        Button btnNext1 = (Button) findViewById(R.id.button1);
        Button btnNext2 = (Button) findViewById(R.id.button2);
        Button btnNext3 = (Button) findViewById(R.id.button3);
        Button btnNext4 = (Button) findViewById(R.id.button4);

        ArrayList<String> yasainame = new ArrayList<String>();

        yasainame.add("きゅうり");
        yasainame.add("うり");
        yasainame.add("とまと");
        yasainame.add("なす");

        Collections.shuffle(yasainame);
        btnNext1.setText(yasainame.get(0));
        btnNext2.setText(yasainame.get(1));
        btnNext3.setText(yasainame.get(2));
        btnNext4.setText(yasainame.get(3));

//        btnNext1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()){
//                    case R.id.button1:
//                        Button button1 = (Button)findViewById(R.id.button1);
//                        CharSequence yasai1 = button1.getText();
//                        if(yasai1=="きゅうり"){
//                            Intent intent = new Intent(MainActivity.this,KyuuriActivity.class);
//                            startActivity(intent);
//                        }else {
//                            Intent intent = new Intent(MainActivity.this,kyuuri_hazureActivity.class);
//                            startActivity(intent);
//                        }
//                }
//            }
//        });
//
//        btnNext2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Button button2 = (Button)findViewById(R.id.button2);
//                CharSequence yasai1 = button2.getText();
//                if(yasai1=="きゅうり"){
//                    Intent intent = new Intent(MainActivity.this,KyuuriActivity.class);
//                    startActivity(intent);
//                }else{
//                    Intent intent = new Intent(MainActivity.this,kyuuri_hazureActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });
//
//        btnNext3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Button button3 = (Button)findViewById(R.id.button3);
//                CharSequence yasai1 = button3.getText();
//                if(yasai1=="きゅうり"){
//                    Intent intent = new Intent(MainActivity.this,KyuuriActivity.class);
//                    startActivity(intent);
//                }else{
//                    Intent intent = new Intent(MainActivity.this,kyuuri_hazureActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });
//
//        btnNext4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Button button4 = (Button)findViewById(R.id.button4);
//                CharSequence yasai1 = button4.getText();
//                if(yasai1=="きゅうり"){
//                    Intent intent = new Intent(MainActivity.this,KyuuriActivity.class);
//                    startActivity(intent);
//                }else{
//                    Intent intent = new Intent(MainActivity.this,kyuuri_hazureActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });
//
    }


}
