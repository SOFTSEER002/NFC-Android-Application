package com.ahsanshamim.nfcreader.utils;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class SystemUtils {

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
