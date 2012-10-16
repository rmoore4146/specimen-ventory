package com.specimen.inventory.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.specimen.inventory.R;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class HeadSurgeryFormActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set view to head surgery screen
        setContentView(R.layout.head_surgery_form);

        //bind list of surgeons to autocomplete field
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.generalSurgeonName);
        String[] surgeons = getResources().getStringArray(R.array.surgeon_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, surgeons);
        textView.setAdapter(adapter);

        Log.i("INFO", this.getClass().toString());
    }

}

