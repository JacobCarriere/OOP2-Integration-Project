package com.example.oop2integrationproject;

public class ScreeningRoom extends Movie{
    private int aRoom;

    public ScreeningRoom(String pName, int pMovieID, String pGenre) {
        super(pName, pMovieID, pGenre);
    }

    public int getRoom(){
        return aRoom;
    }
}
