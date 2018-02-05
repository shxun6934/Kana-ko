package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import smartphoneapp_project.kanazawaapp_2017.Event.EventActivity;
import smartphoneapp_project.kanazawaapp_2017.Zukan.KagayasaiZukan1Activity;

public class MapActivity extends Activity {

    //TODO:Viewの表示・非表示がうまくいかずにエラー
    private ImageView castleView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        castleView = (ImageView) findViewById(R.id.imageView5);
        //データの読み込み
        SharedPreferences data = getSharedPreferences("addKey", Context.MODE_PRIVATE);
        //キーの代入
        String str = data.getString("StatusSave", "Nothing");

        //追加した値：WashiEasy があったら、画像を表示
        if (str.equals("WashiEasy")) {
            castleView.setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.imageView5).setVisibility(View.GONE);//非表示
        }

        View.OnClickListener a = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {//押下時の処理
                //確認ダイアログの作成
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapActivity.this, R.style.MyAlertDialogStyle);
                alertDialog.setTitle("まちがいさがし");
                alertDialog.setMessage("このあそびをやってみる？？");
                alertDialog.setPositiveButton("　　　 すすむ　　　 ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO:すすむボタンが押されたときの処理
                        Intent activity_difficulty = new Intent(MapActivity.this, DifficultyActivity.class);
                        activity_difficulty.putExtra("kind_game", 1);
                        startActivity(activity_difficulty);//画面遷移を行う
                    }
                });
                alertDialog.setNegativeButton("　　　もどる　　 ", null);
                alertDialog.create().show();
            }
        };

        View.OnClickListener b = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {//押下時の処理
                //確認ダイアログの作成
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapActivity.this, R.style.MyAlertDialogStyle);
                alertDialog.setTitle("わしづくり");
                alertDialog.setMessage("このあそびをやってみる？？");
                alertDialog.setPositiveButton("　　　 すすむ　　　 ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO:すすむボタンが押されたときの処理
                        Intent activity_difficulty = new Intent(MapActivity.this, DifficultyActivity.class);
                        activity_difficulty.putExtra("kind_game", 2);
                        startActivity(activity_difficulty);//画面遷移を行う
                    }
                });
                alertDialog.setNegativeButton("　　　もどる　　 ", null);
                alertDialog.create().show();
            }
        };

        View.OnClickListener c = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {//押下時の処理
                //確認ダイアログの作成
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapActivity.this, R.style.MyAlertDialogStyle);
                alertDialog.setTitle("みずあめづくり");
                alertDialog.setMessage("このあそびをやってみる？？");
                alertDialog.setPositiveButton("　　　 すすむ　　　 ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO:すすむボタンが押されたときの処理
                        Intent activity_difficulty = new Intent(MapActivity.this, DifficultyActivity.class);
                        activity_difficulty.putExtra("kind_game", 3);
                        startActivity(activity_difficulty);//画面遷移を行う
                    }
                });
                alertDialog.setNegativeButton("　　　もどる　　 ", null);
                alertDialog.create().show();
            }
        };

        View.OnClickListener d = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {//押下時の処理
                //確認ダイアログの作成
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapActivity.this, R.style.MyAlertDialogStyle);
                alertDialog.setTitle("きんつばづくり");
                alertDialog.setMessage("このあそびをやってみる？？");
                alertDialog.setPositiveButton("　　　 すすむ　　　 ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO:すすむボタンが押されたときの処理
                        Intent activity_difficulty = new Intent(MapActivity.this, DifficultyActivity.class);
                        activity_difficulty.putExtra("kind_game", 4);
                        startActivity(activity_difficulty);//画面遷移を行う
                    }
                });
                alertDialog.setNegativeButton("　　　もどる　　 ", null);
                alertDialog.create().show();
            }
        };

        View.OnClickListener e = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {//押下時の処理
                //確認ダイアログの作成
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapActivity.this, R.style.MyAlertDialogStyle);
                alertDialog.setTitle("やさいくいず");
                alertDialog.setMessage("このあそびをやってみる？？");
                alertDialog.setPositiveButton("　　　 すすむ　　　 ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO:すすむボタンが押されたときの処理
                        Intent activity_difficulty = new Intent(MapActivity.this, DifficultyActivity.class);
                        activity_difficulty.putExtra("kind_game", 5);
                        startActivity(activity_difficulty);//画面遷移を行う
                    }
                });
                alertDialog.setNegativeButton("　　　もどる　　 ", null);
                alertDialog.create().show();
            }
        };

        View.OnClickListener f = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {//押下時の処理
                //確認ダイアログの作成
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapActivity.this, R.style.MyAlertDialogStyle);
                alertDialog.setTitle("きんぱくのばし");
                alertDialog.setMessage("このあそびをやってみる？？");
                alertDialog.setPositiveButton("　　　 すすむ　　　 ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO:すすむボタンが押されたときの処理
                        Intent activity_difficulty = new Intent(MapActivity.this, DifficultyActivity.class);
                        activity_difficulty.putExtra("kind_game", 6);
                        startActivity(activity_difficulty);//画面遷移を行う
                    }
                });
                alertDialog.setNegativeButton("　　　もどる　　 ", null);
                alertDialog.create().show();
            }
        };

        View.OnClickListener g = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {//押下時の処理
                //確認ダイアログの作成
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MapActivity.this, R.style.MyAlertDialogStyle);
                alertDialog.setTitle("しっき");
                alertDialog.setMessage("このあそびをやってみる？？");
                alertDialog.setPositiveButton("　　　 すすむ　　　 ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO:すすむボタンが押されたときの処理
                        Intent activity_difficulty = new Intent(MapActivity.this, DifficultyActivity.class);
                        activity_difficulty.putExtra("kind_game", 7);
                        startActivity(activity_difficulty);//画面遷移を行う
                    }
                });
                alertDialog.setNegativeButton("　　　もどる　　 ", null);
                alertDialog.create().show();
            }
        };

        View.OnClickListener z = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent zukan_change = new Intent(MapActivity.this, KagayasaiZukan1Activity.class);
                startActivity(zukan_change);//画面遷移を行う
            }
        };

        View.OnClickListener i = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//押下時の処理
                Intent event_change = new Intent(MapActivity.this, EventActivity.class);
                startActivity(event_change);//画面遷移を行う
            }
        };

