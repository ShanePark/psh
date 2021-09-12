import com.tistory.shanepark.NumberUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilTest {

    @Test
    void parseInt() {
        assertEquals(3, NumberUtil.parseInt("3"));
        assertEquals(0, NumberUtil.parseInt("오류 가자~"));
        assertEquals(10, NumberUtil.parseInt("010"));
    }
}