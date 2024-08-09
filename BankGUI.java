
/**
 * Description of class BankGUI: In this project, we have made a responsive GUI of banking system by using the classes and interfaces from javax.swing, java.awt, java.awt.event and java.util packages. It consists of a JFrame and two JPanel and inside those JPanels, there are objects of JLabel, JTextField and JButton. The buttons in the GUI is  made respronsive by using actionPerformed method. Abstraction is also used in this project as the class BankGUI implements an interface ActionListener.
 *
 * @author (Rusheet Thapaliya)
 * @version (5/20/2023)
 */


// Importing all the classes and interfaces as rewuired from javax.swing,javax.awt,javax.awt.event and java.util package
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class BankGUI implements ActionListener //Using concept of abstraction since BankGUI is a class and ActionListener is an interface
{
    //Declaring objects of the respective classes and private keyword is used for encapsulation.
    
    private JFrame obj;
    
    //JPanel for debit card
    private JPanel panel_obj;
    //JPanel for credit card
    private JPanel panel_obj2;
    
    //JLabel for debit card
    private JLabel Debit_card,Card_id,Client_name,Issuer_bank,Bank_Account,Balance_Amount,Pin_number,Withdrawal_amount,withdrawal_date;
    //JLabel for credit card
    private JLabel Credit_card,Balance_AMOUNT, Bank_ACCOUNT, Issuer_BANK, Withdrawal_AMOUNT, CVC_NUMBER, Credit_LIMIT, Interest_RATE, Grace_PERIOD, Client_NAME,Card_ID, expiration_date;
    
    //JTextField for debit card
    private JTextField card_debit,client_debit,issuer_debit,account_debit,amount_debit,pin_debit,withdrawal_debit;
    //JTextField for credit card
    private JTextField card_credit,client_credit,issuer_credit,account_credit,amount_credit, cvc,credit,interest,grace;
    
    //JButton for debit card
    private JButton debit_card,withdraw_button,display_button,clear_button;
    //JButton for credit card
    private JButton display_obj, clear_credit, credit_card, credit_limit, cancel;
    
    //JComboBox for debit card
    private JComboBox day, month, year;
    //JComboBox for credit card
    private JComboBox day2, month2, year2; 
    
    
    //Declaring ArrayList of Bank_card datatype
    ArrayList<Bank_card> arrayl = new ArrayList<Bank_card>();
    
    //declaring actionPerformed method for making JButton responsive
    public void actionPerformed(ActionEvent e)
    {
        
        //debit card
        
        if (e.getSource() == debit_card) //JButton object debit_card
        {
            try     //Using try except to detect exceptions
            {
                //Declaring variables after extracting values from JTextField using getText() method
            int balance = Integer.valueOf(amount_debit.getText()); //Conversion of string to int datatype
            int cid = Integer.valueOf(card_debit.getText());
            String b_account = account_debit.getText();
            String i_bank = issuer_debit.getText();
            String c_name = client_debit.getText();
            int pin = Integer.valueOf(pin_debit.getText());
            
            
            boolean card = true;
            
            for (Bank_card tobj : arrayl) // for each loop
            {
                if (tobj instanceof Debit_card) //Checking whether tobj is an instance of Debit_card
                {
                    Debit_card obj_debit = (Debit_card) tobj; //Object downcasting from Bank_card to Debit_card
                    
                    if (obj_debit.getCARD_ID() == cid)
                    {
                        card = false;
                    }
                }
                
            }
            if (card == true)
            {
                Debit_card deb_obj = new Debit_card(balance,cid,b_account,i_bank,c_name,pin); //Creation of new Debit_card object
                arrayl.add(deb_obj); //Adding the object to arraylist
                JOptionPane.showMessageDialog(panel_obj, "Debit card successfully added"); //Showing message dialog on JPanel after meeting all the conditions
                
            }
            else if (card == false)
            {
                
                JOptionPane.showMessageDialog(panel_obj, "The debit card with ID: "+cid+" has already been added");  //Showing message dialog on JPanel after meeting all the conditions
            }   
        }catch (NumberFormatException h)
        {
            JOptionPane.showMessageDialog(panel_obj,"Invalid input! Please enter an appropriate input.","Error",JOptionPane.ERROR_MESSAGE);  //Showing error messsage in case of NumberFormatException
        }
        catch (NullPointerException h)
        {
            JOptionPane.showMessageDialog(panel_obj,"Invalid input! Please enter an appropriate input.","Error",JOptionPane.ERROR_MESSAGE); //Showing error in case of NullPointerException
        }
             
        }
        else if(e.getSource() == withdraw_button) //JButton object withdraw_button
        {
            //Declaring variables after extracting values from JTextField using getText() method
            
            int CID = Integer.valueOf(card_debit.getText());
            
            String Year =year.getSelectedItem().toString(); //Converting selected items in JComboBox to String datatype
            String Month = month.getSelectedItem().toString();
            String Day = day.getSelectedItem().toString();
            
            int pnum = Integer.valueOf(pin_debit.getText());
            int wit = Integer.valueOf(withdrawal_debit.getText());
            String dateofwithdraw = Day+ " " + Month+ " " + Year;
            
            for (Bank_card robj : arrayl) //for each loop
            {
                if(robj instanceof Debit_card) 
                {
                    Debit_card debit_obj = (Debit_card) robj; //Object downcasting
                    
                    if(robj.getCARD_ID() == CID) //Using getters method from Bank_card class
                    
                    {
                        //showing message dialog
                        JOptionPane.showMessageDialog(panel_obj, "The card id is: "+CID+"\n"+"The withdrawal amount is: "+wit+"\n"+"The date of withdrawal is: "+dateofwithdraw + "\nThe pin number is: " +pnum);
                    }
                    if(debit_obj.getPIN_NUMBER() == pnum)
                    {
                        if(wit <= debit_obj.getBALANCE_AMOUNT())
                        {
                            debit_obj.Withdraw(wit, dateofwithdraw, pnum);  //using method from Debit_card class
                            int diduct = debit_obj.getBALANCE_AMOUNT()-wit;
                            String d = Integer.toString(diduct);
                            amount_debit.setText(d); //Updating withdrawal amount value
                            JOptionPane.showMessageDialog(panel_obj,"Successfully withdrawed");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(panel_obj, "The withdraw was unsuccessful");
                        }
                        
                    }
                    
                    else
                    {
                        JOptionPane.showMessageDialog(panel_obj, "Incorrect pin number");
                    }
                }
            }
        }
        else if(e.getSource() == clear_button)
        {
            
            //Setting text to empty String for clearing all textfields
            
            card_debit.setText("");
            client_debit.setText("");
            issuer_debit.setText("");
            account_debit.setText("");
            amount_debit.setText("");
            withdrawal_debit.setText("");
            pin_debit.setText("");
        }
        else if(e.getSource() == display_button)
        {
            //Extracting values from JTextField and saving it in a variable
            int pin = Integer.valueOf(pin_debit.getText());
            int wit = Integer.valueOf(withdrawal_debit.getText());
            int balance = Integer.valueOf(amount_debit.getText());
            int card_ = Integer.valueOf(card_debit.getText());
            String b_account = account_debit.getText();
            String i_bank = issuer_debit.getText();
            String c_name = client_debit.getText();
            
            String Year =year.getSelectedItem().toString(); 
            String Month = month.getSelectedItem().toString();
            String Day = day.getSelectedItem().toString();
            
            String withdrawal_date = Year + " " + Month + " "+Year;
            
            
            //Displaying all the message in the terminal
            
            System.out.println("The pin number is: " + pin);
            System.out.println("The withdrawal amount is: " + wit);
            System.out.println("The date of withdrawal is: " + withdrawal_date);
            System.out.println("The card id is: "+ card_);
            System.out.println("The bank account is: "+ b_account);
            System.out.println("The issuer bank is: "+ i_bank);
            System.out.println("The client name is: "+ c_name);
            System.out.println("The balance amount is: "+ balance);
            
           
            //Dispalying message in JPanel using JOptioPane class and showMessageDialog method.
            JOptionPane.showMessageDialog(panel_obj,"The Pin number is: " + pin+"\nThe withdrawal amount is: " + wit+ "\nThe Date of withdrawal is: " + withdrawal_date+
            "\nThe balance amount is: "+ balance + "\nThe card id is: "+ card_ + "\nThe bank account is: "+ b_account+ "\nThe issuer bank is: "+ i_bank + "\nThe client name is: "+c_name);
        }
        
        
        
        //credit card
        
        else if(e.getSource() ==credit_card)
        {
            //Declaring variables after extracting values from JTextField using getText() method
            int cid = Integer.valueOf(card_credit.getText());
            String cname = client_credit.getText();
            String ibank = issuer_credit.getText();
            String baccount = account_credit.getText();
            int bamount = Integer.valueOf(amount_credit.getText());
            int cvc_num = Integer.valueOf(cvc.getText());
            double int_rate = Integer.valueOf(interest.getText());
            
            String year =year2.getSelectedItem().toString(); 
            String month = month2.getSelectedItem().toString();
            String day = day2.getSelectedItem().toString();
            
            String expiration_date = year +""+ month +""+ ""+day;
            
            boolean cre = true;
            
            for (Bank_card zobj : arrayl) //for each loop
            {
                if (zobj instanceof Credit_card)
                {
                    Credit_card cred = (Credit_card) zobj; //Object downcasting
                    
                    if (cred.getCARD_ID() == cid) //Using getters method from Bank_card class
                    {
                        cre = false;
                    }
                }
            }
            if (cre == true)
            {
                Credit_card cre_obj = new Credit_card(cid , cname, ibank,baccount,bamount,cvc_num,int_rate,expiration_date); //Creating new object of Credit_Card
                arrayl.add(cre_obj);  //Adding the newly created object in ArrayList
                JOptionPane.showMessageDialog(panel_obj2,"Credit card successfully added"); //Displaying message dialog
            }
            else if (cre == false)
            {
                JOptionPane.showMessageDialog(panel_obj2, "Card id "+ cid+ " has already been added"); //Displaying message dialog
            }
        }
        
        else if(e.getSource() == clear_credit)
        {
            
            //Setting text to empty String for clearing all textfields
            
            card_credit.setText("");
            client_credit.setText("");
            issuer_credit.setText("");
            account_credit.setText("");
            amount_credit.setText("");
            cvc.setText("");
            credit.setText("");
            interest.setText("");
            grace.setText("");
            
        }
        if(e.getSource() == display_obj)
        {
            //Declaring variables after extracting values from JTextField using getText() method
            
            int cid = Integer.valueOf(card_credit.getText());
            String cname = client_credit.getText();
            String ibank = issuer_credit.getText();
            String baccount = account_credit.getText();
            int bamount = Integer.valueOf(amount_credit.getText());
            int cvc_num = Integer.valueOf(cvc.getText());
            double int_rate = Integer.valueOf(interest.getText());
            double crelmt = Integer.valueOf(credit.getText());
            int grce = Integer.valueOf(grace.getText());
            
            String year =year2.getSelectedItem().toString(); 
            String month = month2.getSelectedItem().toString();
            String day = day2.getSelectedItem().toString();
            
            String expiration_date = year +""+ month +""+ ""+day;
            
            //Displaying all the message in the terminal
            
            System.out.println("The card id is: " +cid);
            System.out.println("The client name is: " +cname);
            System.out.println("The issuer bank is: " +ibank);
            System.out.println("The bank account is: " +baccount);
            System.out.println("The balance amount is: " +bamount);
            System.out.println("The CVC number is: " +cvc_num);
            System.out.println("The interest rate is: " +int_rate);
            System.out.println("The credit limit is: " +crelmt);
            System.out.println("The grace period is: " +grce);
            System.out.println("The expiration date is: " +expiration_date);
            
            //Displaying message dialog
            JOptionPane.showMessageDialog(panel_obj2, "The card id is: "+cid+
            "\nThe client name is: " +cname+"\nThe issuer bank is: "+ibank +"\nThe namk account is: "+baccount+ "\nThe balance amount is: "+bamount+ 
            "\nThe CVC number is: "+cvc_num+ "\nThe interest rate is: "+int_rate+ "\nThe credit limit is: "+crelmt+ "\nThe grace periiod is: "+grce+ "\nThe expiration date is: "+expiration_date);
            
            
            
        }
    
            
        else if(e.getSource() == credit_limit)
        {
            //Declaring variables after extracting values from JTextField using getText() method
            
            int grace_period = Integer.valueOf(grace.getText());
            double creditlimit = Double.valueOf(credit.getText());
            int cid = Integer.valueOf(card_credit.getText());
       
            for ( Bank_card j: arrayl)
            {
                // instance of operator for getting value
                if (j instanceof Credit_card)
                {
                  //downcasting object
                Credit_card obj_credit = (Credit_card) j;    
                  // comparing the value of card_id (if the values are same or not)
                  if (obj_credit.getCARD_ID() == cid)
                    {
                           //message dialog
                       JOptionPane.showMessageDialog(panel_obj2, "The card id is :"+cid+"\n"+ "The garce period is"+grace_period +
                       "\n" + "The credit limit is "+ creditlimit);
                 
                   
                        if (creditlimit <= 2.5* obj_credit.getBALANCE_AMOUNT()) //calling set_creditlimit method
                        {
                         JOptionPane.showMessageDialog(panel_obj2,"Your credit limit is sucessful." ); //message dialog
                        }
       
                        else
                       {
                         JOptionPane.showMessageDialog(panel_obj2,"Your credit limit is unsucessful." ,"Try Again",JOptionPane.WARNING_MESSAGE); //message dialog
           
       
                        }
                    }
                }
            }
            
        }
        
        else if(e.getSource() == cancel)
        {
            //Declaring variables after extracting values from JTextField using getText() method
            
            int Cid = Integer.valueOf(card_credit.getText());
            int Bamount = Integer.valueOf(amount_credit.getText());
            String Baccount = account_credit.getText();
            String Ibank = issuer_credit.getText();
            String Cname = client_credit.getText();
            int cvc_num = Integer.valueOf(cvc.getText());
            double Interest_rate = Double.valueOf(interest.getText());
            String Year = year2.getSelectedItem().toString();
            String Month = month2.getSelectedItem().toString();
            String Day = day2.getSelectedItem().toString();
            String expiration_date = Year + " " + Month + " " + Day;
            double c_limit =  Double.valueOf(credit.getText());
            int g_period = Integer.valueOf(grace.getText());
            // instance of operator for getting value
            
            for (Bank_card j: arrayl)//Arraylis
            {
                
                if (j instanceof Credit_card)
                {
                  //object downcasting
                  Credit_card obj_credit = (Credit_card) j;    
                  // comparing the value of card_id (if the values are same or not)
                    if (obj_credit.getCARD_ID() == Cid)
                    {
                         obj_credit.cancelCreditCard(); //using cancelCreditCard method from Credit_card class
                         JOptionPane.showMessageDialog(panel_obj2, "Credit card is cancelled");
                         cvc.setText("");
                         credit.setText("");
                         grace.setText("");
                         arrayl.remove(obj_credit);
                         
                    }
                    else
                    {
                     JOptionPane.showMessageDialog(panel_obj2, "Wrong card ID entered! Please enter valid card ID"); //message dialog
                    }
                }
            }
            
        }
        
            
        
    }

    
    public static void main(String args[])  //Declaring main method
    {
        BankGUI gobg = new BankGUI(); //Creating object of the class BankGUI
        gobg.main_gui(); //Connecting the object whith method main_gui() 
        
    }
    
    public void main_gui()   //creating main_gui method
    {
        //Debit card
        
        //JFrame
        obj = new JFrame();
        obj.setTitle("Bank GUI");
        obj.setBounds(455,5,830,850);
        obj.setLayout(null);
       
        //JPanel
        panel_obj = new JPanel();
        panel_obj.setBounds(20,5,780,390);
        panel_obj.setLayout(null);
        panel_obj.setBackground(Color.CYAN);
       
        //JLabel
        Debit_card = new JLabel();
        Debit_card.setText("DEBIT CARD");
        Font ff = new Font("Arial", Font.BOLD , 22);
        Debit_card.setFont(ff);
        Debit_card.setBounds(300,11,155,75);
        panel_obj.add(Debit_card);
       
       
        Card_id = new JLabel();
        Card_id.setText("Card id:");
        Card_id.setBounds(82,91,75,30);
        panel_obj.add(Card_id);
       
        Client_name= new JLabel();
        Client_name.setText("Client name:");
        Client_name.setBounds(82,131,77,30);
        panel_obj.add(Client_name);
       
        Issuer_bank = new JLabel();
        Issuer_bank.setText("Issuer bank:");
        Issuer_bank.setBounds(82,171,77,30);
        panel_obj.add(Issuer_bank);
       
    
        Bank_Account = new JLabel();
        Bank_Account.setText("Bank account: ");
        Bank_Account.setBounds(372,91,100,30);
        panel_obj.add(Bank_Account);
       
        Balance_Amount = new JLabel();
        Balance_Amount.setText("Balance amount:");
        Balance_Amount.setBounds(372,131,140,30);
        panel_obj.add(Balance_Amount);
       
        Pin_number = new JLabel();
        Pin_number.setText("Pin number:");
        Pin_number.setBounds(372,171,100,30);
        panel_obj.add(Pin_number);
       
        Withdrawal_amount = new JLabel();
        Withdrawal_amount.setText("Withdrawal amount:");
        Withdrawal_amount.setBounds(82,226,172,30);
        panel_obj.add(Withdrawal_amount);
       
        //JTextField
        card_debit = new JTextField();
        card_debit.setBounds(162,96,155,20);
        panel_obj.add(card_debit);
       
        client_debit = new JTextField();
        client_debit.setBounds(162,136,155,20);
        panel_obj.add(client_debit);
       
        issuer_debit = new JTextField();
        issuer_debit.setBounds(162,176,155,20);
        panel_obj.add(issuer_debit);
       
        account_debit = new JTextField();
        account_debit.setBounds(502,96,155,20);
        panel_obj.add(account_debit);
       
        amount_debit = new JTextField();
        amount_debit.setBounds(502,136,155,20);
        panel_obj.add(amount_debit);
       
        pin_debit = new JTextField();
        pin_debit.setBounds(502,176,155,20);
        panel_obj.add(pin_debit);
       
        withdrawal_debit = new JTextField();
        withdrawal_debit.setBounds(202,231,140,20);
        panel_obj.add(withdrawal_debit);
       
        //JButton
        debit_card = new JButton();
        debit_card.setText(" Add Debit Card");
        debit_card.setBounds(150,335, 175, 30);
        debit_card.addActionListener(this);
        panel_obj.add(debit_card);
       
        display_button = new JButton();
        display_button.setText("Display");
        display_button.setBounds(470,335,90, 30);
        display_button.addActionListener(this);
        panel_obj.add(display_button);
       
        withdraw_button = new JButton();
        withdraw_button.setText("Withdraw");
        withdraw_button.setBounds(350,335,90, 30);
        withdraw_button.addActionListener(this);
        panel_obj.add(withdraw_button);
        
        clear_button = new JButton();
        clear_button.setText("Clear");
        clear_button.setBounds(520, 220, 100, 45);
        clear_button.addActionListener(this);
        panel_obj.add(clear_button);
        
       
        //JLabel
        withdrawal_date = new JLabel();
        withdrawal_date.setText("Date of Withdrawl:");
        withdrawal_date.setBounds(180,280,290,22);
        panel_obj.add(withdrawal_date);
       
        //Declaring array and JComboBox
        String days[] = {"1","2", "3", "4", "5", "6", "7", "8", "9",
        "10","11","12", "13", "14", "15", "16", "17", "18", "19","20",
        "21","22", "23", "24", "25", "26", "27", "28", "29","30"};
        day = new JComboBox(days);
        day.setBounds (300,280,70,25);
        panel_obj.add(day);
       
        String Month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        month = new JComboBox(Month);
        month.setBounds (370,280,70,25);
        panel_obj.add(month);
       
        String Year[] = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
        "2016","2017","2018","2019","2020","2021","2022","2023"};
         year = new JComboBox(Year);
        year.setBounds (441,280,70,25);
        panel_obj.add(year);
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Credit card
        
        //JPanel
        panel_obj2 = new JPanel();
        panel_obj2.setBounds(20, 400,780,400);
        panel_obj2.setLayout(null);
        panel_obj2.setBackground(Color.lightGray);
       
        //JLabel
        Credit_card = new JLabel();
        Credit_card.setText("CREDIT   CARD");
        Font fc = new Font("Arial", Font.BOLD , 22);
        Credit_card.setFont(fc);
        Credit_card.setBounds(300,20,180,30);
        panel_obj2.add(Credit_card);
       
        Card_ID = new JLabel();
        Card_ID.setText("Card id:");
        Card_ID.setBounds(82,70,75,30);
        panel_obj2.add(Card_ID);
       
        Client_NAME= new JLabel();
        Client_NAME.setText("Client name:");
        Client_NAME.setBounds(82,110,75,30);
        panel_obj2.add(Client_NAME);
       
        Issuer_BANK = new JLabel();
        Issuer_BANK.setText("Issuer bank:");
        Issuer_BANK.setBounds(82,150,75,30);
        panel_obj2.add(Issuer_BANK);
       
        Bank_ACCOUNT = new JLabel();
        Bank_ACCOUNT.setText("Bank account:");
        Bank_ACCOUNT.setBounds(82,200,100,30);
        panel_obj2.add(Bank_ACCOUNT);
               
        Grace_PERIOD = new JLabel();
        Grace_PERIOD.setText("Grace period:");
        Grace_PERIOD.setBounds(82,240,170,30);
        panel_obj2.add(Grace_PERIOD);
       
        Balance_AMOUNT = new JLabel();
        Balance_AMOUNT.setText("Balance amount:");
        Balance_AMOUNT.setBounds(372,70,140,30);
        panel_obj2.add(Balance_AMOUNT);
       
        CVC_NUMBER = new JLabel();
        CVC_NUMBER.setText("CVC number:");
        CVC_NUMBER.setBounds(372,110,170,30);
        panel_obj2.add(CVC_NUMBER);
       
        Credit_LIMIT = new JLabel();
        Credit_LIMIT.setText("Credit limit:");
        Credit_LIMIT.setBounds(372,150,170,30);
        panel_obj2.add(Credit_LIMIT);
       
        Interest_RATE = new JLabel();
        Interest_RATE.setText("Interest rate :");
        Interest_RATE.setBounds(372,190,170,30);
        panel_obj2.add(Interest_RATE);
       
       
        
        //JTextField
        card_credit = new JTextField();
        card_credit.setBounds(162,75,155,20);
        panel_obj2.add(card_credit);
       
        client_credit = new JTextField();
        client_credit.setBounds(162,115,155,20);
        panel_obj2.add(client_credit);
       
        issuer_credit = new JTextField();
        issuer_credit.setBounds(162,155,155,20);
        panel_obj2.add(issuer_credit);
       
        account_credit = new JTextField();
        account_credit.setBounds(182,205,155,20);
        panel_obj2.add(account_credit);
       
        amount_credit = new JTextField();
        amount_credit.setBounds(502,75,155,20);
        panel_obj2.add(amount_credit);
       
       
        cvc = new JTextField();
        cvc.setBounds(502,115,155,20);
        panel_obj2.add(cvc);
       
        credit = new JTextField();
        credit.setBounds(502,155,155,20);
        panel_obj2.add(credit);
       
        interest = new JTextField();
        interest.setBounds(502,195,155,20);
        panel_obj2.add(interest);
       
        grace= new JTextField();
        grace.setBounds(182,245,155,20);
        panel_obj2.add(grace);
       
       
       
        //JButton
        credit_card = new JButton();
        credit_card.setText("Add Credit Card");
        credit_card.setBounds(100, 345, 150, 35);
        credit_card.addActionListener(this);
        panel_obj2.add(credit_card);
       
        
        credit_limit = new JButton();
        credit_limit.setText("Set the credit limit");
        credit_limit.setBounds(270,345,180,35);
        credit_limit.addActionListener(this);
        panel_obj2.add(credit_limit);
        
        cancel = new JButton();
        cancel.setText("Cancel credit card");
        cancel.setBounds(470, 345, 150, 35);
        cancel.addActionListener(this);
        panel_obj2.add(cancel);
       
        display_obj = new JButton();
        display_obj.setText("Display");
        display_obj.setBounds(580, 295,90, 33);
        display_obj.addActionListener(this);
        panel_obj2.add(display_obj);
        
       
        clear_credit = new JButton();
        clear_credit.setText("Clear");
        clear_credit.setBounds(490, 230,100, 40);
        clear_credit.addActionListener(this);
        panel_obj2.add(clear_credit);
        
       
        //JLabel
        expiration_date = new JLabel();
        expiration_date .setText("Expiration Date:");
        expiration_date.setBounds(180,293,150,30);
        panel_obj2.add(expiration_date );
       
        
        //Declaring arrays and JComboBox
         String date[] = {"1","2", "3", "4", "5", "6", "7", "8", "9",
        "10","11","12", "13", "14", "15", "16", "17", "18", "19","20",
        "21","22", "23", "24", "25", "26", "27", "28", "29","30"};
       
        day2 = new JComboBox(date);
        day2.setBounds (290,295,70,25);
        panel_obj2.add(day2);
       
        String monnth[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
       
        month2 = new JComboBox(monnth);
        month2.setBounds (355,295,70,25);
        panel_obj2.add(month2);
       
        String Yr[] = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
        "2016","2017","2018","2019","2020","2021","2022","2023"};
       
        year2 = new JComboBox(Yr);
        year2.setBounds (425,295,70,25);
        panel_obj2.add(year2);
       
       
       
       
       
       
       
        //Adding panel objects inside JFrame object
        obj.add(panel_obj);
        obj.add(panel_obj2);
        //Setting Visibility true to make the JFrame visible
        obj.setVisible(true);
    }
}
