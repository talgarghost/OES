public class OnlineCandidate extends Candidate {
    private String email;
    private String phone_number;
    public OnlineCandidate (int studentID,String name, String last_name,String group,double totalScore,String email,String phone_number){
        super(studentID,name,last_name,group,totalScore);
        this.email=email;
        this.phone_number=phone_number;

    }
 public String getEmail(){
        return email;
 }
 public String getPhone_number(){
        return phone_number;
 }
 @Override
    public String toString(){
        return super.toString()+" "+email+" "+phone_number;
 }
}

