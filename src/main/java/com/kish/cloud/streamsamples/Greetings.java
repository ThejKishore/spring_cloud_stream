package com.kish.cloud.streamsamples;


public class Greetings {

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private long timestamp;

    private String message;


    public Greetings() {
    }
}
