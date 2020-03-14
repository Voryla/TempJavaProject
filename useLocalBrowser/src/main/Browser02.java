package main;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class Browser02 {
    private BrowserType browserType;

    public void openUrl(String uri) {
        URI uriCmd = URI.create(uri);
        Desktop dp = Desktop.getDesktop();
        if (dp.isSupported(Desktop.Action.BROWSE)) {
            try {
                dp.browse(uriCmd);
                return;
            } catch (IOException e) {

            }
        }
        throw new IllegalArgumentException("浏览器类型未选择");
    }
}

