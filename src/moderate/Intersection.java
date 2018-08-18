package moderate;

public class Intersection {

	public Point findPoint(Line a , Line b){
		if(a == null || b == null) return null;
		if(a == b) return a.end;
		
		if(a.start.x > a.end.x) a.swap();
		if(b.start.x > b.end.x) b.swap();
		
		return inter(a,b);
	}
	
	public Point inter(Line a, Line b){
		
		return null;
	}
}


class Point{
	double x;
	double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void setPoint(double x, double y){
		this.x = x;
		this.y = y;
	}
}

class Line{
	Point start;
	Point end;
	
	public Line(Point a, Point b){
		start = a;
		end = b;
	}
	
	public void swap(){
		Point tmp = start;
		start = end;
		end = tmp;
	}
	
}