package com.moringaschool.bookworld.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.moringaschool.bookworld.R;
import com.moringaschool.bookworld.adapter.BookPagerAdapter;
import com.moringaschool.bookworld.models.Item;
import com.moringaschool.bookworld.models.VolumeInfo;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BookDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private BookPagerAdapter adapterViewPager;
    List<Item> mBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);

        mBooks = Parcels.unwrap(getIntent().getParcelableExtra("books"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new BookPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mBooks);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
