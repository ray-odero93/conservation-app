package com.moringaschool.bookworld.network;


import com.moringaschool.bookworld.models.GoogleBookSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApi {
    @GET("item/search")
    Call<GoogleBookSearchResponse> getBooks(
            @Query("searchInfo") String searchInfo,
            @Query("term") String term
    );
}
