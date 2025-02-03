import java.util.Scanner;

class Main {

    public static String calc(String input) {

        String[] massiveOfInput = input.split(" ");

        if (massiveOfInput.length != 3) {
            throw new IllegalArgumentException("Неправильный формат ввода");
        }

        int numb1 = Integer.parseInt(massiveOfInput[0]);
        int numb2 = Integer.parseInt(massiveOfInput[2]);
        String operator = "";

        if (input.contains("+")) {
            operator = "+";
        }

        else if (input.contains("-")) {
            operator = "-";
        }

        else if (input.contains("*")) {
            operator = "*";
        }

        else if (input.contains("/")) {
            operator = "/";
        }

        if (numb1 < 1 || numb1 > 10 || numb2 < 1 || numb2 > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10.");
        }

        switch (operator) {

            case "+":
                return String.valueOf(numb1 + numb2);

            case "-":
                return String.valueOf(numb1 - numb2);

            case "*":
                return String.valueOf(numb1 * numb2);

            case "/":
                if (numb2 == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно.");
                }
                return String.valueOf(numb1 / numb2);

            default:
                throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            String input = scan.nextLine();
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        scan.close();
    }
}
