package smartphoneapp_project.kanazawaapp_2017;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import static smartphoneapp_project.kanazawaapp_2017.R.id.image;

/**
 * Created by meiti on 2017/11/27.
 */

public class Washi1_CanvasView extends View {
    private Paint paint;
    private Bitmap bmp = null;
    private float xpos;
    private float ypos;
    private float preX;
    private float preY;

    public Washi1_CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.kami2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 背景、半透明
        canvas.drawColor(Color.argb(125, 0, 0, 255));

        canvas.drawBitmap(bmp, canvas.getWidth()/2+xpos, canvas.getHeight()/2+ypos, paint);
    }

    public void setPosition(float xp, float yp) {

        float dT = 1.0f;
        final float ax = -xp/5;
        final float ay = yp/5;

        xpos += preX*dT  + ax*dT*dT/2;
        preX += ax*dT;

        ypos += preY*dT  + ay*dT*dT/2;
        preY += ay*dT;

        // 再描画
        invalidate();
    }
}
