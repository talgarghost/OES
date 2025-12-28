import javax.security.auth.login.CredentialException;

public class Circle {
    private double param;
    private double circumference;
    private double area ;

    public double getParam() {
        return param;
    }

    public void setParam(double param) {
        this.param = param;
        this.area=param*param*2*3.14;
        this.circumference=param*2*3.14;
    }

    @Override
    public String toString(){
        return area+" "+circumference;
    }
}
