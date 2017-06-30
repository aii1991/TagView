package com.zjh.library.bean;

public class TagBean {
    private TagBean(){}
    public String text;
    public int textColor;
    public int bgColor;
    public int strokeWidth;
    public int strokeColor;
    public int top;
    public int right;
    public int bottom;
    public int left;
    public int textSize;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public int paddingBottom;
    public int rotateDegrees;

    public static class Builder{
        private TagBean tagBean;
        public Builder(){
            tagBean = new TagBean();
        }

        public Builder setText(String text){
            tagBean.text = text;
            return this;
        }

        public Builder setTextColor(int textColor){
            tagBean.textColor = textColor;
            return this;
        }

        public Builder setBgColor(int bgColor){
            tagBean.bgColor = bgColor;
            return this;
        }

        public Builder setTop(int top){
            tagBean.top = top;
            return this;
        }

        public Builder setRight(int right){
            tagBean.right = right;
            return this;
        }

        public Builder setBottom(int bottom){
            tagBean.bottom = bottom;
            return this;
        }

        public Builder setLeft(int left){
            tagBean.left = left;
            return this;
        }

        public Builder setTextSize(int textSize){
            tagBean.textSize = textSize;
            return this;
        }

        public Builder setPaddingLeft(int paddingLeft){
            tagBean.paddingLeft = paddingLeft;
            return this;
        }

        public Builder setPaddingTop(int paddingTop){
            tagBean.paddingTop = paddingTop;
            return this;
        }

        public Builder setPaddingRight(int paddingRight){
            tagBean.paddingRight = paddingRight;
            return this;
        }

        public Builder setPaddingBottom(int paddingBottom){
            tagBean.paddingBottom = paddingBottom;
            return this;
        }

        public Builder setPadding(int padding){
            tagBean.paddingLeft = padding;
            tagBean.paddingTop = padding;
            tagBean.paddingRight = padding;
            tagBean.paddingBottom = padding;
            return this;
        }

        public Builder setRotateDegrees(int degrees){
            tagBean.rotateDegrees = degrees;
            return this;
        }

        public Builder setStrokeWidth(int width){
            tagBean.strokeWidth = width;
            return this;
        }

        public Builder setStrokeColor(int color){
            tagBean.strokeColor = color;
            return this;
        }

        public TagBean build(){
            return tagBean;
        }
    }

    public int getWidth(){
        return Math.abs(right - left) + paddingLeft + paddingRight;
    }


    public int getHeight(){
        return Math.abs(bottom - top) + paddingTop + paddingBottom;
    }

}