package com.gitonway.lee.niftymodaldialogeffects;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cn.dialog.AnimationStyle;
import com.cn.dialog.NiftyDialogBuilder;


public class MainActivity extends Activity {

    private AnimationStyle effect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void dialogShow(View v) {
        NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.build(this);

        switch (v.getId()) {
            case R.id.fadein:
                effect = AnimationStyle.Fadein;
                break;
            case R.id.slideright:
                effect = AnimationStyle.Slideright;
                break;
            case R.id.slideleft:
                effect = AnimationStyle.Slideleft;
                break;
            case R.id.slidetop:
                effect = AnimationStyle.Slidetop;
                break;
            case R.id.slideBottom:
                effect = AnimationStyle.SlideBottom;
                break;
            case R.id.newspager:
                effect = AnimationStyle.Newspager;
                break;
            case R.id.fall:
                effect = AnimationStyle.Fall;
                break;
            case R.id.sidefall:
                effect = AnimationStyle.Sidefill;
                break;
            case R.id.fliph:
                effect = AnimationStyle.Fliph;
                break;
            case R.id.flipv:
                effect = AnimationStyle.Flipv;
                break;
            case R.id.rotatebottom:
                effect = AnimationStyle.RotateBottom;
                break;
            case R.id.rotateleft:
                effect = AnimationStyle.RotateLeft;
                break;
            case R.id.slit:
                effect = AnimationStyle.Slit;
                break;
            case R.id.shake:
                effect = AnimationStyle.Shake;
                break;
        }

        String json = "1.修复趋势图点击崩溃问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题|2.修复交易列表排序问题";
        json = json.replaceAll("\\|", "\n");

        View view = View.inflate(this, R.layout.custom_view, null);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(json);

        dialogBuilder
                .withTitle("请再次确认订单信息")
                .withMessage("请再次确认订单信息")
                .withDuration(300)
                .withEffect(AnimationStyle.RotateBottom)
               // .setCustomView(view, this)
                .withNegativeText("取消")
                .withPositiveText("确认收购")
                .setNegativeListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setPositiveListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();

//        dialogBuilder
//                .withTitle("Modal Dialog")                                  //.withTitle(null)  no title
//                .withTitleColor("#FFFFFF")                                  //def
//                .withDividerColor("#11000000")                              //def
//                //.withMessage(json)                     //.withMessage(null)  no Msg
//                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
//                .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)                               //def
//                //.withIcon(getResources().getDrawable(R.drawable.icon))
//                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
//                .withDuration(700)                                          //def
//                .withEffect(effect)                                         //def AnimationStyle.Slidetop
//                .withNegativeText("OK")                                      //def gone
//                .withPositiveText("Cancel")                                  //def gone
//                .setCustomView(view, v.getContext())         //.setCustomView(View or ResId,context)
//                .setNegativeListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setPositiveListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .show();

    }


}
