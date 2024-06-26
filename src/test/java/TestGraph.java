import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.kirillakhmetov.work.graphs.Main;

import java.util.LinkedList;
import java.util.List;

public class TestGraph {

    @Test
    public void testReadFileCorrect() {
        List<String> list = new LinkedList<>(List.of("Я", "Питер", "Екатерина",
                "Лёха", "Артём", "программирование",
                "Java", "python",
                "OOP"));
        List<String> listResult = new LinkedList<>(Main.readFile("file1"));
        Assert.assertArrayEquals(list.stream().sorted().toArray(), listResult.stream().sorted().toArray());
    }

    @Test
    public void testReadFileError() {
        Assert.assertThrows(RuntimeException.class, () -> Main.readFile("txt"));
    }
}
