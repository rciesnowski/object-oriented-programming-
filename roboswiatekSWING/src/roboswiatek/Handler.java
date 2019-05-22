package roboswiatek;
import roboswiatek.hierarchia.Organizm;
import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<Organizm> OrganismList = new LinkedList<Organizm>();

        public void tick(){
            for (int i=0;i<OrganismList.size();i++) {
                Organizm tempOrg = OrganismList.get(i);
                tempOrg.tick();
            }
        }
        public void render(Graphics g){
            for (int i=0;i<OrganismList.size();i++) {
                Organizm tempOrg = OrganismList.get(i);
                tempOrg.render(g);
            }
        }
        public void addOrganism(Organizm g){
            this.OrganismList.add(g);
        }
}