package org.project;
import java.util.*;

public class CollectionExample
{
	float balance;
	String address,name;
	long acc;
	static HashSet<Bank_Customer> ls=new HashSet<Bank_Customer>();
	public void create(Bank_Customer obj)
	{
		acc=(long)(Math.random()*999999999+1000000000);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name of the person creating account :");
		name=sc.nextLine();
		System.out.println("enter Current address of the person :");
		address=sc.nextLine();
		System.out.println("enter Account Balance > 1000 :");
		balance=sc.nextFloat();
		if(balance<1000)
		{
			System.out.println("Deposite money need to be greater than 1000 for the account to be created .");
			return;
		}
		obj=new Bank_Customer(acc,name,address,balance);
		ls.add(obj);
		System.out.println("Copy your account number");
		display(acc);
	}
	public void deposite(long acc,float val)
	{
		for(Bank_Customer b:ls)
		{
			if(b.accno==acc)
			{
				b.balance+=val;
				System.out.println(" Deposited Successfully .");
			}
		}
	}
	public void withdraw(long acc,float val)
	{
		for(Bank_Customer b:ls)
		{
			if(b.accno==acc)
			{
				if(b.balance>=(1000+val))
				{
					b.balance-=val;
					System.out.println("withdrawn Successfully .");
				}
				else
				{
					System.out.println("Transaction Unsuccessful. Maintain minimum balance ");
				}
			}
		}
	}
	public void display(long acc)
	{
		for(Bank_Customer b:ls)
		{
			if(b.accno==acc)
			{
				System.out.println(b);
			}
		}
	}
	public void displayAll()
	{
		Iterator<Bank_Customer> itr=ls.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
	public static void main(String[] args)
	{
	//System.out.println(ls);
		int i=0;
		int ch;
		CollectionExample cl=new CollectionExample();
		Bank_Customer[] ob=new Bank_Customer[10000];
		do
		{
			System.out.println("============Start==============");
			System.out.println(" 1.Create Account  ");
			System.out.println(" 2.Deposite Money  ");
			System.out.println(" 3.Withdraw Money  ");
			System.out.println(" 4.Display Account Details give your Account number ");
			System.out.println(" 5.Display All Accounts Details  ");
			System.out.println("=============End================");
			int n;
			Scanner sc=new Scanner(System.in);
			n=sc.nextInt();
			switch(n)
			{
				case 1: cl.create(ob[i]);
						i++;
						break;
				case 2: System.out.println("Enter your Account Number : ");
						long acc=sc.nextLong();
						System.out.println("Enter Money To be Deposited : ");
						float val=sc.nextFloat();
						cl.deposite(acc,val);
				   		break;
				case 3: System.out.println("Enter your Account Number : ");
						long acc1=sc.nextLong();
						System.out.println("Enter money To be withdrawn : ");
						float val1=sc.nextFloat();
						cl.withdraw(acc1, val1);
						break;
				case 4: System.out.println("Enter your Account Number : ");
				       	long acc2=sc.nextLong();
				       	cl.display(acc2);
				       	break;
				case 5: cl.displayAll();
						break;
				default: System.out.println("Please Enter your Correct Choice");
			}
			System.out.println(" Select '1' for accessing other process and to discontinue the bank process type '0' :");
			ch=sc.nextInt();
		}while(ch==1);
	
	}
}