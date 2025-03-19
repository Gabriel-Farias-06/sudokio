package service;

import exceptions.CordenadasInvalidas;
import exceptions.ValorErrado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import ui.Jogo;

public class Sudoku {
    private static Map<Cordenadas, Integer> jogo = new HashMap<>();
    private static Map<Cordenadas, Integer> jogoResultado = new HashMap<>();
    private static String status = "Não Inciado";

    public static boolean valorErrado(Cordenadas cordenadas, Integer valorNovo) {
         return jogo.entrySet().stream().anyMatch(valor -> {
        	 if((valor.getKey().getCordenadas(0) == cordenadas.getCordenadas(0) || valor.getKey().getCordenadas(1) == cordenadas.getCordenadas(1)) && valor.getValue().equals(valorNovo)) {
        		 System.out.println(valor);
        		 return true;
        	 }
        	 return false;
         });
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
        
        try {
			Sudoku.novoJogo(Optional.of(valoresLimpos));
		} catch (CordenadasInvalidas e) {
			e.printStackTrace();
		}
    }

    
    public static void novoJogo(Optional<Map<Cordenadas, Integer>> o) throws CordenadasInvalidas {
        if(o.isEmpty());
        else if(o.get().size() > 81) throw new CordenadasInvalidas("Muitos valores informados para um bloco de números");
        else jogoResultado = o.get();
        jogoResultado.entrySet().forEach(valor -> {
            if (valor.getKey().isFixo()) jogo.put(valor.getKey(), valor.getValue());
	    });
        
        status = "Em andamento";
        try {
            Jogo frame = new Jogo(jogoResultado);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void adicionarValor(Cordenadas cordenadas, Integer valorNovo) throws Exception {
        if(Sudoku.valorErrado(cordenadas, valorNovo)) throw new ValorErrado("Valor inválido: " + valorNovo);
        else if(valorNovo > 9 && valorNovo < 1) throw new ValorErrado("Valor inválido");
        else {
        	jogo.put(cordenadas, valorNovo);
        }
    }

    public static void removerValor(Cordenadas cordenadas) {
        jogo.entrySet().stream().forEach(valor -> {
        	if (valor.getKey() == cordenadas) jogo.put(cordenadas, 0);
        });
    }
    
    public static void exibirStatusJogo() {
        System.out.println("Status do jogo: " + status);
    }

    public static void finalizarJogo() {
        
    }
}
