package com.example.luizmangerotte.workout.entities.enums;

public enum TypeMicrocycle {

    RESTORATIVE(1),
    ACTIVATION(2),
    INTRODUCTORY(3),
    STANDARD(4),
    CONTROL(5),
    SHOCK(6);

    private int code;

    TypeMicrocycle(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TypeMicrocycle valueOf(int code) {
        for (TypeMicrocycle value : TypeMicrocycle.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code");
    }
}
