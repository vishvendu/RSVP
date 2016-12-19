package rsvp.vishvendu.com.rsvp.Utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class TypefaceUtil {

    public enum TypeFace {
        Light, Regular, Thin
    }

    public static void setTypefaceOfMenuItem(Context context,MenuItem menuItem,TypeFace typeFace){
        Typeface customeTypeFace;
        if (typeFace == TypeFace.Light) {
            customeTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/sc_sans_app_light.ttf");
        } else if (typeFace == TypeFace.Regular) {
            customeTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/sc_sans_app_regular.ttf");
        } else {
            customeTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/sc_sans_app_thin.ttf");
        }
            SpannableString mNewTitle = new SpannableString((menuItem.getTitle()));
            mNewTitle.setSpan(new CustomTypefaceSpan("" , customeTypeFace), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            menuItem.setTitle(mNewTitle);
    }

    public static void setTypefaceOfView(Context context, View view, TypeFace typeFace) {

        Typeface customeTypeFace;

        if (typeFace == TypeFace.Light) {
            customeTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/sc_sans_app_light.ttf");
        } else if (typeFace == TypeFace.Regular) {
            customeTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/sc_sans_app_regular.ttf");
        } else {
            customeTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/sc_sans_app_thin.ttf");
        }

        if (customeTypeFace != null && view != null) {
            try {
                if (view instanceof TextView) {
                    ((TextView) view).setTypeface(customeTypeFace);
                } else if (view instanceof Button) {
                    ((Button) view).setTypeface(customeTypeFace);
                } else if (view instanceof EditText) {
                    ((EditText) view).setTypeface(customeTypeFace);
                } else if (view instanceof ViewGroup) {
                    SetTypefaceOfViewGroup(context, (ViewGroup) view, typeFace);
                } else if (view instanceof RadioButton) {
                    ((RadioButton) view).setTypeface(customeTypeFace);
                } else {
                   // Utilities.showLogE("TypefaceUtil: {0} is type of {1} and does not have a typeface property", "" + view.getId());
                }
            } catch (Exception ex) {
               // Utilities.showLogE("TypefaceUtil threw:\n{0}\n{1}", "" + ex.getStackTrace());
                throw ex;
            }
        } else {
           // Utilities.showLogE("TypefaceUtil", " customTypeface / view parameter should not be null");
        }
    }

    public static void SetTypefaceOfViewGroup(Context context, ViewGroup layout, TypeFace customeTypeFace) {
        if (customeTypeFace != null && layout != null) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                setTypefaceOfView(context, layout.getChildAt(i), customeTypeFace);
            }
        } else {
          //  Utilities.showLogE("AndroidTypefaceUtility:", " customTypeface / layout parameter should not be null");
        }
    }

    public static class CustomTypefaceSpan extends TypefaceSpan {

        private final Typeface newType;

        public CustomTypefaceSpan(String family, Typeface type) {
            super(family);
            newType = type;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            applyCustomTypeFace(ds, newType);
        }

        @Override
        public void updateMeasureState(TextPaint paint) {
            applyCustomTypeFace(paint, newType);
        }

        private  void applyCustomTypeFace(Paint paint, Typeface tf) {
            int oldStyle;
            Typeface old = paint.getTypeface();
            if (old == null) {
                oldStyle = 0;
            } else {
                oldStyle = old.getStyle();
            }

            int fake = oldStyle & ~tf.getStyle();
            if ((fake & Typeface.BOLD) != 0) {
                paint.setFakeBoldText(true);
            }

            if ((fake & Typeface.ITALIC) != 0) {
                paint.setTextSkewX(-0.25f);
            }

            paint.setTypeface(tf);
        }
    }


}