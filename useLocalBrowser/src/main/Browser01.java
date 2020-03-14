package main;

import java.io.IOException;

public class Browser01 {
    private BrowserType browserType;

    public Browser01(BrowserType browserType) {
        this.browserType = browserType;
    }

    public void openUrl(String uri) {
        ProcessBuilder processBuilder = null;
        switch (browserType) {
            case BROWSER_TYPE_IE:
                processBuilder = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe",
                        uri);
                break;
            case BROWSER_TYPE_CHROME:
                processBuilder = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe",
                        uri);
                break;
            case BROWSER_TYPE_QQBrowser:
                processBuilder = new ProcessBuilder("F:\\Program Files (x86)\\Tencent\\QQBrowser\\QQBrowser.exe",
                        uri);
                break;
        }
        if (processBuilder != null) {
            try {
                processBuilder.start();
            } catch (IOException e) {

            }
            return;
        }
        throw new IllegalArgumentException("浏览器类型未选择");
    }
}
