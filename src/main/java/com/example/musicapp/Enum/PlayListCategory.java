package com.example.musicapp.Enum;

public enum PlayListCategory {

    Focus("Focus"),
    Chill("Chill"),
    Classical("Clasicall"),
    Happiness("Happiness"),
    Mood("Mood"),
    Workout("Workout");

    private String displayName;

    PlayListCategory(String displayName){
        this.displayName=displayName;
    }

    @Override
    public String toString(){
        return this.displayName;
    }
}
