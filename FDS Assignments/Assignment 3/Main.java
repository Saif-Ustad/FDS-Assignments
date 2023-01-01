import java.util.*;

class Student_info{
    int ID;
    String Name;
    float percentage;


    public Student_info(int ID,String Name,float percentage){
        this.ID = ID;
        this.Name = Name;
        this.percentage = percentage;
    }

   

}

public class Main {

    public static void Sort(Student_info[] arr,int number){
        int i,j,temp1;
        String temp2;
        float temp3;
        for(i=0;i<(number-1);i++){
            for(j=i+1;j<number;j++){
                if(arr[i].ID>arr[j].ID){
                    temp1 = arr[i].ID;
                    temp2 = arr[i].Name;
                    temp3 = arr[i].percentage;
                    arr[i].ID = arr[j].ID;
                    arr[i].Name = arr[j].Name;
                    arr[i].percentage = arr[j].percentage;
                    arr[j].ID = temp1;
                    arr[j].Name = temp2;
                    arr[j].percentage = temp3;
                }
            }
        }
    }

    public static void Search(Student_info[] arr,int Id,int number){
        int first = 0;
        int last = number-1;
        int middle = (last-first)/2;
        while(first<=last) {
            if (arr[middle].ID > Id) {
                last = middle-1;
                middle = (last - first) / 2;
            }

            else if(arr[middle].ID < Id){
                first = middle+1;
                middle = (last - first) / 2;
            }

            else{
                System.out.println("Student Data Found!!!");
                System.out.println("ID     name      percentage");
                System.out.println(arr[middle].ID + "\t" + arr[middle].Name + "\t" + arr[middle].percentage);
                break;
            }
        }
    }

    public static void display(Student_info[] arr,int number){
        System.out.println("\t**** Displaying full database ***");
        System.out.println("ID     name      percentage");
        for(int i=0;i<number;i++){
            
            System.out.println(arr[i].ID + "\t" + arr[i].Name + "\t" + arr[i].percentage);
        }
    }

    public static void main(String[] args){
        int number = 0;
        int choice;
        Student_info[] arr = new Student_info[10];
        Scanner sc = new Scanner(System.in);
        while(number<=10) {
            System.out.println("\t**** Welcome to Student Database ****");
            System.out.println("\tSelect one of the following options");
            System.out.println("\t 1] Add a Student Record ");
            System.out.println("\t 2] Delete a Student Record ");
            System.out.println("\t 3] Search a Student Record ");
            System.out.println("\t 4] Display Student Database ");
            System.out.println("\t 5] EXIT ");
            choice = sc.nextInt();
            if(choice == 5){break;}
            switch (choice) {
                case 1:
                    int id;
                    String name;
                    float percent;
                    System.out.println("\t Enter student ID number");
                    id = sc.nextInt();
                    System.out.println("\t Enter student Name");
                    name = sc.next();
                    System.out.println("\t Enter student Percentage");
                    percent = sc.nextFloat();
                    arr[number] = new Student_info(id, name, percent);
                    number++;
                    Sort(arr, number);
                    break;

                case 2:
                    int id1;
                    System.out.println("\tEnter Student ID to delete ");
                    id1 = sc.nextInt();
                    int first = 0;
                    int last = number - 1;
                    int middle = (last - first) / 2;
                    while (first <= last) {
                        if (arr[middle].ID > id1) {
                            last = middle - 1;
                            middle = (last - first) / 2;
                        } else if (arr[middle].ID < id1) {
                            first = middle + 1;
                            middle = (last - first) / 2;
                        } else {
                            arr[number] = new Student_info(arr[middle].ID,arr[middle].Name,arr[middle].percentage);
                            for(int i=1;i<(number-middle);i++) {
                                arr[middle] = new Student_info(arr[middle + i].ID, arr[middle + i].Name, arr[middle + i].percentage);
                            }
                            number--;
                            break;

                        }
                    }
                    break;

                case 3:
                    int id2;
                    System.out.println("\tEnter Student ID to Search ");
                    id2 = sc.nextInt();
                    Search(arr, id2, number);
                    break;

                case 4:
                    display(arr, number);
                    break;


            }
        }

    }

}