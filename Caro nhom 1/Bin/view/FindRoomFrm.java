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
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FindRoomFrm extends JFrame {
    private Timer timer;
    private boolean isFinded;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JProgressBar jProgressBar1;

    public FindRoomFrm() {
        this.initComponents();
        this.setTitle("Caro Game Nh\u00f3m 5");
        this.setIconImage((new ImageIcon("assets/image/caroicon.png")).getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component) null);
        this.jLabel5.setIcon(new ImageIcon("assets/icon/loading1.gif"));
        this.jButton1.setIcon(new ImageIcon("assets/icon/door_exit.png"));
        this.jProgressBar1.setValue(70);
        this.isFinded = false;
        this.startFind();
        this.sendFindRequest();
    }

    public void stopAllThread() {
        this.timer.stop();
    }

    public void startFind() {
        this.jLabel4.setVisible(false);
        this.jLabel5.setVisible(false);
        this.timer = new Timer(1000, new 1 (this));
        this.timer.setInitialDelay(0);
        this.timer.start();
    }

    public void sendFindRequest() {
        try {
            Client.socketHandle.write("quick-room,");
        } catch (IOException var2) {
            JOptionPane.showMessageDialog(this.rootPane, var2.getMessage());
        }

    }

    public void showFindedRoom() {
        this.isFinded = true;
        this.timer.stop();
        this.jLabel4.setVisible(true);
        this.jLabel5.setVisible(true);
        this.jLabel2.setVisible(false);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jProgressBar1 = new JProgressBar();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jButton1 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(102, 102, 102));
        this.jLabel1.setBackground(new Color(255, 255, 255));
        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("T\u00ecm ph\u00f2ng nhanh");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, -1, 528, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jLabel1).addContainerGap(25, 32767)));
        this.jLabel2.setFont(new Font("Tahoma", 2, 14));
        this.jLabel2.setText("\u0110ang t\u00ecm \u0111\u1ed1i th\u1ee7");
        this.jLabel3.setFont(new Font("Tahoma", 1, 14));
        this.jLabel3.setText("00:20");
        this.jLabel4.setFont(new Font("Tahoma", 0, 14));
        this.jLabel4.setForeground(new Color(0, 51, 204));
        this.jLabel4.setText("\u0110\u00e3 t\u00ecm th\u1ea5y \u0111\u1ed1i th\u1ee7, \u0111ang v\u00e0o ph\u00f2ng");
        this.jButton1.addActionListener(new 2 (this));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(53, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jProgressBar1, -2, 424, -2).addGap(51, 51, 51)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel3, -2, 47, -2).addGap(239, 239, 239)).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel2, -2, 113, -2).addGap(200, 200, 200)).addGroup(layout.createSequentialGroup().addGap(89, 89, 89).addComponent(this.jLabel4).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel5, -2, 43, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1, -2, 50, -2).addContainerGap())))));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(30, 30, 30).addComponent(this.jLabel3).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jProgressBar1, -2, -1, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel5, -2, 41, -2).addComponent(this.jButton1, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        if (!this.isFinded) {
            try {
                Client.socketHandle.write("cancel-room,");
            } catch (IOException var3) {
                JOptionPane.showMessageDialog(this.rootPane, var3.getMessage());
            }

            this.timer.stop();
            Client.closeView(View.FINDROOM);
            Client.openView(View.HOMEPAGE);
        }
    }
    class FindRoomFrm$1 implements ActionListener {
        int count;

        FindRoomFrm$1(FindRoomFrm var1) {
            this.this$0 = var1;
            this.count = 20;
        }

        public void actionPerformed(ActionEvent e) {
            --this.count;
            if (this.count >= 0) {
                if (this.count >= 10) {
                    this.this$0.jLabel3.setText("00:" + this.count);
                } else {
                    this.this$0.jLabel3.setText("00:0" + this.count);
                }

                this.this$0.jProgressBar1.setValue(Math.round((float)this.count / 20.0F * 100.0F));
            } else {
                ((Timer)e.getSource()).stop();

                try {
                    Client.socketHandle.write("cancel-room,");
                } catch (IOException var3) {
                    JOptionPane.showMessageDialog(FindRoomFrm.access$0(this.this$0), var3.getMessage());
                }

                int res = JOptionPane.showConfirmDialog(FindRoomFrm.access$0(this.this$0), "T\u00ecm ki\u1ebfm th\u1ea5t b\u1ea1i, b\u1ea1n mu\u1ed1n th\u1eed l\u1ea1i l\u1ea7n n\u1eefa ch\u1ee9?");
                if (res == 0) {
                    this.this$0.startFind();
                    this.this$0.sendFindRequest();
                } else {
                    Client.closeView(View.FINDROOM);
                    Client.openView(View.HOMEPAGE);
                }
            }

        }
    }
class FindRoomFrm$2 implements ActionListener {
    FindRoomFrm$2(FindRoomFrm var1) {
        this.this$0 = var1;
    }

    public void actionPerformed(ActionEvent evt) {
        this.this$0.jButton1ActionPerformed(evt);
    }
}
}
