import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class functionalities {
    GUI gui;
    String filename, fileaddress;

    public functionalities(GUI gui) {
        this.gui = gui;
    }

    public void newf(){
        gui.tx.setText("");
        gui.wi.setTitle("Notepad - New File");
        filename = null;
        fileaddress = null;
    }
    public void openf() {
        FileDialog op = new FileDialog(gui.wi, "Open", FileDialog.LOAD);
        op.setVisible(true);
        
        if(op.getFile()!=null){
            filename=op.getFile();
            fileaddress=op.getDirectory();
            gui.wi.setTitle(filename);    // Implement file opening logic here
        // For example, using JFileChooser to select a file and read its content
    }
    try{
        BufferedReader br = new BufferedReader(new FileReader(fileaddress + filename));
        gui.tx.setText("");

        String line = null;
        while((line = br.readLine()) != null) {
            gui.tx.append(line + "\n");
        }
        br.close();
    }
    catch(Exception e) {
        System.out.println("Error opening file: " + e.getMessage());
    }
    }
    public void savef() {
        if(filename == null || fileaddress == null) {
            saveasf();
        } else {
            try {
                FileWriter fw = new FileWriter(fileaddress + filename);
                fw.write(gui.tx.getText());
                fw.close();
            } catch(Exception e) {
                System.out.println("Error saving file: " + e.getMessage());
            }
        }
       
    }
    public void saveasf() {
        FileDialog fdsa = new FileDialog(gui.wi, "Save As", FileDialog.SAVE);
        fdsa.setVisible(true);
        if(fdsa.getFile()!=null){
            filename = fdsa.getFile();
            fileaddress = fdsa.getDirectory();
            gui.wi.setTitle(filename);
        }  
        try{
            FileWriter fw = new FileWriter(fileaddress + filename);
            fw.write(gui.tx.getText());
            fw.close();
        }
        catch(Exception e) {
            System.out.println("Error saving file: ");
        }
    }
    public void exitf() {
        System.exit(0);
    }
}   


