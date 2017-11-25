package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by fumiyatakahashi on 2017/11/09.
 */

public class ZukanActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zukan);
        ImageView image1 = (ImageView) findViewById(R.id.negi_image);
        ImageView image2 = (ImageView) findViewById(R.id.kyuri_image);
        ImageView image3 = (ImageView) findViewById(R.id.kinjisou_image);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);

    }

    public void onClick(View v) {
        Intent intent = new Intent(ZukanActivity.this, Zukan2Activity.class);
        switch (v.getId()){
            case R.id.negi_image:
                intent.putExtra("key",0);
                startActivity(intent);
                break;

            case R.id.kyuri_image:
                intent.putExtra("key",1);
                startActivity(intent);
                break;

            case R.id.kinjisou_image:
                intent.putExtra("key",2);
                startActivity(intent);
                break;
        }
    }
}