package com.moringaschool.bookworld.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.bookworld.models.Item;
import com.moringaschool.bookworld.models.VolumeInfo;
import com.moringaschool.bookworld.ui.BookDetailFragment;

import java.util.List;

public class BookPagerAdapter extends FragmentPagerAdapter {
    private List<Item> mBooks;

    public BookPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Item> books) {
        super(fm, behavior);
        mBooks = books;
    }

//    public RestaurantDetailFragment getItem(int position) {
//        return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
//    }
    @Override
    public Fragment getItem(int position) {
        return BookDetailFragment.newInstance(mBooks.get(position));
    }

    @Override
    public int getCount() {
        return mBooks.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBooks.get(position).getKind();
    }
}
