import java.util.*;

public class Main {
    public static int rank;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        makeCombination(word);
        System.out.println("Hello world");
    }
    public static void quickSort(Object[] mass, int left, int right) {
        if (right < left + 1) { return; }
        int fl = left, fr = right;
        char mid = mass[(left + right) / 2].toString().charAt(0);
        while (fl < fr) {
            while (mass[fl].toString().charAt(0) < mid) fl++;
            while (mass[fr].toString().charAt(0) > mid) fr--;
            if (fl <= fr) {
                Object temp = mass[fl];
                mass[fl] = mass[fr];
                mass[fr] = temp;
                fl++;
                fr--;
            }
        }
        quickSort(mass, left, fr);
        quickSort(mass, fl, right);
    }
    public static void makeCombination(String word) {
        int length = word.length();
        int right = -1;
        LinkedHashMap<Character, Integer> letList = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            char curCh = word.charAt(i);
            if (!letList.containsKey(curCh)) {
                letList.put(word.charAt(i), 1);
                right++;
            }
            else {
                letList.put(curCh, letList.get(curCh) + 1);
            }
        }
        Object[] letL = letList.entrySet().toArray();
        quickSort(letL, 0, right);
        letList = new LinkedHashMap<>();
        for (int i = 0; i <= right; i++) {
            String str = letL[i].toString();
            letList.put(str.charAt(0), Integer.parseInt(str.substring(2)));
        }
        generateWords(letList, length, new StringBuilder(), word);
    }
    public static void generateWords(LinkedHashMap<Character, Integer> map, int len, StringBuilder alrWord, String word) {
        if (alrWord.length() == len) {
            rank++;
            if (word.contentEquals(alrWord)) {
                System.out.println(rank);
                return;
            }
            return;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value > 0) {
                entry.setValue(value-1);
                alrWord.append(entry.getKey());
                generateWords(map, len, alrWord, word);
                entry.setValue(value);
                alrWord.deleteCharAt(alrWord.length() - 1);
            }
        }
    }
}