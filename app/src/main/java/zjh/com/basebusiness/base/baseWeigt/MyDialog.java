package zjh.com.basebusiness.base.baseWeigt;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

/**
 * com.customdialogdemo
 * Created by Mr.Hao on 2017/6/2 16:08.
 */

public class MyDialog extends Dialog {
    private static int default_width = 300; //默认宽度

    private static int default_height = 200;//默认高度
    public MyDialog(@NonNull Context context) {
        super(context);
    }

    public MyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public MyDialog(Context context, int width, int height, View layout, int style) {

        super(context, style);

        setContentView(layout);

        Window window = getWindow();

        WindowManager.LayoutParams params = window.getAttributes();

        params.gravity = Gravity.CENTER;

        window.setAttributes(params);

    }


}
