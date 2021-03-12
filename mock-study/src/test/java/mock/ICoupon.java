package mock;

public interface ICoupon {
    String getName();               // 쿠폰 이름
    boolean isValid();              // 쿠폰 유효여부 확인
    int getDiscountPercent();       // 할인률
    boolean isAppliable(Item item); // 해당 아이템에 적용 가능 여부
    void doExpire();                // 사용할수 없는 쿠폰으로 만듦
}
