package com.javabasics.array;
import java.util.Arrays;
import java.util.Scanner;
public class ArrayExample {

	static String[] arr=new String[100];
	static boolean[] available=new boolean[100];
	static int count=0;
	
	public static void add(Scanner sc) {
			
		if(count>=arr.length) {
			System.out.println("The library is full");
			return;
		}

		System.out.println("Enter Book title:");
		String title=sc.nextLine();
		
		for(int i=0;i<count;i++) {
			if(arr[i].equals(title)) {
				System.out.println("Book already exists"); 
				return;
			} 
		}
		
		arr[count]=title;
		available[count]=true;
		count++;
		System.out.println("Book added successfully");	
	}
	
	public static void show(String[] arr) {
		if(count==0) System.out.println("The libraary is empty");
		
		else {
			System.out.println("Books list:");
			
			for(int i=0; i<count;i++) {
				System.out.println(arr[i]);
			}
		}
	}
	
	public static void search( Scanner sc) {
		System.out.println("Enter Book title to search: ");
		String check=sc.nextLine();
		
		for(int i=0; i<count; i++) {
			if(arr[i].equals(check)) {
				System.out.println("The book"+check+ " is found at " +i+ " index");
			}
		}
		
	}
	
	public static void borrowBook(Scanner sc) {
	    System.out.println("Enter book name to borrow:");
	    String name = sc.nextLine();

	    for(int i = 0; i < count; i++) {

	        if(arr[i].equals(name)) {

	            if(available[i]) {
	                available[i] = false;
	                System.out.println("Book borrowed successfully");
	            } else {
	                System.out.println("Book is already borrowed");
	            }

	            return;
	        }
	    }

	    System.out.println("Book not found");
	}

	
	public static void returnBook(Scanner sc) {
		System.out.println("Enter book name to return:");
		String name=sc.nextLine();
		
		for(int i=0; i<count;i++) {
			if(arr[i].equals(name)) {
				if(!available[i]) {
					available[i]=true;
					System.out.println("Book is returned succesfully");
				}else {
					System.out.println("The book was not borrowed");
				}
				return;
			}
		}
	    System.out.println("Book not found");

	}
	
	public static void sort() {
		Arrays.sort(arr,0,count);

	    for(int i = 0; i < count; i++) {
	        System.out.println(arr[i]);
	    }
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int choice;
		
		do {
			System.out.println(" 1: Add a Book\r\n"
					+ " 2: View All Books\r\n"
					+ " 3: Search for a Book\r\n"
					+ " 4: Borrow a Book\r\n"
					+ " 5: Return a Book\r\n"
					+ " 6: Sort Books Alphabetically\r\n"
					+ " 7: Exit");
			
			System.out.println("Enter Yout choice:");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			
			case 1:
				add(sc);
			break;
			
			case 2:
				show(arr);
				break;
			
			case 3:
				search(sc);
				break;
				
			case 4:
				borrowBook(sc);
				break;
				
			case 5:
				returnBook(sc);
				break;
				
			case 6:
				sort();
				break;

			case 7:
				System.out.println("Thank YOu");
				break;
				
			default:
                System.out.println("Invalid choice!");
			}
			
		}while(choice!=7);
		
	}
}
