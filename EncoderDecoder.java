// 9: Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings
import java.util.*;

class EncoderDecoder{
    private static final String DELIMITER = "%";

    public static String encode(List<String> strs){
      StringBuilder sb = new StringBuilder();

      for(String str : strs){
        String encodedStr = str.replace(DELIMITER, "\\" + DELIMITER);
        sb.append(encodedStr).append(DELIMITER);
      } 

      return sb.toString(); 
    }

    public static List<String> decode(String str){
        List<String> decodedStrs = new ArrayList<>();

        String[] encodedArr = str.split(DELIMITER);

        for(String encodedStr : encodedArr){
            String decodeStr = encodedStr.replace("\\" + DELIMITER, DELIMITER);
            decodedStrs.add(decodeStr);
        }
        return decodedStrs;
    }
    public static void main(String[] args){
        List<String> strs = List.of("Hello", "World", "!");
        String encodedStr = encode(strs);

        List<String> decodeStrs = decode(encodedStr);
        System.out.println(decodeStrs);
    }
}