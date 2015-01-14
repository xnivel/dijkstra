import java.util.ArrayList;
import java.util.List;

/**
 * Created by xnivel on 10/01/2015.
 */
public class Status {
    private static Status instance=null;
    public static Status getInstance() {
        if(instance==null)
            instance=new Status();
        return instance;
    }
    synchronized public void printStatus(int crinode){
        for(int i=0;i<maxNodeNumber;i++)
        {
            INode curN= listOfNodes.get(i);
            System.out.print(i + "s" + curN.getStatus()+((i==crinode)?"C  ":"   "));
        }
        System.out.println("");
    }
    public void randstatus(){
        for(ANode i:listOfNodes)
        {
            i.randStatus();
        }
    }
    public void setInstance(int setmax){
        maxNodeNumber=setmax;
        listOfNodes.add(new FirstNode(0));
        for(int i=1;i<maxNodeNumber;i++)
        {
            listOfNodes.add(new Node(i));
        }
        for(ANode i:listOfNodes)
        {
            i.start();
        }


    }
    public int maxNodeNumber=0;
    public List<ANode> listOfNodes=new ArrayList<ANode>();
}
