package com.moringaschool.netracker.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MySocialAppsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mSocialApps;
    private String[] mServices;

    public MySocialAppsArrayAdapter(Context mContext, int resource, String[] mSocialApps, String[] mServices) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mSocialApps = mSocialApps;
        this.mServices = mServices;
    }

    @Override
    public Object getItem(int position) {
        String socialApp = mSocialApps[position];
        String service = mServices[position];
        return String.format("%s \nPurpose: %s", socialApp, service);
    }

    @Override
    public int getCount() {
        return mSocialApps.length;
    }
}
