// Source code is decompiled from a .class file using FernFlower decompiler.
package view;

import controller.Client;
import controller.Client.View;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CreateRoomPasswordFrm extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JTextField jTextField1;

    public CreateRoomPassword Frm() {
        this.initComponents();
        this.setTitle("Caro Nhom 1");
        this.setIconImage((new ImageIcon("assets/image/caroicon.png")).getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.jButton1.setIcon(new ImageIcon("assets/icon/door_exit.png"));
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jLabel2 = new JLabel();
        this.jButton2 = new JButton();
        this.jButton1 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(102, 102, 102));
        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("T\u1ea1o ph\u00f2ng");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, -1, 268, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jLabel1).addContainerGap(22, 32767)));
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("Nh\u1eadp m\u1eadt kh\u1ea9u");
        this.jButton2.setText("T\u1ea1o");
        this.jButton2.addActionListener(new 1(this));
        this.jButton1.addActionListener(new 2(this));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jLabel2, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.jTextField1).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jButton2, -2, 61, -2).addContainerGap()).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jButton1, -2, 50, -2).addGap(104, 104, 104)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(29, 29, 29).addComponent(this.jLabel2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jTextField1, -2, -1, -2).addComponent(this.jButton2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jButton1, -2, 50, -2).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        Client.closeView(View.CREATEROOMPASSWORD);
        Client.openView(View.HOMEPAGE);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        try {
            String password = this.jTextField1.getText();
            if (password.isEmpty()) {
                throw new Exception("Vui l\u00f2ng nh\u1eadp m\u1eadt kh\u1ea9u b\u1ea1n mu\u1ed1n \u0111\u1eb7t cho ph\u00f2ng");
            }

            Client.socketHandle.write("create-room," + password);
            Client.closeView(View.CREATEROOMPASSWORD);
        } catch (IOException var3) {
            JOptionPane.showMessageDialog(this.rootPane, var3.getMessage());
        } catch (Exception var4) {
            JOptionPane.showMessageDialog(this.rootPane, var4.getMessage());
        }

    }
}
