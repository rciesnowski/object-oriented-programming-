import java.awt.*;
import java.util.LinkedList;
public class Handler {
    LinkedList<Organism> OrganismList = new LinkedList<Organism>();
    public void tick(){
        for (int i=0;i<OrganismList.size();i++) {
            Organism tempOrg = OrganismList.get(i);
            tempOrg.tick();
        }
    }
    public void render(Graphics g){
        for (int i=0;i<OrganismList.size();i++) {
            Organism tempOrg = OrganismList.get(i);
            tempOrg.render(g);
        }
    }
    public void addOrganism(Organism g){
        this.OrganismList.add(g);
    }
    public void removeOrganism(Organism g){
        this.OrganismList.remove(g);
    }
}
