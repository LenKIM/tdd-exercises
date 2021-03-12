package mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void addCoupon() throws Exception {
        //Given
        User user = new User("area88");
        assertEquals(0, user.getTotalCouponCount());

        ICoupon coupon = null;
        user.addCoupon(coupon);
        assertEquals(1, user.getTotalCouponCount());
    }

    @Test
    public void getOrderPrice_discountableItem() throws Exception {

    }
}
