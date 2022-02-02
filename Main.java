public class Main {
    public static void main(String[] args) {

        PhoneBook book = new PhoneBook();

        book.createContact();
        book.createContact();
        book.createContact();

        System.out.println("Выведем список из 3х заведенных контактов");
        book.showAllContacts();

        System.out.println("Сохраним состояние нашей книги в файл");
        book.saveBook();

        System.out.println("Удалим контакт под id 2");
        book.removeContact(2);

        System.out.println("Выведем список из 2х оставшихся контактов");
        book.showAllContacts();

        System.out.println("Загрузим сохраненное состояние книги из файла");
        book.loadBook();
        book.showAllContacts();
        System.out.println("Записей снова 3");
        System.out.println("Попробуем найти контакт по id = 4");
        book.showContactById(4);
        System.out.println("Попробуем найти контакт по номеру телефона");
        book.showContactByPhoneNumber("555-555");
        System.out.println("Попробуем найти контакт по имени абонента");
        book.showContactByName("иван");
    }
}
