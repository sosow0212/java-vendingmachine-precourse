package vendingmachine.domain;

import java.util.Arrays;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int quantity;

    Coin(final int amount, final int quantity) {
        this.amount = amount;
        this.quantity = quantity;
    }

    // 추가 기능 구현
    public int getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addCount() {
        quantity++;
    }

    public static Coin getCoin(int amount) {
        return Arrays.stream(values())
                .filter(i -> i.getAmount() == amount)
                .findAny()
                .orElseGet(null);
    }

    public static StringBuilder coinList() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(values())
                .forEach(coin -> sb.append(coin.getAmount()).append("원 - ").append(coin.getQuantity()).append("개")
                        .append("\n"));
        return sb;
    }
}
