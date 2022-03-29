package my;

public class MyBean {
	  private String name;
	  private String var; 
	  
	  public MyBean() {
		  this.name = "Nicht gesetzt!";
		  this.var =  "ein Value kommt geflogen";
	  }
	  
	  public String getName() {
	  return name;
	  }
	  public void setName(String name) {
	  this.name = name;
	  }
	  
	  public String getVar () {
		  return var;
	  }
	  public void setVar(String var) {
		  this.var = var;
	  }
}
