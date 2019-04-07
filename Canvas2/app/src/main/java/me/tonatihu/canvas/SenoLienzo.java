package me.tonatihu.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.View;

/**
 * @author tonatihu
 * Created on 4/6/19
 */
class SenoLienzo extends View {
    Paint paint;
    Path path;
    int x, y, x0, y0;
    int AMPLITUD = 2;
    int PERIODO = 10;
    public static final String TAG = SenoLienzo.class.getName();
    public SenoLienzo(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        path = new Path();
        x = getWidth();
        x0 = x/2;
        y = getHeight();
        y0 = y/2;

        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        canvas.drawText("0, 0", x0 + 5, y0 + 40, paint);

        paint.setColor(Color.GREEN);
        paint.setTextSize(40);
        canvas.drawText("Amplitud=" + AMPLITUD, x0 + 10, 50, paint);

        paint.setColor(Color.GREEN);
        paint.setTextSize(40);
        canvas.drawText("Periodo=" + PERIODO, x0 + 10, 85, paint);

        paint.setColor(Color.rgb(0, 0 ,255));
        canvas.drawLine(x0, 0, x0, y, paint);
        canvas.drawLine(0, y0, x, y0, paint);

        paint.setColor(Color.BLUE);
        canvas.drawText("senA", 20, 50, paint);

        paint.setColor(Color.RED);
        canvas.drawText("cosA", 20, 85, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);

        int amplitudActual = (-100 * AMPLITUD);

        x = getMeasuredWidth();
        Log.d(TAG, "width=" + x);
        path.moveTo(0, 0);
        paint.setColor(Color.BLUE);
        for (int i=0; i < x; i++)
            path.lineTo(i, (float) (Math.sin((i*PERIODO)/172f)*amplitudActual));
        path.offset(0, y0);
        canvas.drawPath(path, paint);

        path = new Path();
        path.moveTo(0, 0);
        paint.setColor(Color.RED);
        for (int i=0; i < x; i++)
            path.lineTo(i, (float) (Math.cos((i*PERIODO)/172f)*amplitudActual));
        path.offset(0, y0);
        canvas.drawPath(path, paint);
    }
}
