package com.example.oop2integrationproject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class extends from ScreeningRoom class to be able to show the showtime with the date and time.
 */
public class Showtime extends ScreeningRoom {
    private LocalDate date;
    private LocalTime time;

    public Showtime(String name, int movieID, String genre, LocalDate date, LocalTime time) {
        super(name, movieID, genre);
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return super.toString() + " Date: " + date + " Time: " + time;
    }
}
