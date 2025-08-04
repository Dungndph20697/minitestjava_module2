import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private static final String FILE_PATH = "contacts.txt";

    public void showContacts() {
        List<Contact> contactList = readFile();
        int stt = 1;
        for (Contact contact : contactList) {
            System.out.println(stt + " " + contact.toString());
            stt++;
        }
    }

    public void addContact(Contact contact) {
        List<Contact> contactList = readFile();
        contactList.add(contact);
        writeFile(contactList);
    }

    public void updateContact(String phoneNumber, Contact updatedContact) {
        List<Contact> contacts = readFile();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                contacts.get(i).setName(updatedContact.getName());
                contacts.get(i).setEmail(updatedContact.getEmail());
                writeFile(contacts);
                return;
            }
        }
    }

    public Contact getContact(String phoneNumber) {
        List<Contact> contacts = readFile();
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContact(String phoneNumber) {
        List<Contact> contacts = readFile();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Ban co muon xoa lien he nay khong? (y/n)");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    contacts.remove(i);
                    writeFile(contacts);
                    System.out.println("Da xoa lien he.");
                } else {
                    System.out.println("Khong xoa lien he.");
                }
            }
        }
    }

    public List<Contact> readFile(){
        List<Contact> contactList = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return contactList; // Trả về danh sách rỗng nếu file chưa có
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            contactList = (List<Contact>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contactList;
    }

    public void writeFile(List<Contact> contacts) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(contacts);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error writing contacts to file" + e.getMessage());
        }
    }
}
