package com.example.luizmangerotte.workout.entities.enums;

public enum GrupamentosMusculares {

    PEITO(1),
    COSTAS(2),
    DELTOIDE(3),
    BICEPS(4),
    TRICEPS(5),
    ABDOMEN(6),
    QUADRICEPS(7),
    ISQUIOTIBIAIS(8),
    GLUTEO_MAXIMO(9),
    GLUTEO_MEDIO(10),
    PANTURRILHA(11);

    private int code;

    GrupamentosMusculares (int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GrupamentosMusculares valueOf(int code) {
        for (GrupamentosMusculares value : GrupamentosMusculares.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo Invalido");
    }
}

