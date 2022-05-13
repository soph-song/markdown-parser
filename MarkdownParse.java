//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            if (openBracket==-1) { break; }
            if (openBracket > 0 && markdown.substring(openBracket-1, openBracket).equals("!")) {
                currentIndex=openBracket+1;
                continue;
            }
            int c=0; 
            int closeBracket = -1;
            int startIndex = openBracket;
            while (startIndex < markdown.length()) {
                String nextChar = markdown.substring(startIndex, startIndex+1);
                if (nextChar.equals("[")) {
                    c++;
                } else if (nextChar.equals("]")) {
                    c--;
                    if (c==0) {
                        closeBracket = startIndex;
                        break;
                    }
                }
                startIndex++;
            }
            if (closeBracket==-1 || closeBracket+2>markdown.length()) { break; }
            if (!markdown.substring(closeBracket+1, closeBracket+2).equals("(")) {
                currentIndex=closeBracket+1;
                continue;
            }
            int openParen = markdown.indexOf("(", closeBracket);
            if (openParen==-1) { break; }
            int closeParen = markdown.indexOf(")", openParen);
            if (closeParen==-1) { break; }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}

// small change