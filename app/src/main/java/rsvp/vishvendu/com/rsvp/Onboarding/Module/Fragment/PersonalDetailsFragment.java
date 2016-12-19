package rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import rsvp.vishvendu.com.rsvp.Onboarding.Module.Activity.OnBoardingMainActivity;
import rsvp.vishvendu.com.rsvp.R;


public class PersonalDetailsFragment extends Fragment implements View.OnClickListener {

    FragmentManager fragmentManager;
    Button AddMorebutton,Next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_personal_details, container, false);
        initFragment(view);
        return view;
    }

    private void initFragment(View view) {

        Next= (Button) view.findViewById(R.id.proceed);
        Next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        OnBoardingMainActivity onBoardingMainActivity = (OnBoardingMainActivity)getActivity();
        onBoardingMainActivity.initFlightBookingDetails();
    }
}
