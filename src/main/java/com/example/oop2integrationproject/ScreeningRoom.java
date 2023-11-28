package com.example.oop2integrationproject;

public class ScreeningRoom extends Movie {
    private int aRoom;

    public ScreeningRoom(String pName, int pMovieID, String pGenre) {
        super(pName, pMovieID, pGenre);
        this.aRoom = aRoom;
    }

    public int getRoom() {
        return aRoom;
    }

    // Add a setter method if you want to change the room after object creation
    public void setRoom(int aRoom) {
        this.aRoom = aRoom;
    }
}
