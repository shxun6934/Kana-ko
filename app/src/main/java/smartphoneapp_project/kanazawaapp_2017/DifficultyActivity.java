package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DifficultyActivity extends Activity {
    int kindGame;
    Intent intentGame;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        Intent intent = getIntent();
        kindGame = intent.getIntExtra("kind_game",0);
        Button easyButton = (Button)findViewById(R.id.button_easy);
        Button normalButton = (Button)findViewById(R.id.button_normal);
        Button hardButton = (Button)findViewById(R.id.button_hard);
        easyButton.setOnClickListener(difficultyClick);
        normalButton.setOnClickListener(difficultyClick);
        hardButton.setOnClickListener(difficultyClick);

    }
    public View.OnClickListener difficultyClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (kindGame){
                case 1:
                    break;

                case 2:
                    intentGame = new Intent(DifficultyActivity.this,Washi1Activity.class);
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
}
