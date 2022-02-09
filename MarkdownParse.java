// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();

        //Split the contents of the markdown file into each individual line
        String[] contentsArray = markdown.split("\n");
        //Loop through each line, check if it is of a link form
        //if so, add the solely the link into the return ArrayList
        for(String s: contentsArray){
            if(isOfLinkForm(s))
                toReturn.add(s.substring(s.indexOf("(")+1, s.lastIndexOf(")")));
                //using lastIndexOf() to fix a whitespace issue (I think) on
                //windows
        }
        /* Original Code
        -----------------------
        // find the next [, then find the ], then find the (, then take up to
        // the next )

        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
<<<<<<< HEAD
            toReturn.add(markdown.substring(openParen + 1, closeParen));
=======
	    int escapeCharacter_start = markdown.indexOf("\\");
	    if(escapeCharacter_start != -1){
		int escape_char_counter = 0;
		for(int i = escapeCharacter_start; i<markdown.length(); i++){
		     if(String.valueOf(markdown.charAt(i)).equals("\\")){
		     	escape_char_counter++;
		     }
		}
		if(escape_char_counter%2 != 0){
			return toReturn;
		}
	    }
            if(nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1){
                return toReturn;
            }
            if((nextOpenBracket != 0  && markdown.charAt(nextOpenBracket - 1) == '!')
                || (openParen != nextCloseBracket + 1)){
                validLink = false;
            }
            if(validLink) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
>>>>>>> cda7257c910a577229e9c0c598e1b3dcfe2efd2f
            currentIndex = closeParen + 1;
        }
        //*/
        //System.out.println(toReturn.size());
        return toReturn;
    }
    public static boolean isOfLinkForm(String s){
        int firstBracket = s.indexOf("[");
        int pivotalSeq = s.indexOf("](");
        boolean containerGood = false;
        String linkContainer = "";
        //this obtains the whole container like [Link]
        if (firstBracket >=0 && pivotalSeq > firstBracket)
            linkContainer = s.substring(firstBracket,pivotalSeq+1);
        //Check linkContainer against container parameters
        containerGood = checkLinkContainer(linkContainer);

        return containerGood && s.contains("(") && s.contains(")") && !s.startsWith("!");
    }

    public static boolean checkLinkContainer(String container){
        int numOpenBrackets = 0;
        int numClosedBrackets = 0;
        String toParse = container;
        for (int i = 0; i < toParse.length(); i++){
            if(toParse.substring(i,i+1).equals("["))
                numOpenBrackets++;
            else if(toParse.substring(i,i+1).equals("]"))
                numClosedBrackets++;
        }
        return container.length() > 2 && numOpenBrackets >= 1 &&
            numClosedBrackets >= 1 && numOpenBrackets >= numClosedBrackets;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
