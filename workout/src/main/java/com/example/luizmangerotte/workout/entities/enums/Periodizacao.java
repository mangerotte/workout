package com.example.luizmangerotte.workout.entities.enums;

public enum Periodizacao {

    LINEAR(1),
    LINEAR_REVERSA(2),
    ONDULATORIA(3);

    private int code;

    Periodizacao(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Periodizacao valueOf(int code) {
        for (Periodizacao value : Periodizacao.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo invalido");
    }
}
