package service;

import java.util.*;

import model.AccountAndInformation;

public class AccountAndInformationService {
    public static String accountID = "";
    FileService fileService = new FileService();

    public void autoGenerateAccountAdmin() {
        UUID uuid = UUID.randomUUID();
        AccountAndInformation accountAndInformation1 = new AccountAndInformation(uuid.toString(), "admin1", "12345", 0, "Son", "19", 1);
        AccountAndInformation accountAndInformation2 = new AccountAndInformation(uuid.toString(), "admin2", "12345", 0, "Hung", "19", 1);
        AccountAndInformation accountAndInformation3 = new AccountAndInformation(uuid.toString(), "admin3", "12345", 0, "Phuong Anh", "19", 0);
        List<AccountAndInformation> accountAndInformationList = new ArrayList<>();
        accountAndInformationList.add(accountAndInformation1);
        accountAndInformationList.add(accountAndInformation2);
        accountAndInformationList.add(accountAndInformation3);

        String filepath = "src\\data\\AccountAndInformation.txt";
        List<AccountAndInformation> accountAndInformationListRead = (List<AccountAndInformation>) fileService.readFile(filepath);
        if (accountAndInformationListRead == null) {
            fileService.writeFile(filepath, accountAndInformationList);
        }
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String userName = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        String confirmPassword = "";
        while (!confirmPassword.equals(password)) {
            if (!confirmPassword.equals("")) {
                System.out.print("Confirm Password must be same as the Password: ");
            }
            System.out.print("Confirm your Password: ");
            confirmPassword = sc.nextLine();
        }
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        String age = sc.nextLine();
        System.out.print("Enter your gender(0 - female, 1 - male): ");
        int gender = sc.nextInt();
        UUID uuid = UUID.randomUUID();
        AccountAndInformation accountAndInformation = new AccountAndInformation(uuid.toString(), userName, password, 1, name, age, gender);

        String filepath = "src\\data\\AccountAndInformation.txt";
        List<AccountAndInformation> accountAndInformationList = (List<AccountAndInformation>) fileService.readFile(filepath);
        accountAndInformationList.add(accountAndInformation);
        fileService.writeFile(filepath, accountAndInformationList);
        System.out.println("\nRegistration Successful\n");
        accountID = uuid.toString();
    }

    public void viewInformation() {
        String filepath = "src\\data\\AccountAndInformation.txt";
        List<AccountAndInformation> accountAndInformationList2 = (List<AccountAndInformation>) fileService.readFile(filepath);
        for (AccountAndInformation accountAndInformation1 : accountAndInformationList2) {
            if (accountID.equals(accountAndInformation1.getId())) {
                System.out.println(accountAndInformation1 + "\n");
                break;
            }
        }
    }

    public void login(int role) {
        String filepath = "src\\data\\AccountAndInformation.txt";
        List<AccountAndInformation> accountAndInformationList2 = (List<AccountAndInformation>) fileService.readFile(filepath);
        Scanner sc = new Scanner(System.in);
        System.out.println("---LOGIN---");
        boolean checkLogin = true;
        while (checkLogin) {
            System.out.print("Enter username: ");
            String userName = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            for (AccountAndInformation accountAndInformation1 : accountAndInformationList2) {
                if (role == accountAndInformation1.getRole() && userName.equals(accountAndInformation1.getUserName())
                        && password.equals(accountAndInformation1.getPassword())) {
                    System.out.println("\nLogin Successful\n");
                    accountID = accountAndInformation1.getId();
                    checkLogin = false;
                    break;
                }
            }
            if (checkLogin) {
                System.out.println("\nLogin Failed. Please try again");
            }
        }
    }

    public void getMembers() {
        String filepath = "src\\data\\AccountAndInformation.txt";
        List<AccountAndInformation> accountAndInformationList = (List<AccountAndInformation>) fileService.readFile(filepath);
        System.out.println();
        for (AccountAndInformation accountAndInformation1 : accountAndInformationList) {
            if (accountAndInformation1.getRole() == 1) {
                System.out.println(accountAndInformation1);
            }
        }
        System.out.println();
    }
}