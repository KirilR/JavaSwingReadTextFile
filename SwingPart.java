package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SwingPart extends JFrame implements ActionListener {

    JTextField txtdata;
    JTextArea area;
    JScrollPane scroll;
    JButton calbtn = new JButton("OpenFile");
    JButton calbtn2 = new JButton("choosefile");
    Filea filea = new Filea();
    public SwingPart(){
        JPanel myPanel = new JPanel();
        this.add(myPanel);
        myPanel.setSize(500,1000);
        myPanel.add(calbtn);
        myPanel.add(calbtn2);
        calbtn.addActionListener(this);
        calbtn2.addActionListener(this);
        txtdata = new JTextField(22);
        area = new JTextArea(3,16);
        scroll = new JScrollPane(area);
        scroll.setBounds(10, 11, 455, 249);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        myPanel.add(txtdata);
        myPanel.add(area);
        myPanel.add(scroll);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calbtn){
            try {
                String text = filea.returnContentFile();
                txtdata.setText(text);
                area.setText(text);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource() ==calbtn2){
            String path = filea.getDirectoryPath();
        }
    }
}
