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
import com.moringaschool.netracker.adapters.MySocialAppsArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialAppsActivity extends AppCompatActivity {
    @BindView(R.id.categoryTextView)
    TextView mCategoryTextView;
    @BindView(R.id.listView)
    ListView mListView;

    private String[] socialApps = new String[] {"Instagram", "Whatsapp", "Twitter", "Telegram",
            "Tiktok" };

    private String[] services = new String[] {"Communication App", "Communication App", "Communication App", "Communication App", "Communication App",
          };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialapps);
        ButterKnife.bind(this);


        mListView = (ListView) findViewById(R.id.listView);
        mCategoryTextView = (TextView) findViewById(R.id.categoryTextView);

        MySocialAppsArrayAdapter adapter = new MySocialAppsArrayAdapter(this, android.R.layout.simple_list_item_1, socialApps, services); // the arguments must match constructor's parameters!
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String socialApp = ((TextView)view).getText().toString();
                Log.v("SocialAppsActivity", "In the onItemClickListener!");
                Toast.makeText(SocialAppsActivity.this, socialApp, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        mCategoryTextView.setText("Here are all the apps under: " + category);
        Log.d("SocialAppsActivity", "In the onCreate method!");


    }


}
