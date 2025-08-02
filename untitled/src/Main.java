import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ContactManager contactManager = new ContactManager();
        Scanner sc = new Scanner(System.in);
        contactManager.fakeData();
        while (true) {
            System.out.println("=====MENU=====");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them moi");
            System.out.println("3. Cap Nhap");
            System.out.println("4. Xoa");
            System.out.println("0. Thoat");
            System.out.print("Moi ban chon chuc nang: ");
            int choice = Integer.valueOf(sc.nextLine());
            switch (choice) {
                case 1:
                    contactManager.showContacts();
                    break;
                case 2: {
                    System.out.print("Moi ban nhap so dien thoai: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Moi ban nhap ten: ");
                    String name = sc.nextLine();
                    System.out.print("Moi ban nhap email: ");
                    String email = sc.nextLine();
                    Contact contact = new Contact(phoneNumber, name, email);
                    contactManager.addContact(contact);
                    break;
                }
                case 3: {
                    System.out.print("Moi ban nhap so dien thoai: ");
                    String phoneNumber = sc.nextLine();
                    if (contactManager.getContact(phoneNumber) != null) {
                        System.out.print("Moi ban nhap ten moi: ");
                        String newName = sc.nextLine();
                        System.out.print("Moi ban nhap email moi: ");
                        String newEmail = sc.nextLine();
                        Contact updatedContact = new Contact(phoneNumber, newName, newEmail);
                        contactManager.updateContact(phoneNumber, updatedContact);
                    } else {
                        System.out.println("Khong tim thay lien he voi so dien thoai nay.");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Moi ban nhap so dien thoai: ");
                    String phoneNumber = sc.nextLine();
                    if (contactManager.getContact(phoneNumber) != null) {
                        contactManager.deleteContact(phoneNumber);
                    } else {
                        System.out.println("Khong tim thay lien he voi so dien thoai nay.");
                    }
                    break;
                }
                case 0: {
                    System.out.println("Cam on ban da su dung chuong trinh.");
                    return;
                }
            }
        }


    }
}