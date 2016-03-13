package com.fayimora.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactEditActivity extends AppCompatActivity {
    public static String EXTRA = "CEA_Contact";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);
        Contact contact = (Contact) getIntent().getSerializableExtra(EXTRA);

        EditText editName = (EditText) findViewById(R.id.contact_edit_name);
        editName.setText(contact.getName());

        addToSection(R.id.phone_number_section, contact.phoneNumbers);
        addToSection(R.id.email_section, contact.emails);

        TextView addNewPhoneNumber = (TextView)findViewById(R.id.add_new_phone_number);
        addNewPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSection(R.id.phone_number_section, "");
            }
        });

        TextView addEmail = (TextView)findViewById(R.id.add_new_email);
        addEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSection(R.id.email_section, "");
            }
        });
    }

    private void addToSection(int sectionID, String value){
        LinearLayout section = (LinearLayout)findViewById(sectionID);
        EditText et = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(lp);
        et.setText(value);
        section.addView(et);
    }

    private void addToSection(int sectionID, ArrayList<String> values) {
        LinearLayout section = (LinearLayout)findViewById(sectionID);
        for (int i = 0; i < values.size(); i++) {
            EditText et = new EditText(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            et.setLayoutParams(lp);
            et.setText(values.get(i));
            section.addView(et);
        }
    }
}