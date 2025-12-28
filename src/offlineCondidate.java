
public class offlineCondidate extends Candidate{
    private String classroom;
    private String seatnumber;
    public offlineCondidate(int studentID,String name, String last_name,String group,double totalScore,String classroom,String seatnumber){
        super(studentID,name,  last_name, group, totalScore);
        this.classroom=classroom;
        this.seatnumber=seatnumber;
    }
    public String getClassroom(){
        return classroom;
    }

    public String getSeatnumber(){
        return seatnumber;
    }
    @Override
    public String toString(){
        return super.toString()+" "+classroom+" "+seatnumber;
    }
}
