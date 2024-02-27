package domain.prize;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "12345678901"})
    void 상품명의_길이가_1보다_작거나_10보다_크면_예외가_발생한다(String name) {
        // when & then
        assertThatThrownBy(() -> new Prize(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1234567890"})
    void 상품명의_길이가_0보다_크고_10보다_작으면_예외가_발생하지_않는다(String name) {
        // when & then
        assertThatCode(() -> new Prize(name))
                .doesNotThrowAnyException();
    }
}
