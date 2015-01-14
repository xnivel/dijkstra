/**
 * Created by xnivel on 10/01/2015.
 */
public class FirstNode extends ANode {

    public FirstNode(int newnr){
        nr=newnr;
    }

    @Override
    public boolean testStatus(int Nstatus) {
        synchronized (obj) {
            return this.status == Nstatus;
        }
    }

    @Override
    public void setStatus(int Nstatus) {
        Status st=Status.getInstance();
        synchronized (obj) {
            status = (Nstatus + 1) % st.maxNodeNumber;
        }
    }
}
