public class GoodRomanNumbers {

    private final String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final int[] arabicNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


    public String parseRomanNumbersToArabicNumbersOrArabicNumbersToRomanNumbers(String inputNumber) {
        if (isValidRomanNumber(inputNumber)) {
            return romanToArabic(inputNumber);
        } else if (isValidArabicNumber(inputNumber)) {
            return arabicToRoman(inputNumber);
        } else {
            return "Wrong input!";
        }
    }

    private boolean isValidArabicNumber(String inputNumber) {
        return inputNumber.matches("[0-9]+") && !inputNumber.matches("0+");
    }

    private boolean isValidRomanNumber(String inputNumber) {
        return inputNumber.matches("[A-Z]+");
    }

    private String romanToArabic(String romanNumber) {
        int resultingArabicNumber = 0;
        int idx = 0;
        while (romanNumber.length() > 0 && idx < romanNumbers.length) {
            if (romanNumber.startsWith(romanNumbers[idx])) {
                resultingArabicNumber += arabicNumbers[idx];
                romanNumber = romanNumber.substring(romanNumbers[idx].length());
            } else {
                idx++;
            }
        }
        return String.valueOf(resultingArabicNumber);
    }

    private String arabicToRoman(String inputNumber) {
        int n = Integer.parseInt(inputNumber);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < romanNumbers.length; i++) {
            while (n >= arabicNumbers[i]) {
                result.append(romanNumbers[i]);
                n -= arabicNumbers[i];
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        GoodRomanNumbers goodRomanNumbers = new GoodRomanNumbers();
        System.out.println(goodRomanNumbers.parseRomanNumbersToArabicNumbersOrArabicNumbersToRomanNumbers(args[0]));
    }

}
