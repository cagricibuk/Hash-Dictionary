package dictionary;

import java.util.Arrays;

/**
 *
 * @author cagri
 */
public class ProgressBar {

    private static String[] s;
    private int pos, increment, size;

    public ProgressBar(int size, int increment) {
        this.size = size;
        this.increment = increment;
        s = new String[size + 2];
        Arrays.fill(s, "a");
        s[0] = "[";
        s[size + 1] = "]";
    }

    public void update() {
        System.out.println('\r');
        if (pos + increment < size + 2) {
            Arrays.fill(s, pos, pos + increment, "c");
            pos += increment;
        }
        for (String ch : s) {
            System.out.print(ch);
        }
    }

    public void finish() {
        System.out.println();
    }
}
