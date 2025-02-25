package com.cn.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cn.dialog.effects.BaseEffects;


/*
 * Copyright 2014 litao
 * https://github.com/sd6352051/NiftyDialogEffects
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class NiftyDialogBuilder extends Dialog implements DialogInterface {

    private final String defTextColor = "#FFFFFFFF";

    private final String defDividerColor = "#11000000";

    private final String defMsgColor = "#FFFFFFFF";

    private final String defDialogColor = "#FFE74C3C";

    private AnimationStyle type = null;

    private RelativeLayout mTitleTemplate;

    private LinearLayout mLinearLayoutView;

    private RelativeLayout mRelativeLayoutView;

    private LinearLayout mLinearLayoutMsgView;

    private LinearLayout mLinearLayoutTopView;

    private FrameLayout mFrameLayoutCustomView;

    private RelativeLayout mRelativeLayoutParentPanel;

    private View mDialogView;

    private View mDivider;

    private TextView mTitle;

    private TextView mMessage;

    private ImageView mIcon;

    private Button mNegativeBtn;

    private Button mPositiveBtn;

    private int mDuration = -1;

    private static int mOrientation = 1;

    private boolean isCancelable = true;

    public NiftyDialogBuilder(Context context) {
        super(context);
        init(context);

    }

    public NiftyDialogBuilder(Context context, int theme) {
        super(context, theme);
        init(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

    }

    public static NiftyDialogBuilder build(Context context) {
        return new NiftyDialogBuilder(context, R.style.dialog_untran);

    }

    private void init(Context context) {
        mDialogView = View.inflate(context, R.layout.dialog_nifty_layout, null);
        mTitleTemplate = (RelativeLayout) mDialogView.findViewById(R.id.title_template);
        mLinearLayoutView = (LinearLayout) mDialogView.findViewById(R.id.parentPanel);
        mRelativeLayoutView = (RelativeLayout) mDialogView.findViewById(R.id.main);
        mLinearLayoutTopView = (LinearLayout) mDialogView.findViewById(R.id.topPanel);
        mLinearLayoutMsgView = (LinearLayout) mDialogView.findViewById(R.id.contentPanel);
        mFrameLayoutCustomView = (FrameLayout) mDialogView.findViewById(R.id.customPanel);
        mRelativeLayoutParentPanel = (RelativeLayout) mDialogView.findViewById(R.id.relativeLayoutParentPanel);
        mTitleTemplate.setVisibility(View.GONE);

        mTitle = (TextView) mDialogView.findViewById(R.id.alertTitle);
        mMessage = (TextView) mDialogView.findViewById(R.id.message);
        mIcon = (ImageView) mDialogView.findViewById(R.id.icon);
        mDivider = mDialogView.findViewById(R.id.titleDivider);
        mNegativeBtn = (Button) mDialogView.findViewById(R.id.negativeBtn);
        mPositiveBtn = (Button) mDialogView.findViewById(R.id.positiveBtn);

        setContentView(mDialogView);

        this.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                mLinearLayoutView.setVisibility(View.VISIBLE);
                if (type == null) {
                    type = AnimationStyle.Slidetop;
                }
                start(type);


            }
        });
        mRelativeLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCancelable) dismiss();
            }
        });
    }

    public void toDefault() {
        mTitle.setTextColor(Color.parseColor(defTextColor));
        mDivider.setBackgroundColor(Color.parseColor(defDividerColor));
        mMessage.setTextColor(Color.parseColor(defMsgColor));
        mLinearLayoutView.setBackgroundColor(Color.parseColor(defDialogColor));
    }

    public NiftyDialogBuilder withDividerColor(String colorString) {
        mDivider.setBackgroundColor(Color.parseColor(colorString));
        return this;
    }

    public NiftyDialogBuilder withDividerColor(int color) {
        mDivider.setBackgroundColor(color);
        return this;
    }


    public NiftyDialogBuilder withTitle(CharSequence title) {
        toggleView(mLinearLayoutTopView, title);
        mTitle.setText(title);
        mTitleTemplate.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder withTitleColor(String colorString) {
        mTitle.setTextColor(Color.parseColor(colorString));
        return this;
    }

    public NiftyDialogBuilder withTitleColor(int color) {
        mTitle.setTextColor(color);
        return this;
    }

    public NiftyDialogBuilder withMessage(int textResId) {
        toggleView(mLinearLayoutMsgView, textResId);
        mMessage.setText(textResId);
        mMessage.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder withMessage(CharSequence msg) {
        toggleView(mLinearLayoutMsgView, msg);
        mMessage.setText(msg);
        mMessage.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder withMessageColor(String colorString) {
        mMessage.setTextColor(Color.parseColor(colorString));
        return this;
    }

    public NiftyDialogBuilder withMessageColor(int color) {
        mMessage.setTextColor(color);
        return this;
    }

    public NiftyDialogBuilder withDialogColor(String colorString) {
        mLinearLayoutView.getBackground().setColorFilter(ColorUtils.getColorFilter(Color
                .parseColor(colorString)));
        return this;
    }

    public NiftyDialogBuilder withDialogColor(int color) {
        mLinearLayoutView.getBackground().setColorFilter(ColorUtils.getColorFilter(color));
        return this;
    }

    public NiftyDialogBuilder withIcon(int drawableResId) {
        mIcon.setImageResource(drawableResId);
        mTitleTemplate.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder withIcon(Drawable icon) {
        mIcon.setImageDrawable(icon);
        mTitleTemplate.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder withDuration(int duration) {
        this.mDuration = duration;
        return this;
    }

    public NiftyDialogBuilder withEffect(AnimationStyle type) {
        this.type = type;
        return this;
    }

    public NiftyDialogBuilder withNegativeButtonEnable(boolean enable) {
        mNegativeBtn.setEnabled(enable);
        return this;
    }

    public NiftyDialogBuilder withPositiveButtonEnable(boolean enable) {
        mPositiveBtn.setEnabled(enable);
        return this;
    }

    public NiftyDialogBuilder withButtonDrawable(int resid) {
        mNegativeBtn.setBackgroundResource(resid);
        mPositiveBtn.setBackgroundResource(resid);
        return this;
    }

    public NiftyDialogBuilder withNegativeButtonDrawable(int resid) {
        mNegativeBtn.setBackgroundResource(resid);
        return this;
    }

    public NiftyDialogBuilder withPositiveButtonDrawable(int resid) {
        mPositiveBtn.setBackgroundResource(resid);
        return this;
    }

    public NiftyDialogBuilder withNegativeText(CharSequence text) {
        mNegativeBtn.setVisibility(View.VISIBLE);
        mNegativeBtn.setText(text);
        return this;
    }

    public NiftyDialogBuilder withPositiveText(CharSequence text) {
        mPositiveBtn.setVisibility(View.VISIBLE);
        mPositiveBtn.setText(text);
        return this;
    }

    public NiftyDialogBuilder setNegativeListener(View.OnClickListener click) {
        mNegativeBtn.setOnClickListener(click);
        return this;
    }

    public NiftyDialogBuilder setPositiveListener(View.OnClickListener click) {
        mPositiveBtn.setOnClickListener(click);
        return this;
    }

    public NiftyDialogBuilder setCustomView(int resId, Context context) {
        View customView = View.inflate(context, resId, null);
        if (mFrameLayoutCustomView.getChildCount() > 0) {
            mFrameLayoutCustomView.removeAllViews();
        }
        mFrameLayoutCustomView.addView(customView);
        mFrameLayoutCustomView.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder setCustomView(View view, Context context) {
        if (mFrameLayoutCustomView.getChildCount() > 0) {
            mFrameLayoutCustomView.removeAllViews();
        }
        mFrameLayoutCustomView.addView(view);
        mFrameLayoutCustomView.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder isCancelableOnTouchOutside(boolean cancelable) {
        this.isCancelable = cancelable;
        this.setCanceledOnTouchOutside(cancelable);
        return this;
    }

    public NiftyDialogBuilder isCancelable(boolean cancelable) {
        this.isCancelable = cancelable;
        this.setCancelable(cancelable);
        return this;
    }

    private void toggleView(View view, Object obj) {
        if (null == view) return;
        if (obj == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void show() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        int widthPixels = outMetrics.widthPixels;
        final int heightPixels = outMetrics.heightPixels;
        final int maxHeight = heightPixels / 5 * 3;

        final ViewGroup.LayoutParams mMessageParams = mMessage.getLayoutParams();
        final ViewGroup.LayoutParams mCustomViewParams = mFrameLayoutCustomView.getLayoutParams();
        final RelativeLayout.LayoutParams  mRelativeLayoutParentPanelParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        mFrameLayoutCustomView.post(new Runnable() {
            @Override
            public void run() {

                if (mFrameLayoutCustomView.getHeight() > maxHeight) {
                    mCustomViewParams.height = maxHeight;
                    mFrameLayoutCustomView.setLayoutParams(mCustomViewParams);

                    mRelativeLayoutParentPanelParams.topMargin = 0;
                    mRelativeLayoutParentPanelParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                    mRelativeLayoutParentPanel.setLayoutParams(mRelativeLayoutParentPanelParams);
                }

                if (mMessage.getHeight() > maxHeight) {
                    mMessageParams.height = maxHeight;
                    mMessage.setLayoutParams(mMessageParams);

                    mRelativeLayoutParentPanelParams.topMargin = 0;
                    mRelativeLayoutParentPanelParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                    mRelativeLayoutParentPanel.setLayoutParams(mRelativeLayoutParentPanelParams);
                }

            }
        });
        super.show();
    }

    private void start(AnimationStyle type) {
        BaseEffects animator = type.getAnimator();
        if (mDuration != -1) {
            animator.setDuration(Math.abs(mDuration));
        }
        animator.start(mRelativeLayoutView);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mNegativeBtn.setVisibility(View.GONE);
        mPositiveBtn.setVisibility(View.GONE);
    }
}
