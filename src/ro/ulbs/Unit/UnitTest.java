package ro.ulbs.Unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    // Test for the add method
    @Test
    void testAdd() {

        Unit calculator = new Unit(10);

        // Act
        calculator.add(5);


        assertEquals(15, calculator.result(), "Adding 5 to 10 should result in 15");
    }

    // Test for the subtract method
    @Test
    void testSubtract() {
        // Arrange
        Unit calculator = new Unit(10);

        // Act
        calculator.subtract(3);

        // Assert
        assertEquals(7, calculator.result(), "Subtracting 3 from 10 should result in 7");
    }

    // Test for the multiply method
    @Test
    void testMultiply() {
        // Arrange
        Unit calculator = new Unit(10);

        // Act
        calculator.multiply(2);

        // Assert
        assertEquals(20, calculator.result(), "Multiplying 10 by 2 should result in 20");
    }

    // Test for the clear method
    @Test
    void testClear() {
        // Arrange
        Unit calculator = new Unit(10);

        // Act
        calculator.clear();

        // Assert
        assertEquals(0, calculator.result(), "Clearing should reset the state to 0");
    }

    // Test for chaining multiple operations
    @Test
    void testChainingOperations() {
        // Arrange
        Unit calculator = new Unit(10);

        // Act
        int result = calculator.add(5).subtract(3).multiply(2).result();

        // Assert
        assertEquals(24, result, "Chaining operations (10 + 5 - 3) * 2 should result in 24");
    }

    // Test for edge case: multiple additions
    @Test
    void testMultipleAdds() {
        // Arrange
        Unit calculator = new Unit(0);

        // Act
        int result = calculator.add(1).add(2).add(3).add(4).result();

        // Assert
        assertEquals(10, result, "Adding 1, 2, 3, 4 should result in 10");
    }

    // Test for subtracting into negative range
    @Test
    void testNegativeSubtraction() {
        // Arrange
        Unit calculator = new Unit(5);

        // Act
        int result = calculator.subtract(10).result();

        // Assert
        assertEquals(-5, result, "Subtracting 10 from 5 should result in -5");
    }

    // Test with large multiplication
    @Test
    void testLargeMultiplication() {
        // Arrange
        Unit calculator = new Unit(1000);

        // Act
        int result = calculator.multiply(2000).result();

        // Assert
        assertEquals(2_000_000, result, "Multiplying 1000 by 2000 should result in 2,000,000");
    }
}