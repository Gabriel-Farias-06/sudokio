package service;

import java.util.List;

import exceptions.CordenadasInvalidas;

public class Cordenadas {
    private List<Integer> cordenadas;
    private boolean fixo = false; //valores declarados no início do jogo

    public Cordenadas(List<Integer> cordenadas) throws Exception {
        if (cordenadas.size() != 2) throw new CordenadasInvalidas("Quantidade de argumentos inválida");
        else this.cordenadas = cordenadas;
    }

    public Cordenadas(List<Integer> cordenadas, boolean fixo) throws Exception {
        if (cordenadas.size() != 2) throw new CordenadasInvalidas("Quantidade de argumentos inválida");
        else this.cordenadas = cordenadas;
        this.fixo = fixo;
    }

    public int getCordenadas(int index) {
        return cordenadas.get(index);
    }

    public boolean isFixo() {
        return this.fixo;
    }
}
