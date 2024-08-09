public class Debit_card extends Bank_card
{
    int PIN_NUMBER;
    int WITHDRAWAL_AMOUNT;
    String DATE_OF_WITHDRAWAL;
    boolean HASWITHDRAWN;
    
    public Debit_card(int balance_amount, int card_id, String bank_account, String issuer_bank, String client_name, int pin_number)
    {
        super(card_id, issuer_bank, bank_account, balance_amount);
        super.setCLIENT_NAME(client_name);
        this.PIN_NUMBER=pin_number;
        this.HASWITHDRAWN=false;
        
    }
    public int getPIN_NUMBER()
    {
        return this.PIN_NUMBER;
    }
    public int getWITHDRAWAL_AMOUNT()
    {
        return this.WITHDRAWAL_AMOUNT;
    }
    public String getDATE_OF_WITHDRAWAL()
    {
        return this.DATE_OF_WITHDRAWAL;
    }
    public boolean getHASWITHDRAWN()
    {
        return this.HASWITHDRAWN;
    }
        
    public void setWITHDRAWAL_AMOUNT(int withdrawal_amount){
        this.WITHDRAWAL_AMOUNT=withdrawal_amount;
    }
    
    public void Withdraw(int withdrawal_amount,String date_of_withdraw, int pin_number)
    {
        if(this.PIN_NUMBER == pin_number){
            if(super.getBALANCE_AMOUNT()>=withdrawal_amount){
                
                int balance = super.getBALANCE_AMOUNT() - withdrawal_amount;
                super.setBALANCE_AMOUNT(balance);
                this.HASWITHDRAWN=true;
                
            }
            else{
                System.out.println("Insufficient balance");
            }
            
        }
        else{
            System.out.println("Incorrect pin");
        }
    }
    
    public void display()
    {
        
    }
}
