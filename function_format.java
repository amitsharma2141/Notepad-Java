import java.awt.Font;

public class function_format {
    GUI gui;
    Font Arial, ComicSansMS, TimesNewRoman;
    String selectfont;
    public function_format(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap(){
        if(gui.wordWrapOn=false){
            gui.wordWrapOn = true;
            gui.tx.setLineWrap(true);
            gui.tx.setWrapStyleWord(true);
            gui.fwrap.setText("Word Wrap: On");
        }
        else if(gui.wordWrapOn=true){
            gui.wordWrapOn = false;
            gui.tx.setLineWrap(false);
            gui.tx.setWrapStyleWord(false);
            gui.fwrap.setText("Word Wrap: Off");
        }
    }

    public void createfont(int fontsize){
        Arial = new Font("Arial", Font.PLAIN, fontsize);
        ComicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontsize);
        TimesNewRoman = new Font("Times New Roman", Font.PLAIN, fontsize);
        setfont(selectfont);    
    }

    public void setfont(String font){
        selectfont = font;
        switch (selectfont) {
            case "Arial":
                gui.tx.setFont(Arial);               
                break;
            case "Comic Sans MS":
                gui.tx.setFont(ComicSansMS);    
                break;
            case "Times New Roman":
                gui.tx.setFont(TimesNewRoman);    
                break;
            default:
                break;
        }
    }
    
}
