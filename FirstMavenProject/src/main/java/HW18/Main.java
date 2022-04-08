package HW18;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String actualPath = "";

        if (args.length > 0) {
            if (args[0] != "") {
                actualPath = args[0];
            }
        }

        Converter conv = new Converter(actualPath);
        conv.Start();
    }
}
