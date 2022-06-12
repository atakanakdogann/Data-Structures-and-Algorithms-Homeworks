import java.lang.String;
public class Buildings extends PlayGroundLinkedList{
    private int side;
    private int position;
    private int length;
    private int height;
    private String owner;
    public String color;
    public int number_of_rooms;
    public String jobType;
    public String openTime;
    public String closeTime;
    public Buildings(){

    }

    public void setSide(int side_){
        side = side_;
    }
    public int getSide(){
        return side;
    }
    public void setPosition(int pos){
        position = pos;
    }
    public int getPosition(){
        return position;
    }
    public void setLength(int len){
        length = len;
    }
    public int getLength(){
        return length;
    }
    public void setHeight(int hei){
        height = hei;
    }
    public int getHeight(){
        return height;
    }
    public void setOwner(String own){
        owner = own;
    }
    public String getOwner() {
        return owner;
    }
    public void setColor(String col){
        color = col;
    }
    public String getColor() {
        return color;
    }
    public void setRoomNumber(int rooms){
        number_of_rooms = rooms;
    }
    public int getRoomNumber() {
        return number_of_rooms;
    }
    public void setJobType(String job){
        jobType = job;
    }
    public String getJobType() {
        return jobType;
    }
    public void setJobTimes(String open,String close ){
        openTime = open;
        closeTime = close;
    }
    public String getOpenTime() {
        return openTime;
    }
    public String getCloseTime() {
        return closeTime;
    }
    public String getFocus(){
        
        System.out.printf("Owner is: ");
        return owner;
    }

    @Override
    public String toString() {
        return String.format("Building " + this.getLength()+" Height "+this.getHeight()+" Position "+position+" Owner "+ this.getOwner()+"\n");
    }

}