import java.util.Random;

/**
 * Created by xnivel on 10/01/2015.
 */
public abstract class ANode extends Thread implements INode {
    public final static Object obj = new Object();
    private Random rand = new Random();
    public int status=0;
    public int nr=0;
    private void wakeNext(){
        Status st=Status.getInstance();
        st.listOfNodes.get((nr + 1) % st.maxNodeNumber).forceCheck();
    }
    @Override
    public int checkStatus() {
        Status st=Status.getInstance();
        return st.listOfNodes.get((nr-1)==-1?st.maxNodeNumber-1:nr-1).getStatus();
    }

    @Override
    public void forceCheck() {
        synchronized (obj){
            obj.notify();
        }
    }
    @Override
    public void randStatus(){
        Status st=Status.getInstance();
        synchronized (obj){
            status=rand.nextInt(st.maxNodeNumber-1);
            obj.notify();
        }

    }

    @Override
    public void run() {
        while(true){
            int neighbourStatus=checkStatus();
            int lastStatus=status;
            if(testStatus(neighbourStatus))
            {
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                synchronized (obj){
                    if(lastStatus==status)
                    criSection(neighbourStatus);
                }
            }
            else
            {
                synchronized (obj){
                    try {
                        obj.wait(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    @Override
    public void criSection(int newStatus) {
        Status.getInstance().printStatus(nr);
        setStatus(newStatus);
        wakeNext();
    }
    @Override
    public int getStatus() {
        synchronized (obj){
            return status;
        }
    }

}
