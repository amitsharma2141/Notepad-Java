public class functionedit {
    GUI gui;
    public functionedit(GUI gui) {
        this.gui = gui;
    }
    public void undo(){
        gui.undo.undo();
    }
    public void redo(){
        gui.undo.redo();
    }
    
}
