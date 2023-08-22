class Patient {
  // instance variables with patient's name and condition
  private String name = "";
  private String condition = "";

  // sets instance variables to the patient's name and condition
  public Patient(String n, int c) {
    name = n;
    //Depending on user input for condition will assign conditon to status
    if (c == 1)
    {
      condition = "Critical";
    }
    else if (c == 2)
    {
      condition = "Serious";
    }
    else
    {
      condition = "Fair";
    }
  }
// returns patient's name
  public String getName() {
    return name;
  }
// return patient's condition
  public String getCondition() {
    return condition;
  }
  // returns patient's name and condition
  public String getInfo() {
    return name + " / " + condition; 
  }
}