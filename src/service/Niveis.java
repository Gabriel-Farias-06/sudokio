package src.service;

public enum Niveis {
    FACIL("0,0;5,true 1,0;3,true 2,0;4,true 3,0;6,false 4,0;7,true 5,0;8,false 6,0;9,false 7,0;1,false 8,0;2,true "
        + "0,1;6,false 1,1;7,true 2,1;2,false 3,1;1,true 4,1;9,false 5,1;5,true 6,1;3,false 7,1;4,true 8,1;8,false "
        + "0,2;1,true 1,2;9,false 2,2;8,true 3,2;3,false 4,2;4,true 5,2;2,false 6,2;5,true 7,2;6,false 8,2;7,false "
        + "0,3;8,false 1,3;5,true 2,3;9,false 3,3;7,true 4,3;6,false 5,3;1,true 6,3;4,false 7,3;2,true 8,3;3,false "
        + "0,4;4,true 1,4;2,false 2,4;6,true 3,4;8,false 4,4;5,true 5,4;3,false 6,4;7,true 7,4;9,false 8,4;1,true "
        + "0,5;7,false 1,5;1,true 2,5;3,false 3,5;9,true 4,5;2,false 5,5;4,true 6,5;8,false 7,5;5,false 8,5;6,false "
        + "0,6;9,true 1,6;6,false 2,6;1,true 3,6;5,false 4,6;3,true 5,6;7,false 6,6;2,true 7,6;8,false 8,6;4,true "
        + "0,7;2,true 1,7;8,false 2,7;7,true 3,7;4,false 4,7;1,true 5,7;9,false 6,7;6,false 7,7;3,true 8,7;5,false "
        + "0,8;3,false 1,8;4,true 2,8;5,false 3,8;2,true 4,8;8,false 5,8;6,false 6,8;1,true 7,8;7,false 8,8;9,true"),

    MEDIO("0,0;5,true 1,0;3,true 2,0;4,false 3,0;6,false 4,0;7,true 5,0;8,false 6,0;9,false 7,0;1,true 8,0;2,false "
        + "0,1;6,false 1,1;7,false 2,1;2,true 3,1;1,false 4,1;9,false 5,1;5,false 6,1;3,true 7,1;4,false 8,1;8,true "
        + "0,2;1,true 1,2;9,false 2,2;8,true 3,2;3,true 4,2;4,true 5,2;2,false 6,2;5,false 7,2;6,false 8,2;7,true "
        + "0,3;8,false 1,3;5,true 2,3;9,true 3,3;7,false 4,3;6,false 5,3;1,false 6,3;4,true 7,3;2,false 8,3;3,false "
        + "0,4;4,false 1,4;2,false 2,4;6,false 3,4;8,true 4,4;5,false 5,4;3,true 6,4;7,false 7,4;9,true 8,4;1,false "
        + "0,5;7,false 1,5;1,true 2,5;3,false 3,5;9,false 4,5;2,true 5,5;4,true 6,5;8,true 7,5;5,false 8,5;6,true "
        + "0,6;9,true 1,6;6,true 2,6;1,false 3,6;5,true 4,6;3,true 5,6;7,false 6,6;2,false 7,6;8,false 8,6;4,true "
        + "0,7;2,false 1,7;8,false 2,7;7,true 3,7;4,false 4,7;1,true 5,7;9,false 6,7;6,true 7,7;3,false 8,7;5,false "
        + "0,8;3,false 1,8;4,true 2,8;5,false 3,8;2,true 4,8;8,true 5,8;6,false 6,8;1,false 7,8;7,false 8,8;9,false"),

    DIFICIL("0,0;5,true 1,0;3,false 2,0;4,true 3,0;6,false 4,0;7,true 5,0;8,false 6,0;9,false 7,0;1,true 8,0;2,false "
        + "0,1;6,false 1,1;7,false 2,1;2,true 3,1;1,false 4,1;9,false 5,1;5,false 6,1;3,true 7,1;4,false 8,1;8,true "
        + "0,2;1,true 1,2;9,false 2,2;8,true 3,2;3,false 4,2;4,true 5,2;2,false 6,2;5,false 7,2;6,false 8,2;7,true "
        + "0,3;8,false 1,3;5,true 2,3;9,false 3,3;7,true 4,3;6,false 5,3;1,false 6,3;4,true 7,3;2,false 8,3;3,false "
        + "0,4;4,false 1,4;2,true 2,4;6,false 3,4;8,true 4,4;5,false 5,4;3,true 6,4;7,false 7,4;9,true 8,4;1,false "
        + "0,5;7,true 1,5;1,false 2,5;3,true 3,5;9,false 4,5;2,true 5,5;4,false 6,5;8,true 7,5;5,false 8,5;6,true "
        + "0,6;9,false 1,6;6,true 2,6;1,false 3,6;5,false 4,6;3,true 5,6;7,true 6,6;2,false 7,6;8,false 8,6;4,true "
        + "0,7;2,true 1,7;8,false 2,7;7,true 3,7;4,false 4,7;1,false 5,7;9,false 6,7;6,true 7,7;3,false 8,7;5,false "
        + "0,8;3,false 1,8;4,true 2,8;5,false 3,8;2,true 4,8;8,false 5,8;6,false 6,8;1,false 7,8;7,true 8,8;9,false");



    private final String nivel;

    private Niveis(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }
}
