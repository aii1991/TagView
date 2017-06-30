package com.zjh.library.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zjh.library.bean.TagBean;

import java.util.List;

/**
 * @author zjh
 *         2017/6/28
 */

public class TagView extends View{
    List<TagBean> tags;
    Paint mPaint;
    Rect mTextBounds;
    Path bgPath;
    public TagView(Context context) {
        super(context);
        init();
    }

    public TagView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TagView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mTextBounds = new Rect();
        bgPath = new Path();
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (tags != null){
            for (TagBean tagBean : tags){
                canvas.save();
                canvas.rotate(tagBean.rotateDegrees);

                generateTextBound(tagBean);
                generateBgPath(tagBean);

                int baseLine = calcBaseLine(tagBean);
                drawBg(canvas, tagBean);
                drawText(canvas, tagBean, baseLine);
                mPaint.reset();
                canvas.restore();
            }
        }
    }

    /**
     * 绘制文字
     * @param canvas
     * @param tagBean
     * @param baseLine
     */
    private void drawText(Canvas canvas, TagBean tagBean, int baseLine) {
        if (tagBean.textColor != 0){
            mPaint.setColor(tagBean.textColor);
        }
        int hOffset = (tagBean.getWidth() - mTextBounds.width()) / 2;
        canvas.drawTextOnPath(tagBean.text,bgPath,hOffset,baseLine,mPaint);
    }

    /**
     * 绘制背景
     * @param canvas
     * @param tagBean
     */
    private void drawBg(Canvas canvas, TagBean tagBean) {
        if (tagBean.bgColor != 0){
            mPaint.setColor(tagBean.bgColor);
            canvas.drawPath(bgPath,mPaint);
        }
        if (tagBean.strokeColor != 0){
            mPaint.setColor(tagBean.strokeColor);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(tagBean.strokeWidth);
            canvas.drawPath(bgPath,mPaint);
            mPaint.setStrokeWidth(0);
        }
    }

    /**
     * 计算基线
     * @param tagBean
     * @return
     */
    private int calcBaseLine(TagBean tagBean) {
        Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
        return (tagBean.getHeight() - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
    }

    /**
     * 生成背景路径
     * @param tagBean
     */
    private void generateBgPath(TagBean tagBean) {
        if (tagBean.right == 0 && tagBean.bottom == 0){
            tagBean.right = tagBean.left + mTextBounds.width();
            tagBean.bottom = tagBean.top + mTextBounds.height();
        }
        bgPath.reset();
        bgPath.addRect(tagBean.left,tagBean.top,tagBean.left + tagBean.getWidth(),tagBean.top + tagBean.getHeight(), Path.Direction.CW);
    }

    /**
     * 生成文字显示区域(TextBounds)
     * @param tagBean
     */
    private void generateTextBound(TagBean tagBean) {
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(tagBean.textSize);
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.getTextBounds(tagBean.text,0,tagBean.text.length(), mTextBounds);
    }

    public void setTags(List<TagBean> tags) {
        this.tags = tags;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


}
