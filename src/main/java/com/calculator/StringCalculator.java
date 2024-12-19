package com.calculator;

public class StringCalculator {
    String numbers;

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public StringCalculator() {
        this.numbers = "";
    }

    public StringCalculator(String numbers) {
        this.numbers = numbers;
    }

    int add() {
        if(numbers.isBlank()) {
            return 0;
        } else {
            String delimiter = ",";
            if (numbers.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
            String[] numbersArray = numbers.split(delimiter + "|\n");
            return arraySum(numbersArray);
        }
    }

    int arraySum(String[] numbersArray) {
        int sum = 0;
        StringBuilder negativeString = new StringBuilder();
        for(String number : numbersArray) {
            int current = Integer.parseInt(number);
            if(current < 0){
                negativeString.append(number).append(",");
            }
            if(current < 1000) {
                sum += current;
            }
        }
        if(!negativeString.isEmpty()) {
            negativeString.deleteCharAt(negativeString.length() - 1);
            throw new IllegalArgumentException("Negatives not allowed: " + negativeString);
        }
        return sum;
    }
}
