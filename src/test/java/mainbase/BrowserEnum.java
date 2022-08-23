package mainbase;

public enum BrowserEnum {
    CHROME("chrome"), FIREFOX("firefox"), EDGE("edge"),CHROMEHEADLESS("chromeheadless"),EDGEHEADLESS("edgeheadless"),FIREFOXHEADLESS("firefoxheadless");
    private String browserName;

    BrowserEnum(String browserName) {
        this.browserName = browserName;
    }

    String getName() {
        return browserName;
    }
}
