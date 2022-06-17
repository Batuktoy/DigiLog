package qrGaller;

public class QR_images {
	private String Id_number;
	private String Name;
	byte [] Image;
	byte [] Image2;
	private String C_number;
	private String Course;
	private String Address;
	
	
	public QR_images() {}
	public QR_images(String id_number, String name, byte [] image, byte [] image2, String c_number, String course, String address) {
		
		this.Id_number = id_number;
		this.Name = name;
		this.Image = image;
		this.Image2 = image2;
		this.C_number = c_number;
		this.Course = course;
		this.Address = address;
		
	}
	 public String getID(){
	      return Id_number;
	    }
	    
	    public void setID(String ID){
	        this.Id_number = ID;
	    }
	    
	    public String getName(){
	        return Name;
	    }
	    
	    public void setName(String Name){
	        this.Name = Name;
	    }
	   
	    public byte[] getMyImage(){
	        return Image;
	    }
	    
	    public byte[] getMyImage2(){
	        return Image2;
	    }
	    public String getcNumber(){
	        return C_number;
	    }
	    
	    public void setcNumber(String c_number){
	        this.C_number = c_number;
	    }
	    
	    public String getCourse(){
	        return Course;
	    }
	    
	    public void setCourse(String course){
	        this.Course = course;
	    }
	    
	    public String getAddress(){
	        return Address;
	    }
	    
	    public void setAddress(String address){
	        this.Address = address;
	    }
	    
	    

}
