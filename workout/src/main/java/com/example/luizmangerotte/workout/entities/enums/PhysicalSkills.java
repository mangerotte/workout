package com.example.luizmangerotte.workout.entities.enums;

public enum PhysicalSkills {

    MAXIMUM_STRENGTH(1),
    ENDURANCE_STRENGTH(2),
    POWER(3),
    SPEED(4),
    AGILITY(5),
    CARDIOVASCULAR_ENDURANCE(6),
    ANAEROBIC_ENDURANCE(7),
    FLEXIBILITY(8),
    COORDINATION(9),
    BALANCE(10);

    private int code;

    PhysicalSkills(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PhysicalSkills valueOf(int code) {
        for (PhysicalSkills value : PhysicalSkills.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code");
    }
}
