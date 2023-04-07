import java.util.Scanner;

public class Password3 {
    public Password3() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        System.out.print("What is the password: ");
        String var2 = var1.nextLine();
        if (var2.equals("zz")) {
            System.out.println("login correct");
        } else {
            System.out.println("login incorrect");
        }

    }
}