package zjh.com.basebusiness.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import zjh.com.basebusiness.R;

/**
 * @author zhangjianhao
 * @date 2020-01-10
 */
public class ToastUtils {
    public static final int CENTER_LAYOUT = 1;
    public static final int TOP_LAYOUT = 2;
    public static final int BOTTOM_LAYOUT = 3;

    public void showNormalToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public void showToast(Context context, String content, int showArea) {
        Toast toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        if (showArea == CENTER_LAYOUT){
            toast.setGravity(Gravity.CENTER, 0, 0);
        }else if (showArea ==TOP_LAYOUT){
            toast.setGravity(Gravity.TOP, 0, 0);
        }else if (showArea ==BOTTOM_LAYOUT){
            toast.setGravity(Gravity.BOTTOM, 0, 0);
        }else{
            toast.setGravity(Gravity.BOTTOM, 0, 0);
        }
        toast.show();
    }

    public void showCustomToast(Context context, String content, int showArea, @Nullable @DrawableRes int imageIcon) {
        Toast toast = new Toast(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.toast_custom, null);
        TextView contentTv = inflate.findViewById(R.id.content);
        ImageView icon = inflate.findViewById(R.id.icon);
        contentTv.setText(content);
        icon.setImageResource(R.mipmap.ic_launcher);
        toast.setDuration(Toast.LENGTH_SHORT);
        if (showArea == CENTER_LAYOUT){
            toast.setGravity(Gravity.CENTER, 0, 0);
        }else if (showArea ==TOP_LAYOUT){
            toast.setGravity(Gravity.TOP, 0, 0);
        }else if (showArea ==BOTTOM_LAYOUT){
            toast.setGravity(Gravity.BOTTOM, 0, 0);
        }else{
            toast.setGravity(Gravity.BOTTOM, 0, 0);
        }
        toast.setView(inflate);
        toast.show();
    }

}
