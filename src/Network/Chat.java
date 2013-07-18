package Network;

import java.net.*;
import java.awt.Container;
import java.awt.Dimension;
import java.io.*;
import java.util.*;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
/**
 *Klasse für den "normalen" Chat User. 
 * 
 */
public class Chat extends JFrame {
    /**
	 * Variablen deklaration
	 * Ip ist selbstreferenzierend, reader liest die Dateien die vom Server gesendet werden, writer schreibt dateien an den Server
	 * ArrayList bildet die Online User List
	 */
	private static final long serialVersionUID = 1L;
	String username, serverIP = "127.0.0.1 ";
    int Port = 5000;
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    ArrayList<String> userList = new ArrayList();
    Boolean isConnected = false;
    
    


   /**
    * initiert den Chat und seine Komponenten
    */
    public Chat() {
        initComponents();
    }

    /**
     * liest die Strings die vom Server gesendet werden. Der String wird durch ":" in 3 Teile geteilt. Der letzte Teil 
     * zeigt dem Reader worum es geht und was mit dem String passieren soll. 
     * @author Sarah
     *
     */
    public class IncomingReader implements Runnable{

        public void run() {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try {
                while ((stream = reader.readLine()) != null) {

                    data = stream.split(":");

                     if (data[2].equals(chat)) {

                        chatTextArea.append(data[0] + ": " + data[1] + "\n");
                        chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength());

                    } else if (data[2].equals(connect)){

                        chatTextArea.removeAll();
                        userAdd(data[0]);

                    } else if (data[2].equals(disconnect)) {


                        userRemove(data[0]);

                    } else if (data[2].equals(done)) {


                        usersList.setText("");
                        writeUsers();
                        userList.clear();

                    }
                 
                }
           }catch(Exception ex) {
           }
        }
    }

    public void ListenThread() {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }

    public void userAdd(String data) {
         userList.add(data);

     }

    public void userRemove(String data) {
         chatTextArea.append(data + " has disconnected.\n");

     }

    public void writeUsers() {
         String[] tempList = new String[(userList.size())];
         userList.toArray(tempList);
         for (String token:tempList) {

             usersList.append(token + "\n");

         }

     }

    public void sendDisconnect() {

       String bye = (username + ": :Disconnect");
        try{
            writer.println(bye); // Sends server the disconnect signal.
            writer.flush(); // flushes the buffer
        } catch (Exception e) {
            chatTextArea.append("Could not send Disconnect message.\n");
        }

      }

    public void Disconnect() {

        try {
               chatTextArea.append("Disconnected.\n");
               sock.close();
        } catch(Exception ex) {
               chatTextArea.append("Failed to disconnect. \n");
        }
        isConnected = false;
        usernameField.setEditable(true);
        usersList.setText("");

      }
    /**
     * initiert die Komponenten  
     */
                         
    private void initComponents() {

    	jScrollPane1 = new JScrollPane();
        inputTextArea = new JTextArea();
        ScrollChatTextArea = new JScrollPane();
        chatTextArea = new JTextArea();
        inputUsername = new JLabel();
        usernameField = new JTextField();
        connectButton = new JButton();
        disconnectButton = new JButton();
        sendButton = new JButton();
        ScrollUserList = new JScrollPane();
        usersList = new JTextArea();
        lblOnlineArea = new JLabel();
        JLabel label_name;
        ImageIcon icon_bild = new ImageIcon(this.getClass().getResource("/Resources/NetworkMainbackground.PNG"));
        
       
        label_name = new JLabel(icon_bild);
		label_name.setBounds(0, 0, 798, 620);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Client");
     
               

        inputTextArea.setColumns(20);
        inputTextArea.setLineWrap(true);
        inputTextArea.setRows(5);
        jScrollPane1.setViewportView(inputTextArea);

        chatTextArea.setColumns(20);
        chatTextArea.setEditable(false);
        chatTextArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        chatTextArea.setLineWrap(true);
        chatTextArea.setRows(5);
        ScrollChatTextArea.setViewportView(chatTextArea);

        inputUsername.setText("Username:");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        

        usersList.setEditable(false);
        usersList.setColumns(20);
        usersList.setRows(5);
        ScrollUserList.setViewportView(usersList);
        lblOnlineArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOnlineArea.setText("Online Users");
                  
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ScrollChatTextArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectButton)
                        .addGap(18, 18, 18)
                        .addComponent(disconnectButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOnlineArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollUserList))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disconnectButton)
                    .addComponent(connectButton)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lblOnlineArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollChatTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                    .addComponent(ScrollUserList))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>   
    
    
 
    
    /**
     * das Betätigen des Connect Buttons verbindet den Chat mit dem Server. Ist der Nutzername eingegeben und die Verbindung hergestellt, wird das USername Feld auf
     * nicht editierbar gesetzt
     * @param evt
     */

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
            if (isConnected == false) {
            username = usernameField.getText();
            usernameField.setEditable(false);



            try {
                sock = new Socket(serverIP, Port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + ":has connected.:Connect"); // Displays to everyone that user connected.
                writer.flush(); // flushes the buffer
                isConnected = true; // Used to see if the client is connected.
                LobbyUser.main(null);
            } catch (Exception ex) {
                chatTextArea.append("Cannot Connect! Try Again. \n");
                usernameField.setEditable(true);
            }
            ListenThread();
        } else if (isConnected == true) {
            chatTextArea.append("You are already connected. \n");
        }
    }                                             

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        sendDisconnect();
        Disconnect();
    }                                                

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String nothing = "";
        if ((inputTextArea.getText()).equals(nothing)) {
            inputTextArea.setText("");
            inputTextArea.requestFocus();
        } else {
            try {
               writer.println(username + ":" + inputTextArea.getText() + ":" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                chatTextArea.append("Message was not sent. \n");
            }
            inputTextArea.setText("");
            inputTextArea.requestFocus();
        }

        inputTextArea.setText("");
        inputTextArea.requestFocus();
    }                                          

                                     

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    /**
    * Main Methode
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JLabel inputUsername;
    private javax.swing.JLabel lblOnlineArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane ScrollChatTextArea;
    private javax.swing.JScrollPane ScrollUserList;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextArea usersList;
    // End of variables declaration                   

}
