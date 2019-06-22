import java.util.ArrayList;

import java.util.List;

public class Main {

    static String data =
            "1000.00\n125 Market 125.45\n126 Hardware 34.95\n127 Video 7.45\n128 Book 14.32\n129 Gasoline 16.10";

    public static String balance(String book) {

        double totalExpense = 0;
        double averageExpense;
        int counter =0;
        String startBook = book;
        String[] signs = {"!","=","+",":","_"};
        for( String s :signs   ){
            if( startBook.contains(s) ){
                startBook = startBook.replaceAll(s," ");
            }
        }
        if( startBook.contains("  ") ){
            startBook = startBook.replaceAll("  "," ");
        }
        if( startBook.contains("  ") ){
            startBook = startBook.replaceAll("  "," ");
        }
        String result = "Original Balance: ";
        String[] lines = startBook.split("\n");
        double total = Double.valueOf(lines[0]);
//        double roundTotal = (Math.round(total * 100.0) / 100.0);
        double balance = total;
        String roundTotal = String.format("%.2f", total);
        result = result + roundTotal+"\\r\\n";

        for(int i = 1; i<lines.length; i++){
            String[] items = lines[i].split(" ");
            List<String> itemsList = new ArrayList<String>();
            for(String s: items ){
                itemsList.add(s);
            }
            String price = itemsList.get(itemsList.size()-1);
            totalExpense = totalExpense + (Double.valueOf(price));
            counter++;
            itemsList.add("Balance");
            balance = balance - Double.valueOf(price);
            itemsList.add( String.valueOf(   (Math.round((balance * 100.0) / 100.0)     )) );
            String temp = "";
            for(int j =0; j<itemsList.size(); j++){
                temp = temp + itemsList.get(j)+" ";
            }
            temp = temp.substring(0,temp.length()-1)+"\\r\\n";
            result = result + temp;
        }
        averageExpense = totalExpense/counter;
        result = result + "Total expense  "+(Math.round(totalExpense * 100.0) / 100.0)+"\\r\\n";
        result = result + "Average expense  "+(Math.round(averageExpense * 100.0) / 100.0);
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(data);
        System.out.println("-------------------------------------------");
        System.out.println(balance(data));
    }


}

