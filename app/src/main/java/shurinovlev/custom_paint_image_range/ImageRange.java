package shurinovlev.custom_paint_image_range;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 1 on 21.03.2018.
 */

public class ImageRange extends View {

    Paint mPaint = new Paint();
    float w, h, x1, x2, x3, y1, y2, y3, side;
    int j=0;
    int square1 = Color.RED;
    int square2 = Color.YELLOW;
    int square3 = Color.BLUE;
    int square4 = Color.GREEN;

    public ImageRange (Context context){
        super(context);

    }
    public ImageRange (Context context, AttributeSet attrs){
        super(context,attrs);

    }
    public ImageRange(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w = canvas.getWidth();
        h = canvas.getHeight();

        // сторона
        side = w * 1/2;
        //диагональные углы
        x1 = 0;
        x2 = x1 + side;
        x3 = x2 + side;
        y1 = 0;
        y2 = y1 + side;
        y3 = y2 + side;


        if(j==0){
            mPaint.setColor(square1);
            canvas.drawRect(x1,y1,x2,y2, mPaint);
            mPaint.setColor(square2);
            canvas.drawRect(x2,y1,x3,y2, mPaint);
            mPaint.setColor(square3);
            canvas.drawRect(x1,y2,x2,y3, mPaint);
            mPaint.setColor(square4);
            canvas.drawRect(x2,y2,x3,y3, mPaint);
        }
        if (j==1){
            mPaint.setColor(square1);
            canvas.drawRect(x1,y1,x3,y3,mPaint);
        }
        if (j==2){
            mPaint.setColor(square2);
            canvas.drawRect(x1,y1,x3,y3,mPaint);
        }
        if (j==3){
            mPaint.setColor(square3);
            canvas.drawRect(x1,y1,x3,y3,mPaint);
        }
        if (j==4){
            mPaint.setColor(square4);
            canvas.drawRect(x1,y1,x3,y3,mPaint);
        }
       // canvas.save();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // х и у координаты точки касания
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(j==0){
                    if( (x >= x1 && x <= x2) && (y <= y2 && y >= y1) ){
                        // 1 квадрат
                        j=1;
                    }
                    if( (x <= x3 && x >= x2) && (y <= y2 && y >= y1) ){
                        // 2 квадрат
                        j=2;
                    }
                    if( (x >= x1 && x <= x2) && (y <= y3 && y >= y2) ){
                        //3 квадрат
                        j=3;
                    }
                    if( (x <= x3 && x >= x2) && (y <= y3 && y >= y2) ){
                        // 4 квадрат
                        j=4;
                    }
                }
                else {
                    if( (x>=x1 && x<=x3) && (y>=y1 && y<=y3) ){
                        j=0;
                    }
                }
                invalidate();
        }
        return true;
    }
}
