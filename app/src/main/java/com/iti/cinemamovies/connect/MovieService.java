package com.iti.cinemamovies.connect;

import retrofit2.Call;
import retrofit2.http.GET;


public interface  MovieService {
    @GET("top_rated?api_key=3c3d662f3dfecdd191da7642c1b1e2af")
    Call<MoviesModel> getMovieModel();

//    @GET("most_popular?api_key=3c3d662f3dfecdd191da7642c1b1e2af")
//    Call<String> get();
}
