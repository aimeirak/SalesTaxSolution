package com.company;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Main reciept = new Main();
        try
        {
            Vector<PurchasedItems> basket = reciept.getPurchase();
            reciept.printReciept(basket);
        }
        catch (NumberFormatException error)
        {
            error.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void printReciept(Vector<PurchasedItems> basket) throws Exception
    {
        float totalPrice = 0.0f;
        float totalTax = 0.0f;
        float Amount = 0.0f;
        for(int i=0; i<basket.size(); i++)
        {
            PurchasedItems purchaseItem = basket.get(i);
            purchaseItem = basket.get(i);
            totalPrice += purchaseItem.getPrice();
            totalTax += purchaseItem.getTax();
            purchaseItem.setItemPriceWithTax(purchaseItem.getPrice()+purchaseItem.getTax());
            System.out.println(purchaseItem);
            Amount = Amount+purchaseItem.getItemPriceWithTax();
        }
        System.out.println("Sales Taxes: "+totalTax);
        System.out.println("Total: "+(Amount));

    }
    private Vector<PurchasedItems> getPurchase() throws Exception
    {
        Scanner keyboard = new Scanner(System.in);
        String userInput = null;

        Vector<PurchasedItems> basket = new Vector<PurchasedItems>();

        int countOfItems = 1;
        while(true)
        {
            PurchasedItems purchaseItem = new PurchasedItems();

            System.out.print("Item "+countOfItems+" quantity: ");
            userInput = keyboard.nextLine();
            purchaseItem.setquantity(Integer.parseInt(userInput));
            System.out.print("Item "+countOfItems+" Name: ");
            userInput = keyboard.nextLine();
            purchaseItem.setName(userInput);
            System.out.print("Item "+countOfItems+" Price:");
            userInput = keyboard.nextLine();
            purchaseItem.setPrice(Float.parseFloat(userInput));
            System.out.print("Is Item "+countOfItems+" Imported[y/n]: ");
            userInput = keyboard.nextLine();
            if(userInput.toLowerCase().equals("y"))
            {
                purchaseItem.setImported( true ) ;
            }
            System.out.print("Is Item "+countOfItems+" Exempted[y/n]: ");
            userInput = keyboard.nextLine();
            if( userInput.toLowerCase().equals("y") )
            {
                purchaseItem.setExempted(true);
            }
            // compute tax
            purchaseItem.computeTax();
            basket.add(purchaseItem);
            countOfItems++;

            System.out.print("Do you have more Items [y/n]: ");
            userInput = keyboard.nextLine();
            if(userInput.toLowerCase().equals("n"))
            {
                break;
            }

        }
        return basket;
    }
}
