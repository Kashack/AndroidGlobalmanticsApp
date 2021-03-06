package com.example.androidglobalmanticsapp.services;

import com.example.androidglobalmanticsapp.models.Idea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IdeaService {
    @GET("ideas")
    Call<List<Idea>> getIdeas(@Query("owner") String owner);

    @GET("ideas/{id}")
    Call<Idea> getIdea(@Path("id") int id);
}
