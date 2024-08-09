public class Credit_card extends Bank_card
{
    int CVC_NUMBER;
    double CREDIT_LIMIT;
    double INTEREST_RATE;
    String EXPIRATION_DATE;
    int GRACE_PERIOD;
    boolean ISGRANTED;
    
    public Credit_card(int card_id, String client_name, String issuer_bank, String bank_account, double balance_amount, int CVC_number, double interest_rate, String expiration_date)
    {
        super(card_id, issuer_bank, bank_account, balance_amount);
        this.CVC_NUMBER = CVC_number;
        this.INTEREST_RATE = interest_rate;
        this.EXPIRATION_DATE = expiration_date;
        this.ISGRANTED = false;
    }
    
    public int getCVC_NUMBER()
    {
        return this.CVC_NUMBER;
    }
    public double getCREDIT_LIMIT()
    {
        return this.CREDIT_LIMIT;
    }
    public double getINTEREST_RATE()
    {
        return this.INTEREST_RATE;
    }
    public String getEXPIRATION_DATE()
    {
        return this.EXPIRATION_DATE;
    }
    public int getGRACE_PERIOD()
    {
        return this.GRACE_PERIOD;    
    }
    public boolean getISGRANTED()
    {
        return this.ISGRANTED;
    }
    
}
