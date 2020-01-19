import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeafRatsCounter_ {

    private final DeafRatsCounter deafRatsCounter = new DeafRatsCounter();

    @Test
    public void an_empty_string_should_return_zero_deaf_rats() {
        assertThat(deafRatsCounter.countDeafRats("")).isEqualTo(0);
    }

    @Test
    public void a_pied_piper_and_a_deaf_rats_should_return_one_deaf_rats() {
        assertThat(deafRatsCounter.countDeafRats("P ~O")).isEqualTo(1);
    }

    @Test
    public void a_pied_piper_and_two_deaf_rats_should_return_two_deaf_rats() {
        assertThat(deafRatsCounter.countDeafRats("P ~O ~O")).isEqualTo(2);
    }

    @Test
    public void a_pied_piper_and_one_deaf_rats_on_each_side_should_return_two_deaf_rats() {
        assertThat(deafRatsCounter.countDeafRats("O~ P ~O")).isEqualTo(2);
    }

    @Test
    public void a_pied_piper_and_zero_deaf_rats_on_the_left_side_and_two_deaf_rats_on_the_right_side_should_return_two_deaf_rats() {
        assertThat(deafRatsCounter.countDeafRats("~O~O~O~OP~O~OO~")).isEqualTo(2);
    }
}
