import java.util.Scanner;
interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

class DebitCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Debit Card");
    }
}

class UpiPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}
class User {
    String name;
    double balance;

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    void display() {
        System.out.println("User: " + name);
        System.out.println("Balance: ₹" + balance);
    }
}

// Child Class
class Customer extends User {

    Customer(String name, double balance) {
        super(name, balance);
    }

    // Deposit
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    // Withdraw
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Polymorphism here
    void makePayment(Payment p, double amount) {
        if (amount <= balance) {
            balance -= amount;
            p.pay(amount);
        } else {
            System.out.println("Payment failed: Low balance");
        }
    }
}

// Main Class
public class BankATMApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Customer c = new Customer("Esther", 10000);

        int choice;

        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Display Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Make Payment");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    c.display();
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double dep = sc.nextDouble();
                    c.deposit(dep);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double wd = sc.nextDouble();
                    c.withdraw(wd);
                    break;

                case 4:
                    System.out.println("Select Payment Method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. Debit Card");
                    System.out.println("3. UPI");

                    int payChoice = sc.nextInt();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();

                    Payment p = null;

                    if (payChoice == 1)
                        p = new CreditCardPayment();
                    else if (payChoice == 2)
                        p = new DebitCardPayment();
                    else if (payChoice == 3)
                        p = new UpiPayment();
                    else {
                        System.out.println("Invalid option");
                        break;
                    }

                    c.makePayment(p, amt); // polymorphism
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
//notification system java interview questions
import java.util.*;

// Interface
interface Notification {
    void send(String message);
    String getType(); // for history tracking
}

// Email
class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
    public String getType() {
        return "Email";
    }
}

// SMS
class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
    public String getType() {
        return "SMS";
    }
}

// Push
class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
    public String getType() {
        return "Push";
    }
}

// WhatsApp (New Feature - OCP)
class WhatsAppNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending WhatsApp: " + message);
    }
    public String getType() {
        return "WhatsApp";
    }
}

// Service Class
class NotificationService {
    private Notification notification;

    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void notifyUser(String message) {
        notification.send(message);
    }
}

// Main Class
public class bankatm{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> history = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Notification Menu =====");
            System.out.println("1. Email");
            System.out.println("2. SMS");
            System.out.println("3. Push Notification");
            System.out.println("4. WhatsApp");
            System.out.println("5. View History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }

            if (choice == 5) {
                System.out.println("\n--- Notification History ---");
                if (history.isEmpty()) {
                    System.out.println("No notifications sent yet.");
                } else {
                    for (String h : history) {
                        System.out.println(h);
                    }
                }
                continue;
            }

            System.out.print("Enter your message: ");
            String message = sc.nextLine();

            Notification notification = null;

            switch (choice) {
                case 1:
                    notification = new EmailNotification();
                    break;
                case 2:
                    notification = new SMSNotification();
                    break;
                case 3:
                    notification = new PushNotification();
                    break;
                case 4:
                    notification = new WhatsAppNotification();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            // Service call
            NotificationService service = new NotificationService(notification);
            service.notifyUser(message);

            // Save history
            history.add(notification.getType() + " -> " + message);
        }

        sc.close();
    }
}
