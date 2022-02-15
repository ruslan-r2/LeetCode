import java.io.*;
import java.nio.charset.StandardCharsets;

public class Parser {

    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public byte[] getContent() {
        byte[] buffer = null;
        try (InputStream inputStream = new FileInputStream(file)) {
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
        }catch (IOException e) {
            e.getStackTrace();
        }
        return buffer;
    }

    public void getContent1() {
        try (InputStream fis = new FileInputStream(file);
              InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
              BufferedReader br = new BufferedReader(isr)) {
            br.lines().forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.getStackTrace();
        }

    }


}