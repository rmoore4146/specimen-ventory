package com.specimen.inventory.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import com.specimen.inventory.R;
import com.specimen.inventory.service.api.SpecimenService;
import com.specimen.inventory.service.impl.SurgeryServiceImpl;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class HeadSurgeryFormActivity extends Activity {

    SpecimenService specimenService = new SurgeryServiceImpl();


    private class SubmitButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            handleSubmitButtonClick();
        }
    }

    private class CancelButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            handleCancelButtonClick();
        }
    }

    public void handleSubmitButtonClick() {
        //TODO this is where service call will happen
        finish();
    }

    public void handleCancelButtonClick() {
        startActivity(new Intent(this, SurgerySelectActivity.class));
        finish();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set view to head surgery screen
        setContentView(R.layout.head_surgery_form);

        //bind list of surgeons to autocomplete field
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.generalSurgeonName);
        String[] surgeons = getResources().getStringArray(R.array.surgeon_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, surgeons);
        textView.setAdapter(adapter);

        //bind listeners to buttons
        final Button submitButton = (Button) findViewById(R.id.cancelButton);
        final Button cancelButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new SubmitButtonHandler());
        cancelButton.setOnClickListener(new CancelButtonHandler());

        Log.i("INFO", this.getClass().toString());
    }

}

