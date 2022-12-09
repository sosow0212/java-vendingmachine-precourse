package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import vendingmachine.domain.Coin;

public class CoinGenerator {
    public void generateRandomCoin(int money) {
        List<Integer> vendingMoneyList = Arrays.asList(500, 100, 50, 10);
        while (money != 0) {
            int randomNumber = Randoms.pickNumberInList(vendingMoneyList);
            if (money >= randomNumber) {
                money -= randomNumber;
                Coin.getCoin(randomNumber).addCount();
            }
        }
    }

    public HashMap<Integer, Integer> coinList(int money) {
        HashMap<Integer, Integer> coinList = new HashMap<>();

        for (Coin coin : Coin.values()) {
            if (money <= 0) {
                break;
            }
            int require = money / coin.getAmount();

            if (require > coin.getQuantity()) {
                money -= (coin.getQuantity() * coin.getAmount());
                coinList.put(coin.getAmount(), coin.getQuantity());
                continue;
            }

            money -= (require * coin.getAmount());
            coinList.put(coin.getAmount(), require);
        }
        return coinList;
    }
}
