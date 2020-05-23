public class StringWrapper {
    public String stringWrap(String toWrap) {
        if(toWrap.length() == 0) {
            return "";
        }
        String wrapped = "";
        boolean addLast = true;
        for(int i = 0; i < toWrap.length() - 1; i++) {
            int occurences = 1;
            char temp = toWrap.charAt(i);
            char nextChar = toWrap.charAt(i + 1);
            while(temp == nextChar && i != toWrap.length() - 2) {
                i++;
                temp = toWrap.charAt(i);
                nextChar = toWrap.charAt(i + 1);
                occurences++;
            }
            if(i == toWrap.length() - 2) {
                if(temp == nextChar) {
                    occurences++;
                    addLast = false;
                }
            }
            wrapped += temp;
            if(occurences > 1) {
                wrapped += occurences;
            }
        }
        if(addLast) {
            wrapped += toWrap.charAt(toWrap.length() - 1);
        }
        return wrapped;
    }

    public String stringUnwrap(String toUnwrap) {
        if(toUnwrap.length() == 0) {
            return "";
        }
        String unwrapped = "";
        toUnwrap += " ";
        for(int i = 1; i < toUnwrap.length(); i++) {
            String toParse = "";
            char temp = toUnwrap.charAt(i);
            char backup = toUnwrap.charAt(i - 1);
            while(temp >= '0' && temp <= '9') {
                toParse += temp;
                i++;
                temp = toUnwrap.charAt(i);
            }
            if(toParse.length() != 0) {
                int count = Integer.parseInt(toParse);
                for(int j = 0; j < count; j++) {
                    unwrapped += backup;
                }
            } else {
                unwrapped += backup;
            }
        }
        return unwrapped;
    }
}
