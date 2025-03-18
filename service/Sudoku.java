package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import exceptions.CampoFixo;
import exceptions.CordenadasInvalidas;
import exceptions.ValorErrado;
import ui.Jogo;

public class Sudoku {
    private static Map<Cordenadas, Integer> jogo;
    private static String status = "Não Inciado";

    public Sudoku(Map<Cordenadas, Integer> jogoNovo) throws CordenadasInvalidas{
        if (jogoNovo.size() != 9) throw new CordenadasInvalidas("Quantidade de argumentos inválida");
        else jogo = jogoNovo;
    }

    public static boolean verificarLinhasEColunas(Cordenadas cordenadas, Integer valorNovo) {
         return jogo.entrySet().stream().anyMatch(n -> {
            if((n.getKey().getCordenadas(0) == cordenadas.getCordenadas(0) || n.getKey().getCordenadas(1) == cordenadas.getCordenadas(1)) && n.getValue() == valorNovo)
                return false;
            return true;
        });
    }
    
    public static void limparEntrada(String entradas) {
        //cada um é um valor, preciso pegar 9 para cada bloco
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
                Cordenadas cordenadas = new Cordenadas(cordenadasInt, Boolean.parseBoolean(partes[2]));                
                int valorEsperado = Integer.parseInt(partes[1]);
                valoresLimpos.put(cordenadas, valorEsperado);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    
    public static void novoJogo(Optional<Map<Cordenadas, Integer>> o) throws CordenadasInvalidas {
        if(o.isEmpty()); //funcao verificar bloco
        else if(o.get().size() > 9) throw new CordenadasInvalidas("Muitos valores informados para um bloco de números");
        else jogo = o.get();
        status = "Em andamento";
        try {
            Jogo frame = new Jogo();
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void adicionarValor(Cordenadas cordenadas, Integer valorNovo) throws Exception {
        if(!Sudoku.verificarLinhasEColunas(cordenadas, valorNovo)) throw new ValorErrado("Valor no mesmo bloco / linha / coluna ");
        else if(valorNovo > 9 || valorNovo < 1) throw new ValorErrado("Valor inválido");
        else if(cordenadas.isFixo()) throw new CampoFixo();
        else {
            jogo.entrySet().stream().forEach(Integer -> Integer.getValue().getValores().entrySet().stream().forEach(valor -> {
                if (valor.getKey() == cordenadas) Integer.getValue().adicionarValor(cordenadas, valorNovo);
            }));
        }
    }

    public static void removerValor(Cordenadas cordenadas) {
        jogo.entrySet().stream().forEach(Integer -> Integer.getValue().getValores().entrySet().stream().forEach(valor -> {
            if (valor.getKey() == cordenadas) Integer.getValue().removerValor(cordenadas);
        }));
    }
    
    public static void exibirStatusJogo() {
        System.out.println("Status do jogo: " + status);
    }

    public static void finalizarJogo() {
        
    }
}
