package config;

public class Config {

    private static final String ENV_PROPERTIES = PropertyReader.getProperties("common.properties").getProperty("env.properties.file");
    public static final String BROWSER = PropertyReader.getProperties("common.properties").getProperty("browser");
    public static final String URL= PropertyReader.getProperties(ENV_PROPERTIES).getProperty("url");
    public static final String CHROME_DRIVER_PATH = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("chrome.driver.path");

    public static final String CHROME_WEBDRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    public static final String FIREFOX_WEBDRIVER_SYSTEM_PROPERTY = "webdriver.gecko.driver";
    public static final int ZERO = 0;


    static{
        System.out.println("\n---------------------Config----------------------------------");
        System.out.println("   env properties file:        "+ ENV_PROPERTIES);
        System.out.println("   url:                        "+ URL);
        System.out.println("   browser:                    "+ BROWSER);
        System.out.println("------------------------------------------------------------\n");

    }

}
