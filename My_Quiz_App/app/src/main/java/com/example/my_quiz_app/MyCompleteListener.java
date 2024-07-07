package com.example.my_quiz_app;

public interface MyCompleteListener {
    void onSuccess();

    default void onFailure() {

    }
}
