package ro.ulbs.paradigme.lab2;

public class Triangle extends Form {
    private float height;
    private float base;


    public Triangle() {
        super();
        this.height = 0;
        this.base = 0;
    }


    public Triangle(String color, float height, float base) {
        super(color);
        this.height = height;
        this.base = base;
    }


    @Override
    public float getArea() {
        return (base * height) / 2;
    }


    @Override
    public String toString() {
        return super.toString() + ", height = " + height + ", base = " + base + ", area = " + getArea();
    }

    @Override
        public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Triangle other = (Triangle) obj;
        if(Float.floatToIntBits(base) != Float.floatToIntBits(other.base)) return false;
        if(Float.floatToIntBits(height) != Float.floatToIntBits(other.height)) return false;
        return true;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + Float.floatToIntBits(this.base);
        hash = 97 * hash + Float.floatToIntBits(this.height);
        return hash;
    }
}

