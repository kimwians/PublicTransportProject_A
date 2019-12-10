package application.Models;

//importing interface permissions to extend methods needed to implement required process

public abstract class User {
	
  int id;
  String firstName;
  String lastName;
  String address;
  String zip;
  String state;
  String userName;
  String password;
  String email;
  String ssn;
  String secQuestion;
  String secQuestionAnswer;
  
  int type;
  //obtain username from user
  public String getUserName() {
      return userName;
  }
  //return username chosen
  public void setUserName(String userName) {
      this.userName = userName;
  }
  //obtain password from user
  public String getPassword() {
      return password;
  }
  //return & set chosen password
  public void setPassword(String password) {
      this.password = password;
  }
  //obtain security question from user
  public String getsecQuestion() {
      return secQuestion;
  }
  //set security question chosen by user
  public void setsecQuestion(String secQuestion) {
      this.secQuestion = secQuestion;
  }
  //obtain elected answer for security question
  public String getsecQuestionAnswer() {
      return secQuestionAnswer;
  }
  //set elected answer for security question 
  public void setsecQuestionAnswer(String secQuestionAnswer) {
      this.secQuestionAnswer = secQuestionAnswer;
  }
  //set user ID
  public void setId(int id) {
      this.id = id;
  }
  //get user ID
  public int getId() {
      return id;
  }
  //obtain users firstName
  public String getFirstName() {
      return firstName;
  }
  //set users first name
  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }
  //get users last name
  public String getLastName() {
      return lastName;
  }
  //set users last name
  public void setLastName(String lastName) {
      this.lastName = lastName;
  }
  //get users address
  public String getAddress() {
      return address;
  }
  //set users address
  public void setAddress(String address) {
      this.address = address;
  }
  //get users state
  public String getState() {
      return state;
  }
  //set users state
  public void setState(String state) {
      this.state = state;
  }
  //get users zip
  public String getZip() {
      return zip;
  }
  //set users zip
  public void setZip(String zip) {
      this.zip = zip;
  }
  //get users email
  public String getEmail() {
      return email;
  }
  //set users email
  public void setEmail(String email) {
      this.email = email;
  }
  //get users ssn
  public String getSsn() {
      return ssn;
  }
  //set users ssn
  public void setSsn(String ssn) {
      this.ssn = ssn;
  }
  //get the type
  public int getType() {
      return type;
  }
  //set the type
  public void setType(int type) {
      this.type = type;
  }

}
