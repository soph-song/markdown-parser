import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import java.util.*;

class TryCommonMark {
    public static void main(String[] args) {
        Parser parser = Parser.builder().build();
        Node node = parser.parse("[link](url)  [anotherlink](anotherurl) ![notalink](notaurl)");
        // WordCountVisitor visitor = new WordCountVisitor();
        // node.accept(visitor);
        // System.out.println(visitor.wordCount);
        LinkVisitor visitor = new LinkVisitor();
        node.accept(visitor);
        System.out.println(visitor.links);
    }
}

class LinkVisitor extends AbstractVisitor {
    ArrayList<String> links = new ArrayList<>();

    @Override
    public void visit(Link link) {
        links.add(link.getDestination());

        visitChildren(link);
    }
}

class WordCountVisitor extends AbstractVisitor {
    int wordCount = 0;

    @Override
    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        wordCount += text.getLiteral().split("\\W+").length;

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(text);
    }
}
