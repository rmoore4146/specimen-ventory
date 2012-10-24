package com.specimen.inventory.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.http.AndroidHttpClient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.gson.Gson;
import com.specimen.inventory.R;
import com.specimen.inventory.exception.ActivityRuntimeException;
import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.AnesthesiaType;
import com.specimen.inventory.model.HeadSurgeryForm;
import com.specimen.inventory.model.SurgeryForm;
import com.specimen.inventory.model.SurgeryType;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class SurgeryFormActivity extends Activity {

    Button datePickerButton;
    AndroidHttpClient httpClient;

    private static final String SURGERY_POST_URL = "http://192.168.0.108:8080/test/specimen-ventory/rest/surgery/head/";
    static final int DATEINIT_DIALOG = 0;

    SimpleDateFormat sdf = new SimpleDateFormat("m/d/yyyy");
//    SurgeryService specimenService = new SurgeryServiceImpl();

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

        SurgeryForm createdSurgery;
        try {
            SurgeryForm form = getSurgeryValuesFromScreen();
//            createdSurgery = specimenService.createSurgery(form);

            Gson g = new Gson();
            String message = g.toJson(form);
            this.httpClient = AndroidHttpClient.newInstance("");
            HttpContext localContext = new BasicHttpContext();
            NetworkComm task = new NetworkComm(httpClient, localContext, new SubmitListener(), 0, message, SURGERY_POST_URL, "");
            task.start();

        } catch (ParseException pe) {
            throw new ActivityRuntimeException("Exception caught in createSurgeryEntry() call", pe);
        }
        Log.i("specimenService.createSurgeryEntry(...)", "blah made it here");
    }

    public void handleDateSet(int year, int month, int day) {
        String dateText = month + "/" + day + "/" + year;
        datePickerButton.setText(dateText);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                handleDateSet(year, monthOfYear, dayOfMonth);
            }
        };

        Calendar date = Calendar.getInstance();
        switch (id) {
            case DATEINIT_DIALOG:
                return new DatePickerDialog(this, dateSetListener, date.get(Calendar.YEAR),date.get(Calendar.MONTH),
                        date.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }
    public void handleCancelButtonClick() {
        startActivity(new Intent(this, SurgerySelectActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get surgery type from saved bundle
        String surgeryType = null;
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            surgeryType = extras.getString("surgeryType");
        }

        if(surgeryType!=null && surgeryType.equals(SurgeryType.HEAD_SURGERY.value())) {
            //set view to Head surgery
            setContentView(R.layout.head_surgery_form);
        } else if(surgeryType!=null && surgeryType.equals(SurgeryType.IV_SURGERY.value())) {
            //set view to IV surgery
            setContentView(R.layout.iv_surgery_form);
        } else {
            throw new ActivityRuntimeException("Bundle was bad");
        }

        //bind list of surgeons to autocomplete field
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.generalSurgeonName);
        String[] surgeons = getResources().getStringArray(R.array.surgeon_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, surgeons);
        textView.setAdapter(adapter);

        //bind listeners to buttons
        final Button submitButton = (Button) findViewById(R.id.submitButton);
        final Button cancelButton = (Button) findViewById(R.id.cancelButton);
        submitButton.setOnClickListener(new SubmitButtonHandler());
        cancelButton.setOnClickListener(new CancelButtonHandler());

        datePickerButton = (Button) findViewById(R.id.generalDateButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATEINIT_DIALOG);

            }

        });

        Log.e("INFO", this.getClass().toString());
    }

    private SurgeryForm getSurgeryValuesFromScreen() throws ParseException {
        EditText animalIdView = (EditText) findViewById(R.id.generalAnimalId);
        EditText startTimeView = (EditText) findViewById(R.id.generalStartTime);
        EditText endTimeView = (EditText) findViewById(R.id.generalEndTime);
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
        String dateString = datePickerButton.getText().toString();
        if(StringUtils.isNotEmpty(dateString) && !dateString.equals("Choose Date")) {
            form.setSurgeryDate(sdf.parse(dateString));
        }
        form.setTimeEnd(endTimeView.getText().toString());
        form.setTimeStart(startTimeView.getText().toString());
        form.setFreeText(freeTextView.getText().toString());

        return form;
    }

    public class SubmitListener implements NetworkComm.TaskResponseListener{
        public void onTaskResponse(int type, String response, Object extra) {
            doResponseMethod(response);
            Log.e("blah", "here");
        }
    }

    private void doResponseMethod(String response){
        this.httpClient.close();
    }
}

