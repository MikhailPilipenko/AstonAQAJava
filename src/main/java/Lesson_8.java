import java.util.*;

public class Lesson_8 {
    public static void main(String[] args) {
        //task 1
        String[] words = new String[] {"aston", "java", "android", "react", "angular",
                                        "node", "python", "golang", "ruby", "net",
                                        "scala", "aston", "selenium", "java", "aston",
                                        "aston", "android", "java", "aston", "selenium"};

        Set<String> setList = new HashSet<>(Arrays.asList(words));

        System.out.println("Original array from " +words.length + " words: \n" + Arrays.toString(words));
        System.out.println("Unique " + setList.size() + " words from the original array: \n" + setList);

        HashMap<String, Integer> map = new HashMap<>();

        for (String element : setList) {
            map.put(element, 0);
        }

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.printf("\nWord %s - %d times", item.getKey(), item.getValue());
        }

        // task 2
        Phonebook book = new Phonebook(new HashMap<>());
        book.add("Gerasimov", 863946923711L);
        book.add("Mironova", 868313065048L);
        book.add("Belousov", 867776783890L);
        book.add("Mironova", 863499299016L);
        book.add("Belousov", 865396473006L);
        book.add("Belousov", 865396473009L);

        System.out.println("\n\ntask 2");
        System.out.println("Phonebook records: ");
        book.get("Gerasimov");
        book.get("Belousov");
        book.get("Mironova");
    }
}
