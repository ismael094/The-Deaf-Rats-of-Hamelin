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

    @Test
    public void a_pied_piper_and_zero_deaf_rats_on_the_left_side_and_two_deaf_rats_on_the_right_side_should_return_two_deaf_rats() {
        assertThat(countDeafRats("~O~O~O~OP~O~OO~")).isEqualTo(2);
    }

    private int countDeafRats(String roadOfRats) {
        if (roadOfRats.length() == 0)
            return 0;
        return sumDeafRatsInTheLeftAndRight(roadOfRats);
    }

    private int sumDeafRatsInTheLeftAndRight(String roadOfRats) {
        return countDeafRatsOnTheLeft(deleteSpace(roadOfRats)) + countDeafRatsOnTheRight(deleteSpace(roadOfRats));
    }

    private String deleteSpace(String roadOfRats) {
        return roadOfRats.replaceAll(" ", "");
    }

    private int countDeafRatsOnTheLeft(String roadOfRats) {
        return countDeafRats(getRatsOnTheLeft(roadOfRats), LEFT_DEAF_RAT);
    }

    private int countDeafRatsOnTheRight(String roadOfRats) {
        return countDeafRats(getRatsOnTheRight(roadOfRats), RIGHT_DEAF_RAT);
    }

    private String getRatsOnTheRight(String roadOfRats) {
        return roadOfRats.substring(roadOfRats.indexOf("P")+1);
    }

    private String getRatsOnTheLeft(String roadOfRats) {
        return roadOfRats.substring(0,roadOfRats.indexOf("P"));
    }

    private int countDeafRats(String str, String deafRat) {
        if (str.length() < 2)
            return 0;
        if (str.substring(0,2).contains(deafRat))
            return 1 + countDeafRats(str.substring(2),deafRat);
         else
            return countDeafRats(str.substring(2),deafRat);

    }



}
