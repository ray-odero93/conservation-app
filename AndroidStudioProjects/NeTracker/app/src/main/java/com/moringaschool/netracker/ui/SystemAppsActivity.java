package com.moringaschool.netracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.netracker.R;
import com.moringaschool.netracker.adapters.MySystemAppsArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SystemAppsActivity extends AppCompatActivity {

        @BindView(R.id.locationTextView) TextView mLocationTextView;
        @BindView(R.id.listView) ListView mListView;

        private String[] systemApps = new String[]  {"Instagram", "Whatsapp", "Twitter", "Telegram",
                "Tiktok" };

        private String[] systemServices= new String[]{"Communication App", "Communication App", "Communication App", "Communication App", "Communication App",
        };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systemapps);
        ButterKnife.bind(this);


        mListView = (ListView) findViewById(R.id.listView);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);

        MySystemAppsArrayAdapter adapter = new MySystemAppsArrayAdapter(this, android.R.layout.simple_list_item_1, systemApps, systemServices); // the arguments must match constructor's parameters!
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String systemApp = ((TextView)view).getText().toString();
                Log.v("SystemAppsActivity", "In the onItemClickListener!");
                Toast.makeText(SystemAppsActivity.this, systemApp, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String systemApp = intent.getStringExtra("systemApp");
       mLocationTextView.setText("Here are all the apps under: " + systemApp);
      Log.d("SystemAppsActivity", "In the onCreate method!");


    }
}