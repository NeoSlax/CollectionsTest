import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private CarList carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Car :" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenRemovedByIndexThenSizeMustDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }


    @Test
    public void whenRemovedByElementThenSizeMustDecreased() {
        Car car = new Car("", 34);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnedFalse() {
        Car car = new Car("Toyota", 34);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrowException() {
        carList.get(455);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexNegativeThenThrowException() {
        carList.get(-455);
    }

    @Test
    public void methodReturnedRightVersion() {
        Car car = carList.get(1);
        assertEquals("Car :1", car.name());
    }
}