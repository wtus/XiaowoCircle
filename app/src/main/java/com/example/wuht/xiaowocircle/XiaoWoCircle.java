package com.example.wuht.xiaowocircle;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by vcc on 2016/11/5.
 */

public class XiaoWoCircle extends View {

    private Paint
            mPaint = new Paint();

    private int mWidth, mHeight;
    private RectF rectCircel, rectOval1, rectOval2, rectOval3, rectOval4;
    private float alpha,m;
    private ValueAnimator valueAnimator;

    public XiaoWoCircle(Context context) {
        this(context, null);
        init();
    }

    public XiaoWoCircle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public XiaoWoCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initPaint(mPaint, Color.RED, true, Paint.Style.FILL);
        mPaint.setAlpha(100);

        float beta = 2;
        rectCircel = new RectF(-90 * beta, -90 * beta, 90 * beta, 90 * beta);
        rectOval1 = new RectF(-90 * beta, -110 * beta, 90 * beta, 110 * beta);
        rectOval2 = new RectF(-90 * beta, -110 * beta, 90 * beta, 110 * beta);
        rectOval3 = new RectF(-90 * beta, -110 * beta, 90 * beta, 110 * beta);
        rectOval4 = new RectF(-90 * beta, -110 * beta, 90 * beta, 110 * beta);

        valueAnimator = ValueAnimator.ofFloat(0, 359.99f);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setDuration(50000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                alpha = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.rotate(alpha);
        // drawCircle(canvas);
        canvas.drawOval(rectOval1, mPaint);
        canvas.rotate(45f);
        canvas.drawOval(rectOval2, mPaint);
        canvas.rotate(90f);
        canvas.drawOval(rectOval3, mPaint);
        canvas.rotate(-45f);
        canvas.drawOval(rectOval3, mPaint);
        canvas.drawOval(rectCircel, mPaint);
        

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        valueAnimator.start();
    }

    private void initPaint(Paint paint, int color, boolean isAntiAlias, Paint.Style style) {
        paint.setColor(color);
        paint.setAntiAlias(isAntiAlias);
        paint.setStyle(style);
    }

    public void setM() {
        m = m + 3;
        if (m > 360) {
            m = 0;
        }
        invalidate();
    }
}
