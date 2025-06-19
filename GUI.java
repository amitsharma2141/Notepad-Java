import javax.swing.*;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.*;
// Notepad GUI application using Java Swing
public class GUI implements ActionListener{
    JFrame wi;
    JTextArea tx;
    boolean wordWrapOn = false;
    JScrollPane sb;
    JMenuBar mb;    
    JMenu mfile, medit, mformat, mcolor, mpdf;
    JMenuItem fnew, fopen, fsave, fsaveas, fexit;
    JMenuItem fwrap, fArial, fcms, ftnr, fsize8, fsize12, fsize18, fsize24, fsize28;
    JMenu fofont, fsize;
    JMenuItem color1, color2, color3;
    JMenuItem eundo, eredo;
    
    functionalities files = new functionalities(this);
    function_format format = new function_format(this);
    functionedit edit = new functionedit(this);
    UndoManager undo = new UndoManager();
    public static void main(String[] args) {
        new GUI();
    }
    public GUI(){
        createwin();
        textare();
        menubar();
        createfilemenu();
        wi.setVisible(true);
        createeditmenu();
        createformatmenu();
        format.selectfont = "Arial"; // Default font
        format.createfont(12); // Default font size
        format.wordWrap();
        createcolormenu();
    }
    public void createwin(){
        wi = new JFrame("Notepad");
        wi.setSize(600,300);
        wi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void textare(){
        tx = new JTextArea();

        tx.getDocument().addUndoableEditListener(new UndoableEditListener() {
             public void undoableEditHappened(javax.swing.event.UndoableEditEvent e) {
                undo.addEdit(e.getEdit()); 
             }
        });
        tx.setLineWrap(true);
        tx.setWrapStyleWord(true);
        wi.add(tx);
        sb = new JScrollPane(tx,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sb.setBorder(BorderFactory.createEmptyBorder());
        wi.add(sb);
        
    }
    public void menubar(){
        mb = new JMenuBar();
        wi.setJMenuBar(mb);
        
        mfile = new JMenu("File");
        mb.add(mfile);

        medit = new JMenu("Edit");
        mb.add(medit);

        mformat = new JMenu("Format");
        mb.add(mformat);

        mcolor = new JMenu("Color");
        mb.add(mcolor);

        mpdf = new JMenu("Convert to PDF");
        mb.add(mpdf);


    }
    public void createfilemenu(){
        fnew = new JMenuItem("New");
        fnew.addActionListener(this);
        fnew.setActionCommand("New");
        mfile.add(fnew);

        fopen = new JMenuItem("Open");
        fopen.addActionListener(this);
        fnew.setActionCommand("Open");
        mfile.add(fopen);

        fsave = new JMenuItem("Save");
        fsave.addActionListener(this);
        fsave.setActionCommand("Save");
        mfile.add(fsave);

        fsaveas = new JMenuItem("Save As");
        fsaveas.addActionListener(this);
        fsaveas.setActionCommand("Save As");
        mfile.add(fsaveas);

        fexit = new JMenuItem("Exit");
        fexit.addActionListener(this);
        fexit.setActionCommand("Exit");
        mfile.add(fexit);
    }

    public void createeditmenu(){
        eundo = new JMenuItem("Undo");
        eundo.addActionListener(this);
        eundo.setActionCommand("Undo");
        medit.add(eundo);

        eredo = new JMenuItem("Redo");
        eredo.addActionListener(this);
        eredo.setActionCommand("Redo");
        medit.add(eredo);
    }

    public void createformatmenu(){
        fwrap = new JMenuItem("Word wrap");
        fwrap.addActionListener(this);
        fwrap.setActionCommand("Word wrap");
        mformat.add(fwrap);

        fofont = new JMenu("Font");
        mformat.add(fofont);

        fArial = new JMenuItem("Arial");
        fArial.addActionListener(this);
        fArial.setActionCommand("Arial");
        fofont.add(fArial);

        fcms = new JMenuItem("Comic Sans MS");
        fcms.addActionListener(this);
        fcms.setActionCommand("Comic Sans MS");
        fofont.add(fcms);

        ftnr = new JMenuItem("Times New Roman");
        ftnr.addActionListener(this);
        ftnr.setActionCommand("Times New Roman");
        fofont.add(ftnr);

        fsize = new JMenu("Font Size");
        mformat.add(fsize);

        fsize8 = new JMenuItem("8");
        fsize8.addActionListener(this);
        fsize8.setActionCommand("Size 8");
        fsize.add(fsize8);

        fsize12 = new JMenuItem("12");
        fsize12.addActionListener(this);
        fsize12.setActionCommand("Size 12");
        fsize.add(fsize12);

        fsize18 = new JMenuItem("18");
        fsize18.addActionListener(this);
        fsize18.setActionCommand("Size 18");
        fsize.add(fsize18);
        
        fsize24 = new JMenuItem("24");
        fsize24.addActionListener(this);
        fsize24.setActionCommand("Size 24");
        fsize.add(fsize24);

        fsize28 = new JMenuItem("28");
        fsize28.addActionListener(this);
        fsize28.setActionCommand("Size 28");
        fsize.add(fsize28);
    }
    public void createcolormenu(){
        color1 = new JMenuItem("White");
        color1.addActionListener(this);
        color1.setActionCommand("Color White");    
        mcolor.add(color1);

        color2 = new JMenuItem("Black");
        color2.addActionListener(this);
        color2.setActionCommand("Color Black");
        mcolor.add(color2);

        color3 = new JMenuItem("Blue");
        color3.addActionListener(this);
        color3.setActionCommand("Color Blue");
        mcolor.add(color3);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                files.newf();
                break;
            case "Open":
                files.openf();
                break;
            case "Save":
                files.savef();
                break;
            case "Save As":
                files.saveasf();
                break;
            case "Exit":
                files.exitf();
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();    
                break;
            case "Word wrap":
                format.wordWrap();   
                break;
            case "Arial":
                format.setfont(command);
                break;
            case "Comic Sans MS":
                format.setfont(command);
                break;
            case "Times New Roman":
                format.setfont(command);
                break;
            case "Size 8":
                format.createfont(8);
                break;
            case "Size 12":
                format.createfont(12);
                break;
            case "Size 18":
                format.createfont(18);
                break;
            case "Size 24":
                format.createfont(24);
                break;            
            case "Size 28":
                format.createfont(28);
                break;
            case "Color White":
                tx.setBackground(java.awt.Color.WHITE);
                break;
            case "Color Black":
                tx.setBackground(java.awt.Color.BLACK);
                break;
            case "Color Blue":
                tx.setBackground(java.awt.Color.BLUE);
                break;
            default:
                break;
        }
    }
}
