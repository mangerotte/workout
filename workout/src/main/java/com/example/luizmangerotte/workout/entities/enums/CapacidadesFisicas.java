package com.example.luizmangerotte.workout.entities.enums;

public enum CapacidadesFisicas {

    FORCA_MAXIMA(1),
    FORCA_RESISTENCIA(2),
    FORCA_POTENCIA(3),
    VELOCIDADE(4),
    AGILIDADE(5),
    RESISTENCIA_AEROBIA(6),
    RESISTENCIA_ANAEROBIA(7),
    FLEXIBILIDADE(8);

    private int code;

    CapacidadesFisicas(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CapacidadesFisicas valueOf(int code) {
        for (CapacidadesFisicas value : CapacidadesFisicas.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo invalido");
    }
}
