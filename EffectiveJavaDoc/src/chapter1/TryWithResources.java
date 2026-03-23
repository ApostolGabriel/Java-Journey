package chapter1;

import java.io.*;

/**
 * 1.9 Prefer try-with-resources instead of try-finally
 * <p>
 *     Java libraries contain multiple instances of resources that require invoking a close method:
 *     InputStream, OutputStream, java.sql.Connection.
 * </p>
 * <p>
 *     try-finally was the best way to guarantee that a resource would be close properly.
 * </p>
 * <p>
 *     Always use try-with-resources because it is short and clear, exceptions that appear are easier to detect in stack trace - shows first exception, then each one suppressed.
 * </p>
 */
public class TryWithResources {

    // try finally - was best
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        // try block and finally block are able to throw exceptions with the same input
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[256];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    // try with resource - best way
    static String firstLineOfFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // InputStream and OutputStream implement AutoCloseable
    static void copyImproved(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[256];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
