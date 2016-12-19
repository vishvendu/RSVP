package rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import rsvp.vishvendu.com.rsvp.Onboarding.Module.Activity.OnBoardingMainActivity;
import rsvp.vishvendu.com.rsvp.R;
import rsvp.vishvendu.com.rsvp.Utils.FragmentManagerClass;


public class RegisterMobileNo extends Fragment implements View.OnClickListener {

    TextView MobileNoText,TextDetails;
    ImageButton RegisterMobileBtn ;
    PersonalDetailsFragment personalDetailsFragment;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_mobile_no, container, false);
        initFragment(view);
        return view;
    }

    private void initFragment(View view) {

         MobileNoText = (TextView)view .findViewById(R.id.mobilenotext);
         TextDetails = (TextView)view. findViewById(R.id.mobilenodescription);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/sc_sans_app_thin.ttf");
        MobileNoText.setTypeface(face);
        TextDetails.setTypeface(face);
        RegisterMobileBtn = (ImageButton)view.findViewById(R.id.BtnRegistermobileno);
        RegisterMobileBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        OnBoardingMainActivity onBoardingMainActivity = (OnBoardingMainActivity)getActivity();

        onBoardingMainActivity.initPersonalDetailInflate();
       /* personalDetailsFragment = new PersonalDetailsFragment();
        FragmentManagerClass.inflateFragment(personalDetailsFragment,fragmentManager,R.id.onboarding_container,null);*/

    }
}
