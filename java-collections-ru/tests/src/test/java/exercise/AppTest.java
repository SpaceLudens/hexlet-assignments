package exercise;

import static exercise.App.take;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        var actual = take(list, 4);
        assertThat(actual).isEqualTo(expected);
        // END
    }
}
