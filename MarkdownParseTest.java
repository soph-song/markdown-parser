import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.*;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testMarkdownParseTestFile() throws IOException {
        MarkdownParse testerObj = new MarkdownParse();
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = testerObj.getLinks(content);
        assertArrayEquals(new String[]{"https://something.com", "some-thing.html"}, links.toArray());
    }

    @Test
    public void testMarkdownParseNewFile() throws IOException {
        MarkdownParse testerObj = new MarkdownParse();
        Path fileName = Path.of("new-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = testerObj.getLinks(content);
        assertArrayEquals(new String[]{"https://something.com", "some-thing.html"}, links.toArray());
    }

    @Test
    public void testMarkdownParseImageFile() throws IOException {
        MarkdownParse testerObj = new MarkdownParse();
        Path fileName = Path.of("image-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = testerObj.getLinks(content);
        assertArrayEquals(new String[]{"some-thing.html"}, links.toArray());
    }

    @Test
    public void testMarkdownParseBuggyFile() throws IOException {
        MarkdownParse testerObj = new MarkdownParse();
        Path fileName = Path.of("buggy-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = testerObj.getLinks(content);
        assertArrayEquals(new String[]{"https://something.com", "some-thing.html"}, links.toArray());
    }
}