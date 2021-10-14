package com.moringaschool.netracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.netracker.AppUsageStatisticsFragment;
import com.moringaschool.netracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener  {

    @BindView(R.id.findAppsButton) Button mFindAppsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.categoryEditText) EditText mCategoryEditText;
    @BindView(R.id.findSystemAppsButton) Button mFindSystemAppsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, AppUsageStatisticsFragment.newInstance())
                    .commit();
        }
        ButterKnife.bind(this);
        mFindSystemAppsButton.setOnClickListener(this);
        mFindSystemAppsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Submitted", Toast.LENGTH_LONG).show();
            }
        });
        mFindAppsButton.setOnClickListener(this);

    }
        @Override
        public void onClick(View v){

            if (v == mFindSystemAppsButton) {
                String applocation = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SystemAppsActivity.class);
                intent.putExtra("applocation", applocation);
                startActivity(intent);
            }
            if (v == mFindAppsButton) {
                String category = mCategoryEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SocialAppsActivity.class);
                intent.putExtra("category", category);
                startActivity(intent);
            }

    }


}