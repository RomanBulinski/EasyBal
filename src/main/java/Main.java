import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static String data =
            "1000.00\n125 Market 125.45\n126 Hardware 34.95\n127 Video 7.45\n128 Book 14.32\n129 Gasoline 16.10";


    public static String balance(String book) {

        String result = "Original_Balance:_";
        String[] lines = book.split("\n");
        double total = Double.valueOf(lines[0]);
        result = result + String.valueOf(total)+"\n";

        for(int i = 1; i<lines.length; i++){
            String[] items = lines[i].split(" ");

            List<String> itemsList = new ArrayList<String>();

            for(int z = 0; z<items.length; z++ ){
                itemsList.add(items[z]);
            }
            String price = itemsList.get(itemsList.size()-1);
            itemsList.add("Balance");
            itemsList.add( String.valueOf(total-(Double.valueOf(price) )) );
            String temp = "";
            for(int j =0; j<itemsList.size(); j++){
                temp = temp + itemsList.get(j)+"_";
            }
            temp = temp.substring(0,temp.length()-1);
            temp = temp + "\n";
            result = result + temp;
        }
        return  result;
    }

    public static void main(String[] args) {

        System.out.println(data);

        System.out.println("-------------------------------------------");
        System.out.println(balance(data));


    }


}

