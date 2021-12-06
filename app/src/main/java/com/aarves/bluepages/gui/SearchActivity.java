package com.aarves.bluepages.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.Collections;

import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.controllers.LookupController;
import com.aarves.bluepages.adapter.MapboxGateway;
import com.aarves.bluepages.entities.Location;

import org.json.JSONObject;

import java.util.ArrayList;
public class SearchActivity extends AppCompatActivity {


    private Button foodButton, locationButton, allButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
//    private void unSelectAllFilterButtons()
//    {
//        lookUnSelected(allButton);
//        lookUnSelected(foodButton);
//        lookUnSelected(locationButton);
//    }
//    private void lookSelected(Button parsedButton)
//    {
//        parsedButton.setTextColor();
//        parsedButton.setBackgroundColor();
//    }
//
//    private void lookUnSelected(Button parsedButton)
//    {
//        parsedButton.setTextColor();
//        parsedButton.setBackgroundColor();
//    }
private void searchConfiguration() {
    EditText editText = this.findViewById(R.id.search);
    editText.setOnEditorActionListener((v, actionId, event) -> {
        boolean handled = false;
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            new Thread() {
                public void run() {
                    LookupController lc = new LookupController();
                    MapboxGateway mg = new MapboxGateway();
                    JSONObject json = lc.lookupLocation(editText.getText().toString(), getResources().getString(R.string.mapbox_access_token));
                    ArrayList<Location> locationArray = mg.parseInformation(json);

                    for (Location loc: locationArray) {
                        System.out.println(loc);
                    }
                }
            }.start();
            handled = true;
        }
        return handled;
    });
}
}
