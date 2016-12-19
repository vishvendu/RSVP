package rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import rsvp.vishvendu.com.rsvp.Onboarding.Module.Activity.OnBoardingMainActivity;
import rsvp.vishvendu.com.rsvp.R;

public class FlightBookingDetails extends Fragment implements View.OnClickListener {

TextView FlightBookingdetail;
    Button Proceed;
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
        Proceed.setOnClickListener(this);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/sc_sans_app_thin.ttf");
        FlightBookingdetail.setTypeface(face);
    }


    @Override
    public void onClick(View v) {

        OnBoardingMainActivity onBoardingMainActivity = (OnBoardingMainActivity)getActivity();
        onBoardingMainActivity.initDocumentDetails();
    }
}
