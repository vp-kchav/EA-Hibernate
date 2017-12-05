package mum.edu.app;


import java.util.Date;
import java.util.Scanner;


public class MenuBuilder 
{
	public static int menu(){
		System.out.println("\n");
		System.out.println("**************************************************************");
		System.out.println("*                                                            *");
		System.out.println("*                            Menu                            *");
		System.out.println("*                                                            *");
		System.out.println("**************************************************************");
		System.out.println("*                                                            *");
		System.out.println("*                 1. Display All Information Project         *");
		System.out.println("*                 2. Add new Task                            *");
		System.out.println("*                 3. Delete Task                             *");
		System.out.println("*                 4. Offered Task                            *");
		System.out.println("*                 5. List Task by Project                    *");
		System.out.println("*                 6. List project By Status                  *");
		System.out.println("*                 7. List project By Keyword and Location    *");
	    System.out.println("*                 8. List Volunteer Offered projects         *");
	    System.out.println("*                 9. List Project by Type of Resource        *");
		System.out.println("*                 10. Exit                                   *");
		System.out.println("*                                                            *");
		System.out.println("**************************************************************");

		int choice = 0;
		while(true){
			System.out.println("Choice: ");
			Scanner sc = new Scanner(System.in); 
			if (!sc.hasNextInt()){
				System.out.println("This menu can input number only.\n");
				continue;
			}
			
			choice = sc.nextInt();
			
			if(choice == -1){
				break;				
			}
			if(choice < 1 || choice > 10){
				System.out.println("Out of range. Please choose number (1 - 9) in menu.\n");
				continue;
			}
			break;
		}		
		return choice;
	}
	
	
	public static double inputDouble()
	{
		double number;
		Scanner in = new Scanner(System.in);
		number = in.nextDouble();
		return number;
	}
	public static int inputInt()
	{
		int number;
		Scanner in = new Scanner(System.in);
		number = in.nextInt();
		return number;
	}
	public static String inputString()
	{
		String str;
		Scanner in = new Scanner(System.in);
		str = in.nextLine();
		return str;
	}
	
	public static Long inputLong()
    {
        Long l;
        Scanner in = new Scanner(System.in);
        l = in.nextLong();
        return l;
    }
	
	public static Date inputDate()
    {
	    System.out.println("please input Month");
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        System.out.println("please input Day");
        int day = in.nextInt();
        System.out.println("please input year(yyyy)");
        int year = in.nextInt();
        Date d = new Date(year,month,day);
        return d;
    }
    
}
