package me.tonatihu.extras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author tonatihu
 * Created on 5/26/19
 */
class MiLienzo extends View {
    float x = 50, y = 50;
    String s = "";
    Path pa = new Path();

    public MiLienzo(Context c) {
        super(c);
    }

    @Override
    protected void onDraw(Canvas c) {
        c.drawColor(Color.rgb(200, 200, 200));
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(6);
        p.setColor(Color.RED);
        if (s == "abajo") pa.moveTo(x, y);
        if (s == "mover") pa.lineTo(x, y);
        c.drawPath(pa, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        x = me.getX();
        y = me.getY();
        if (me.getAction() == MotionEvent.ACTION_DOWN) s = "abajo";
        if (me.getAction() == MotionEvent.ACTION_MOVE) s = "mover";
        invalidate();
        return true;
    }
}