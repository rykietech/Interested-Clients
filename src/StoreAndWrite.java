//@hishaamr
//Student number--3652426
//Assignment 1

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;  // Import the Scanner class
import java.io.FileWriter;   // Import the FileWriter class


public class StoreAndWrite {

    //method sorts the clients alphabetically by name
    public void SortClients(Client[] clientarr, int max1) {

        for (int i = 0; i < max1; i++) {
            for (int j = 0; j < max1 - 1; j++) {
                if ((clientarr[i].getName().compareToIgnoreCase(clientarr[j].getName())) < 0) {
                    Client temp = clientarr[i];
                    clientarr[i] = clientarr[j];
                    clientarr[j] = temp;
                }

            }
        }
    }
    //Question 1b
    //Creating age.txt
    public void CreateAgeTextFile(Client[] clientarr, int max) {
        for (int i = 0; i < max; i++) {
            //Compares the age and finds if it is in range 35<age<45
            if (clientarr[i].getAge()>35 && clientarr[i].getAge() < 45) {
                try {
                    File myObj = new File("Age.txt");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: Age");
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                     e.printStackTrace();
                }

                try {
                    FileWriter myWriter = new FileWriter("Age.txt");
                    myWriter.write(clientarr[i].getName() + " " + clientarr[i].getAge() + "\r\n");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                     e.printStackTrace();
                }

            }
        }

    }
        //Question 1c)
        //Creates professors.txt file
    
        public void CreateOccTextFile(Client[] clientarr, int max) {
        for (int i = 0; i < max; i++) {
            //checks if the clients occupations is a match with "professor"
            if (clientarr[i].getOcc().equalsIgnoreCase("professor")) {
                try {
                    File myObj = new File("Professors.txt");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: Professors");
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                     e.printStackTrace();
                }

                try {
                    FileWriter myWriter = new FileWriter("Professors.txt");
                    myWriter.write(clientarr[i].getName() + " " + clientarr[i].getOcc()+ "\r\n");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                     e.printStackTrace();
                }

            }
        }

    }

    public void run() {
        Client clientArray[] = new Client[60];//Setting the max ammount of clients
        //Variables that will be used
        String name ;
        String surname;
        int age;
        String gender;
        String occ;
        String email;
        int max;
        
        Scanner keyboard1 = new Scanner(System.in);
        System.out.println("Enter number of interested clients: ");
        max = keyboard1.nextInt();
        if (max < 0) {
            System.out.println("Error encountered");
        } else if (max > 60) {
            System.out.println("Interested clients is greater then 60");
        } else {
            for (int i = 0; i < max; i++) {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter your Name: ");
                name = keyboard.nextLine();
                System.out.println("Enter your Surname: ");
                surname = keyboard.nextLine();
                System.out.println("Enter your age: ");
                age = keyboard1.nextInt();
                
                if( age >0){
                System.out.println("Enter your Gender: ");
                gender = keyboard.nextLine();
                System.out.println("Enter your Occupation: ");
                occ = keyboard.nextLine();
                System.out.println("Enter your Email: ");
                String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                email = keyboard.nextLine();
                if(email.matches(regex)){
                    clientArray[i] = new Client(name, surname, age, gender, occ, email);

                }else{
                    System.out.println("Email not valid!!");
                }
                }
                else{
                    System.out.println("Age not applicable!!");
                }
                
                
                
            }
        }
        //Question 1a)
        try {
            File myObj = new File("InterestedClients(Unsorted).txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
             e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("InterestedClients(Unsorted).txt");
            for (int i = 0; i < max; i++) {
                myWriter.write(clientArray[i].toString() + "\r\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
             e.printStackTrace();
        }

        SortClients(clientArray, max);
        //Write to SOrted file	
        try {
            File myObj1 = new File("InterestedClients(Sorted).txt");
            if (myObj1.createNewFile()) {
                System.out.println("File created: " + myObj1.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
             e.printStackTrace();
        }

        try {
            FileWriter myWriter1 = new FileWriter("InterestedClients(Sorted).txt");
            for (int i = 0; i < max; i++) {
                myWriter1.write(clientArray[i].toString() + "\r\n");
            }
            myWriter1.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
             e.printStackTrace();
        }
        CreateAgeTextFile(clientArray, max);
        CreateOccTextFile(clientArray, max);
    }

    public static void main(String[] args) {

        StoreAndWrite t1 = new StoreAndWrite();
        t1.run();
    }

}