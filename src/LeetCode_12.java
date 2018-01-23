import java.util.Arrays;

/**
 *
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class LeetCode_12 {


    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while(num>0){
            if (num >= 1000){
                num -= 1000;
                roman.append("M");
                continue;
            }
            if (num >= 500){
                if (num >= 900){
                    num -= 900;
                    roman.append("C");
                    roman.append("M");
                    continue;

                }
                num -= 500;
                roman.append("D");
                continue;

            }
            if (num >= 100){
                if (num >= 400){
                    num -= 400;
                    roman.append("C");
                    roman.append("D");
                    continue;

                }
                num -= 100;
                roman.append("C");
                continue;

            }
            if (num >= 50){
                if (num >= 90){
                    num -= 90;
                    roman.append("X");
                    roman.append("C");
                    continue;

                }
                num -= 50;
                roman.append("L");
                continue;

            }
            if (num >= 10){
                if (num >= 40){
                    num -= 40;
                    roman.append("X");
                    roman.append("L");
                    continue;

                }
                num -= 10;
                roman.append("X");
                continue;

            }
            if (num >= 5){
                if (num == 9){
                    num -= 9;
                    roman.append("I");
                    roman.append("X");
                    continue;

                }
                num -= 5;
                roman.append("V");
                continue;

            }
            if (num >= 1){
                if (num == 4){
                    num -= 4;
                    roman.append("I");
                    roman.append("V");
                    continue;

                }
                num -= 1;
                roman.append("I");
                continue;

            }

        }

        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_12().intToRoman(1024));
    }
}
