import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    public void showContacts() {
        int stt = 1;
        for (Contact contact : contacts) {
            System.out.println(stt + " " + contact.toString());
            stt++;
        }
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(String phoneNumber, Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                contacts.get(i).setName(updatedContact.getName());
                contacts.get(i).setEmail(updatedContact.getEmail());
                return;
            }
        }
    }

    public Contact getContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContact(String phoneNumber) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Ban co muon xoa lien he nay khong? (y/n)");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    contacts.remove(i);
                    System.out.println("Da xoa lien he.");
                } else {
                    System.out.println("Khong xoa lien he.");
                }
            }
        }
    }

    public void fakeData() {
        contacts.add(new Contact("1234567890", "a", "email"));
        contacts.add(new Contact("1234567890", "b", "email"));
        contacts.add(new Contact("1234567890", "c", "email"));
    }
}
