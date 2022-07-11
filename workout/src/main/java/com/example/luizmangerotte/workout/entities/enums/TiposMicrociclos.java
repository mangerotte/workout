package com.example.luizmangerotte.workout.entities.enums;

public enum TiposMicrociclos {

    CHOQUE(1),
    ESTABILIZADOR(2),
    MANUTENCAO(3),
    RECUPERATIVO(4),
    CONTROLE(5),
    PRE_COMPETITIVO(6),
    COMPETITIVO(7);

    private int code;

    TiposMicrociclos (int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TiposMicrociclos valueOf(int code) {
        for (TiposMicrociclos value : TiposMicrociclos.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo invalido");
    }
}
