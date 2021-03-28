package org.example.main;

public class VendingMachine {

    int changeAmount;

    public void putCoin(int coin) {
        changeAmount = changeAmount + coin;

    }

    public double changeAmount() {
        return changeAmount;
    }

    public void selectDrink(Drink cola) {
        changeAmount = changeAmount - cola.price();
    }

    public ChangeModule changeCoinSet() {
        ChangeModule changeModule = new ChangeModule();

        while (changeAmount >= 500){
            changeAmount -= 500;
            changeModule.add(500);
        }

        while (changeAmount >= 100){
            changeAmount -= 100;
            changeModule.add(100);
        }

        while (changeAmount >= 50){
            changeAmount -= 50;
            changeModule.add(50);
        }

        while (changeAmount >= 10){
            changeAmount -= 10;
            changeModule.add(10);
        }

        return changeModule;
    }
}
