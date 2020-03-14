package com.zwk.learn.fileCopy.bufferedStream;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class UseBufferedReaderWriter {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String msg = "";
            while (!msg.equals("exit")) {
                msg = bufferedReader.readLine();
                bufferedWriter.write(msg);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        getUrl();
        downloadUrl();
    }

    public static void getUrl() {
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("https://www.baidu.com").openStream(), "UTF-8"))) {
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.print(msg);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadUrl() {
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("https://www.baidu.com").openStream(), "UTF-8"));
             BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new OutputStreamWriter(new FileOutputStream("C:Users/LWK/Desktop/a.html"), "UTF-8"))) {
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                bufferedWriter.write(msg);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

