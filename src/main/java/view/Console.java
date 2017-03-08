package view;

import java.util.Scanner;

public class Console implements View {

    @Override
    public String read() {
        Scanner in = new Scanner(System.in);
        String read = in.next();
        return read;
    }

    @Override
    public void write(String string) {
        System.out.println(string);
    }
}
