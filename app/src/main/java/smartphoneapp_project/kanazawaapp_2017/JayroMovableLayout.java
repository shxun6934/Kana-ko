package smartphoneapp_project.kanazawaapp_2017;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;

import static android.content.Context.SENSOR_SERVICE;

public class JayroMovableLayout extends FrameLayout implements SensorEventListener {

    public interface SensorListenerUnregister {
        void unregister();
    }

    @IntDef({
            DIRECTION_VERTICAL,
            DIRECTION_HORIZONTAL})
    public @interface Direction {
    }
    public static final int DIRECTION_VERTICAL = 4;
    public static final int DIRECTION_HORIZONTAL = 5;

    private SparseArray<Float> accelerations = new SparseArray<>();
    private SensorManager sensorManager;

    public JayroMovableLayout(@NonNull Context context) {
        this(context, null);
    }

    public JayroMovableLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JayroMovableLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Nullable
    public SensorListenerUnregister listenSensorListener(Context context) {
        if (sensorManager == null) {
            sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
            if (sensorManager == null) {
                return null;
            }
        }

        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer == null) {
            return null;
        }

        sensorManager.registerListener(this,
                accelerometer,
                SensorManager.SENSOR_DELAY_GAME);

        return new SensorListenerUnregister() {
            @Override
            public void unregister() {
                sensorManager.unregisterListener(JayroMovableLayout.this);
            }
        };
    }

    public void addView(View child, float acceleration) {
        super.addView(child);
        accelerations.put(child.getId(), acceleration);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != Sensor.TYPE_ACCELEROMETER) {
            return;
        }

        float sensorY = sensorEvent.values[0] * -1; // 右に傾けていくと負に大きくなるため反転させる
        float sensorX = sensorEvent.values[1];

        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            if (scaledWidth(childView) <= 0 || scaledHeight(childView) <= 0) {
                continue;
            }

            sensorX *= accelerations.get(childView.getId(), 1f);
            sensorY *= accelerations.get(childView.getId(), 1f);

            if (willOver(DIRECTION_HORIZONTAL, childView, (int) (sensorX))) {
                childView.setX(getEdgeOf(DIRECTION_HORIZONTAL, childView) * Math.signum(sensorX));
            } else {
                childView.setX(childView.getX() + sensorX);
            }
            if (willOver(DIRECTION_VERTICAL, childView, (int) sensorY)) {
                childView.setY(getEdgeOf(DIRECTION_VERTICAL, childView) * Math.signum(sensorY));
            } else {
                childView.setY(childView.getY() + sensorY);
            }
        }
    }

    private boolean willOver(@Direction int direction, View v, int amount) {
        switch (direction) {
            case DIRECTION_HORIZONTAL:
                if (scaledWidth(v) < getWidth()) {
                    return true;
                }
                return Math.abs(amount + v.getX()) > getEdgeOf(direction, v);

            case DIRECTION_VERTICAL:
                if (scaledHeight(v) < getHeight()) {
                    return true;
                }
                return Math.abs(amount + v.getY()) > getEdgeOf(direction, v);

            default:
                return false;
        }
    }

    private int getEdgeOf(@Direction int direction, View v) {
        switch (direction) {
            case DIRECTION_HORIZONTAL:
                return (scaledWidth(v) - getWidth()) / 2;

            case DIRECTION_VERTICAL:
                return (scaledHeight(v) - getHeight()) / 2;

            default:
                return 0;
        }
    }

    private int scaledHeight(View v) {
        return (int) (v.getHeight() * v.getScaleY());
    }

    private int scaledWidth(View v) {
        return (int) (v.getWidth() * v.getScaleX());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // Do nothing.
    }
}
