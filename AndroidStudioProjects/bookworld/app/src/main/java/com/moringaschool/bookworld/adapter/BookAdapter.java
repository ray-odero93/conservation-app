package com.moringaschool.bookworld.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;


import com.moringaschool.bookworld.R;
import com.moringaschool.bookworld.models.Book;

import java.text.DecimalFormat;
import java.util.List;


public class BookAdapter extends ArrayAdapter<Book> {


    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        // Find the book at the given position in the list of books
        Book currentBook = getItem(position);

        // Find the TextView with view ID rating
        TextView ratingView = (TextView) listItemView.findViewById(R.id.rating);
        // Format the rating to show 1 decimal place
        String formattedRating = formatRating(currentBook.getRating());
        // Display the rating of the current book in that TextView
        ratingView.setText(formattedRating);

        // Set the proper background color on the rating circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable ratingCircle = (GradientDrawable) ratingView.getBackground();
        // Get the appropriate background color based on the current book rating
        int ratingColor = getRatingColor(currentBook.getRating());
        // Set the color on the rating circle
        ratingCircle.setColor(ratingColor);

        // Get the title string from the Book object
        String title = currentBook.getTitle();
        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        // Display the title of the current book in that TextView
        titleView.setText(title);

        // Get the subtitle string from the Book object
        String subtitle = currentBook.getSubtitle();
        // Find the TextView with view ID subtitle
        TextView subtitleView = (TextView) listItemView.findViewById(R.id.subtitle);
        // Display the subtitle of the current book in that TextView
        subtitleView.setText(subtitle);

        // Get the author string from the Book object
        String author = currentBook.getAuthor();
        // Find the TextView with view ID authors
        TextView authorView = (TextView) listItemView.findViewById(R.id.authors);
        // Display the authors of the current book in that TextView
        authorView.setText(author);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    private int getRatingColor(double rating) {
        int ratingColorResourceId;
        int ratingFloor = (int) Math.floor(rating);
        switch (ratingFloor) {
            case 0:
            case 1:
                ratingColorResourceId = R.color.rating1;
                break;
            case 2:
                ratingColorResourceId = R.color.rating2;
                break;
            case 3:
                ratingColorResourceId = R.color.rating3;
                break;
            case 4:
                ratingColorResourceId = R.color.rating4;
                break;
            default:
                ratingColorResourceId = R.color.rating5;
                break;
        }

        return ContextCompat.getColor(getContext(), ratingColorResourceId);
    }

    private String formatRating(double rating) {
        DecimalFormat ratingFormat = new DecimalFormat("0.0");
        return ratingFormat.format(rating);
    }

}