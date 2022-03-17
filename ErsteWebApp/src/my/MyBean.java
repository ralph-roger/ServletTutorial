package my;

public class MyBean {
	  private String name=new String();
	  
	  public MyBean() {
		  this.name = "Nicht gesetzt";
	  }
	  
	  public String getName() {
	  return name;
	  }
	  public void setName(String name) {
	  this.name = name;
	  }
}
