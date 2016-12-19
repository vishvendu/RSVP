package rsvp.vishvendu.com.rsvp.Onboarding.Module.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.FrameLayout;

import rsvp.vishvendu.com.rsvp.BaseActivity;
import rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment.DocumentSubmit;
import rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment.FlightBookingDetails;
import rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment.PersonalDetailsFragment;
import rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment.RegisterMobileNo;
import rsvp.vishvendu.com.rsvp.R;
import rsvp.vishvendu.com.rsvp.Utils.FragmentManagerClass;

public class OnBoardingMainActivity extends BaseActivity {

    FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    RegisterMobileNo registerMobileNo ;
    private PersonalDetailsFragment personalDetailsFragment;
    private FlightBookingDetails flightBookingDetails;
    private DocumentSubmit documentSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_on_boarding_main);
        setToolBar(true,"Registration",this,Back.SET_BACK);
        initClass();
    }

    @Override
    public void initClass() {

    frameLayout = (FrameLayout)findViewById(R.id.onboarding_container);
    fragmentManager = getSupportFragmentManager();
    intiOnBoardingFragment();
    }

    private void intiOnBoardingFragment() {
        registerMobileNo = new RegisterMobileNo();
        FragmentManagerClass.inflateFragment(registerMobileNo,fragmentManager,R.id.onboarding_container,null);
    }

    public void initPersonalDetailInflate(){
        setToolBar(true, "Personal Details", OnBoardingMainActivity.this, Back.SET_BACK);
        personalDetailsFragment = new PersonalDetailsFragment();
        Log.i("personal Details ", String.valueOf(personalDetailsFragment));
        Log.i("fragmentManager ", String.valueOf(fragmentManager));
        Log.i("container", String.valueOf(R.id.onboarding_container));
        FragmentManagerClass.inflateFragment(personalDetailsFragment,fragmentManager,R.id.onboarding_container,null);
    }

    public void initFlightBookingDetails(){

        setToolBar(true, "Flight Details", OnBoardingMainActivity.this, Back.SET_BACK);
        flightBookingDetails = new FlightBookingDetails();
        Log.i("personal Details ", String.valueOf(personalDetailsFragment));
        Log.i("fragmentManager ", String.valueOf(fragmentManager));
        Log.i("container", String.valueOf(R.id.onboarding_container));
        FragmentManagerClass.inflateFragment(flightBookingDetails,fragmentManager,R.id.onboarding_container,null);


    }

    public void initDocumentDetails(){

        setToolBar(true, "Documents", OnBoardingMainActivity.this, Back.SET_BACK);
        documentSubmit = new DocumentSubmit();
        Log.i("documentSubmit ", String.valueOf(documentSubmit));
        Log.i("fragmentManager ", String.valueOf(fragmentManager));
        Log.i("container", String.valueOf(R.id.onboarding_container));
        FragmentManagerClass.inflateFragment(documentSubmit,fragmentManager,R.id.onboarding_container,null);
    }

    @Override
    public void initCallback() {

    }
}
