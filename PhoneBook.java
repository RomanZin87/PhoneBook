import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook implements Serializable {

    private static Map<Integer, Contact> phoneBook;
    private static int id = 0;

    public PhoneBook() {
        if (phoneBook == null) {
            phoneBook = new HashMap<>();
        }
    }

    public void createContact() {

        Contact contact = new Contact();

        System.out.println("Введите данные контакта для телефонной книги, " +
                "если хотите пропустить поле, просто нажмите enter");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Имя: ");
            contact.setName(reader.readLine());
            System.out.print("Фамилия: ");
            contact.setSurname(reader.readLine());
            System.out.print("Прозвище: ");
            contact.setNickname(reader.readLine());
            System.out.print("Номер телефона: ");
            contact.setPhoneNumber(reader.readLine());
            System.out.print("Е-мейл: ");
            contact.setEmail(reader.readLine());
            System.out.print("Дата рождения: ");
            contact.setBirthday(reader.readLine());

        } catch (IOException ignored) {
        }

        phoneBook.put(++id, contact);
    }

    public void showAllContacts() {
        for (Map.Entry<Integer, Contact> entry : phoneBook.entrySet()) {
            System.out.println("Contact id = " + entry.getKey() + " " + entry.getValue());
        }
    }

    public void showContactById(int id) {
        boolean find = false;
        if (phoneBook.containsKey(id)) {
            System.out.println("Contact id = " + id + phoneBook.get(id));
            find = true;
        }
        if (!find) System.out.println("В книге нет контакта с таким id");
    }

    public void showContactByPhoneNumber(String phoneNumber) {
        boolean find = false;
        for (Map.Entry<Integer, Contact> entry : phoneBook.entrySet()) {
            if (phoneNumber.equals(entry.getValue().getPhoneNumber())) {
                System.out.println("Contact id = " + entry.getKey() + " " + entry.getValue());
                find = true;
            }
        }
        if (!find) System.out.println("В книге нет контакта с таким номером телефона");
    }

    public void showContactByName(String name) {
        boolean find = false;
        for (Map.Entry<Integer, Contact> entry : phoneBook.entrySet()) {
            if (name.equalsIgnoreCase(entry.getValue().getName())) {
                System.out.println("Contact id = " + entry.getKey() + " " + entry.getValue());
                find = true;
            }
        }
        if (!find) System.out.println("В книге нет контакта с таким именем");
    }

    public void removeContact(int id) {
        phoneBook.remove(id);
    }

    public void saveBook() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.ser"));
            oos.writeObject(phoneBook);
            oos.close();
        } catch (IOException ignored) {
        }
    }

    @SuppressWarnings("unchecked")
    public void loadBook() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.ser"));
            phoneBook = (Map<Integer, Contact>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }


}
