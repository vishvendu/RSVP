package rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rsvp.vishvendu.com.rsvp.R;


public class PersonalDetailsFragment extends Fragment {

    FragmentManager fragmentManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_personal_details, container, false);
        return view;
    }

}
