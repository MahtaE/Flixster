package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {     //encapsulate the idea of movie with these data
    String backdropPath;
    String posterPath;        // we want to get data out of these objects so generate all three getter with right click and generate.
    String title;
    String overview;
      // however calls this method is responsible for handling the exception
    public Movie(JSONObject jsonObject) throws JSONException { // constructor takes in JSON object construct movie object(take object and read the fields that we care (posterpath
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }
    //this method is responsible for iterating through the JSONArray and constructing a movie for each element in the JSON array
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }
    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }
    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
