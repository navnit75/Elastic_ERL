/**
 * Driver code for the ElasticERL
 */
public class Main{
    public static final String p_folderLocation = "src/main/resources/input/";
    public static void main(String args[]){
        System.out.println("=============TEST1========================");
//        test1();
        System.out.println("=============TEST2========================");
//        test2();
        System.out.println("=============TEST3========================");
//        test3();
        System.out.println("=============TEST4========================");
        test4();
        System.out.println("=============TEST5========================");
        test5();
        System.out.println("=============TEST6========================");
        test6();
        System.out.println("=============TEST7========================");
        test7();
        System.out.println("=============TEST8========================");
        test8();
        System.out.println("=============TEST9========================");
        test9();
    }
    /**
     * Tests the input from EHITS_test_file1.txt
     */
    public static void test1(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file1.txt");

        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("03322773",""),new Node("75249794",""));
        System.out.println("Range Keys from 03322773 to 75249794: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("75249794","#EIN: 75249794"));
        System.out.println("getValue for : 75249794");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("75249794","#EIN: 75249794"));
        System.out.println("getNextKey for : 75249794 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("75249794","#EIN: 75249794"));
        System.out.println("getPrevKey for : 75249794 ");
        System.out.println(element);
        System.out.println();
    }

    /**
     * Tests the input from EHITS_test_file2.txt
     */
    public static void test2(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file2.txt");


        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("22439726",""),new Node("46346726",""));
        System.out.println("Range Keys from 22439726 to 46346726: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("46346726","#EIN: 46346726"));
        System.out.println("getValue for : 46346726");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("46346726","#EIN: 46346726"));
        System.out.println("getNextKey for : 46346726 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("46346726","#EIN: 46346726"));
        System.out.println("getPrevKey for : 46346726 ");
        System.out.println(element);
        System.out.println();
    }

    /**
     * Tests the input from EHITS_test_file3.txt
     */
    public static void test3(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file3.txt");


        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("14448795",""),new Node("36657715",""));
        System.out.println("Range Keys from 14448795 to 36657715: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("36657715","#EIN: 36657715"));
        System.out.println("getValue for : 36657715");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("36657715","#EIN: 36657715"));
        System.out.println("getNextKey for : 36657715 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("36657715","#EIN: 36657715"));
        System.out.println("getPrevKey for : 36657715 ");
        System.out.println(element);
        System.out.println();
    }

    /**
     * Tests the input from EHITS_test_file5.txt
     */
    public static void test4(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file5.txt");


        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("06893971",""),new Node("33248386",""));
        System.out.println("Range Keys from 06893971 to 33248386: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("33248386","#EIN: 33248386"));
        System.out.println("getValue for : 33248386");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("33248386","#EIN: 33248386"));
        System.out.println("getNextKey for : 33248386 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("33248386","#EIN: 33248386"));
        System.out.println("getPrevKey for : 33248386 ");
        System.out.println(element);
        System.out.println();
    }

    /**
     * Tests the input from EHITS_test_file6.txt
     */
    public static void test5(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file6.txt");


        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("15485764",""),new Node("33279693",""));
        System.out.println("Range Keys from 15485764 to 33279693: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("33279693","#EIN: 33279693"));
        System.out.println("getValue for : 33279693");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getNextKey for : 33279693 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getPrevKey for : 33279693 ");
        System.out.println(element);
        System.out.println();
    }

    /**
     * Tests the input from EHITS_test_file7.txt
     */
    public static void test6(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file7.txt");;


        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("15485764",""),new Node("33279693",""));
        System.out.println("Range Keys from 15485764 to 33279693: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("33279693","#EIN: 33279693"));
        System.out.println("getValue for : 33279693");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getNextKey for : 33279693 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getPrevKey for : 33279693 ");
        System.out.println(element);
        System.out.println();
    }

    /**
     * Tests the input from EHITS_test_file8.txt
     */
    public static void test7(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file8.txt");


        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("15485764",""),new Node("33279693",""));
        System.out.println("Range Keys from 15485764 to 33279693: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("33279693","#EIN: 33279693"));
        System.out.println("getValue for : 33279693");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getNextKey for : 33279693 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getPrevKey for : 33279693 ");
        System.out.println(element);
        System.out.println();
    }

    /**
     * Tests the input from EHITS_test_file9.txt
     */
    public static void test8(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file9.txt");


        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("15485764",""),new Node("33279693",""));
        System.out.println("Range Keys from 15485764 to 33279693: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("33279693","#EIN: 33279693"));
        System.out.println("getValue for : 33279693");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getNextKey for : 33279693 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getPrevKey for : 33279693 ");
        System.out.println(element);
        System.out.println();
    }

    /**
     * Tests the input from EHITS_test_file10.txt
     */
    public static void test9(){
        ImportData data = new ImportData();
        ElasticERL<Node> est = data.addData(p_folderLocation + "EHITS_test_file10.txt");


        System.out.println("Generated Value : ");
        System.out.println(est.generate());
        System.out.println();

        ArraySequence<Node> arr = est.getAllKeys();
        System.out.println("All Keys: ");
        System.out.println(arr);
        System.out.println();

        arr = est.rangeKey(new Node("15485764",""),new Node("33279693",""));
        System.out.println("Range Keys from 15485764 to 33279693: ");
        System.out.println(arr);
        System.out.println();

        Node n1 = new Node("00000019","#EIN: 00000019");
        est.add(n1);
        arr = est.getAllKeys();
        System.out.println("Add ");
        System.out.println(arr);
        System.out.println();

        est.remove(n1);
        arr = est.getAllKeys();
        System.out.println("Remove ");
        System.out.println(arr);
        System.out.println();

        Node element = est.getValues(new Node("33279693","#EIN: 33279693"));
        System.out.println("getValue for : 33279693");
        System.out.println(element);
        System.out.println();

        element = est.getNextKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getNextKey for : 33279693 ");
        System.out.println(element);
        System.out.println();

        element = est.getPrevKey(new Node("33279693","#EIN: 33279693"));
        System.out.println("getPrevKey for : 33279693 ");
        System.out.println(element);
        System.out.println();
    }
}
