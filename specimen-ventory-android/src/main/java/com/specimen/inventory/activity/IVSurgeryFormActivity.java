package com.specimen.inventory.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.specimen.inventory.R;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class IVSurgeryFormActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        Log.i("INFO", this.getClass().toString());
    }

}
