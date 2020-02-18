//@hishaamr
public class Client{

	//preliminary list contains name,surname,age,gender,occupation,email address.
	
	String name = " ";
	String surname = " ";
	int age = 0;
	String gender= " ";
	String occ = " ";
	String email = " ";

	public Client(String name1, String surn1,int age1,String gen1,String occ1,String em1){
			name = name1;
			surname = surn1;
			age = age1;
			gender = gen1;
			occ = occ1;
			email = em1;
	}

	//Setters
	public void setName(String n){
		name = n;
	}

	public void setSurname(String s){
		surname = s;
	}

	public void setGender(String g){
		gender = g;
	}

	public void setAge(int a ){
		age = a;	
	}

	public void setOcc(String o){
		occ = o;
	}

	public void setEm(String e){
		email = e;
	}

	//Getters

	public String getName(){
		return name;
	}

	public String getSurname(){
		return surname;
	}

	public String getGender(){
		return gender;
	}

	public int getAge(){
			return age;	
	}

	public String getOcc(){
		return occ;
	}

	public String getEm(){
		return email;
	}

	
	@Override
	//Display the Clients information 
	public String toString(){
		return "\n"+ name+";"+surname +";"+age+";"+gender +";"+occ +";"+email+"\n";	
	}

	
}
