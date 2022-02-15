import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File("mbr");
        Parser parser = new Parser();
        parser.setFile(file);

        byte[] content = parser.getContent();
        int i = 0;
        for (byte b: content) {
            if (i % 16 == 0) {
                System.out.println();
            }
            System.out.printf("%02x ", b);
            i++;
        }

        //выводит файл в utf-8
        parser.getContent1();

    }
}