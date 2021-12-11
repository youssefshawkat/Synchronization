import java.io.FileWriter;
import java.io.OutputStream;
import javax.swing.JTextArea;

public class CustomOutputStream extends OutputStream {
    private final JTextArea textArea;



    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char)b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
        try {
            FileWriter fileWriter = new FileWriter("./out.txt");
            fileWriter.write(textArea.getText());
            fileWriter.close();
        }catch (Exception e){System.out.println(e);}
    }
}
