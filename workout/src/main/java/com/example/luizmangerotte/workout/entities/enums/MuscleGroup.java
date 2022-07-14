package com.example.luizmangerotte.workout.entities.enums;

public enum MuscleGroup {

    CHEST(1),
    BACK(2),
    SHOULDERS(3),
    BICEPS(4),
    TRICEPS(5),
    ABDOMINALS(6),
    QUADRICEPS(7),
    HAMSTRINGS(8),
    GLUTE_MAXIMUM(9),
    GLUTE_MEDIUS(10),
    CALF(11);

    private int code;

    MuscleGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static MuscleGroup valueOf(int code) {
        for (MuscleGroup value : MuscleGroup.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code");
    }
}

