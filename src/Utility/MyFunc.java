package Utility;

public class MyFunc{
    public static void sleep(int ms){
        try {
            Thread.sleep(ms*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
