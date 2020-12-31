package core;

public class Logger {
    private static final org.apache.log4j.Logger LOG4J = org.apache.log4j.Logger.getLogger(Logger.class);
    private static Logger instance = null;

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String message) {
        LOG4J.info(message);
    }

    public void warn(String message) {
        LOG4J.warn(message);
    }

    /**
     * This method is using for formatting almost all log records
     *
     * @param msg Formatted message
     */
    public void step(final String msg) {
        info(msg);
    }

    public void logTestName(final String testName) {
        String formattedName = String.format("=====================  Test case: '%s' =====================", testName);

        String delims = "";
        int nChars = formattedName.length();
        for (int i = 0; i < nChars; i++) {
            delims += "-";
        }
        info(delims);
        info(formattedName);
        info(delims);
    }

    public void logTestEnd(final String testName) {
        info("");
        String formattedEnd = String.format("***** Test case: '%s' Passed *****", testName);
        String stars = "";
        int nChars = formattedEnd.length();
        for (int i = 0; i < nChars; i++) {
            stars += "*";
        }
        info(stars);
        info(formattedEnd);
        info(stars);
        info("");
    }
}
