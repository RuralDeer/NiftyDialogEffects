package com.gitonway.lee.niftymodaldialogeffects;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        dialogBuilder
                //.withTitle("Modal Dialog")                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage("GitHub是一个面向开源及私有软件项目的托管平台，因为只支持git 作为唯一的版本库格式进行托管，故名GitHub")                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)                               //def
                //.withIcon(getResources().getDrawable(R.drawable.icon))
                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                .withDuration(700)                                          //def
                .withEffect(effect)                                         //def AnimationStyle.Slidetop
                .withNegativeText("OK")                                      //def gone
                .withPositiveText("Cancel")                                  //def gone
                .setCustomView(R.layout.custom_view, v.getContext())         //.setCustomView(View or ResId,context)
                .setNegativeListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }


}
