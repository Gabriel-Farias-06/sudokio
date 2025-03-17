package service;

import java.util.Map;

import java.util.Optional;
import java.util.stream.Collectors;

import exceptions.CampoFixo;
import exceptions.CordenadasInvalidas;
import exceptions.ValorErrado;

public class Sudoku {
    private static Map<Cordenadas, BlocoSudoku> jogo;
    private static String status = "Não Inciado";

    public Sudoku(Map<Cordenadas, BlocoSudoku> jogoNovo) throws CordenadasInvalidas{
        if (jogoNovo.size() != 9) throw new CordenadasInvalidas("Quantidade de argumentos inválida");
        else jogo = jogoNovo;
    }

    public static boolean verificarLinhasEColunas(Cordenadas cordenadas, Integer valor) {
         return jogo.entrySet().stream().anyMatch(n -> {
            if (n.getKey().getCordenadas(0) == cordenadas.getCordenadas(0) || n.getKey().getCordenadas(1) == cordenadas.getCordenadas(1))
                return n.getValue().getValores().entrySet().stream().anyMatch(n2 -> n2.getValue() == valor);
                return true;
        });
    }

    
    public static void novoJogo(Optional<Map<Cordenadas, BlocoSudoku>> o) throws CordenadasInvalidas {
        if(o.isEmpty()) jogo.entrySet().stream().map(bloco -> 
            bloco.getValue().getValores().entrySet().stream().filter(valor -> valor.getKey().isFixo()));
        else if(o.get().size() > 9) throw new CordenadasInvalidas("Muitos valores informados para um bloco de números");
        else jogo = o.get();
        status = "Em andamento";
    }

    public static void adicionarValor(Cordenadas cordenadas, Integer valor) throws Exception {
        if(valores.entrySet().stream().anyMatch(v -> v.getValue() == valor)) throw new ValorErrado("Valor já presente no mesmo bloco");
        else if(!Sudoku.verificarLinhasEColunas(cordenadas, valor)) throw new ValorErrado("Valor na mesma linha / coluna");
        else if(valor > 9 || valor < 1) throw new ValorErrado("Valor inválido");
        else if(cordenadas.isFixo()) throw new CampoFixo();
        else valores.put(cordenadas, valor);
    }

    public static void removerValor(Cordenadas cordenadas) {
        valores.put(cordenadas, 0);
    }
    
    public static void exibirStatusJogo() {
        System.out.println("Status do jogo: " + status);
    }

    public static void finalizarJogo() {
        
    }
}
