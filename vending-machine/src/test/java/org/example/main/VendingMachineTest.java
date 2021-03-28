package org.example.main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO |자판기를 만들기
 * TODO |잔액 확인
 * TODO |잔액만큼 최소 동전으로 거스름돈 반환
 */
class VendingMachineTest {

    @Test
    @DisplayName("잔액 확인")
    void getChangeAmount() {

        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        assertEquals(100, machine.changeAmount(), "투입 금액 100원");

        machine.putCoin(500);
        assertEquals(600, machine.changeAmount(), "추가 투입 금액 500");
    }
// 500 / 100 / 50 / 10
    @Test
    @DisplayName("거스름돈 50원")
    void returnChangeCoinSet_oneCoin_50() {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        machine.putCoin(100);
        machine.putCoin(500);
        machine.selectDrink(new Drink("Cola", 650));

        ChangeModule expectedChangeModule = new ChangeModule(); // 코인 컨테이너 클래스
        expectedChangeModule.add(50);
        assertEquals(expectedChangeModule, machine.changeCoinSet(), "700원 투입 후 650원 음료 선택");

    }

    @Test
    @DisplayName("거스름돈 180원")
    void returnChangeCoinSet_coins_180() {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        machine.putCoin(100);
        machine.putCoin(500);
        machine.selectDrink(new Drink("Soda", 520));

        ChangeModule expectedChangeModule = new ChangeModule();
        expectedChangeModule.add(100);
        expectedChangeModule.add(50);
        expectedChangeModule.add(10);
        expectedChangeModule.add(10);
        expectedChangeModule.add(10);

        assertEquals(expectedChangeModule, machine.changeCoinSet(), "700원 투입 후 520원 음료 선택");
    }

    /**
     * 테스트 케이스를 메트릭스 형태로 작성할 수도 있다.
     *
     */
}