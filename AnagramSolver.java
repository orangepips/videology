import java.util.HashMap;
import java.util.Map;

public class AnagramSolver {
    public static boolean isAnagram(String a, String b) {
        a = a.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        b = b.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        return (getCharCounts(a).equals(getCharCounts(b)));
    }

    private static Map<Character, Integer> getCharCounts(String value) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (Character c : value.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }
        return counts;
    }

    public static void main(String... args) {
        String a = "A man’s rag";
        String b = "anagrams";

        System.out.println(isAnagram(a, b));

        String c = "test";
        String d = "wrong";

        System.out.println(isAnagram(c, d));

        String e = "Reach Excel Nettle";
        String f = "Excellent Teacher";

        System.out.println(isAnagram(e, f));
    }
}
