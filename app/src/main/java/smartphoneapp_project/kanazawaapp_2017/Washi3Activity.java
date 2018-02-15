package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Washi3Activity extends Activity {
    private int intentkey=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washi3);
        ImageView murasakiView=(ImageView) findViewById(R.id.murasakiView);
        Button tomap =(Button)findViewById(R.id.button2);
        Button todifficult=(Button)findViewById(R.id.button3);
        Resources r=getResources();
        Intent intent=getIntent();
        Bitmap momijibmp=BitmapFactory.decodeResource(r,R.drawable.washi2_momiji1);
        ImageView momijiview=(ImageView)findViewById(R.id.momijiView);
        intentkey=intent.getIntExtra("DIFFICULTY",0);
        if (intentkey==2){
            Bitmap murasakibmp= BitmapFactory.decodeResource(r,R.drawable.murasakinoha);
            murasakiView.setImageBitmap(murasakibmp);
        }else if(intentkey==3){
            Bitmap gyakumomiji=BitmapFactory.decodeResource(r,R.drawable.washi2_gyakumomiji);
            ImageView bigmomijiView=(ImageView)findViewById(R.id.bigmomijiView);
            bigmomijiView.setImageBitmap(gyakumomiji);
        }
        tomap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "addKey"という名前でインスタンスを生成
                SharedPreferences data = getSharedPreferences("addKey", Context.MODE_PRIVATE);

                //データの保存
                SharedPreferences.Editor editor = data.edit();//オブジェクト取得
                editor.putString("StatusSave", "WashiEasy");//キー：StatusSava 値：WashiEasy
                editor.apply();//データの保存

                Intent intent= new Intent(Washi3Activity.this,MapActivity.class);
                startActivity(intent);
            }
        });
        todifficult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Washi3Activity.this,DifficultyActivity.class);
                intent.putExtra("kind_game",2);
                startActivity(intent);
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