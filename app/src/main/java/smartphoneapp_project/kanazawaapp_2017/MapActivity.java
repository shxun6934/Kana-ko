package smartphoneapp_project.kanazawaapp_2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        View.OnClickListener a = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent map1_change = new Intent(MapActivity.this, map1Activity.class);
                startActivity(map1_change);//画面遷移を行う
            }
        };

        View.OnClickListener b = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent map2_change = new Intent(MapActivity.this, map2Activity.class);
                startActivity(map2_change);//画面遷移を行う
            }
        };

        View.OnClickListener c = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent map3_change = new Intent(MapActivity.this, map3Activity.class);
                startActivity(map3_change);//画面遷移を行う
            }
        };

        View.OnClickListener d = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent map4_change = new Intent(MapActivity.this, map4Activity.class);
                startActivity(map4_change);//画面遷移を行う
            }
        };

        View.OnClickListener e = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent map5_change = new Intent(MapActivity.this, map5Activity.class);
                startActivity(map5_change);//画面遷移を行う
            }
        };

        View.OnClickListener f = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent map6_change = new Intent(MapActivity.this, map6Activity.class);
                startActivity(map6_change);//画面遷移を行う
            }
        };

        View.OnClickListener g = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent map7_change = new Intent(MapActivity.this, map7Activity.class);
                startActivity(map7_change);//画面遷移を行う
            }
        };

        View.OnClickListener z = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent zukann_change = new Intent(MapActivity.this, zukannActivity.class);
                startActivity(zukann_change);//画面遷移を行う
            }
        };


/*map1へ画面遷移*/
        final Button map1_1 =(Button)findViewById(R.id.button1_1);
        map1_1.setOnClickListener(a);

        final Button map1_2 =(Button)findViewById(R.id.button1_2);
        map1_2.setOnClickListener(a);

        final Button map1_3 =(Button)findViewById(R.id.button1_3);
        map1_3.setOnClickListener(a);

        final Button map1_4 =(Button)findViewById(R.id.button1_4);
        map1_4.setOnClickListener(a);

        final Button map1_5 =(Button)findViewById(R.id.button1_5);
        map1_5.setOnClickListener(a);

        final Button map1_6 =(Button)findViewById(R.id.button1_6);
        map1_6.setOnClickListener(a);

        final Button map1_7 =(Button)findViewById(R.id.button1_7);
        map1_7.setOnClickListener(a);

        final Button map1_8 =(Button)findViewById(R.id.button1_8);
        map1_8.setOnClickListener(a);

/*map2へ画面遷移*/
        final Button map2_1 =(Button)findViewById(R.id.button2_1);
        map2_1.setOnClickListener(b);

        final Button map2_2 =(Button)findViewById(R.id.button2_2);
        map2_2.setOnClickListener(b);

        final Button map2_3 =(Button)findViewById(R.id.button2_3);
        map2_3.setOnClickListener(b);

        final Button map2_4 =(Button)findViewById(R.id.button2_4);
        map2_4.setOnClickListener(b);

        final Button map2_5 =(Button)findViewById(R.id.button2_5);
        map2_5.setOnClickListener(b);

/*map3へ画面遷移*/

        final Button map3_1 = (Button)findViewById(R.id.button3_1);
        map3_1.setOnClickListener(c);

        final Button map3_2 = (Button)findViewById(R.id.button3_2);
        map3_1.setOnClickListener(c);

        final Button map3_3 = (Button)findViewById(R.id.button3_3);
        map3_1.setOnClickListener(c);

        final Button map3_4 = (Button)findViewById(R.id.button3_4);
        map3_1.setOnClickListener(c);

        final Button map3_5 = (Button)findViewById(R.id.button3_5);
        map3_1.setOnClickListener(c);

/*map4へ画面遷移*/
        final Button map4_1 = (Button)findViewById(R.id.button4_1);
        map4_1.setOnClickListener(d);

        final Button map4_2 = (Button)findViewById(R.id.button4_2);
        map4_2.setOnClickListener(d);

        final Button map4_3 = (Button)findViewById(R.id.button4_3);
        map4_3.setOnClickListener(d);

/*map5へ画面遷移*/
        final Button map5_1 = (Button)findViewById(R.id.button5_1);
        map5_1.setOnClickListener(e);

        final Button map5_2 = (Button)findViewById(R.id.button5_2);
        map5_2.setOnClickListener(e);

        final Button map5_3 = (Button)findViewById(R.id.button5_3);
        map5_3.setOnClickListener(e);

        final Button map5_4 = (Button)findViewById(R.id.button5_4);
        map5_4.setOnClickListener(e);

/*map6へ画面遷移*/
        final Button map6_1 = (Button)findViewById(R.id.button6_1);
        map6_1.setOnClickListener(f);

        final Button map6_2 = (Button)findViewById(R.id.button6_2);
        map6_2.setOnClickListener(f);

        final Button map6_3 = (Button)findViewById(R.id.button6_3);
        map6_3.setOnClickListener(f);

        final Button map6_4 = (Button)findViewById(R.id.button6_4);
        map6_4.setOnClickListener(f);

/*map7へ画面遷移*/
        final Button map7_1 = (Button)findViewById(R.id.button7_1);
        map7_1.setOnClickListener(g);

        final Button map7_2 = (Button)findViewById(R.id.button7_2);
        map7_2.setOnClickListener(g);

        final Button map7_3 = (Button)findViewById(R.id.button7_3);
        map7_3.setOnClickListener(g);

        final Button map7_4 = (Button)findViewById(R.id.button7_4);
        map7_4.setOnClickListener(g);

/*地図へ画面遷移*/
        final Button zukann = (Button)findViewById(R.id.zukann);
        zukann.setOnClickListener(z);

    }

}
