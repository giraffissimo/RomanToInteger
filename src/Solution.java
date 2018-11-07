/**
 * Created by giraffissimo on 11/2/2018.
 *
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

 Example 1:

 Input: "III"
 Output: 3
 Example 2:

 Input: "IV"
 Output: 4
 Example 3:

 Input: "IX"
 Output: 9
 Example 4:

 Input: "LVIII"
 Output: 58
 Explanation: L = 50, V= 5, III = 3.
 Example 5:

 Input: "MCMXCIV"
 Output: 1994
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */


public class Solution {
    public static int romanToInt(String s) {
        int result = 0;
        String[] array = s.split("");
        for (int i = 0; i < array.length; i++) {
            if (array.length - 1 > i) {
                int doubleNumberIndex = i + 1;
                if ((Roman.valueOf(array[i]).getName() == "I" && (Roman.valueOf(array[doubleNumberIndex]).getName() == "V" || Roman.valueOf(array[doubleNumberIndex]).getName() == "X")) ||
                        (Roman.valueOf(array[i]).getName() == "X" && (Roman.valueOf(array[doubleNumberIndex]).getName() == "L" || Roman.valueOf(array[doubleNumberIndex]).getName() == "C")) ||
                        (Roman.valueOf(array[i]).getName() == "C" && (Roman.valueOf(array[doubleNumberIndex]).getName() == "D" || Roman.valueOf(array[doubleNumberIndex]).getName() == "M"))) {
                    result += processDoubleNumber(array[i], array[doubleNumberIndex]);
                    i++;
                    continue;
                }
            }
            result += Roman.valueOf(array[i]).getId();
        }
        return result;
    }

    public static int processDoubleNumber(String first, String second){
        return Roman.valueOf(second).getId() - Roman.valueOf(first).getId();
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

}

enum Roman {
    I(1, "I"),
    V(5, "V"),
    X(10, "X"),
    L(50, "L"),
    C(100, "C"),
    D(500, "D"),
    M(1000, "M");

    private Integer id;
    private String name;

    private Roman(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}