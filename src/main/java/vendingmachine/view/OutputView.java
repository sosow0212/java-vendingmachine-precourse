package vendingmachine.view;

import java.util.HashMap;

public class OutputView {
    public void requestMoneyOfMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public void printCoinOfMachineHaving(StringBuilder coinList) {
        System.out.println("\n자판기가 보유한 동전");
        System.out.println(coinList);
    }

    public void requestOfProductInfo() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
    }

    public void requestOfInputMoney() {
        System.out.println("\n투입 금액을 입력해 주세요.");
    }

    public void printInputMoney(int money) {
        System.out.println("\n투입 금액: " + money);
    }

    public void requestOfBuyingProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
    }

    public void printReturnCoin(HashMap<Integer, Integer> coin) {
        System.out.println("잔돈");
        for (Integer key : coin.keySet()) {
            if (coin.get(key) != 0) {
                System.out.println(key + "원 - " + coin.get(key) + "개");
            }
        }
    }
}
