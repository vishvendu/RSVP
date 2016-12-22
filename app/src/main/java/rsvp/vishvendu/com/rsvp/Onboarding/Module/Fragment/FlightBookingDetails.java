package rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import rsvp.vishvendu.com.rsvp.Onboarding.Module.Activity.OnBoardingMainActivity;
import rsvp.vishvendu.com.rsvp.R;

public class FlightBookingDetails extends Fragment implements View.OnClickListener {

TextView FlightBookingdetail;
    Button Proceed;
    RelativeLayout myRelative;
    FlightBookingDetails flightBookingDetails;
    expanddateview expanddateview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flight_booking_details, container, false);
        intiFragment(view);
        return view;
    }

    private void intiFragment(View view) {

        FlightBookingdetail=(TextView)view.findViewById(R.id.bookingbehalf);
        Proceed=(Button)view.findViewById(R.id.flightproceed);
        myRelative = (RelativeLayout)view.findViewById(R.id.RRlayout);
        Proceed.setOnClickListener(this);
        myRelative.setOnClickListener(this);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/sc_sans_app_thin.ttf");
        FlightBookingdetail.setTypeface(face);
    }


    @Override
    public void onClick(View v) {

        Transition changeTransform = TransitionInflater.from(getActivity()).
                inflateTransition(R.transition.change_image_transform);
        Transition explodeTransform = TransitionInflater.from(getActivity()).
                inflateTransition(android.R.transition.explode);

        FlightBookingDetails flightBookingdetail =new FlightBookingDetails();

        // Setup exit transition on first fragment
        flightBookingdetail.setSharedElementReturnTransition(changeTransform);
        flightBookingdetail.setExitTransition(explodeTransform);

        expanddateview expanddateviewT = new expanddateview();
        // Setup enter transition on second fragment
        expanddateviewT.setSharedElementEnterTransition(changeTransform);
        expanddateviewT.setEnterTransition(explodeTransform);

        // Find the shared element (in Fragment A)
        RelativeLayout ivProfile = (RelativeLayout) v.findViewById(R.id.RRlayout);

        // Add second fragment by replacing first
        FragmentTransaction ft = getFragmentManager().beginTransaction()
                .replace(R.id.onboarding_container, expanddateviewT)
                .addToBackStack("transaction")
                .addSharedElement(ivProfile, "profile");
        // Apply the transaction
        ft.commit();

        /*OnBoardingMainActivity onBoardingMainActivity = (OnBoardingMainActivity)getActivity();
        onBoardingMainActivity.initDocumentDetails();*/
    }
}
