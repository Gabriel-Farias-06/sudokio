package src.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import src.ui.Info;
import src.ui.Jogo;

public class Sudoku {
    private static Map<Cordenadas, Integer> jogo = new HashMap<>();
    private static Map<Cordenadas, Integer> jogoResultado = new HashMap<>();

    public static boolean valorErrado(Cordenadas cordenadas, Integer valorNovo) {
        return jogo.entrySet().stream().anyMatch(valor -> 
            valor.getValue().equals(valorNovo) && !valor.getKey().equals(cordenadas) && (
                valor.getKey().getCordenadas(0) == cordenadas.getCordenadas(0) ||
                valor.getKey().getCordenadas(1) == cordenadas.getCordenadas(1) ||
                (Sudoku.calcularBloco(valor.getKey().getCordenadas(0)) == Sudoku.calcularBloco(cordenadas.getCordenadas(0)) &&
                 Sudoku.calcularBloco(valor.getKey().getCordenadas(1)) == Sudoku.calcularBloco(cordenadas.getCordenadas(1)))
            )
        );
    }

    private static int calcularBloco(int cordenada) {
        return (int) Math.floor(cordenada / 3);
    }

    
    public static void limparEntrada(String entradas) {
    	
    	Map<Cordenadas, Integer> valoresLimpos = new HashMap<>();
        String entradasSeparadas [] = entradas.split(" ");

        for (String valor : entradasSeparadas) {
	        String partes[] = valor.split(";");
	        String cordenadasString [] = partes[0].split(",");
	        List<Integer> cordenadasInt = new ArrayList<>();
	        for (String string : cordenadasString) {
	            cordenadasInt.add(Integer.parseInt(string));
            }

            try {
                Cordenadas cordenadas = new Cordenadas(cordenadasInt, Boolean.parseBoolean(partes[1].substring(2)));                
                int valorEsperado = Integer.parseInt(partes[1].charAt(0) + "");
                valoresLimpos.put(cordenadas, valorEsperado);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        Sudoku.novoJogo(Optional.of(valoresLimpos));

    }

    
    public static void novoJogo(Optional<Map<Cordenadas, Integer>> o) {
    	
    	jogoResultado = o.get();
        jogoResultado.entrySet().forEach(valor -> {
            if (valor.getKey().isFixo()) jogo.put(valor.getKey(), valor.getValue());
	    });
        
        try {
            Jogo frame = new Jogo(jogoResultado);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void adicionarValor(Cordenadas cordenadas, Integer valorNovo) throws Exception {
        if(Sudoku.valorErrado(cordenadas, valorNovo)) {
        	Info frame = new Info("Valor " + valorNovo + " já existe no mesmo bloco/linha/coluna");
        	frame.setVisible(true);
        }
        else if(valorNovo > 9 && valorNovo < 1) {
        	Info frame = new Info("Só são aceito números de 1 a 9!");
        	frame.setVisible(true);
        }
        
        else jogo.put(cordenadas, valorNovo);
    }

    public static void removerValor(Cordenadas cordenadas) {
        jogo.entrySet().stream().forEach(valor -> {
        	if (valor.getKey() == cordenadas) jogo.put(cordenadas, 0);
        });
    }


    public static boolean verificarStatus() {
        if(jogo.equals(jogoResultado)) return true;
        else {
        	Info frame = new Info("O jogo não está completo/correto");
        	frame.setVisible(true);
        	return false;
        }
    }
}
