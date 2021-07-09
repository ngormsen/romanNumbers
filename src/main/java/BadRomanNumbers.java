public class BadRomanNumbers {



    //roman numbers
    private final String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String parseRomanNumbersToArabicNumbersOrArabicNumbersToRomanNumbers(String inputNumber) {
        try{
            Integer.parseInt(inputNumber);
            flag = true;
        }catch(Exception e){
            // exception
            if (inputNumber.matches("[a-zA-Z]+")) { flag = false; }
            else{ return "Wrong input!"; }
        }




        if(flag){ // arabic to roman
            int n = Integer.parseInt(inputNumber);
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < romanNumbers.length; i++){ while (n >= an[i]) { result.append(romanNumbers[i]);n -= an[i]; } }
            return result.length() > 0 ? result.toString() : "Wrong input!";
        }else{ // roman to arabic
            String n = inputNumber;
            int r = 0;
            int i = 0;
            while (n.length() > 0 && i < romanNumbers.length) { if(n.startsWith(romanNumbers[i])){ r += an[i]; n = n.substring(romanNumbers[i].length()); }else{ i++; } }
            return String.valueOf(r);
        }
    }

    // arabic numbers
    private final int[] an = new ArabicNumbers().getArabicNumbers();
    private boolean flag; //flag for different cases

    public static void main(String[] args) {
        BadRomanNumbers romanNumbers = new BadRomanNumbers();
        System.out.println(romanNumbers.parseRomanNumbersToArabicNumbersOrArabicNumbersToRomanNumbers(args[0]));
    }

}
