package rsvp.vishvendu.com.rsvp.Onboarding.Module.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rsvp.vishvendu.com.rsvp.R;


public class DocumentSubmit extends Fragment {

TextView DocumentDetialsPage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_document_submit, container, false);
        intiFragment(view);
        return view;
    }

    private void intiFragment(View view) {

        DocumentDetialsPage = (TextView)view.findViewById(R.id.documentdetailspage);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/sc_sans_app_thin.ttf");
        DocumentDetialsPage.setTypeface(face);
    }

}
