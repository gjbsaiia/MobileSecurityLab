package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

@RequiresApi(14)
class ImageViewUtilsApi14 implements ImageViewUtilsImpl {
    ImageViewUtilsApi14() {
    }

    public void startAnimateTransform(ImageView view) {
        ScaleType scaleType = view.getScaleType();
        view.setTag(C0110R.C0112id.save_scale_type, scaleType);
        if (scaleType == ScaleType.MATRIX) {
            view.setTag(C0110R.C0112id.save_image_matrix, view.getImageMatrix());
        } else {
            view.setScaleType(ScaleType.MATRIX);
        }
        view.setImageMatrix(MatrixUtils.IDENTITY_MATRIX);
    }

    public void animateTransform(ImageView view, Matrix matrix) {
        view.setImageMatrix(matrix);
    }

    public void reserveEndAnimateTransform(final ImageView view, Animator animator) {
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                ScaleType scaleType = (ScaleType) view.getTag(C0110R.C0112id.save_scale_type);
                view.setScaleType(scaleType);
                view.setTag(C0110R.C0112id.save_scale_type, null);
                if (scaleType == ScaleType.MATRIX) {
                    view.setImageMatrix((Matrix) view.getTag(C0110R.C0112id.save_image_matrix));
                    view.setTag(C0110R.C0112id.save_image_matrix, null);
                }
                animation.removeListener(this);
            }
        });
    }
}
