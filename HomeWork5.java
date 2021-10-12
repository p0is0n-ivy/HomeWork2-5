import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork5 {
    public static void main(String[] args) {
        String[] header;
        Integer[][] data;
        header = new String[]{"Value 1", "Value 2", "Value 3"};
        data = new Integer[][]{{100, 200, 123}, {300, 400, 500}};
        save(header, data);
        read("Table.txt", header, data);

    }

    private static String builderString1(String[] header) {
        StringBuffer str1 = new StringBuffer();
        for (int i = 0; i < header.length; i++) {
            str1.append(header[i]);
            str1.append(";");
        }
        String string1 = str1.toString();
        string1 = string1.substring(0, string1.length() - 1);
        return string1;
    }

    private static String builderString2(Integer[][] data) {
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        for (Integer[] row : data) {
            sb.append(Arrays.toString(row)).append(lineSeparator);
        }
        String string = sb.toString();
        String stringData = string.replace(", ", ";");
        stringData = stringData.replace("[", "");
        stringData = stringData.replace("]", "");
        return stringData;
    }

    public static void save(String[] header, Integer[][] data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Table.txt"))) {
            bufferedWriter.write(builderString1(header));
            bufferedWriter.newLine();
            bufferedWriter.write(builderString2(data));
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void read(String fileName, String[] header, Integer[][] data) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Table.txt"))) {
           header = bufferedReader.readLine().split(";");
           System.out.println(String.join(";", header));
           String line;
           ArrayList<Integer[]> arrayList = new ArrayList<>();
           while ((line = bufferedReader.readLine()) != null) {
               arrayList.add(toIntArrayData(line));
               System.out.println(line);
           }
           data = arrayList.toArray(new Integer[][]{});

           } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Integer[] toIntArrayData (String str){
        String[] stringArray = str.split(";");
        Integer [] intArray = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

}






