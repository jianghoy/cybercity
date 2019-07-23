package com.jianghoy.cybercity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView eventListView = (ListView) findViewById(R.id.event_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.event_item,
                R.id.event_name,
                getEventNames()
        );

        eventListView.setAdapter(adapter);
    }

    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"
        };
        return names;
    }
}
