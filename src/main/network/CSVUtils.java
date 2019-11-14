package network;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("./data/FoodDataStatCan.txt", "UTF-8");
        String theURL = "https://www150.statcan.gc.ca/t1/tbl1/en/dtl!downloadDbLoadingData-nonTraduit.action?pid=1810000201&latestN=5&startDate=&endDate=&csvLocale=en&selectedMembers=%5B%5B1%5D%2C%5B12%2C53%2C29%2C44%2C35%2C56%2C1%2C16%2C59%2C24%2C43%2C6%2C10%2C38%2C55%2C31%2C41%2C48%2C60%2C21%2C28%2C22%2C5%2C54%2C18%2C45%2C27%2C36%2C42%2C7%2C58%2C15%2C17%2C40%2C39%2C4%2C47%2C19%2C37%2C61%2C23%2C62%2C20%2C57%2C33%2C34%2C11%2C2%2C3%2C25%2C9%2C46%5D%5D";
        URL url = new URL(theURL);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        try {
            while (true) {
                List<String> line = parseLine(br.readLine());
                System.out.println("Food [name = " + line.get(3) + " , price=" + line.get(10) + "]");
                String dataWanted = "2019-05";
                if (line.get(0).equals(dataWanted)) {
                    writer.println(line.get(3) + " " + line.get(10));
                }

            }
        } finally {
            br.close();
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }

}
