import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(content));
    }

    @Test public void failedTestLab5() throws IOException {
        Path fileName = Path.of("break-test-lab5.md");
        String content = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(content));
    }

    @Test public void failedTestLab5Task3() throws IOException {
        Path fileName = Path.of("break-test-lab5.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-thi)ng.html"), MarkdownParse.getLinks(content));
    }
}