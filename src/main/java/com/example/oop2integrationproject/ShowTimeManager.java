package com.example.oop2integrationproject;

import java.util.ArrayList;
import java.util.List;

public class ShowTimeManager {
    private List<Showtime> showtimes;

    public ShowTimeManager() {
        this.showtimes = new ArrayList<>();
    }

    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
    }

    public void displayShowtimes() {
        for (Showtime showtime : showtimes) {
            System.out.println(showtime);
        }
    }

    public void deleteShowtime(Showtime showtime) {
        showtimes.remove(showtime);
    }
}
