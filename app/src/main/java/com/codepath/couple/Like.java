package com.codepath.couple;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Like")

public class Like extends ParseObject {


    public static final String KEY_POSTER = "Poster";
    public static final String KEY_LIKER = "Liker";




//    public ParseUser getPoster() {
//        return getParseUser(KEY_POSTER);
//    }

    public void setPoster(ParseUser Poster) {
        put(KEY_POSTER, Poster);
    }

//    public ParseUser getLiker() {
//        return getParseUser(KEY_LIKER);
//    }

    public void setLiker(ParseUser Liker) {
        put(KEY_LIKER, Liker);
    }
}
