package com.example.luizmangerotte.workout.model.enums;

public enum Periodization {

    LINEAR(1),
    REVERSE_LINEAR(2),
    UNDULATING(3);

    private int code;

    Periodization(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Periodization valueOf(int code) {
        for (Periodization value : Periodization.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code");
    }
}
