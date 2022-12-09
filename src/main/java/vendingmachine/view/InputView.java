package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputMoneyOfMachine() {
        try {
            String input = Console.readLine();
            // 예외
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputMoneyOfMachine();
        }
    }

    public String inputProductInfo() {
        try {
            String input = Console.readLine();
            // 예외
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputProductInfo();
        }
    }

    public int inputUserMoney() {
        try {
            String input = Console.readLine();
            // 예외
            return Integer.valueOf(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputUserMoney();
        }
    }

    public String inputProductName() {
        try {
            String input = Console.readLine();
            // 예외
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputProductName();
        }
    }
}
