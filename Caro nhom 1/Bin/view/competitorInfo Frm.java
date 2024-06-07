// Source code is decompiled from a .class file using FernFlower decompiler.
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import model.User;

public class CompetitorInfo Frm extends JFrame {
    private boolean isFriend;
    private User user;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;

    public CompetitorInfo Frm(User user) {
        try {
            this.initComponents();
            this.user = user;
            this.setTitle("Caro Game Nh\u00f3m 5");
            this.setIconImage((new ImageIcon("assets/image/caroicon.png")).getImage());
            this.setResizable(false);
            this.setDefaultCloseOperation(2);
            this.setLocationRelativeTo((Component)null);
            this.jLabel6.setIcon(new ImageIcon("assets/avatar/" + user.getAvatar() + ".jpg"));
            this.jLabel7.setText(user.getNickname());
            this.jLabel8.setText("" + user.getNumberOfGame());
            this.jLabel9.setText("" + user.getNumberOfwin());
            this.jLabel17.setText("" + user.getNumberOfDraw());
            this.jLabel13.setText("" + user.getRank());
            if (user.getNumberOfGame() == 0) {
                this.jLabel15.setText("-");
            } else {
                JLabel var10000 = this.jLabel15;
                Object[] var10002 = new Object[]{(float)user.getNumberOfwin() / (float)user.getNumberOfGame() * 100.0F};
                var10000.setText(String.format("%.2f", var10002) + "%");
            }

            this.jLabel12.setText("" + (user.getNumberOfwin() * 10 + user.getNumberOfGame()));
            Client.socketHandle.write("check-friend," + user.getID());
        } catch (IOException var3) {
            JOptionPane.showMessageDialog(this.rootPane, var3.getMessage());
        }

    }

    public void checkFriend(boolean isFriend) {
        this.isFriend = isFriend;
        if (isFriend) {
            this.jButton1.setIcon(new ImageIcon("assets/icon/friendship.png"));
            this.jButton1.setToolTipText("B\u1ea1n b\u00e8");
            this.jLabel5.setText("B\u1ea1n b\u00e8");
        } else {
            this.jButton1.setIcon(new ImageIcon("assets/icon/add-friend.png"));
            this.jButton1.setToolTipText("Click \u0111\u1ec3 g\u1eedi y\u00eau c\u1ea7u k\u1ebft b\u1ea1n");
            this.jLabel5.setText("K\u1ebft b\u1ea1n \u0111\u1ec3 ch\u01a1i c\u00f9ng nhau d\u1ec5 d\u00e0ng h\u01a1n");
        }

    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(102, 102, 102));
        this.jPanel1.setForeground(new Color(102, 102, 102));
        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Th\u00f4ng tin \u0111\u1ed1i th\u1ee7");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, -1, -1, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel1).addContainerGap(23, 32767)));
        this.jButton1.addActionListener(new 1(this));
        this.jLabel2.setText("Nickname");
        this.jLabel3.setText("S\u1ed1 v\u00e1n ch\u01a1i");
        this.jLabel4.setText("S\u1ed1 v\u00e1n th\u1eafng");
        this.jLabel5.setForeground(new Color(0, 51, 255));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText("C\u00e1c b\u1ea1n hi\u1ec7n \u0111ang l\u00e0 b\u1ea1n b\u00e8");
        this.jLabel7.setText("{nickname}");
        this.jLabel8.setText("{sovachoi}");
        this.jLabel9.setText("{sovanthang}");
        this.jLabel10.setText("\u0110i\u1ec3m");
        this.jLabel11.setText("Th\u1ee9 h\u1ea1ng");
        this.jLabel12.setText("{diem}");
        this.jLabel13.setText("{thuhang}");
        this.jLabel14.setText("T\u1ec9 l\u1ec7 th\u1eafng");
        this.jLabel15.setText("{tillethang}");
        this.jLabel16.setText("S\u1ed1 v\u00e1n h\u00f2a");
        this.jLabel17.setText("{sovanhoa}");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jLabel5, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel6, -2, 90, -2).addComponent(this.jLabel3, -2, 69, -2).addComponent(this.jLabel4, -2, 78, -2).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel2, -2, 69, -2).addGap(33, 33, 33)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.jLabel14, Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel11, Alignment.LEADING, -1, 67, 32767)).addGap(35, 35, 35))).addComponent(this.jLabel10, -2, 40, -2).addComponent(this.jLabel16, -2, 78, -2)).addGap(20, 20, 20).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.jLabel9, -1, 90, 32767).addComponent(this.jLabel8, -1, -1, 32767)).addComponent(this.jButton1, -2, 99, -2).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel15, -2, 63, -2).addGroup(Alignment.LEADING, layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.jLabel13, Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel12, Alignment.LEADING, -2, 63, -2))).addComponent(this.jLabel7, -2, 110, -2).addComponent(this.jLabel17, -2, 72, -2)).addContainerGap(22, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel6, -2, 91, -2).addComponent(this.jButton1, -2, 91, -2)).addGap(28, 28, 28).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel7)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel8)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel9)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.jLabel17)).addPreferredGap(ComponentPlacement.RELATED, 11, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel14).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel10).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel11)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel15).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel12).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel13))).addGap(18, 18, 18).addComponent(this.jLabel5).addContainerGap()));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        if (this.isFriend) {
            JOptionPane.showMessageDialog(this.rootPane, "B\u1ea1n v\u00e0 \u0111\u1ed1i th\u1ee7 \u0111ang l\u00e0 b\u1ea1n b\u00e8");
        } else {
            int res = JOptionPane.showConfirmDialog(this.rootPane, "B\u1ea1n \u0111\u1ed3ng \u00fd g\u1eedi l\u1eddi m\u1eddi k\u1ebft b\u1ea1n t\u1edbi \u0111\u1ed1i th\u1ee7 ch\u1ee9", "X\u00e1c nh\u1eadn y\u00eau c\u1ea7u k\u1ebft b\u1ea1n", 0);
            if (res == 0) {
                try {
                    Client.socketHandle.write("make-friend," + this.user.getID());
                } catch (IOException var4) {
                    JOptionPane.showMessageDialog(this.rootPane, var4.getMessage());
                }
            }
        }

    }
}
