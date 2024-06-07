
package view;

import controller.Client;
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
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FriendRequestFrm extends JFrame {
    private int ID;
    private Timer timer;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel7;
    private JPanel jPanel1;

    public FriendRequestFrm(int ID, String nickname) {
        this.ID = ID;
        this.initComponents();
        this.setTitle("Caro Game Nh\u00f3m 5");
        this.setIconImage((new ImageIcon("assets/image/caroicon.png")).getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(2);
        this.setLocationRelativeTo((Component)null);
        this.jLabel7.setText("T\u1eeb " + nickname + "(ID=" + ID + ")");
        this.timer = new Timer(1000, new 1(this));
        this.timer.setInitialDelay(0);
        this.timer.start();
    }

    public void disposeFrame() {
        this.dispose();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jLabel3 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(102, 102, 102));
        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Y\u00eau c\u1ea7u k\u1ebft b\u1ea1n");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, -1, -1, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(29, 32767).addComponent(this.jLabel1).addGap(28, 28, 28)));
        this.jLabel2.setFont(new Font("Tahoma", 1, 14));
        this.jLabel2.setForeground(new Color(0, 102, 204));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("B\u1ea1n nh\u1eadn \u0111\u01b0\u1ee3c m\u1ed9t l\u1eddi m\u1eddi k\u1ebft b\u1ea1n ");
        this.jLabel7.setFont(new Font("Tahoma", 1, 14));
        this.jLabel7.setForeground(new Color(0, 102, 204));
        this.jLabel7.setHorizontalAlignment(0);
        this.jLabel7.setText("T\u1eeb");
        this.jButton1.setText("\u0110\u1ed3ng \u00fd");
        this.jButton1.addActionListener(new 2(this));
        this.jButton2.setText("T\u1eeb ch\u1ed1i");
        this.jButton2.addActionListener(new 3(this));
        this.jLabel3.setText("T\u1ef1 \u0111\u1ed9ng \u0111\u00f3ng sau ");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jLabel2, Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel7, Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(75, 75, 75).addComponent(this.jButton1, -2, 84, -2).addGap(27, 27, 27).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jButton2, -2, 86, -2).addContainerGap(76, 32767)).addComponent(this.jLabel3, -1, -1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel7).addGap(38, 38, 38).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel3).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        try {
            this.timer.stop();
            Client.socketHandle.write("make-friend-confirm," + this.ID);
            this.dispose();
        } catch (IOException var3) {
            JOptionPane.showMessageDialog(this.rootPane, "C\u00f3 l\u1ed7i x\u1ea3y ra");
        }

    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.timer.stop();
        this.dispose();
    }
    class FriendRequestFrm$1 implements ActionListener {
        int count;

        FriendRequestFrm$1(FriendRequestFrm var1) {
            this.this$0 = var1;
            this.count = 10;
        }

        public void actionPerformed(ActionEvent e) {
            --this.count;
            if (this.count >= 0) {
                this.this$0.jLabel3.setText("T\u1ef1 \u0111\u1ed9ng \u0111\u00f3ng trong " + this.count);
            } else {
                ((Timer)e.getSource()).stop();
                this.this$0.disposeFrame();
            }

        }
    }

    class FriendRequestFrm$2 implements ActionListener {
        FriendRequestFrm$2(FriendRequestFrm var1) {
            this.this$0 = var1;
        }

        public void actionPerformed(ActionEvent evt) {
            this.this$0.jButton1ActionPerformed(evt);
        }
    }
    class FriendRequestFrm$3 implements ActionListener {
        FriendRequestFrm$3(FriendRequestFrm var1) {
            this.this$0 = var1;
        }

        public void actionPerformed(ActionEvent evt) {
            this.this$0.jButton2ActionPerformed(evt);
        }
    }

}
