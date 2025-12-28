public class Cylinder {
    private double param1;
    private double param2;
    private double surfaceArea;
    private  double volume;
    public double getParam1() {
        return param1;
    }

    public void setParam(double param1,double param2) {
        this.param1 = param1;
        this.param2=param2;
        this.surfaceArea=2*3.14*param1*param1+2*3.14*param1*param2;
                this.volume=2*3.14*param1*param1*param2;
    }

public String toString1(){
        return surfaceArea+" "+volume;
}


}
