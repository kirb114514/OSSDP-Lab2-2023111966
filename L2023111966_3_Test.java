import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class L123456_3_Test {
    
    @Test
    public void testSortWithPositiveAndNegativeNumbers() {
        int[] input = {3, -1, 2, -5, 0};
        int[] expected = {-5, -1, 0, 2, 3};
        SortAlgorithm.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        SortAlgorithm.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortAlreadySorted() {
        int[] input = {-5, 0, 2, 3};
        int[] expected = {-5, 0, 2, 3};
        SortAlgorithm.sort(input);
        assertArrayEquals(expected, input);
    }


    @Test
    public void testSortAllSameElements() {
        int[] input = {5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5};
        SortAlgorithm.sort(input);
        assertArrayEquals(expected, input);
    }
}
