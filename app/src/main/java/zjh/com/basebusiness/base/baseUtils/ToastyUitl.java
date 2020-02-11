package zjh.com.basebusiness.base.baseUtils;

import android.content.Context;

import androidx.annotation.NonNull;

import es.dmoral.toasty.Toasty;

/**
 * @author zhangjianhao
 * @date 2019-11-19
 */
public class ToastyUitl {
    public static void successToasty(@NonNull Context context, @NonNull CharSequence content) {
        Toasty.success(context, content).show();
    }

    public static void errorToasty(@NonNull Context context, @NonNull CharSequence content) {
        Toasty.error(context, content).show();
    }

    public static void infoToasty(@NonNull Context context, @NonNull CharSequence content) {
        Toasty.info(context, content).show();
    }

    public static void warnToasty(@NonNull Context context, @NonNull CharSequence content) {
        Toasty.warning(context, content).show();
    }
}
