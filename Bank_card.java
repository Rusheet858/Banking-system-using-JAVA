public class Bank_card
{
    //declaring instance variables
    //keyword private is use for encapsulation
    private int CARD_ID;            
    private String CLIENT_NAME;
    private String ISSUER_BANK;
    private String BANK_ACCOUNT;
    private int BALANCE_AMOUNT;
    
    //declaring constructor name Bank_card that consists of 4 parameters
    public Bank_card(int card_id, String issuer_bank, String bank_account, int balance_amount)
    {
        //this keyword is used to call the instance variables
        this.CARD_ID= card_id;                  
        this.ISSUER_BANK= issuer_bank;
        this.BANK_ACCOUNT= bank_account;
        this.BALANCE_AMOUNT= balance_amount;        
        this.CLIENT_NAME="";
    }
    
    //declaring getters or accessor method
    public int getCARD_INT()
    {
        return this.CARD_ID;
    }
    
    public String getCLIENT_NAME()
    {
        return this.CLIENT_NAME;
    }
    
    public String getISSUER_BANK()
    {
        return this.ISSUER_BANK;
    }
    
    public String getBANK_ACCOUNT()
    {
        return this.BANK_ACCOUNT;
    }
    
    public int getBALANCE_AMOUNT()
    {
        return this.BALANCE_AMOUNT;
    }
    
    //declaring setters or withdrawal method
    public void setCLIENT_NAME(String client_name)
    {
        this.CLIENT_NAME=client_name;
        
    }
    public void setBALANCE_AMOUNT(int balance_amount)
    {
        this.BALANCE_AMOUNT=balance_amount;
    }
    
    //declsring method named display
    public void display()
    {
        System.out.println("Your card id: " + this.CARD_ID);
        System.out.println("Your issuer bank: " + this.ISSUER_BANK);
        System.out.println("Your bank amount: " + this.BANK_ACCOUNT);
        System.out.println("Your balance amount: " + this.BALANCE_AMOUNT);
        
        
        if(this.CLIENT_NAME==""){              //if else statement
            System.out.println("Client name is empty. Please enter the client name");
            
        }
        else{
                System.out.println("Client name: " + this.CLIENT_NAME);

        }
        
        
    }
}
