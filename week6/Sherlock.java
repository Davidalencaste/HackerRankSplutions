import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        arr.add(0,0);
        arr.add(0);
        int i = 0;
        int j = n+1;
        int cSumL = arr.get(i);
        int cSumR = arr.get(j);
        while(j>=i+2){
            if(cSumL>cSumR){
                j--;
                cSumR += arr.get(j);    
            }else if(cSumL<cSumR){
                i++;
                cSumL += arr.get(i);
            }else{
                if(j==i+2){
                    return "YES";
                }else{
                    if(arr.get(j-1)==0){
                        j--;
                    }else{
                        i++;
                        cSumL += arr.get(i);
                        
                    }
                }
            }

        }
        return "NO";
    }

}

public class Sherlock {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());
        
        long startTime = System.nanoTime();

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.print( duration / 1_000_000.0);
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