/*map1へ画面遷移*/
        final Button map1_1 = (Button) findViewById(R.id.button1_1);
        final Button map1_2 = (Button) findViewById(R.id.button1_2);
        final Button map1_3 = (Button) findViewById(R.id.button1_3);
        final Button map1_4 = (Button) findViewById(R.id.button1_4);
        final Button map1_5 = (Button) findViewById(R.id.button1_5);
        final Button map1_6 = (Button) findViewById(R.id.button1_6);
        final Button map1_7 = (Button) findViewById(R.id.button1_7);
        final Button map1_8 = (Button) findViewById(R.id.button1_8);

        map1_1.setOnClickListener(a);
        map1_2.setOnClickListener(a);
        map1_3.setOnClickListener(a);
        map1_4.setOnClickListener(a);
        map1_5.setOnClickListener(a);
        map1_6.setOnClickListener(a);
        map1_7.setOnClickListener(a);
        map1_8.setOnClickListener(a);

/*map2へ画面遷移*/
        final Button map2_1 = (Button) findViewById(R.id.button2_1);
        final Button map2_2 = (Button) findViewById(R.id.button2_2);
        final Button map2_3 = (Button) findViewById(R.id.button2_3);
        final Button map2_4 = (Button) findViewById(R.id.button2_4);
        final Button map2_5 = (Button) findViewById(R.id.button2_5);

        map2_1.setOnClickListener(b);
        map2_2.setOnClickListener(b);
        map2_3.setOnClickListener(b);
        map2_4.setOnClickListener(b);
        map2_5.setOnClickListener(b);

/*map3へ画面遷移*/

        final Button map3_1 = (Button) findViewById(R.id.button3_1);
        final Button map3_2 = (Button) findViewById(R.id.button3_2);
        final Button map3_3 = (Button) findViewById(R.id.button3_3);
        final Button map3_4 = (Button) findViewById(R.id.button3_4);
        final Button map3_5 = (Button) findViewById(R.id.button3_5);
        map3_1.setOnClickListener(c);
        map3_2.setOnClickListener(c);
        map3_3.setOnClickListener(c);
        map3_4.setOnClickListener(c);
        map3_5.setOnClickListener(c);

/*map4へ画面遷移*/
        final Button map4_1 = (Button) findViewById(R.id.button4_1);
        final Button map4_2 = (Button) findViewById(R.id.button4_2);
        final Button map4_3 = (Button) findViewById(R.id.button4_3);

        map4_1.setOnClickListener(d);
        map4_2.setOnClickListener(d);
        map4_3.setOnClickListener(d);

/*map5へ画面遷移*/
        final Button map5_1 = (Button) findViewById(R.id.button5_1);
        final Button map5_2 = (Button) findViewById(R.id.button5_2);
        final Button map5_3 = (Button) findViewById(R.id.button5_3);
        final Button map5_4 = (Button) findViewById(R.id.button5_4);

        map5_1.setOnClickListener(e);
        map5_2.setOnClickListener(e);
        map5_3.setOnClickListener(e);
        map5_4.setOnClickListener(e);

/*map6へ画面遷移*/
        final Button map6_1 = (Button) findViewById(R.id.button6_1);
        final Button map6_2 = (Button) findViewById(R.id.button6_2);
        final Button map6_3 = (Button) findViewById(R.id.button6_3);
        final Button map6_4 = (Button) findViewById(R.id.button6_4);

        map6_1.setOnClickListener(f);
        map6_2.setOnClickListener(f);
        map6_3.setOnClickListener(f);
        map6_4.setOnClickListener(f);

/*map7へ画面遷移*/
        final Button map7_1 = (Button) findViewById(R.id.button7_1);
        final Button map7_2 = (Button) findViewById(R.id.button7_2);
        final Button map7_3 = (Button) findViewById(R.id.button7_3);
        final Button map7_4 = (Button) findViewById(R.id.button7_4);

        map7_1.setOnClickListener(g);
        map7_2.setOnClickListener(g);
        map7_3.setOnClickListener(g);
        map7_4.setOnClickListener(g);

/*図鑑へ画面遷移*/
        final Button zukan = (Button) findViewById(R.id.zukan);

        zukan.setOnClickListener(z);

/*イベントへ画面遷移*/
        final Button event = (Button) findViewById(R.id.event);

        event.setOnClickListener(i);

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
