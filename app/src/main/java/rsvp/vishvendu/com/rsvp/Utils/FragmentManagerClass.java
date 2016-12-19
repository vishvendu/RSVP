package rsvp.vishvendu.com.rsvp.Utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import rsvp.vishvendu.com.rsvp.R;



public class FragmentManagerClass {

    public static FragmentTransaction fragmentTransaction;

    public static void inflateFragment(Fragment fragment, FragmentManager fragmentManager, int fragmentContainer, Bundle bundle) {
        fragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragmentContainer, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    public static void callFragment(FragmentManager fm, Fragment obj, int resId, Bundle extras) {
        try {
            try {
                if (extras != null) {
                    obj.setArguments(extras);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter,
                    R.anim.fragment_slide_left_exit,
                    R.anim.fragment_slide_right_enter,
                    R.anim.fragment_slide_right_exit);
            fragmentTransaction.replace(resId, obj);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void callFragmentLeft(FragmentManager fm, Fragment obj, int resId, Bundle extras) {
        try {
            try {
                if (extras != null) {
                    obj.setArguments(extras);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_right_enter,
                    R.anim.fragment_slide_right_exit, R.anim.fragment_slide_left_enter,
                    R.anim.fragment_slide_left_exit);
            fragmentTransaction.replace(resId, obj);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void callFragmentWithoutStack(FragmentManager fm, Fragment obj, int resId, Bundle extras) {
        try {
            try {
                if (extras != null) {
                    obj.setArguments(extras);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter,
                    R.anim.fragment_slide_left_exit,
                    R.anim.fragment_slide_right_enter,
                    R.anim.fragment_slide_right_exit);
            fragmentTransaction.replace(resId, obj);
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void callAddFragment(FragmentManager fm, Fragment obj, int resId, Bundle extras) {
        try {
            try {
                if (extras != null) {
                    obj.setArguments(extras);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter,
                    R.anim.fragment_slide_left_exit,
                    R.anim.fragment_slide_right_enter,
                    R.anim.fragment_slide_right_exit);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.add(resId, obj);
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void callAddFragmentWithStack(FragmentManager fm, Fragment obj, int resId, Bundle extras) {
        try {
            try {
                if (extras != null) {
                    obj.setArguments(extras);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.add(resId, obj);
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void popAllFragment(FragmentManager fragmentManager) {
        try {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   /* public void gobackToPreviousFragment(FragmentManager fManager, String preFragmentTag, Fragment preFragment){

        FragmentManager  fm = fManager;

        FragmentTransaction ft = fm.beginTransaction();
        //ft.setCustomAnimations(R.animator.close_slide_in,R.animator.close_slide_out);

        ft.show(preFragment);

        //**BY REMOVING FRAGMENT, WHEN USER TRIES TO REVISIT, FRAGMENT IS BLACK**

        ft.remove(fm.findFragmentByTag(.currentContentFragmentTag));
        ft.addToBackStack(null);
        ft.commit();

        Misc.currentContentFragmentTag = preFragmentTag;

        createBar(preFragment);
    }
*/
}