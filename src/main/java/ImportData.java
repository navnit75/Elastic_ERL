import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a helper class for file reading and line number reading
 */
class ImportData {
    /**
     * This function returns the number of lines a files has
     * @param filename : File name to be read
     * @return int : Number of lines in the file
     */
    public int numberOfLines(String filename){
        int lines = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                myReader.nextLine();
                lines++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return lines;
    }

    /**
     * This function ElasticERL<Node> based on the data read from file
     * @param filename : File name to be read
     * @return ElasticERL<Node> : ADT containing the data
     */
    public ElasticERL<Node> addData(String filename){
        ElasticERL<Node> arr = new ElasticERL<Node>();
        arr.SetEINThreshold(numberOfLines(filename));


        try {

            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String tempString = myReader.nextLine();
                Node temp = new Node(tempString,"#EIN: " + tempString);
                arr.add(temp);
            }
            myReader.close();
        } catch (
            FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return arr;
    }
}