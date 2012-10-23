package com.specimen.inventory.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.specimen.inventory.R;
import com.specimen.inventory.model.SurgeryType;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class SurgerySelectActivity extends Activity {

    private class CancelButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            handleCancelButtonClick();
        }
    }

    private class NextButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            handleNextButtonClick();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.surgery_select);

        final Button nextButton = (Button) findViewById(R.id.nextButtonDisplay);
        final Button cancelButton = (Button) findViewById(R.id.cancelButton);

        nextButton.setOnClickListener(new NextButtonHandler());
        cancelButton.setOnClickListener(new CancelButtonHandler());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.startActivity(new Intent(this, MenuActivity.class));
        finish();
    }

    public void handleNextButtonClick() {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioSurgerySelect);
        int selected = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedButton = (RadioButton) findViewById(selected);
        String selectedSurgery = (String)selectedButton.getText();

        if (selectedSurgery.equalsIgnoreCase(getString(R.string.radio_head_surgery))) {
            Intent i = new Intent(this, SurgeryFormActivity.class);
            i.putExtra("surgeryType", SurgeryType.HEAD_SURGERY.value());
            startActivity(i);
            finish();
        } else if (selectedSurgery.equalsIgnoreCase(getString(R.string.radio_iv_surgery))) {
            Intent i = new Intent(this, SurgeryFormActivity.class);
            i.putExtra("surgeryType", SurgeryType.IV_SURGERY.value());
            startActivity(i);
            finish();
        } else {
            throw new ActivityNotFoundException("No activity fot this case.");
        }
    }

    public void handleCancelButtonClick() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}
