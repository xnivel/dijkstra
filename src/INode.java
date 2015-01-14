/**
 * Created by xnivel on 10/01/2015.
 */
public interface INode {
    public int checkStatus();
    public int getStatus();
    public void forceCheck();
    public void run();
    public void criSection(int newStatus);
    public boolean testStatus(int Nstatus);
    public void setStatus(int Nstatus);
    public void randStatus();
}
