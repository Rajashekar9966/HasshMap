import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static String word = "bollo world";

    public static void main(String[] args) {
//        Find top K frequent elements
//        Input: [1, 1, 1, 2, 2, 3],K = 2 →Output: [1, 2]
        int k=4;
        int [] arr={1,1,1,2,2,3};
        Map<Integer,Integer> map=new HashMap<>();
        for (Integer i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()>=k){
                System.out.println(m.getKey()+"--"+m.getValue());
            }
        }


    }


    private static void checkAnagram() {
        //        Group anagrams together
//        Input: ["bat", "tab", "eat", "tea", "ate"] → Output: [[bat, tab], [eat, tea, ate]]
        String s1 = "vishal";
        String s2 = "shalvi";

        if (s1.length() != s2.length()) {
            System.out.println("Two strings are not same length so cannot form anagrams");
        } else {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            if (Arrays.equals(c1, c2))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    private static void DuplicateNumbers() {
        //        Find duplicates in a list of integers
//        Input: [1, 2, 3, 2, 4, 1] → Output: [1, 2]
        int[] arr = {1, 2, 2, 4, 8, 8, 4, 4, 3, 3, 5, 6, 7, 3};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > 1)
                System.out.println(m.getKey() + " " + m.getValue());
        }
        // System.out.println(map);
    }

    private static void firstNonRepeatingCharacter() {
        //        Find the first non-repeating character
//        Input: "swiss" → Output: 'w'

        HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        for (char c : Main.word.toCharArray()) {
//            if (c == ' ') continue;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            if (i.getValue() == 1) {
                System.out.println(i.getKey() + " " + i.getValue());
                break;
            }
        }
        System.out.println("using streams....");
        Map<Character, Long> freqMap = word.chars()
                .filter(c -> c != ' ') // optional: skip spaces
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        Optional<Map.Entry<Character, Long>> first = freqMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst();

        if (first.isPresent()) {
            System.out.println(first.get().getKey() + " " + first.get().getValue());
        }
    }


    private static void printAscii() {
        IntStream isw = Main.word.chars();
        System.out.println("printing ascii values using Iterator");
        Iterator<Integer> j = isw.iterator();

        while (j.hasNext()) {
            int ascii = j.next();
            char c = (char) ascii;
            System.out.print(ascii + " = " + c);
            System.out.println();
        }
    }

    private static void CharacterFrequency() {
        String word = "RajaShekar";
        //    Count character frequency in a string
//    Input:"hello world"
//    →Output:  {h = 1, e = 1, l = 3, o = 2, ...}

        HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        for (char c : word.toCharArray()) {
//            if (c == ' ') continue;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            System.out.println(i.getKey() + "--" + i.getValue());
        }
        System.out.println(map);
        System.out.println("using java - 8 streams");
        Map<Character, Long> freqMap = word.chars()
                .filter(c -> c != ' ') // optional: skip spaces
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        System.out.println(freqMap);

    }
}

