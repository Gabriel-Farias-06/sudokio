package service;

import java.util.HashMap;
import java.util.Map;

public class BlocoSudoku {
    private static Map<Cordenadas, Integer> valores = new HashMap<>();    
    public Map<Cordenadas, Integer> getValores() {
        return valores;
    }

}
