package service;

import exceptions.CordenadasInvalidas;
import java.util.List;

public class Cordenadas implements Comparable<Cordenadas> {
    private List<Integer> cordenadas;
    private boolean fixo;

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

	@Override
	public String toString() {
		return "Cordenadas [cordenadas=" + cordenadas + ", fixo=" + fixo + "]";
	}

	@Override
	public int compareTo(Cordenadas c1) {
	    int cmp = Integer.compare(this.getCordenadas(1), c1.getCordenadas(1));
	    return (cmp != 0) ? cmp : Integer.compare(this.getCordenadas(0), c1.getCordenadas(0));
	}
	
	
}