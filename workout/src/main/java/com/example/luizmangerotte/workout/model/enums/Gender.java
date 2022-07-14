package com.example.luizmangerotte.workout.model.enums;

public enum Gender {

    MALE(1),
    FEMALE(2),
    OTHER(3);

    private int code;

    Gender(int code) {
        this.code = code;
    }
}
