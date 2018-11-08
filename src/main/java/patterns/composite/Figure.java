package patterns.composite;

public abstract class Figure {
	public GroupFigure parent = null;
	public abstract void draw(String prefix);
}
