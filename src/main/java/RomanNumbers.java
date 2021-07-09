public class RomanNumbers {
    private final String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final int[] arabicNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String parse(String inputNumber) {
        if (isArabic(inputNumber)) return romanNumberOf(inputNumber);
        else if (isRoman(inputNumber)) return arabicNumberOf(inputNumber);
        else return "Wrong input!";
    }

    private String romanNumberOf(String inputNumber) {
        int arabicNumber = Integer.parseInt(inputNumber);

        StringBuilder result = new StringBuilder();
        for(int idx = 0; idx < romanNumbers.length; idx++){
            while (arabicNumber >= arabicNumbers[idx]){
                result.append(romanNumbers[idx]);
                arabicNumber -= arabicNumbers[idx];
            }
        }
        return result.toString();
    }

    private String arabicNumberOf(String inputNumber) {
        int resultingArabicNumber = 0;
        int idx = 0;
        while (inputNumber.length() > 0 && idx < romanNumbers.length) {
            if(inputNumber.startsWith(romanNumbers[idx])){
                resultingArabicNumber += arabicNumbers[idx];
                inputNumber = inputNumber.substring(romanNumbers[idx].length());
            }else{
                idx++;
            }
        }
        return String.valueOf(resultingArabicNumber);
    }

    private boolean isArabic(String number) {
        return number.matches("[0-9]+") && !number.matches("0+");
    }

    private boolean isRoman(String number) {
        return number.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        RomanNumbers romanNumbers = new RomanNumbers();
        System.out.println(romanNumbers.parse(args[0]));
    }
}
