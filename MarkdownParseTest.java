import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition(){
        assertEquals(2, 1+1);
    }
    ArrayList<String> emptyArrayList = new ArrayList<>();

    @Test
    public void getLinksBreakFile() throws IOException{
        Path fileName = Path.of("break-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://()something.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest1() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest2() throws IOException{
        Path fileName = Path.of("test-file2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest3() throws IOException{
        Path fileName = Path.of("test-file3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://[]something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest4() throws IOException{
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https()www.link.com", "https()www.link.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest5() throws IOException{
        Path fileName = Path.of("test-file5.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("(thisisalink.com)"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest6() throws IOException{
        Path fileName = Path.of("test-file6.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("something.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest7() throws IOException{
        Path fileName = Path.of("test-file7.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("something.com", "something.com", "something.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest8() throws IOException{
        Path fileName = Path.of("test-file8.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://www.parenthesis().com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest9() throws IOException{ //this returns an ArrayList with the empty string
        Path fileName = Path.of("test-file9.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTest10() throws IOException{ //markdown does not format this as a link
        Path fileName = Path.of("test-file10.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest1() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest2() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest3() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file3.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest4() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file4.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest5() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file5.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest6() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file6.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest7() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file7.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksJoeTest8() throws IOException{
        Path fileName = Path.of("./joe-test-files/test-file8.md");
        String contents = Files.readString(fileName);
        assertEquals(emptyArrayList, MarkdownParse.getLinks(contents));
    }
}
