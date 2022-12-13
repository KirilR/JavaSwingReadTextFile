package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

public class Filea extends Component {

//String path = getDirectoryPath();
    public String getDirectoryPath() {
        JFileChooser chooser = new JFileChooser();
       // chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
       // chooser.addChoosableFileFilter(new FileNameExtensionFilter("MS Word file(.docx)", "docx"));
        chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
        chooser.showOpenDialog(this);
        File file = chooser.getSelectedFile();
        String fullPath = file.getAbsolutePath();
        return fullPath;
    }

    public String returnContentFile() throws IOException {
        //File file = new File(getDirectoryPath());
        BufferedReader br = new BufferedReader(new FileReader(getDirectoryPath()));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();

        }
        String everything = sb.toString();
        br.close();
        return  everything;
    }


}
