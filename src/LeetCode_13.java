
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class LeetCode_13 {
    private static Map<Character,Integer> ROMAN_DICT;
    static {
        ROMAN_DICT = new HashMap<>(7);
        ROMAN_DICT.put('I',1);
        ROMAN_DICT.put('V',5);
        ROMAN_DICT.put('X',10);
        ROMAN_DICT.put('L',50);
        ROMAN_DICT.put('C',100);
        ROMAN_DICT.put('D',500);
        ROMAN_DICT.put('M',1000);
    }
    public int romanToInt(String s) {
        Integer sum = 0;
        if(s.length() == 1){
            sum += ROMAN_DICT.get(s.charAt(0));
            return sum;
        }
        for (int i = 0; i<s.length();i++){
            Integer currentVal = ROMAN_DICT.get(s.charAt(i));
            Integer nextVal = i >= s.length()-1?0:ROMAN_DICT.get(s.charAt(i+1));
            if (currentVal < nextVal){
                sum += (nextVal - currentVal);
                i++;
            }else {
                sum += currentVal;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_13().romanToInt("MCMXC"));
    }
}
