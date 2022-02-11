package kisok;
import java.util.ArrayList;
public class Main {
    public static ArrayList<String> addr = new ArrayList<String>();
    public static MyArrayList m = new MyArrayList();
    public static void multiCommandCheck(String command, MyArrayList m){
        String test = command;
        String delimiter = " ";
        String cmd = "";
        int place_holder = -1;
        String array[] = test.split(delimiter);
        for(int i = 0; i<array.length; i++){
            if(place_holder == 0){
                i --;
            }
            System.out.println(array[i]);
            if(array[i].equals("PP")||array[i].equals("P")|| array[i].equals("PZ") || array[i].equals("Q") ){
                //execute command
                m.add(array[i]);
                cmd = "";
            }else if(array[i].equals("B")|| array[i].equals("C") || array[i].equals("CP")){
                cmd = cmd+ array[i] + " ";

                int j = 0;
                for(j = i+1; j<array.length; j++){

                    if(array[j].equals("PP")||array[j].equals("P")|array[j].equals("B")|| array[j].equals("C") || array[j].equals("CP")|| array[j].equals("PZ")|| array[j].equals("Q") ){

                        break;
                    }

                    cmd = cmd + array[j]+" ";


                }
                m.add(cmd);
                if(array[j-1].equals("PP")||array[j-1].equals("PZ")||array[j-1].equals("Q")||array[j-1].equals("P") ){
                    m.add(array[j-1]);
                }
                place_holder = 0;
                i = j;


                cmd = "";
            }

        }

    }
    public static void main(String[] args) {
        multiCommandCheck("B 8/31/1978 Jane Doe 7/19/2022 9:15 middlesex CP 8/31/1978 Jane Doe",m);
        String[] arr = m.getArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
