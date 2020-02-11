package zjh.com.basebusiness.base.baseUtils;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import zjh.com.basebusiness.R;
import zjh.com.basebusiness.base.baseWeigt.MyDialog;


/**
 * Created by Mr.Hao on 2017/11/1.
 *
 * @author zhangjianhao
 */

public class DialogUtil {

    private static MyDialog dialog;
    private static TextView loading_text;

    public static void showLoading(Context context, @Nullable String dialogName) {
        View view = LayoutInflater.from(context).inflate(R.layout.base_loading_layout, null);
        dialog = new MyDialog(context, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT, view, 0);
        loading_text = view.findViewById(R.id.loading_text);
        if (TextUtils.isEmpty(dialogName)) {
            loading_text.setText("正在加载...");
        } else {
            loading_text.setText(dialogName);
        }
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
    }

    public static void updateLoadingName(String updateName) {
        if (dialog != null) {
            if (loading_text != null) {
                loading_text.setText(updateName);
            }
        }
    }

    public static void dismissDialog(Context context) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
