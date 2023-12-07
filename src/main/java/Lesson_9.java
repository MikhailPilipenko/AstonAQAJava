import java.util.*;
import java.util.stream.Collectors;

public class Lesson_9 {
    public static void main(String[] args) {
        // task 1
        List<Integer> numbers = new ArrayList<>();
        int number;
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            number = random.nextInt() % 100;
            numbers.add(number);
        }

        System.out.println("List random numbers: \n" + numbers);

        int countEvenNumbers = (int) numbers.stream()
                .filter(n -> (n % 2) == 0)
                .count();
        System.out.println("Number of even numbers: " + countEvenNumbers);

        // task 2
        List<String> words = new ArrayList<>();
        Collections.addAll(words, "Highload", "High", "Load", "Highload");

        int countWord = (int) words.stream()
                .filter("High"::equals)
                .count();
        System.out.println("\nList of words: " + words);
        System.out.println("Number of High: " + countWord);

        String firstWord = words.stream()
                .findFirst()
                .orElse("0");
        System.out.println("First word: " + firstWord);

        String lastWord = words.stream()
                .skip(words.size() - 1)
                .findFirst()
                .orElse("0");
        System.out.println("Last word: " + lastWord);

        // task 3
        List<String> elements = new ArrayList<>();
        Collections.addAll(elements, "f10", "f15", "f2", "f4", "f4");
        System.out.println("\nOriginal List: " + elements);

        List<String> sortElementsList;
        sortElementsList = elements.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted List: " + sortElementsList);

        String[] sortElementsArray;
        sortElementsArray = elements.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
        System.out.print("Sorted Array: ");
        for (String s : sortElementsArray) {
            System.out.print(s + " ");
        }

        // task 4
        Collection<Students.Student> students = Arrays.asList(
                new Students.Student("Дмитрий", 17, Students.Gender.MAN),
                new Students.Student("Максим", 20, Students.Gender.MAN),
                new Students.Student("Екатерина", 20, Students.Gender.WOMAN),
                new Students.Student("Михаил", 28, Students.Gender.MAN)
        );

        // part 1
        double avgManAge = students.stream()
                .filter(s -> s.getGender() == Students.Gender.MAN)
                .mapToInt(Students.Student::getAge)
                .average()
                .getAsDouble();
        System.out.printf("\n\nAverage age of male students: %.2f", avgManAge);

        // part 2
        List<Students.Student> militaryServiceAgeStudents;

        militaryServiceAgeStudents = students.stream()
                .filter(s -> s.getAge() >= 18 && s.getAge() <= 27 && s.getGender() == Students.Gender.MAN)
                .collect(Collectors.toList());

        System.out.println("\n\nMilitary service age students: " + militaryServiceAgeStudents);

        // task 5
        Scanner scanner = new Scanner(System.in);
        String s;
        List<String> stringList = new ArrayList<>();

        System.out.println("\nEnter logins: ");

        while (true) {
            s = scanner.nextLine();
            if (s.equals("")) {
                break;
            }
            stringList.add(s);
        }

        List<String> filterStringList = stringList.stream()
                .filter(str -> str.charAt(0) == 'f')
                .toList();

        System.out.println("All logins: " + stringList);
        System.out.println("Logins beginning with 'f': " + filterStringList);
    }
}
