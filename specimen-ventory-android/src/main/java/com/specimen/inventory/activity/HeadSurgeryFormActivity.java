package com.specimen.inventory.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.specimen.inventory.R;
import com.specimen.inventory.exception.ActivityRuntimeException;
import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.AnesthesiaType;
import com.specimen.inventory.model.HeadSurgeryForm;
import com.specimen.inventory.service.exception.SpecimenServiceException;
import com.specimen.inventory.service.impl.SurgeryServiceImpl;
import com.specimen.inventory.service.producer.SurgeryService;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class HeadSurgeryFormActivity extends Activity {

    SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yy");
    SurgeryService specimenService = new SurgeryServiceImpl();

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

        Boolean response;
        try {
            getSurgeryValuesFromScreen();
            response = specimenService.createSurgeryEntry();
        } catch (SpecimenServiceException sse) {
            throw new ActivityRuntimeException("Exception caught in createSurgeryEntry() call", sse);
        } catch (ParseException pe) {
            throw new ActivityRuntimeException("Exception caught in createSurgeryEntry() call", pe);
        }
        Log.i("specimenService.createSurgeryEntry(...)", response.toString());
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

    private HeadSurgeryForm getSurgeryValuesFromScreen() throws ParseException {
        EditText dateView = (EditText) findViewById(R.id.generalDate);
        EditText startTimeView = (EditText) findViewById(R.id.generalStartTime);
        EditText endTimeView = (EditText) findViewById(R.id.generalEndTime);
        EditText animalIdView = (EditText) findViewById(R.id.generalAnimalId);
        EditText surgeonView = (EditText) findViewById(R.id.generalSurgeonName);
        EditText procedureView = (EditText) findViewById(R.id.generalProcedureId);
        RadioGroup anesthesiaRadioGroup = (RadioGroup) findViewById(R.id.anesthesiaTypeRadioGroup);
        int selectedAnesthesiaType = anesthesiaRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedAnesthesiaRadioButton = (RadioButton) findViewById(selectedAnesthesiaType);
        RadioGroup analgesiaRadioGroup = (RadioGroup) findViewById(R.id.analgesiaTypeRadioGroup);
        int selectedAnalgesiaType = analgesiaRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedAnalgesiaRadioButton = (RadioButton) findViewById(selectedAnalgesiaType);
        EditText anesthesiaDosageView = (EditText) findViewById(R.id.generalAnesthesiaDosage);
        EditText analgesiaDosageView = (EditText) findViewById(R.id.generalAnalgesiaDosage);
        EditText freeTextView = (EditText) findViewById(R.id.generalNotes);

        HeadSurgeryForm form = new HeadSurgeryForm();
        form.setAnalgesiaDose(analgesiaDosageView.getText().toString());
        form.setAnalgesiaType(AnalgesiaType.fromValue(selectedAnalgesiaRadioButton.getText().toString()));
        form.setAnesthesiaDosage(anesthesiaDosageView.getText().toString());
        form.setAnesthesiaType(AnesthesiaType.fromValue(selectedAnesthesiaRadioButton.getText().toString()));
        form.setAnimalUUID(animalIdView.getText().toString());
        form.setProcedureName(procedureView.getText().toString());
        form.setSurgeon(surgeonView.getText().toString());
        String dateString = dateView.getText().toString();
        if(dateString != null) {
            form.setSurgeryDate(sdf.parse(dateString));
        }
        form.setTimeEnd(endTimeView.getText().toString());
        form.setTimeStart(startTimeView.getText().toString());
        form.setFreeText(freeTextView.getText().toString());

        return form;
    }
}

