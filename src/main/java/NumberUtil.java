public class NumberUtil {

    /**
     * parse String to int and return the number
     * if it occurs NumberFormatException then return 0
     *
     * @param args
     * @return
     */
    public static int parseInt(String args) {
        int number;
        try {
            number = Integer.parseInt(args);
        } catch (NumberFormatException e) {
            number = 0;
        }
        return number;
    }

}
