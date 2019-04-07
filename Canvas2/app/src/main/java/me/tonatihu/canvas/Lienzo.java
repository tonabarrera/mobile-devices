package me.tonatihu.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

/**
 * @author tonatihu
 * Created on 4/6/19
 */
class Lienzo extends View {
    Paint p;
    int x, y;

    public Lienzo(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p = new Paint();
        x = getWidth();
        y = getHeight();
        p.setColor(Color.WHITE);
        canvas.drawPaint(p);
        p.setColor(Color.BLACK);
        p.setTextSize(20);
        p.setTypeface(Typeface.DEFAULT);
        canvas.drawText("x0=" + x/2 + ", y0=" + y/2, x/2 + 20, y/2 - 20, p);
        p.setColor(Color.rgb(0, 0, 255));
        canvas.drawLine(x/2, 0, x/2, y, p);
        canvas.drawLine(0, y/2, x, y/2, p);

        p.setTextAlign(Paint.Align.LEFT);
        p.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("Eje x", x-5, y/2 - 10, p);
        p.setTextAlign(Paint.Align.valueOf("CENTER"));
        p.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("Eje y", x/2 + 30, 20, p);

        p.setColor(Color.argb(20, 200, 100, 100));
        canvas.drawCircle(x/2, y/2, 100, p);

        p.setColor(Color.argb(40, 100, 200, 100));
        canvas.drawOval(x - x/4 - 100, y/4 - 100, x - x/4 + 200, y/4 + 150, p);

        p.setColor(Color.argb(60, 100, 100, 200));
        canvas.drawRect(x/4 - 100, y/4 - 100, x/4 + 100, y/4 + 100, p);

        p.setColor(Color.argb(80, 200, 200, 100));
        canvas.drawRoundRect(x/4 - 100, y - y/4 - 100, x/4 + 100, y - y/4 + 100, 50, 50, p);

        p.setColor(Color.argb(100, 200, 100, 200));
        canvas.drawArc(x - x/4 - 100, y - y/4 - 100, x - x/4 + 100,
                    y - y/4 + 100, 0, 180, false, p);
    }
}
