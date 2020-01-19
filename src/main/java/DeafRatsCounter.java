public class DeafRatsCounter {
    public static final String LEFT_DEAF_RAT = "O~";
    public static final String RIGHT_DEAF_RAT = "~O";


    public static int countDeafRats(String roadOfRats) {
        if (roadOfRats.length() == 0)
            return 0;
        return sumDeafRatsInTheLeftAndRight(roadOfRats);
    }

    private static int sumDeafRatsInTheLeftAndRight(String roadOfRats) {
        return countDeafRatsOnTheLeft(deleteSpace(roadOfRats)) + countDeafRatsOnTheRight(deleteSpace(roadOfRats));
    }

    private static String deleteSpace(String roadOfRats) {
        return roadOfRats.replaceAll(" ", "");
    }

    private static int countDeafRatsOnTheLeft(String roadOfRats) {
        return deafRatsIn(getRatsOnTheLeft(roadOfRats), LEFT_DEAF_RAT);
    }

    private static int countDeafRatsOnTheRight(String roadOfRats) {
        return deafRatsIn(getRatsOnTheRight(roadOfRats), RIGHT_DEAF_RAT);
    }

    private static String getRatsOnTheRight(String roadOfRats) {
        return roadOfRats.substring(roadOfRats.indexOf("P") + 1);
    }

    private static String getRatsOnTheLeft(String roadOfRats) {
        return roadOfRats.substring(0, roadOfRats.indexOf("P"));
    }

    private static int deafRatsIn(String str, String deafRatOrientation) {
        if (str.length() < 2)
            return 0;
        if (str.substring(0, 2).contains(deafRatOrientation))
            return 1 + deafRatsIn(str.substring(2), deafRatOrientation);
        else
            return deafRatsIn(str.substring(2), deafRatOrientation);

    }
}