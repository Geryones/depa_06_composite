package patterns.composite;

import java.util.LinkedList;
import java.util.List;

public class GroupFigure extends Figure {
	private String name;
	private List<Figure> figures = new LinkedList<>();

	public GroupFigure(String name, Figure... figures) {
		this.name = name;

		for (Figure f : figures) {
			addFigure(f);
		}
	}

	public void addFigure(Figure f) {
		if (this == f){
			throw new IllegalArgumentException("no circlejerk");
		}

		if (f.parent != null){
			throw new IllegalArgumentException("figure is in already in grp");
		}

		if (isParent(f)){
			throw new IllegalArgumentException(" no cycles allowed");
		}

		figures.add(f);
		f.parent = this;
	}

	private boolean isParent(Figure f){
		Figure parent = this.parent;
		while(parent != null){
			if (parent == f){
				return true;
			}
			parent = parent.parent;
		}
		return false;
	}

	@Override
	public void draw(String prefix) {
		System.out.println(prefix + name);
		for (Figure f : figures) {
			f.draw(prefix + ">>");
		}
	}
}
