package smartphoneapp_project.kanazawaapp_2017;

import android.support.annotation.NonNull;
import android.view.MotionEvent;

public class RotationGestureDetector {

    interface OnRotationGestureListener {
        void onRotate(float angle);
    }

    private float centerX = 0;
    private float centerY = 0;
    public float angle = 0;

    private OnRotationGestureListener listener;

    public RotationGestureDetector(@NonNull OnRotationGestureListener listener) {
        this.listener = listener;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public void onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float angle = calcAngle(event.getX(), event.getY(), centerX, centerY);
            listener.onRotate(angle);
        }
    }

    private float calcAngle(float fingerX, float fingerY, float centerX, float centerY) {
        float x = fingerX - centerX;
        float y = fingerY - centerY;
        float theta = (float) Math.atan2(y, x);
        float angle = (float) Math.toDegrees(theta);

        if (angle < 0) angle += 360;
        angle = Math.abs(360 - angle);
        if (angle == 360) angle = 0.0F;

        return angle;
    }
}
