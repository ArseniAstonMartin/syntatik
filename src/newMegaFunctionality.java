public class newMegaFunctionality {
    private int anInt;

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }
    public void printAnInt() {
        System.out.println(anInt + "some text");
    }
    public static void nothing(int anInt) throws StackOverflowError{
        if (anInt % 2 == 1) nothing(anInt / 2);
    }
}
