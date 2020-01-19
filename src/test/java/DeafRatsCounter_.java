import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeafRatsCounter_ {
    @Test
    public void an_empty_string_should_return_zero_deaf_rats() {
        assertThat(countDeafRats("")).isEqualTo(0);
    }

    @Test
    public void just_a_pied_piper_and_a_deaf_rats_should_return_one_deaf_rats() {
        assertThat(countDeafRats("P ~O")).isEqualTo(1);
    }

    private int countDeafRats(String ratsOfHamelin) {
        if (ratsOfHamelin.length() == 0)
            return 0;
        return 1;
    }

}
