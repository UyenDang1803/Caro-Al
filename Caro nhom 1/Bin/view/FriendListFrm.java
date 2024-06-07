// Source code is decompiled from a .class file using FernFlower decompiler.
package view;

import controller.Client;
import controller.Client.View;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import model.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FriendListFrm extends JFrame {
    private List<User> listFriend;
    private boolean isClicked;
    private Thread thread;
    DefaultTableModel defaultTableModel;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane3;
    private JTable jTable1;

    public FriendListFrm() {
        this.initComponents();
        this.defaultTableModel = (DefaultTableModel)this.jTable1.getModel();
        this.setTitle("Caro Game Nh\u00f3m 5");
        this.setIconImage((new ImageIcon("assets/image/caroicon.png")).getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.isClicked = false;
        this.requestUpdate();
        this.startThread();
    }

    public void stopAllThread() {
        this.isClicked = true;
    }

    public void startThread() {
        this.thread = new 1(this);
        this.thread.start();
    }

    public void requestUpdate() {
        try {
            Client.socketHandle.write("view-friend-list,");
        } catch (IOException var2) {
            JOptionPane.showMessageDialog(this.rootPane, var2.getMessage());
        }

    }

    public void updateFriendList(List<User> friends) {
        this.listFriend = friends;
        this.defaultTableModel.setRowCount(0);

        ImageIcon icon;
        User friend;
        for(Iterator var4 = this.listFriend.iterator(); var4.hasNext(); this.defaultTableModel.addRow(new Object[]{"" + friend.getID(), friend.getNickname(), icon})) {
            friend = (User)var4.next();
            if (!friend.isIsOnline()) {
                icon = new ImageIcon("assets/icon/offline.png");
            } else if (friend.isIsPlaying()) {
                icon = new ImageIcon("assets/icon/swords-mini.png");
            } else {
                icon = new ImageIcon("assets/icon/swords-1-mini.png");
            }
        }

    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.jScrollPane3 = new JScrollPane();
        Object[][] rows = new Object[0][];
        String[] columns = new String[]{"ID", "Nickname", ""};
        DefaultTableModel model = new 2(this, rows, columns);
        this.jTable1 = new JTable();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(102, 102, 102));
        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Danh s\u00e1ch b\u1ea1n b\u00e8");
        this.jButton1.setText("X");
        this.jButton1.addActionListener(new 3(this));
        this.jTable1.setFont(new Font("Tahoma", 1, 18));
        this.jTable1.setModel(model);
        this.jTable1.setRowHeight(60);
        this.jTable1.addMouseListener(new 4(this));
        this.jScrollPane3.setViewportView(this.jTable1);
        if (this.jTable1.getColumnModel().getColumnCount() > 0) {
            this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
            this.jTable1.getColumnModel().getColumn(1).setMinWidth(240);
            this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(240);
            this.jTable1.getColumnModel().getColumn(1).setMaxWidth(240);
            this.jTable1.getColumnModel().getColumn(2).setMinWidth(120);
            this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            this.jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButton1).addGap(0, 0, 32767)).addComponent(this.jLabel1, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 423, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jButton1).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.RELATED, 27, 32767).addComponent(this.jScrollPane3, -2, 427, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        Client.closeView(View.FRIENDLIST);
        Client.openView(View.HOMEPAGE);
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        try {
            if (this.jTable1.getSelectedRow() == -1) {
                return;
            }

            User friend = (User)this.listFriend.get(this.jTable1.getSelectedRow());
            if (!friend.isIsOnline()) {
                throw new Exception("Ng\u01b0\u1eddi ch\u01a1i kh\u00f4ng online");
            }

            if (friend.isIsPlaying()) {
                throw new Exception("Ng\u01b0\u1eddi ch\u01a1i \u0111ang trong tr\u1eadn \u0111\u1ea5u");
            }

            this.isClicked = true;
            int res = JOptionPane.showConfirmDialog(this.rootPane, "B\u1ea1n c\u00f3 mu\u1ed1n th\u00e1ch \u0111\u1ea5u ng\u01b0\u1eddi b\u1ea1n n\u00e0y kh\u00f4ng", "X\u00e1c nh\u1eadn th\u00e1ch \u0111\u1ea7u", 0);
            if (res == 0) {
                Client.closeAllViews();
                Client.openView(View.GAMENOTICE, "Th\u00e1ch \u0111\u1ea5u", "\u0110ang ch\u1edd ph\u1ea3n h\u1ed3i t\u1eeb \u0111\u1ed1i th\u1ee7");
                Client.socketHandle.write("duel-request," + friend.getID());
            } else {
                this.isClicked = false;
                this.startThread();
            }
        } catch (IOException var4) {
            JOptionPane.showMessageDialog(this.rootPane, var4.getMessage());
        } catch (Exception var5) {
            JOptionPane.showMessageDialog(this.rootPane, var5.getMessage());
        }

    }
    class FriendListFrm$1 extends Thread {
        FriendListFrm$1(FriendListFrm var1) {
            this.this$0 = var1;
        }

        public void run() {
            while(Client.friendListFrm.isDisplayable() && !this.this$0.isClicked) {
                try {
                    System.out.println("Xem danh s\u00e1ch b\u1ea1n b\u00e8 \u0111ang ch\u1ea1y!");
                    this.this$0.requestUpdate();
                    Thread.sleep(500L);
                } catch (InterruptedException var2) {
                    var2.printStackTrace();
                }
            }

        }
    }
    class FriendListFrm$2 extends DefaultTableModel {
        FriendListFrm$2(FriendListFrm var1, Object[][] $anonymous0, Object[] $anonymous1) {
            super($anonymous0, $anonymous1);
            this.this$0 = var1;
        }

        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return ImageIcon.class;
                default:
                    return Object.class;
            }
        }
    }
    class FriendListFrm$3 implements ActionListener {
        FriendListFrm$3(FriendListFrm var1) {
            this.this$0 = var1;
        }

        public void actionPerformed(ActionEvent evt) {
            this.this$0.jButton1ActionPerformed(evt);
        }
    }
    class FriendListFrm$4 extends MouseAdapter {
        FriendListFrm$4(FriendListFrm var1) {
            this.this$0 = var1;
        }

        public void mouseClicked(MouseEvent evt) {
            this.this$0.jTable1MouseClicked(evt);
        }
    }
}
