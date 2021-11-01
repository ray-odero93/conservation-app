package com.moringaschool.bookworld.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.moringaschool.bookworld.R;
import com.moringaschool.bookworld.models.Book;
import com.moringaschool.bookworld.models.Item;
import com.moringaschool.bookworld.models.VolumeInfo;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.titleTextView) TextView mTitle;
//    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.saveBookButton) TextView mSaveBookButton;


    private VolumeInfo mBook;

    public BookDetailFragment() {
        // Required empty public constructor
    }


    public static BookDetailFragment newInstance(Item book) {
        BookDetailFragment bookDetailFragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("book", Parcels.wrap(book));
        bookDetailFragment.setArguments(args);
        return bookDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mBook = Parcels.unwrap(getArguments().getParcelable("book"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_book_detail, container, false);
        ButterKnife.bind(this, view);
//        Picasso.get().load(mBook.getImageLink()).into(mImageLabel);

//        List<String> volumeInfos = new ArrayList<>();
//
//       for (VolumeInfo volumeInfo: mBook.getVolumeInfo() ){
//            volumeInfo.add(volumeInfo.getTitle());
//       }
        mSaveBookButton.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        if (v == mTitle) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mBook.getDescription()));
            startActivity(webIntent);
        }

    }

        }

