package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by isidadaiti on 2018/01/03.
 */

public class Washi3Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washi3);
    }
    public void onclicknextbutton(View v){
        Intent intent= new Intent(this,MapActivity.class);
        startActivity(intent);

    }
    public void onclickreturnbutton(View view){
        Intent intent= new Intent(this,DifficultyActivity.class);
        startActivity(intent);
    }
}
