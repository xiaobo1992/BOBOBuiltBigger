package com.example.xiaobozhang.myapplication.backend;

import com.example.Joke;

/**
 * Created by xiaobozhang on 10/13/17.
 */

public class MyJoke {
    Joke joke;

    public MyJoke() {
        joke = new Joke();
    }

    public String getMyJoke() {
        return joke.content;
    }
}
