import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.kirillakhmetov.work.matrix.Main;

import java.util.Arrays;

public class TestMatrix {
    @Test
    public void testCompareString() {
        Integer[] arr = {10, 100, 23, 3, 34, 8, 80};
        Integer[] arr2 = {10, 8, 80, 100, 23, 34, 3};
        Arrays.sort(arr2, new Main.IntComparator());
        Assert.assertArrayEquals(arr, arr2);
    }
}
