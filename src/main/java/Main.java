import java.util.ArrayList;

import java.util.List;

public class Main {
    

    public static String balance(String book) {

        StringBuilder result = new StringBuilder();
        result.append("Original Balance: ");
        double totalExpense = 0;
        double averageExpense;
        int counter =0;

        String[] lines = book.replaceAll("[^a-zA-Z0-9\n. ]", "").split("\n+");

        double totalStart = Double.valueOf(lines[0]);
        double balance = totalStart;
        String totalStartS = String.format("%.2f", totalStart);
        result.append(totalStartS).append("\\r\\n");

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
            result.append(temp);
        }

        averageExpense = totalExpense/counter;
        String totalString = String.format("%.2f", (Math.round(totalExpense * 100.0) / 100.0));
        String averageString = String.format("%.2f", (Math.round(averageExpense * 100.0) / 100.0));

        return  result.append("Total expense  ")
                .append(totalString).append("\\r\\n")
                .append("Average expense  ")
                .append(averageString)
                .toString();

    }



}

