import java.util.ArrayList;

import java.util.List;

public class Main {

    static String data =
            "1000.00\n125 Market 125.45\n126 Hardware 34.95\n127 Video 7.45\n128 Book 14.32\n129 Gasoline 16.10";

    public static String balance(String book) {

        String result = "Original Balance: ";
        double totalExpense = 0;
        double averageExpense;
        int counter =0;
        String startBook = book;
        startBook = startBook.replaceAll("\\?","");
        startBook = startBook.replaceAll("\\{}","");

        String[] signs = {"!","=","+",":","_",",",";"};

        for( String s :signs   ){
            if( startBook.contains(s) ){
                startBook = startBook.replaceAll(s,"");
            }
        }
        String[] lines = startBook.split("\n");
        double totalStart = Double.valueOf(lines[0]);
        double balance = totalStart;
        String totalStartS = String.format("%.2f", totalStart);
        result = result + totalStartS+"\\r\\n";

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
            balance =  Math.round(balance*100)/100D;

            itemsList.add( String.format("%.2f", balance) );
            String temp = "";
            for(int j =0; j<itemsList.size(); j++){
                temp = temp + itemsList.get(j)+" ";
            }
            temp = temp.substring(0,temp.length()-1)+"\\r\\n";
            result = result + temp;
        }

        averageExpense = totalExpense/counter;
        String totalString = String.format("%.2f", (Math.round(totalExpense * 100.0) / 100.0));
        result = result + "Total expense  "+     totalString    +"\\r\\n";
        result = result + "Average expense  "+(Math.round(averageExpense * 100.0) / 100.0);
        return  result;
    }

    public static void main(String[] args) {

        String b2 = "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n" +
                "123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?";



    }


}

