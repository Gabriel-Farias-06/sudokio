package service;

public enum EnumCordenadas {

    cordenadas_0_0(0, 0),
    cordenadas_0_1(0, 1),
    cordenadas_0_2(0, 2),
    cordenadas_1_0(1, 0),
    cordenadas_1_1(1, 1),
    cordenadas_1_2(1, 2),
    cordenadas_2_0(2, 0),
    cordenadas_2_1(2, 1),
    cordenadas_2_2(2, 2);

    private int n1;
    private int n2;

    private EnumCordenadas(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
