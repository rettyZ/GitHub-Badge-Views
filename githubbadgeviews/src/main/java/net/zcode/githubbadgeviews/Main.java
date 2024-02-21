package net.zcode.githubbadgeviews;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

    static int added;
    static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Number:");
        String numberInput = userInput.nextLine();

        System.out.println("Url:");
        String urlInput = userInput.nextLine();

        getViews(Integer.parseInt(numberInput), urlInput);
    }

    private static void getViews(int number, String url) {
        while(number > added){
            try{
                URLConnection openConnection = new URL(url).openConnection();
                openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
                openConnection.connect();

                System.out.println("Number variable: " + number + " Added variable:" + added);

                @SuppressWarnings("resource")
                Scanner scan = new Scanner((new InputStreamReader(openConnection.getInputStream())));
                scan.nextLine();

                added++;
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}