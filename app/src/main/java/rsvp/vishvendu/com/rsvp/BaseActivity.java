package rsvp.vishvendu.com.rsvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import rsvp.vishvendu.com.rsvp.Utils.TypefaceUtil;


/**
 * Created by vishvendu.palawat on 15-11-2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FrameLayout baseMainLayout;
    private Activity mActivity;
    private Toolbar toolbar;
    private TextView mTitle;
    private View lineView;
    private ImageView toolBarBack;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        baseMainLayout=(FrameLayout)findViewById(R.id.baseMainLayout);

    }

    public void setBaseContentView(int id){
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(id, null);
        baseMainLayout.addView(view);
    }

    public enum Back{
        SET_BACK
    }


    public BaseActivity setToolBar(boolean isRequired, String title, final Activity activity,Back back){

        mActivity=activity;
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        mTitle= (TextView) findViewById(R.id.toolbarTitle);
        TypefaceUtil.setTypefaceOfView(this, mTitle, TypefaceUtil.TypeFace.Regular);

        toolBarBack = (ImageView)toolbar.findViewById(R.id.toolBarBack);
        toolbar.setVisibility(View.GONE);

        if(isRequired){

            if(back == Back.SET_BACK){

                toolBarBack.setVisibility(View.VISIBLE);
                toolbar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.onBackPressed();
                    }
                });
                toolbar.setNavigationIcon(null);
            }
            toolbar.setVisibility(View.VISIBLE);

            mTitle.setText(title);

        }

        return this;
    }

    public abstract void initClass();

    public abstract void initCallback();

}
