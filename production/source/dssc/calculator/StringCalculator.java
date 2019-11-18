package dssc.calculator;



public class StringCalculator {

    public static String findDelimiter(String numbers){
        String separator = numbers.substring(2, numbers.lastIndexOf('\n') );
        return separator; }

    public static String extractNumbers(String numbers){
        char sep = '\n';
        int index = numbers.lastIndexOf(sep);
        return numbers.substring(index + 1);
    }

    public static int separateAndSum(String numbers, String separator){
        String[] tokens = numbers.split(separator);
        int result = 0;
        for(String number : tokens){
            int addendo = (Integer.valueOf(number) < 1000)? Integer.valueOf(number):0;
            result += addendo;
        }

        return result;
    }

    public static int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        } else if (numbers.length() == 1){
            return Integer.valueOf(numbers);
        }

        if(numbers.contains("-")){
            String negative_number = "-" + numbers.charAt(numbers.indexOf('-') + 1) ;
            throw new RuntimeException("Negative numbers not allowed" + negative_number);
        }

        if (numbers.startsWith("//")) {
            String separator = findDelimiter(numbers);
            return separateAndSum(extractNumbers(numbers), separator);
        } else if (numbers.contains(",")) {
            return separateAndSum(numbers, ",");
        } else {
            return separateAndSum(numbers, "\n");
        }
    }
}
