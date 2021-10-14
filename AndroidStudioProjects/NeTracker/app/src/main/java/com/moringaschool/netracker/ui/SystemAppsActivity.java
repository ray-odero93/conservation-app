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
//    private TextView mLocationTextView;
//    private ListView mListView;
//    private String[] restaurants = new String[] {"Mi Mero Mole", "Mother's Bistro",
//            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
//            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
//            "Lardo", "Portland City Grill", "Fat Head's Brewery",
//            "Chipotle", "Subway"};

        @BindView(R.id.locationTextView) TextView mLocationTextView;
        @BindView(R.id.listView) ListView mListView;

        private String[] restaurants = new String[]  {"Instagram", "Whatsapp", "Twitter", "Telegram",
                "Tiktok" };

        private String[] cuisines = new String[]{"Communication App", "Communication App", "Communication App", "Communication App", "Communication App",
        };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systemapps);
        ButterKnife.bind(this);


        mListView = (ListView) findViewById(R.id.listView);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);

        MySystemAppsArrayAdapter adapter = new MySystemAppsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines); // the arguments must match constructor's parameters!
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Log.v("RestaurantsActivity", "In the onItemClickListener!");
                Toast.makeText(SystemAppsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
       mLocationTextView.setText("Here are all the apps under: " + location);
      Log.d("RestaurantsActivity", "In the onCreate method!");


    }
}