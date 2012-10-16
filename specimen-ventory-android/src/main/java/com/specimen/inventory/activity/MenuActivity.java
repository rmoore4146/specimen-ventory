package com.specimen.inventory.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.specimen.inventory.R;

public class MenuActivity extends Activity {

    private class NewSurgeryButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            handleNewSurgeryButtonClick();
        }
    }

    private class ShowInventoryButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            handleShowInventoryButtonClick();
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);

        final Button newSurgeryButton = (Button) findViewById(R.id.new_surgery_button);

        final Button showInventoryButton = (Button) findViewById(R.id.show_inventory_button);

        newSurgeryButton.setOnClickListener(new NewSurgeryButtonHandler());
        showInventoryButton.setOnClickListener(new ShowInventoryButtonHandler());
    }

    public void handleNewSurgeryButtonClick() {
        startActivity(new Intent(this, SurgerySelectActivity.class));
        finish();
    }

    public void handleShowInventoryButtonClick() {
        startActivity(new Intent(this, SurgerySelectActivity.class));
        finish();
    }
}
