/**
 * Created by xnivel on 10/01/2015.
 */
public class Node extends ANode {

    public Node(int newnr){
        nr=newnr;
    }
    @Override
    public boolean testStatus(int Nstatus) {
        synchronized (obj) {
            return this.status != Nstatus;
        }
    }

    @Override
    public void setStatus(int Nstatus) {
        synchronized (obj) {
            status = Nstatus;
        }
    }
}
