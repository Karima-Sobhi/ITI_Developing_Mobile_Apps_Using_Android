package com.iti.cinemamovies.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.iti.cinemamovies.R;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {

    private TextView titleDetails,overviewDetails,releaseDate,voteAverageDetails;
    private ImageView imageViewDetails ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        titleDetails = findViewById(R.id.movieTitle);
        overviewDetails = findViewById(R.id.movieOverView);
        releaseDate = findViewById(R.id.movieRelease);
        voteAverageDetails = findViewById(R.id.movieVote);
        imageViewDetails = findViewById(R.id.imageView);

        GetDataFromIntent();
    }
    private void GetDataFromIntent() {
        if (getIntent().hasExtra("movie")) {
            Movie movieObject = (Movie) getIntent().getSerializableExtra("movie");

//            Toast.makeText(getApplicationContext(), "Successful in movie", Toast.LENGTH_LONG).show();
            assert movieObject != null;
            titleDetails.setText(movieObject.getTitle());
            overviewDetails.setText((movieObject.getOverview()));

            // Get the string resource for "Release Date: "
            String releaseLabel = getString(R.string.Release);
            releaseDate.setText(releaseLabel + movieObject.getRelease_date());

            float voteAverage = movieObject.getVote_average();
            String voteAverageString = String.valueOf(voteAverage);
            String voteLabel = getString(R.string.vote);
            voteAverageDetails.setText( voteLabel + voteAverageString);

            Glide.with(this)
                    .load("http://image.tmdb.org/t/p/w185" + movieObject.getPoster_path())
                    .into(imageViewDetails);
        }

    }

}