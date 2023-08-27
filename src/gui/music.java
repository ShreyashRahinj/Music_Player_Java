/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import sqlconnector.connector;


/**
 *
 * @author Shreyash
 */
public class music extends javax.swing.JFrame {
    Clip clip;
    long cliptimeposition = 0;
    static Node head = null;
    static Node now = null;
    Boolean isplaying = false;
    
    
    /**
     * Creates new form music
     */
    public music() {
        initComponents();
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        previousbutton = new javax.swing.JButton();
        playbutton = new javax.swing.JButton();
        pausebutton = new javax.swing.JButton();
        nextbutton = new javax.swing.JButton();
        addfilebutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deletebutton = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        previousbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/previousbutton.png"))); // NOI18N
        previousbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(previousbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 63, -1));

        playbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Thumbnail.png"))); // NOI18N
        playbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(playbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 64, 67));

        pausebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/pausebutton.jpg"))); // NOI18N
        pausebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(pausebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 260, 60, 67));

        nextbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/nextbutton.png"))); // NOI18N
        nextbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(nextbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 60, -1));

        addfilebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/addsongbutton.png"))); // NOI18N
        addfilebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addfilebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(addfilebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        jTable1.setBackground(new java.awt.Color(255, 153, 0));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Songs"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 190, 220));

        deletebutton.setBackground(new java.awt.Color(0, 0, 0));
        deletebutton.setForeground(new java.awt.Color(255, 255, 255));
        deletebutton.setText("Delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(deletebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pausebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausebuttonActionPerformed

        isplaying = false;
        pausemusic();
    }//GEN-LAST:event_pausebuttonActionPerformed

    private void previousbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousbuttonActionPerformed

        isplaying = false;
        clip.stop();
        cliptimeposition = 0;
        now = now.previous;
        playmusic(now.song_name);
    }//GEN-LAST:event_previousbuttonActionPerformed

    private void nextbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbuttonActionPerformed

        isplaying = false;
        clip.stop();
        cliptimeposition = 0;
        now = now.next;
        playmusic(now.song_name);    
    }//GEN-LAST:event_nextbuttonActionPerformed

    private void addfilebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addfilebuttonActionPerformed
        music obj = new music();
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        try{
            Connection Con = connector.getCon();
            Statement st = Con.createStatement();
            st.executeUpdate("insert into music values('"+filename+"')");
            ResultSet rs = st.executeQuery("select * from music");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println("Song format unsupported");
        }
        
        Node n = new Node(filename);
        music.insert(n);
    }//GEN-LAST:event_addfilebuttonActionPerformed

    private void playbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playbuttonActionPerformed

        playmusic(now.song_name);
    }//GEN-LAST:event_playbuttonActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
        try{
            Connection Con = connector.getCon();
            Statement st = Con.createStatement();
            ResultSet rs = st.executeQuery("select * from music");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){
                Node a = new Node(rs.getString("sname"));
                insert(a);
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_formComponentShown

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        music obj = new music();
        DefaultTableModel tb1 = (DefaultTableModel)jTable1.getModel();
        String tb1s = tb1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        try{
            Connection Con = connector.getCon();
            Statement st = Con.createStatement();
            st.executeUpdate("DELETE FROM music WHERE sname='"+tb1s+"'");
            String s = tb1s.substring(0,2);
            s = s.concat("\\");
            s = s.concat(tb1s.substring(2,7));
            s = s.concat("\\");
            s = s.concat(tb1s.substring(7));
            Node a = new Node(s);
            deleteNode(a);
            setVisible(false);
            new music().setVisible(true);
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        import_songs();
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(music.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new music().setVisible(true);
            }
        });
    }
    public void playmusic(String filepath){
        if(!isplaying){
        try {
            AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(filepath));
            
            clip = AudioSystem.getClip();
            clip.open(inputstream);
            clip.setMicrosecondPosition(cliptimeposition);
            clip.start();
            isplaying = true;
        }   
            catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                
                e.printStackTrace();
            }
        }}
        public void pausemusic(){
            cliptimeposition = clip.getMicrosecondPosition();
            clip.stop();
        }
        class Node{
        String song_name;
        Node next;
        Node previous;
        Node(String sname){
            song_name = sname;
            next = null;
            previous = null;
        }
    }

    static void insert(Node new_node){
        new_node.next = null;
        if(head == null){
            new_node.previous = null;
            head = new_node;
            now = new_node;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.previous = temp;
        }
        
    }



    static void import_songs(){
        music obj = new music();

        try{
            Connection Con = connector.getCon();
            Statement st = Con.createStatement();
            ResultSet rs = st.executeQuery("select * from music");
            
            while(rs.next()){
                
                String filename = rs.getString("sname");
                String s = filename.substring(0,2);
                s = s.concat("\\");
                s = s.concat(filename.substring(2,7));
                s = s.concat("\\");
                s = s.concat(filename.substring(7));
                Node a = obj.new Node(s);
                insert(a);
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        

    }
    static void deleteNode(Node del)
    {
 
        // Base case
        if (head == null || del == null) {
            return;
        }
 
        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }
 
        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.previous = del.previous;
        }
 
        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.previous != null) {
            del.previous.next = del.next;
            }
 
        // Finally, free the memory occupied by del
        return;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addfilebutton;
    private javax.swing.JButton deletebutton;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton nextbutton;
    private javax.swing.JButton pausebutton;
    private javax.swing.JButton playbutton;
    private javax.swing.JButton previousbutton;
    // End of variables declaration//GEN-END:variables
}
