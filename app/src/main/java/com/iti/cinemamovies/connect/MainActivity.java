package com.iti.cinemamovies.connect;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iti.cinemamovies.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.widget.RelativeLayout;
public class MainActivity extends AppCompatActivity implements AdvancedRecycleAdapter.OnItemClickListener {

    RecyclerView recyclerView;
    AdvancedRecycleAdapter advancedRecycleAdapter;
    private RelativeLayout rootView;
    private boolean isImageVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        ArrayList<Movie> movies = new ArrayList<>();

        advancedRecycleAdapter = new AdvancedRecycleAdapter(movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(advancedRecycleAdapter);
        ///////////////////
        advancedRecycleAdapter.setOnItemClickListener(this);
        ///////////////////
        rootView = findViewById(R.id.activity);
    }

    public void updateData(ArrayList<Movie> models) {
        //advancedAdapter.setData(models);
        advancedRecycleAdapter.setData(models);
    }

    public void click(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService service = retrofit.create(MovieService.class);
        Call<MoviesModel> call = service.getMovieModel();
        call.enqueue(new Callback<MoviesModel>() {
            @Override
            public void onResponse(Call<MoviesModel> call, Response<MoviesModel> response) {
                if (response.isSuccessful()) {
                    MoviesModel moviesModel = response.body();
                    updateData(moviesModel.getMovies());

                    // make the button invisible after connection is set
                    Button button = findViewById(R.id.button);
                    button.setVisibility(View.GONE); // Hide the button

                    if (isImageVisible) {
                        rootView.setBackgroundResource(android.R.color.transparent);
                    } else {
                        rootView.setBackgroundColor(getResources().getColor(R.color.backgroundColor)); // Set your desired color
                    }
                    isImageVisible = !isImageVisible;

                }
            }

            @Override
            public void onFailure(Call<MoviesModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemClick(Movie movie) {
        Intent intent = new Intent(this, MovieDetails.class);
        intent.putExtra("movie",movie);
        startActivity(intent);
    }
}