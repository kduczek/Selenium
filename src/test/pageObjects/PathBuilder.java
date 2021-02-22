public class PathBuilder {
    private static final String SELENIUM_EASY_ADDRESS = "https://www.seleniumeasy.com/test/";

    public static String createPath(String subPage) {
        return SELENIUM_EASY_ADDRESS + subPage;
    }
}
