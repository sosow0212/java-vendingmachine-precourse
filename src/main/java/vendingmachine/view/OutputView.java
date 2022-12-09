package vendingmachine.view;

public class OutputView {
    public void requestMoneyOfMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public void printCoinOfMachineHaving() {

    }

    public void requestOfProductInfo() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    }

    public void requestOfInputMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
    }

    public void printInputMoney(String money) {
        System.out.println("투입 금액: " + money);
    }

    public void requestOfBuyingProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
    }
}
