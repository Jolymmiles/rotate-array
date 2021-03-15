import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "2\r\n1 2\r\n3 4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 3, 2, 4};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "4\r\n-925 -764 -347 715\r\n-621 -924 -348 -275\r\n-444 853 -431 -845\r\n-570 916 783 654";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{-925, -621, -444, -570, -764, -924, 853, 916, -347, -348, -431, 783, 715, -275, -845, 654};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "7\r\n311 -836 639 -915 -300 -776 783\r\n-475 939 75 569 88 403 -641\r\n-330 566 669 915 555 286 688\r\n533 -508 889 608 -787 782 981\r\n169 -265 -781 -207 898 -795 912\r\n-753 425 716 315 213 478 -854\r\n674 -806 -125 482 863 702 866";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{311, -475, -330, 533, 169, -753, 674, -836, 939, 566, -508, -265, 425, -806, 639, 75, 669, 889, -781, 716, -125, -915, 569, 915, 608, -207, 315, 482, -300, 88, 555, -787, 898, 213, 863, -776, 403, 286, 782, -795, 478, 702, 783, -641, 688, 981, 912, -854, 866};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "5\r\n0 0 0 0 0\r\n0 0 0 0 0\r\n0 0 0 0 0\r\n0 0 0 0 0\r\n0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

}