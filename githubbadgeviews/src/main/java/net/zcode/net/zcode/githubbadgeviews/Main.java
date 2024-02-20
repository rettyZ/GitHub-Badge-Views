package net.zcode.net.zcode.githubbadgeviews;

import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    static int added;

    //static String url = "https://camo.githubusercontent.com/5af1f7cebe015f69e22e39a962e579f42d746fcca950347cb1ad63456a85e1f1/68747470733a2f2f6b6f6d617265762e636f6d2f67687076632f3f757365726e616d653d426172746856697375616c73266c6162656c3d50726f66696c65253230766965777326636f6c6f723d306537356236267374796c653d666c6174";

    static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        

        System.out.println("Number:");
        String numberInput = userInput.nextLine();

        System.out.println("Url:");
        String urlInput = userInput.nextLine();

        // System.out.println("Proxy file location:");
        // String proxyLocInput = userInput.nextLine();

        getViews(Integer.parseInt(numberInput), urlInput/*,proxyLocInput*/);

    }

    private static void getViews(int number, String url/*, String proxyLocInput*/) {
        while(number > added){
            
            try{
                added++;

                // PROXY START
                
                // File file = new File(proxyLocInput); 
                // final RandomAccessFile f = new RandomAccessFile(file, "r");
                // final long randomLocation = (long) (Math.random() * f.length());
                // f.seek(randomLocation);
                // f.readLine();
                // String randomLine = f.readLine();

                // String[] parts = randomLine.split(":");
                // String part1 = parts[0];
                // String part2 = parts[1];

                // Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(part1, Integer.parseInt(part2)));

                // PROXY END

                URLConnection openConnection = new URL(url).openConnection(/* usun se jak nie chcesz proxy nie */ /*proxy*/);
                openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
                openConnection.connect();

                System.out.println("Number variable: " + number + " Added variable:" + added);

                @SuppressWarnings("resource")
                Scanner scan = new Scanner((new InputStreamReader(openConnection.getInputStream())));
                scan.nextLine();

                //f.close();
            }
            catch (Exception ex){
                ex.printStackTrace();

                added--;
            }
        }
    }
}