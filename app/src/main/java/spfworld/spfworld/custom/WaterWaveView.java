package spfworld.spfworld.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class WaterWaveView extends View {
    private Handler mHandler;
    private long c = 0L;
    private boolean mStarted = false;
    private float f = 0.00F;//速度
    private int mAlpha = 0;//透明度
    private int mColor = Color.WHITE;
    private float mAmplitude = 0.0F; // 振幅
    private final Paint mPaint = new Paint();
    private float mWateLevel = 0.0F;//水高(0~1)
    private Path mPath;
    public WaterWaveView(Context paramContext)
    {
        super(paramContext);
        init(paramContext);
    }
    public WaterWaveView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        init(paramContext);
    }
    /**
     * 开始波动
     */
    public void startWave()
    {
        if (!mStarted)
        {
            this.c = 0L;
            mStarted = true;
            this.mHandler.sendEmptyMessage(0);
        }
    }
    private void init(Context context)
    {
        mPaint.setStrokeWidth(1.0F);
        mPaint.setColor(mColor);
        mPaint.setAlpha(mAlpha);
        mPath = new Path();
        mHandler = new Handler()
        {
            @Override
            public void handleMessage(android.os.Message msg)
            {
                if (msg.what == 0)
                {
                    invalidate();
                    if (mStarted)
                    {
                        //不断发消息给自己，使自己不断被重绘
                        mHandler.sendEmptyMessageDelayed(0, 60L);
                    }
                }
            }
        };
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.save();
        mPaint.setAlpha(mAlpha);
        mPaint.setColor(mColor);
        // 得到控件的宽高
        int width = getWidth();
        int height = getHeight();
        // 如果未开始（未调用startWave方法）,绘制一个矩形
        if ((!mStarted) || (width == 0) || (height == 0))
        {
            canvas.drawRect(0.0F, height / 2, width, height, mPaint);
            return;
        }
        if (this.c >= 8388607L)
        {
            this.c = 0L;
        }
        //每次onDraw时c都会自增
        this.c = (1L + this.c);
        float f1 = height * (1.0F - mWateLevel);
        int top = (int) (f1 + mAmplitude);
        mPath.reset();
        // 绘制矩形,即水面静止时的高度
        canvas.drawRect(0.0F, top, width, height, mPaint);
        int startX = 0;
        //波浪效果
        while (startX < width)
        {
            int startY = (int) (f1 - mAmplitude* Math.sin(Math.PI* (2.0F * (startX + this.c * width * this.f))/ width));
            canvas.drawLine(startX, startY, startX, top, mPaint);
            startX++;
        }
        canvas.restore();
    }
    /**
     * 设置振幅
     * @param amplitued
     */
    public void setAmplitude(float amplitued)
    {
        mAmplitude = amplitued;
    }
    /**
     * 设置透明度
     * @param alpha
     */
    public void setWaterAlpha(float alpha)
    {
        this.mAlpha = ((int) (255.0F * alpha));
        mPaint.setAlpha(this.mAlpha);
    }
    /**
     * 设置速度
     */
    public void setF(float f1)
    {
        f  = f1;
    }
    /**
     * 设置颜色
     * @param color
     */
    public void setColor(int color)
    {
        this.mColor = color;
    }

    /**
     * 设置水面高度
     * @param paramFloat
     */
    public void setWaterLevel(float paramFloat)
    {
        mWateLevel = paramFloat;
    }

    @Override
    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        // 关闭硬件加速，防止异常unsupported operation exception
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }
}