package smartphoneapp_project.kanazawaapp_2017;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class Washi2Activity extends Activity implements View.OnTouchListener {

    ImageView target1;
    ImageView target2;
    ImageView target3;
    int currentX;
    int currentY;
    int offsetX;
    int offsetY;

    int currentX2;
    int currentY2;
    int offsetX2;
    int offsetY2;

    int currentX3;
    int currentY3;
    int offsetX3;
    int offsetY3;



    private Animation anime;

    private Rect rect = new Rect();
    private ImageView bt2;
    private ImageView bt3;
    private boolean isBt2Click;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washi2);
        Resources r = getResources();
        Bitmap bmp1 = BitmapFactory.decodeResource(r, R.drawable.kuroba);
        Bitmap bmp2 = BitmapFactory.decodeResource(r, R.drawable.momiji1);
        Bitmap bmp3 = BitmapFactory.decodeResource(r, R.drawable.momiji2);
        Bitmap bmp4 = BitmapFactory.decodeResource(r, R.drawable.momiji1kage);
        Bitmap bmp5 = BitmapFactory.decodeResource(r, R.drawable.momiji2kage);
        Button button = (Button)findViewById(R.id.button);
        target1 = (ImageView) findViewById(R.id.ImageView1);
        target2 = (ImageView) findViewById(R.id.ImageView2);
        target3 = (ImageView) findViewById(R.id.ImageView3);
        bt2 = (ImageView)findViewById(R.id.imageView2S) ;
        bt2.setImageBitmap(bmp4);
        bt3 = (ImageView)findViewById(R.id.ImageView3S);
        bt3.setImageBitmap(bmp5);
        target1.setImageBitmap(bmp1);
        target2.setImageBitmap(bmp2);
        target3.setImageBitmap(bmp3);
        this.target1.setOnTouchListener(this);
        this.target2.setOnTouchListener(this);
        this.target3.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (view.getId()) {

            case R.id.ImageView1://黄色のクローバーのドラッグアンドドロップの動作

                int x = (int) event.getRawX();
                int y = (int) event.getRawY();

                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    int diffX = target1.getLeft() + (x - offsetX);
                    int diffY = target1.getTop()  +  (y - offsetY);
                    currentX = diffX;
                    currentY = diffY;
                    target1.layout(currentX, currentY, currentX + target1.getWidth(),
                            currentY + target1.getHeight());
                    offsetX = x;
                    offsetY = y;
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    offsetX = x;
                    offsetY = y;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    target1.setVisibility(target1.VISIBLE);
                }



                break;

            case R.id.ImageView2://枝分かれしている紅葉のドラッグアンドドロップの操作

                Resources r = getResources();
                Bitmap bmp2 = BitmapFactory.decodeResource(r, R.drawable.momiji1);
                int x2 = (int) event.getRawX();
                int y2 = (int) event.getRawY();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {

                    int diffX = target2.getLeft()  +  (x2 - offsetX2);
                    int diffY = target2.getTop()  +  (y2 - offsetY2);

                    currentX2 = diffX;
                    currentY2 = diffY;


                    target2.layout(currentX2, currentY2, currentX2 + target2.getWidth()
                            , currentY2 + target2.getHeight());

                    offsetX2 = x2;
                    offsetY2 = y2;

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    offsetX2 = x2;
                    offsetY2 = y2;


                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    bt2.getHitRect(rect);
                    if (rect.contains(x2, y2)) {
                        bt2.setImageBitmap(bmp2);
                        target2.setVisibility(target2.INVISIBLE);
                    }else {
                        target2.setVisibility(target2.VISIBLE);
                    }



                }

                break;

            case R.id.ImageView3://一枚の葉っぱの形をしたモミジのドラッグアンドドロップ
                int StartX =(int) target3.getX();
                int StartY =(int) target3.getY();
                Resources r2 = getResources();
                Bitmap bmp3 = BitmapFactory.decodeResource(r2, R.drawable.momiji2);
                int x3 = (int) event.getRawX();
                int y3 = (int) event.getRawY();

                if (event.getAction() == MotionEvent.ACTION_MOVE) {

                    int diffX = target3.getLeft()  +  (x3 - offsetX3);
                    int diffY = target3.getTop()  +  (y3 - offsetY3);

                    currentX3 = diffX;
                    currentY3 = diffY;


                    target3.layout(currentX3, currentY3, currentX3 + target3.getWidth()
                            , currentY3 + target3.getHeight());

                    offsetX3 = x3;
                    offsetY3 = y3;

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    offsetX3 = x3;
                    offsetY3 = y3;


                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    bt3.getHitRect(rect);
                    if (rect.contains(x3, y3)) {
                        bt3.setImageBitmap(bmp3);
                        target3.setVisibility(target3.INVISIBLE);
                    }else {
                        target3.layout(StartX, StartY, target3.getWidth()
                                , target3.getHeight());

                    }

                }

                break;


        }


        return true;

    }
}
