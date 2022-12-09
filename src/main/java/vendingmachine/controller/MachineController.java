package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.ProductManager;
import vendingmachine.util.CoinGenerator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CoinGenerator coinGenerator = new CoinGenerator();
    private ProductManager productManager;

    public void start() {
        int moneyOfMachine = getMoneyOfMachine();
        generatorCoin(moneyOfMachine);

        // 상품 정보
        String productInfo = getProductInfo();
        productManager = new ProductManager(productInfo);

        // 투입 금액
        int userInputMoney = getUserInputMoney();
        outputView.printInputMoney(userInputMoney);

        process(userInputMoney);
    }

    public void process(int money) {
        while(productManager.canPurchaseProduct(money)) {
            String productName = inputView.inputProductName();
            if (!productManager.canPurchase(productName, money)) {
                break;
            }
            money = productManager.purchaseGoods(productName, money);
            outputView.printInputMoney(money);
        }
        result(money);
    }

    private void result(int money) {
        if(money != 0) {
            outputView.printReturnCoin(coinGenerator.coinList(money));
        }
    }

    public int getMoneyOfMachine() {
        outputView.requestMoneyOfMachine();
        int moneyOfMachine = inputView.inputMoneyOfMachine();
        return moneyOfMachine;
    }

    public void generatorCoin(int moneyOfMachine) {
        coinGenerator.generateRandomCoin(moneyOfMachine);
        outputView.printCoinOfMachineHaving(Coin.coinList());
    }

    public String getProductInfo() {
        outputView.requestOfProductInfo();
        String productInfo = inputView.inputProductInfo();
        return productInfo;
    }

    public int getUserInputMoney() {
        outputView.requestOfInputMoney();
        int money = inputView.inputUserMoney();
        return money;
    }
}
