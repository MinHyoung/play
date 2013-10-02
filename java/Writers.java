import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Writers {

    public static void main(String[] args) throws Exception {
        /**
         * In general, a Writer sends its output immediately to the underlying
         * character or byte stream. Unless prompt output is required, it is
         * advisable to wrap a BufferedWriter around any Writer whose write()
         * operations may be costly, such as FileWriters and OutputStreamWriters.
         *
         * For example, new PrintWriter(new BufferedWriter(new FileWriter("foo.out")));
         * will buffer the PrintWriter's output to the file. Without buffering, each
         * invocation of a print() method would cause characters to be converted into
         * bytes that would then be written immediately to the file, which can be very
         * inefficient.
         */
        File file = new File("data/writer.out");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write("writer");
        bw.close();

    }
}
