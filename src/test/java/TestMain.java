import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String expected = "1\t3\t\r\n2\t4\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "4\r\n-925 -764 -347 715\r\n-621 -924 -348 -275\r\n-444 853 -431 -845\r\n-570 916 783 654";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "-925\t-621\t-444\t-570\t\r\n-764\t-924\t853\t916\t\r\n-347\t-348\t-431\t783\t\r\n715\t-275\t-845\t654\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "7\r\n311 -836 639 -915 -300 -776 783\r\n-475 939 75 569 88 403 -641\r\n-330 566 669 915 555 286 688\r\n533 -508 889 608 -787 782 981\r\n169 -265 -781 -207 898 -795 912\r\n-753 425 716 315 213 478 -854\r\n674 -806 -125 482 863 702 866";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "311\t-475\t-330\t533\t169\t-753\t674\t\r\n-836\t939\t566\t-508\t-265\t425\t-806\t\r\n639\t75\t669\t889\t-781\t716\t-125\t\r\n-915\t569\t915\t608\t-207\t315\t482\t\r\n-300\t88\t555\t-787\t898\t213\t863\t\r\n-776\t403\t286\t782\t-795\t478\t702\t\r\n783\t-641\t688\t981\t912\t-854\t866\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "5\r\n0 0 0 0 0\r\n0 0 0 0 0\r\n0 0 0 0 0\r\n0 0 0 0 0\r\n0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "0\t0\t0\t0\t0\t\r\n0\t0\t0\t0\t0\t\r\n0\t0\t0\t0\t0\t\r\n0\t0\t0\t0\t0\t\r\n0\t0\t0\t0\t0\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

}