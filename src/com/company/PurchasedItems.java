package com.company;
public class PurchasedItems implements TaxCalculator
{
    private int quantity = 0;
    private String name = null;
    private float price = 0.0f;
    private boolean imported = false;
    private boolean exempted = false;
    private float itemPriceWithTax =0.0f;
    private float tax = 0.0f;

    public String toString()
    {
        return getquantity()+" " +getName()+" at "+getItemPriceWithTax();
    }

    public void computeTax()
    {
        float totalTaxPercent = 0.0f;

        if(isImported() && !isExempted())
        {
            totalTaxPercent = 0.15f;
        }
        else if(isImported() && isExempted())
        {
            totalTaxPercent = 0.05f;
        }
        else if( !isImported() && !isExempted())
        {
            totalTaxPercent = 0.1f;
        }
        else
        {
            totalTaxPercent = 0.0f;
        }
        tax = totalTaxPercent * price;
    }
    public float getTax()
    {
        return tax;
    }
    public float getPrice()
    {
        return price;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public boolean isImported()
    {
        return imported;
    }
    public void setImported(boolean imported)
    {
        this.imported = imported;
    }
    public boolean isExempted()
    {
        return exempted;
    }
    public void setExempted(boolean exempted)
    {
        this.exempted = exempted;
    }
    public void setPrice(float price)
    {
        this.price = price;
    }
    public int getquantity()
    {
        return quantity;
    }
    public void setquantity(int quantity)
    {
        this.quantity = quantity;
    }
    public float getItemPriceWithTax()
    {
        return itemPriceWithTax;
    }
    public void setItemPriceWithTax(float itemPriceWithTax)
    {
        this.itemPriceWithTax = itemPriceWithTax;
    }
}

