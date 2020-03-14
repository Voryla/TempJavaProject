package main;

public class Main {
    public static void main(String[] args) {
        String  uri="http://www.baidu.com";
        Browser01 browser01=new Browser01(BrowserType.BROWSER_TYPE_QQBrowser);
        browser01.openUrl(uri);
        Browser02 browser02=new Browser02();
        browser02.openUrl(uri);
    }
}
