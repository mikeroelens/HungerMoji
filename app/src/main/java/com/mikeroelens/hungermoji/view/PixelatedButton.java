package com.mikeroelens.hungermoji.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.mikeroelens.hungermoji.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PixelatedButton extends FrameLayout {
    @Bind(R.id.bgPixelatedButton) FrameLayout backgroundLayout;
    @Bind(R.id.txtPixelatedButton) PixelatedTextView mText;

    public PixelatedButton(Context context) {
        this(context, null);
    }

    public PixelatedButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PixelatedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.pixelated_button, this);
        ButterKnife.bind(this, v);

        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.PixelatedButton, defStyle, 0);
        

        String text = a.getString(
                R.styleable.PixelatedButton_text);

        float textSize = a.getDimension(R.styleable.PixelatedButton_textSize, 14.0f);
        int backgroundColour = a.getColor(R.styleable.PixelatedButton_backgroundColour, -1);
        int textColour = a.getColor(R.styleable.PixelatedButton_textColour, -1);

        a.recycle();

        mText.setTextSize(textSize);
        mText.setText(text);

        if (backgroundColour != -1) {
            backgroundLayout.setBackgroundColor(backgroundColour);
        }

        if (textColour != -1) {
            mText.setTextColor(textColour);
        }
    }
}
