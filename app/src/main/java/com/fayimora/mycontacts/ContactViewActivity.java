package com.fayimora.mycontacts;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContactViewActivity extends AppCompatActivity {
    public static String EXTRA = "CVA_Contact";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        int width = point.x;
        int height = point.y;

        ImageView contactImage = (ImageView) findViewById(R.id.contact_view_image);
        contactImage.setLayoutParams(new RelativeLayout.LayoutParams(width, (int)(width * (9.0/16.0))));

        Contact c = (Contact) getIntent().getSerializableExtra(EXTRA);
        TextView tv = (TextView) findViewById(R.id.contact_view_name);
        tv.setText(c.getName());

    }

}
