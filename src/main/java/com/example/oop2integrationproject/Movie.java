package com.example.oop2integrationproject;

public class Movie {
    private String aName;
    private int aMovieID;
    private String aGenre;

    public Movie(String pName, int pMovieID, String pGenre) {
        aMovieID = pMovieID;
        aName = pName;
        aGenre = pGenre;
    }

    public String getMovieName() {
        return aName;
    }

    public String getGenre() {
        return aGenre;
    }

    public int getIdMovie() {
        return aMovieID;
    }

    @Override
    public String toString() {
        // Use StringBuilder for efficient string concatenation
        return getMovieName() + " " + getGenre();
    }
}
