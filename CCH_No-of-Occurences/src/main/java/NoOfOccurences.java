import java.util.*;

public class NoOfOccurences {

    public static void main(String[] args){
        System.out.println("Enter sequence of letters to sort (Eg. aAaxbyxc)");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(findOccurences(input));
    }

    public static String findOccurences(String text){
        HashMap<String,Integer> occurences = new HashMap<>();

        text = text.toLowerCase();
        String[] letters = text.split("");

        for(String letter : letters){
            if(letter.charAt(0) < 97 || letter.charAt(0) > 122){
                return "Please enter valid sequence of letters";
            }
            if(LinearSearch(occurences,letter)){
                occurences.put(letter, occurences.get(letter) +1);
            }else{
                occurences.put(letter,1);
            }
        }
        List<String> sortedKeys =new ArrayList<String>(occurences.keySet());
        sortList(sortedKeys,0,sortedKeys.size() - 1);

        String outputString = "";
        for(String s : sortedKeys){
            outputString += String.format("%s - %d\n",s,occurences.get(s));
        }
        return outputString;
    }

    public static boolean LinearSearch(HashMap map, String searchLetter){
        List<String> keys = new ArrayList<String>(map.keySet());

        for (String key : keys) {
            if (key.equals(searchLetter)) {
                return true;
            }
        }
        return false;
    }

    public static void sortList(List<String> list, int initIndex, int finalIndex) {

        if (initIndex < finalIndex) {
            int midIndex = initIndex + (finalIndex - initIndex) / 2;

            sortList(list, initIndex, midIndex);
            sortList(list, midIndex + 1, finalIndex);

            merge(list, initIndex, midIndex, finalIndex);

        }
    }

    public static void merge(List<String> list, int initIndex, int middleIndex, int finalIndex) {
        int sizeOfLeftArray = middleIndex - initIndex + 1;
        int sizeOfRightArray = finalIndex - middleIndex;

        String[] tempLeftArray = new String[sizeOfLeftArray];
        String[] tempRightArray = new String[sizeOfRightArray];

        for (int i = 0; i < sizeOfLeftArray; i++) {
            tempLeftArray[i] = list.get(initIndex + i);
        }
        for (int j = 0; j < sizeOfRightArray; j++) {
            tempRightArray[j] = list.get(middleIndex + 1 + j);
        }

        int i = 0;
        int j = 0;
        int k = initIndex;

        while (i < sizeOfLeftArray && j < sizeOfRightArray) {
            if (tempLeftArray[i].charAt(0) <= tempRightArray[j].charAt(0)) {
                list.set(k, tempLeftArray[i]);
                i++;
            } else {
                list.set(k, tempRightArray[j]);
                j++;
            }
            k++;
        }

        while (i < sizeOfLeftArray) {
            list.set(k, tempLeftArray[i]);
            i++;
            k++;
        }
        while (j < sizeOfRightArray) {
            list.set(k, tempRightArray[j]);
            j++;
            k++;
        }
    }

}
