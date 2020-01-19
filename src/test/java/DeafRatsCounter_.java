import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeafRatsCounter_ {

    public static final String LEFT_DEAF_RAT = "O~";
    public static final String RIGHT_DEAF_RAT = "~O";

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

    @Test
    public void a_pied_piper_and_one_deaf_rats_on_each_side_should_return_two_deaf_rats() {
        assertThat(countDeafRats("O~ P ~O")).isEqualTo(2);
    }

    private int countDeafRats(String ratsOfHamelin) {
        if (ratsOfHamelin.length() == 0)
            return 0;
        return countDeafRats(ratsOfHamelin.substring(0,ratsOfHamelin.indexOf("P")), LEFT_DEAF_RAT) + countDeafRats(ratsOfHamelin.substring(ratsOfHamelin.indexOf("P")+1).trim(), RIGHT_DEAF_RAT);
    }

    private int countDeafRats(String str, String deafRat) {
        if (str.contains(deafRat))
            return 1 + countDeafRats(str.substring(str.indexOf(deafRat)+2),deafRat);


        return 0;
    }



}
