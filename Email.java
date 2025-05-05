import java.awt.*;  
import java.awt.event.*;  

public class Email
{
    public static void main(String[] args) 
    {
        Color Background = Color.white;
        Color TextColor = Color.black;
        Color ButtonColor = new Color(66, 133, 244); // Google Blue
        Color ButtonText = Color.white;
        Color ErrorText = Color.red;

        Frame f1 = new Frame("Google Mail");
        f1.setBackground(Background);

        Label Title = new Label("Create an");
        Title.setBounds(50, 150, 180, 15);
        Title.setForeground(TextColor);
        Title.setFont(new Font("Century Gothic", Font.BOLD, 18));

        Label Title_0 = new Label("Account");
        Title_0.setBounds(50, 180, 250, 15);
        Title_0.setForeground(TextColor);
        Title_0.setFont(new Font("Century Gothic", Font.BOLD, 20));

        Label L1 = new Label("Create Email");
        L1.setForeground(TextColor);
        L1.setBounds(400, 150, 100, 15);
        L1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        TextField T1 = new TextField();
        T1.setBounds(400, 170, 150, 25);

        Button B1 = new Button("Next");
        B1.setBounds(500, 220, 50, 25);
        B1.setForeground(ButtonText);
        B1.setBackground(ButtonColor);

        f1.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent we) 
            {
                System.exit(0);
            }
        });

        f1.add(Title);
        f1.add(Title_0);
        f1.add(L1);
        f1.add(T1);
        f1.add(B1);

        f1.setSize(600, 400);
        f1.setLayout(null);
        f1.setVisible(true);

        //----------------------------------------------------------------------------------------------------------------------------

        Frame f = new Frame("Google Mail");
        f.setBackground(Background);

        Label title = new Label("Create an Account");
        title.setBounds(210, 50, 180, 50);
        title.setForeground(TextColor);
        title.setFont(new Font("Century Gothic", Font.BOLD, 18));

        Label l1 = new Label("First Name");
        l1.setBounds(25, 150, 100, 50);
        l1.setForeground(TextColor);
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        Label l2 = new Label("Last Name");
        l2.setBounds(300, 150, 100, 50);
        l2.setForeground(TextColor);
        l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        Label l3 = new Label("Mobile");
        l3.setBounds(25, 250, 100, 50);
        l3.setForeground(TextColor);
        l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        Label l4 = new Label("DOB");
        l4.setBounds(300, 250, 100, 50);
        l4.setForeground(TextColor);
        l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        Label l5 = new Label("Password");
        l5.setBounds(25, 350, 100, 50);
        l5.setForeground(TextColor);
        l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        Label l6 = new Label("Re-enter");
        l6.setBounds(300, 350, 110, 20);
        l6.setForeground(TextColor);
        l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        Label l6_0 = new Label("Password");
        l6_0.setBounds(300, 370, 110, 20);
        l6_0.setForeground(TextColor);
        l6_0.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

        TextField t1 = new TextField();
        t1.setBounds(150, 160, 120, 30);
        TextField t2 = new TextField();
        t2.setBounds(425, 160, 120, 30);
        TextField t3 = new TextField();
        t3.setBounds(150, 260, 120, 30);
        TextField t4 = new TextField();
        t4.setBounds(425, 260, 120, 30);
        TextField t5 = new TextField();
        t5.setBounds(150, 360, 120, 30);
        TextField t6 = new TextField();
        t6.setBounds(425, 360, 120, 30);

        TextField t7 = new TextField();
        t7.setBounds(195, 500, 215, 20);
        t7.setForeground(Color.green);
        t7.setBackground(Background);
        t7.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        t7.setVisible(false);

        Button submit = new Button("SUBMIT");
        submit.setBounds(245, 450, 100, 30);
        submit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        submit.setForeground(ButtonText);
        submit.setBackground(ButtonColor);

        f.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent we) 
            {
                System.exit(0);
            }
        });

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l6_0);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(t7);
        f.add(submit);
        f.add(title);

        f.setSize(570, 600);
        f.setLayout(null);

        //------------------------------------------------------------------------------------------------------------------------

        B1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String a = T1.getText();
                if (a.isEmpty()) 
                {
                    T1.setForeground(ErrorText);
                    T1.setText("Enter a Mail");
                } 
                else 
                {
                    f1.setVisible(false);
                    f.setVisible(true);
                }
            }
        });

        submit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String pass = t5.getText();
                String pass2 = t6.getText();
                String mobile = t3.getText();
                
                boolean valid = true;

                try 
                {
                    Long.parseLong(mobile);
                    if (mobile.length() != 10) 
                    {
                        t3.setForeground(ErrorText);
                        t3.setText("Enter valid number");
                        valid = false;
                    }
                } 
                catch (Exception ex) 
                {
                    t3.setForeground(ErrorText);
                    t3.setText("Enter valid number");
                    valid = false;
                }

                if (pass.isEmpty()) 
                {
                    t5.setForeground(ErrorText);
                    t5.setText("Enter a password");
                    valid = false;
                }

                if (!pass.equals(pass2)) 
                {
                    t6.setForeground(ErrorText);
                    t6.setText("Enter same password");
                    valid = false;
                }

                if (valid) 
                {
                    t7.setText("Account Created Successfully");
                    t7.setVisible(true);
                }
            }
        });
    }
}