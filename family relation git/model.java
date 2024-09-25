package bala;

import java.util.ArrayList;

public class model {
	String name;
	model father;
	model mother;
	String gender;
	ArrayList<model> siblings=new ArrayList<>();

public model(String name, model father, model mother, String gender) {
		this.name = name;
		this.father = father;
		this.mother = mother;
		this.gender = gender;
		
	}
@Override
public String toString() {
    return this.name;
}


}
