public class Office extends Buildings{
    private int side;
    private int position;
    private int length;
    private int height;
    private String owner;
    public String jobType;

    @Override
    public void setSide(int side_){
        side = side_;
    }
    @Override
    public int getSide(){
        return side;
    }
    @Override
    public void setPosition(int pos){
        position = pos;
    }
    @Override
    public int getPosition(){
        return position;
    }
    @Override
    public void setLength(int len){
        length = len;
    }
    @Override
    public int getLength() {
        return length;
    }
    @Override
    public void setHeight(int hei){
        height = hei;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public void setOwner(String own){
        owner = own;
    }
    @Override
    public String getOwner() {
        return owner;
    }
    @Override
    public void setJobType(String job){
        jobType = job;
    }
    @Override
    public String getJobType() {
        return jobType;
    }

    @Override
    public String getFocus(){
        System.out.printf("Job Type is: ");
        return jobType;
    }

    @Override
    public String toString() {
        return String.format("Office " + "Length " + this.getLength()+" Height "+this.getHeight()+" Position "+position+" Owner "+ this.getOwner()+"\n");
    }

    
}