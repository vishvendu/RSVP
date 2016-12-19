package rsvp.vishvendu.com.rsvp.Onboarding.Module.Util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Vishal on 17-12-2016.
 */

public class RegistrationviewPager extends ViewPager {

    private boolean isPagingEnabled = true;

    public RegistrationviewPager(Context context) {
        super(context);
    }
    public RegistrationviewPager(Context context,AttributeSet attrs) {
        super(context,attrs);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean isEnabled) {
        this.isPagingEnabled = isEnabled;
    }
}
