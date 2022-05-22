import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.*;


public class MarkdownParseTest {

    void testHelper(String fileName, String[] strArr) throws IOException {
        MarkdownParse parser = new MarkdownParse();
        String content = Files.readString(Path.of(fileName));
        ArrayList<String> links = parser.getLinks(content);
        assertArrayEquals(strArr, links.toArray());
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testMarkdownParseTestFile() throws IOException {
        testHelper("test-file.md", new String[]{"https://something.com", "some-thing.html"});
    }

    @Test
    public void testMarkdownParseNewFile() throws IOException {
        testHelper("new-file.md", new String[]{"https://something.com", "some-thing.html"});
    }

    @Test
    public void testMarkdownParseImageFile() throws IOException {
        testHelper("image-file.md", new String[]{"some-thing.html"});
    }

    @Test
    public void testMarkdownParseBuggyFile() throws IOException {
        testHelper("buggy-file.md", new String[]{"https://something.com", "some-thing.html"});
    }

    @Test
    public void testMarkdownImportedFile1() throws IOException {
        testHelper("imported_tests/test-file.md", new String[]{"https://something.com", "some-thing.html"});
    }
    
    @Test
    public void testMarkdownImportedFile2() throws IOException {
        testHelper("imported_tests/test-file2.md", new String[]{"https://something.com", "some-page.html"});

    }

    @Test
    public void testMarkdownImportedFile3() throws IOException {
        testHelper("imported_tests/test-file3.md", new String[]{});

    }

    @Test
    public void testMarkdownImportedFile4() throws IOException {
        testHelper("imported_tests/test-file4.md", new String[]{});
    }

    @Test
    public void testMarkdownImportedFile5() throws IOException {
        testHelper("imported_tests/test-file5.md", new String[]{});
    }

    @Test
    public void testMarkdownImportedFile6() throws IOException {
        testHelper("imported_tests/test-file6.md", new String[]{});
    }

    @Test
    public void testMarkdownImportedFile7() throws IOException {
        testHelper("imported_tests/test-file7.md", new String[]{});
    }

    @Test
    public void testMarkdownImportedFile8() throws IOException {
        testHelper("imported_tests/test-file8.md", new String[]{"a link on the first line"});
    }

    @Test
    public void testToSucceed() throws IOException {
        testHelper("test-file.md", new String[]{"https://something.com", "some-thing.html"});
    }

    @Test
    public void lab5test() throws IOException {
        testHelper("lab5failingtest.md", new String[]{"something.com"});
    }

    @Test
    public void lab8test() throws IOException {
	    testHelper("lab8testfile.md", new String[]{"startoftheline.com"});
	}    

    // @Test
    // public void snippet1Test() throws IOException {
    //     testHelper("snippet1.md", new String[]{"`google.com", "google.com", "ucsd.edu"});
    // }

    // @Test
    // public void snippet2Test() throws IOException {
    //     testHelper("snippet2.md", new String[]{"a.com", "a.com(())", "example.com"});
    // }

    @Test
    public void snippet3Test() throws IOException {
        testHelper("snippet3.md", new String[]{"https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule"});
    }
}
