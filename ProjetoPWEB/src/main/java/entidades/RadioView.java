import javax.faces.bean.ManagedBean;

@ManagedBean
public class RadioView {
     
    private String console;    
 
    public String getConsole() {
        return console;
    }
 
    public void setConsole(String console) {
        this.console = console;
    }
}