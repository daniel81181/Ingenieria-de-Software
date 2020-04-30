

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class UserLogin1 implements ActionListener{

  FileReader input;
  BufferedReader reader;

    JLabel loginLbl;
    JLabel userLbl;
    JLabel passwordLbl;
    JTextField userTxtF;
     JButton loginBtn;
     JPasswordField password;

     String user1;
     String passw;
     int n=0;
       private MenuPrincipalGUI menuac = new MenuPrincipalGUI();
  JFrame window ;
  public UserLogin1() {
  //  openFile(fileName);

    window = new JFrame("Refaccionaria login");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel main =  new JPanel();
    main.setLayout(new GridLayout(4,1) );

    JPanel userPanel=new JPanel();
    userPanel.setLayout(new GridLayout(1,2));

    JPanel passPanel=new JPanel();
    passPanel.setLayout(new GridLayout(1,2));

    loginLbl=new JLabel("Log In Refaccionaria",JLabel.CENTER);
    userLbl=new JLabel("User: ",JLabel.CENTER);
    passwordLbl=new JLabel("Password: ",JLabel.CENTER);

    userTxtF=new JTextField();
password=new JPasswordField();


   loginBtn=new JButton("Log In");loginBtn.addActionListener(this);

  userPanel.add(userLbl);userPanel.add(userTxtF);
  passPanel.add(passwordLbl);passPanel.add(password);

  main.add(loginLbl);
  main.add(userPanel);
  main.add(passPanel);
  main.add(loginBtn);


  window.getContentPane().add(main);
  window.setSize(450,200);
  window.setVisible(true);
  }

  public void openFile(String fileName) throws FileNotFoundException{

    input = new FileReader(fileName);
    reader = new BufferedReader(input);
  }

  public void doInput() throws IOException{

      openFile("users.txt");
      /*BufferedReader systemInput = new BufferedReader(new InputStreamReader(System.in) );
      System.out.print("User:");
      String user = systemInput.readLine();
      System.out.print("Pass:");
      String pass = systemInput.readLine();
*/}




  public boolean doValidate(String u, String p) throws IOException{

    String str  = "esta validando";
    while( (str = reader.readLine()) != null ){
      StringTokenizer tokenizer = new StringTokenizer(str,":");
      String user = tokenizer.nextToken();
      String pass = tokenizer.nextToken();
      System.out.println(u);
      System.out.println(p);

      if( user.equals(u) && pass.equals(p) ){
System.out.println("si jala");
        return true;

      }
    }

    return false;
  }

  public void closeFile()throws IOException{
    reader.close();
  }
  public void setUPass(){
    try{
      System.out.println(user1);
      System.out.println(passw);
      boolean validate = doValidate(user1,passw);


      if( validate==true){
        System.out.println("Entered!");
        window.setVisible(false);
        menuac.getPanel();
        menuac.setVisible(true);
        closeFile();
      }else{

        System.out.println("Bye");
      }
  }catch(Exception e){
    System.out.println(e);
  }
  }
   public void actionPerformed(ActionEvent evt)
{
  if(evt.getSource()== loginBtn){
     user1 = userTxtF.getText();

      char[]passw1= password.getPassword();
    String passwo=new String(passw1);

      passw=passwo;
      //giveString(user1,passw);
      setUPass();
    }
  }


  public static void main(String args[]){


    try{
    UserLogin1 login = new UserLogin1();
    login.doInput();

    //login.closeFile();
  }catch(Exception e){
    System.out.println(e);
  }
}

}
