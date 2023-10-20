package com.performance.tune.sample.pojo;

import com.performance.tune.sample.Sample;

import java.time.Year;
import java.util.Comparator;

public record CD(String artistName, String title, int noOfTracks, Year year, Genre genre) implements Comparable<CD>{

    public boolean isPop(){
        return this.genre == Genre.POP;
    }
    public boolean isJazz(){
        return this.genre == Genre.JAZZ;
    }
    public boolean isOther(){
        return this.genre == Genre.OTHER;
    }

    @Override
    public int compareTo(CD other) {
        return Comparator.comparing(CD::artistName)
                .thenComparing(CD::title)
                .thenComparing(CD::noOfTracks)
                .thenComparing(CD::year)
                .thenComparing(CD::genre)
                .compare(this,other);
    }
}