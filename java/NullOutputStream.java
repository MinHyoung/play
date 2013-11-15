import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class NullOutputStream extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // do nothing
    }

    public static void main(String[] args) {
        PrintStream out = new PrintStream(new NullOutputStream());
        out.println("hello world");
    }
}
