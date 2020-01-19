import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeafRatsCounter_ {
    @Test
    public void an_empty_string_should_return_zero_deaf_rats() {
        assertThat(countDeafRats("")).isEqualTo(0);
    }

    @Test
    public void a_pied_piper_and_a_deaf_rats_should_return_one_deaf_rats() {
        assertThat(countDeafRats("P ~O")).isEqualTo(1);
    }

    @Test
    public void a_pied_piper_and_two_deaf_rats_should_return_two_deaf_rats() {
        assertThat(countDeafRats("P ~O ~O")).isEqualTo(2);
    }

    private int countDeafRats(String ratsOfHamelin) {
        if (ratsOfHamelin.length() == 0)
            return 0;
        return deafRats(ratsOfHamelin.substring(ratsOfHamelin.indexOf("P")));
    }

    private int deafRats(String str) {
        if (str.contains("~O"))
            return 1 + deafRats(str.substring(str.indexOf("~O")+2));
        return 0;
    }

}
