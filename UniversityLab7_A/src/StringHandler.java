import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandler {
//    public String insertAfter(String toEdit, String substring, String toInsert) {
//        String[] words = toEdit.split("[,.:!? ]+");
//        Pattern pattern = Pattern.compile(substring + "$");
//        for(var i : words) {
//            Matcher matcher = pattern.matcher(i);
//            if(matcher.find()) {
//                System.out.println(i);
//            }
//        }
//        return "";
//    }

    public String insertAfter(String toEdit, String substring, String toInsert) {
        Pattern pattern = Pattern.compile("\\b(\\w+" + substring + ")\\b");
        Matcher matcher = pattern.matcher(toEdit);
        String toReturn = "";
        int lastFound = 0;
        while(matcher.find()) {
            toReturn += toEdit.substring(lastFound, matcher.end()) + " " + toInsert;
            lastFound = matcher.end();
        }
        toReturn += toEdit.substring(lastFound, toEdit.length());
        return toReturn;
    }

}
