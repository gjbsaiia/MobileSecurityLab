package android.support.p000v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnyRes;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({Scope.LIBRARY_GROUP})
/* renamed from: android.support.v4.content.res.TypedArrayUtils */
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    public static boolean hasAttribute(@NonNull XmlPullParser parser, @NonNull String attrName) {
        return parser.getAttributeValue(NAMESPACE, attrName) != null;
    }

    public static float getNamedFloat(@NonNull TypedArray a, @NonNull XmlPullParser parser, @NonNull String attrName, @StyleableRes int resId, float defaultValue) {
        return !hasAttribute(parser, attrName) ? defaultValue : a.getFloat(resId, defaultValue);
    }

    public static boolean getNamedBoolean(@NonNull TypedArray a, @NonNull XmlPullParser parser, String attrName, @StyleableRes int resId, boolean defaultValue) {
        return !hasAttribute(parser, attrName) ? defaultValue : a.getBoolean(resId, defaultValue);
    }

    public static int getNamedInt(@NonNull TypedArray a, @NonNull XmlPullParser parser, String attrName, @StyleableRes int resId, int defaultValue) {
        return !hasAttribute(parser, attrName) ? defaultValue : a.getInt(resId, defaultValue);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray a, @NonNull XmlPullParser parser, String attrName, @StyleableRes int resId, @ColorInt int defaultValue) {
        return !hasAttribute(parser, attrName) ? defaultValue : a.getColor(resId, defaultValue);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray a, @NonNull XmlPullParser parser, String attrName, @StyleableRes int resId, @AnyRes int defaultValue) {
        return !hasAttribute(parser, attrName) ? defaultValue : a.getResourceId(resId, defaultValue);
    }

    public static String getNamedString(@NonNull TypedArray a, @NonNull XmlPullParser parser, String attrName, @StyleableRes int resId) {
        if (!hasAttribute(parser, attrName)) {
            return null;
        }
        return a.getString(resId);
    }

    public static TypedValue peekNamedValue(TypedArray a, XmlPullParser parser, String attrName, int resId) {
        if (!hasAttribute(parser, attrName)) {
            return null;
        }
        return a.peekValue(resId);
    }

    public static TypedArray obtainAttributes(Resources res, Theme theme, AttributeSet set, int[] attrs) {
        if (theme == null) {
            return res.obtainAttributes(set, attrs);
        }
        return theme.obtainStyledAttributes(set, attrs, 0, 0);
    }

    public static boolean getBoolean(TypedArray a, @StyleableRes int index, @StyleableRes int fallbackIndex, boolean defaultValue) {
        return a.getBoolean(index, a.getBoolean(fallbackIndex, defaultValue));
    }

    public static Drawable getDrawable(TypedArray a, @StyleableRes int index, @StyleableRes int fallbackIndex) {
        Drawable val = a.getDrawable(index);
        if (val == null) {
            return a.getDrawable(fallbackIndex);
        }
        return val;
    }

    public static int getInt(TypedArray a, @StyleableRes int index, @StyleableRes int fallbackIndex, int defaultValue) {
        return a.getInt(index, a.getInt(fallbackIndex, defaultValue));
    }

    @AnyRes
    public static int getResourceId(TypedArray a, @StyleableRes int index, @StyleableRes int fallbackIndex, @AnyRes int defaultValue) {
        return a.getResourceId(index, a.getResourceId(fallbackIndex, defaultValue));
    }

    public static String getString(TypedArray a, @StyleableRes int index, @StyleableRes int fallbackIndex) {
        String val = a.getString(index);
        if (val == null) {
            return a.getString(fallbackIndex);
        }
        return val;
    }

    public static CharSequence getText(TypedArray a, @StyleableRes int index, @StyleableRes int fallbackIndex) {
        CharSequence val = a.getText(index);
        if (val == null) {
            return a.getText(fallbackIndex);
        }
        return val;
    }

    public static CharSequence[] getTextArray(TypedArray a, @StyleableRes int index, @StyleableRes int fallbackIndex) {
        CharSequence[] val = a.getTextArray(index);
        if (val == null) {
            return a.getTextArray(fallbackIndex);
        }
        return val;
    }

    public static int getAttr(Context context, int attr, int fallbackAttr) {
        TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attr, value, true);
        return value.resourceId != 0 ? attr : fallbackAttr;
    }
}
