package network;
//shamelessly quoting from: http://zetcode.com/articles/javareadwebpage/

import model.NonFood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadWebPageEx {

    public static void main(String[] args) throws MalformedURLException, IOException {

        BufferedReader br = null;

        PrintWriter writer = new PrintWriter("./data/FoodDataStatCan.txt", "UTF-8");


        try {
            String theURL = "https://www150.statcan.gc.ca/t1/tbl1/en/dtl!downloadDbLoadingData-nonTraduit.action?pid=1810000201&latestN=5&startDate=&endDate=&csvLocale=en&selectedMembers=%5B%5B1%5D%2C%5B12%2C53%2C29%2C44%2C35%2C56%2C1%2C16%2C59%2C24%2C43%2C6%2C10%2C38%2C55%2C31%2C41%2C48%2C60%2C21%2C28%2C22%2C5%2C54%2C18%2C45%2C27%2C36%2C42%2C7%2C58%2C15%2C17%2C40%2C39%2C4%2C47%2C19%2C37%2C61%2C23%2C62%2C20%2C57%2C33%2C34%2C11%2C2%2C3%2C25%2C9%2C46%5D%5D"; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();
            int lineNum = 0;
            String dataWanted = "2019-05";
            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());

                String[] row = line.split(",");
                String dateToCompare = row[0].substring(1, row[0].length() - 1);
                if (lineNum >= 1 && dateToCompare.equals(dataWanted)) {
                    System.out.println(row[0] + lineNum);
                    writer.println(row[3].substring(1, row[3].length()) + " " + row[11].substring(1, row[11].length() - 1));
                }

                lineNum = lineNum + 1;

            }

            System.out.println(sb);
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (br != null) {
                br.close();
            }
        }
    }
}