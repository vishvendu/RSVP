package rsvp.vishvendu.com.rsvp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView MobileNoText = (TextView) findViewById(R.id.mobilenotext);
        TextView TextDetails = (TextView) findViewById(R.id.mobilenodescription);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/sc_sans_app_thin.ttf");
        MobileNoText.setTypeface(face);
        TextDetails.setTypeface(face);
    }
}
