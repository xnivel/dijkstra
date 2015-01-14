import java.io.IOException;
import java.util.Scanner;

/**
 * Created by xnivel on 10/01/2015.
 */
public class Main {
    public static void main(String[] args) {
        Status st=Status.getInstance();
        st.setInstance(6);
        try {
            while(true)
            {
                System.in.read();
                st.randstatus();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
