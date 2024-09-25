package railwayreservation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class trainmodel {
public int no;
public HashMap<Character,Integer> berthcapacity=new HashMap<>(); 

//Queue<model> rac=new LinkedList<>(3);
 Queue<reservation> rac=new LinkedList<>();
 Queue<reservation> wl=new LinkedList<>();// for each train a wl and rac list is maintained


trainmodel(int no,HashMap<Character,Integer> berthcapacity)
{
	this.no=no;
	this.berthcapacity=berthcapacity;
}

}
