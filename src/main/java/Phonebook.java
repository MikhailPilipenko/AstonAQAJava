import java.util.Map;

public class Phonebook {
    private Map<Long, String> records;

    public Phonebook(Map<Long, String> records) {
        this.records = records;
    }

    public void add(String name, Long phoneNumber) {
        records.put(phoneNumber, name);
    }

    public void get(String name) {
        for (Map.Entry<Long, String> item : records.entrySet()) {
            if (item.getValue().equals(name)) {
                System.out.println("Name: " + item.getValue() + "; phone number : " + item.getKey());
            }
        }
    }
}
