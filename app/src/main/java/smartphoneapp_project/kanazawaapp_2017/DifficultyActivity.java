package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DifficultyActivity extends Activity {
    int kindGame;
    Intent intentGame;
    Button easyButton;
    Button normalButton;
    Button hardButton;
    int easy=1;
    int normal=2;
    int hard=3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        final Intent intent = getIntent();
        kindGame = intent.getIntExtra("kind_game",0);
        Resources resources = getResources();
        Bitmap washi1Bitmap = BitmapFactory.decodeResource(resources,R.drawable.difficulty_description_washi1);
        Bitmap washi1ResizeBitmap=Bitmap.createScaledBitmap(washi1Bitmap,750,500,false);

        Bitmap washi2bitmap = BitmapFactory.decodeResource(resources,R.drawable.difficulty_description_washi2);
        Bitmap washi2ResizeBitmap=Bitmap.createScaledBitmap(washi2bitmap,750,500,false);

        Bitmap kaga1bitmap = BitmapFactory.decodeResource(resources,R.drawable.difficulty_description_quiz);
        Bitmap kaga1ResizeBitmap=Bitmap.createScaledBitmap(kaga1bitmap,500,750,false);

        ImageView washi1Image = new ImageView(this);
        washi1Image.setImageBitmap(washi1ResizeBitmap);
        washi1Image.setAdjustViewBounds(true);

        ImageView washi2Image = new ImageView(this);
        washi2Image.setImageBitmap(washi2ResizeBitmap);
        washi2Image.setAdjustViewBounds(true);

        ImageView kaga1Image = new ImageView(this);
        kaga1Image.setImageBitmap(kaga1ResizeBitmap);
        kaga1Image.setAdjustViewBounds(true);

        switch (kindGame){
            case 1:
                break;

            case 2:
                AlertDialog.Builder washi2Dialog=new AlertDialog.Builder(this);
                washi2Dialog.setView(washi2Image).setTitle("つくったわしに、\n            かざりつけができるぞ！").setNegativeButton("とじる", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();

                AlertDialog.Builder washi1Dialog1=new AlertDialog.Builder(this);
                washi1Dialog1.setView(washi1Image).setTitle("すまほをよこにして、\n                              うごかそう！").setNegativeButton("とじる", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                AlertDialog.Builder kaga1Dialog=new AlertDialog.Builder(this);
                kaga1Dialog.setView(kaga1Image).setNegativeButton("とじる", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                break;

            case 6:
                break;

            case 7:
                break;
        }
        easyButton = (Button)findViewById(R.id.button_easy);
        normalButton = (Button)findViewById(R.id.button_normal);
        hardButton = (Button)findViewById(R.id.button_hard);
        Button backButton = (Button)findViewById(R.id.button_back);
        easyButton.setOnClickListener(difficultyClick);
        normalButton.setOnClickListener(difficultyClick);
        hardButton.setOnClickListener(difficultyClick);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMap = new Intent(DifficultyActivity.this,MapActivity.class);
                startActivity(intentMap);
            }
        });

    }
    public View.OnClickListener difficultyClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (kindGame){
                case 1:
                    break;

                case 2:
                    intentGame = new Intent(DifficultyActivity.this,Washi1Activity.class);
                    if(view==easyButton){
                    intentGame.putExtra("DIFFICULTY",easy);
                    }else if (view==normalButton){
                        intentGame.putExtra("DIFFICULTY",normal);
                    }else{
                        intentGame.putExtra("DIFFICULTY",hard);
                    }
                    startActivity(intentGame);
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    intentGame = new Intent(DifficultyActivity.this,Kaga1Activity.class);
                    startActivity(intentGame);
                    break;

                case 6:
                    break;

                case 7:
                    break;

            }
        }
    };

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
