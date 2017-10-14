package com.example;

public class Joke {
    public String content;

    public Joke() {
        this.content = "Q: What did the DNA say to the other DNA?\n" +
                "A: Do these genes make my butt look fat.";
    }

    public Joke(String content) {
        this.content = content;
    }
}
