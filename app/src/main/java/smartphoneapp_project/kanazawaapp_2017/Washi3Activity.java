package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by isidadaiti on 2018/01/03.
 */

public class Washi3Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washi3);
        Button tomap =(Button)findViewById(R.id.button2);
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
    }

//        Intent intent= new Intent(this,DifficultyActivity.class);
//        startActivity(intent);

}