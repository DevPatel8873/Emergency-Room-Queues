import java.util.*;

class Main {
  public static void main(String[] args) {
    // declaring variables
    String patientName;
    int patientCondition;

    //Creates 3 queues for each condition type
    Queue<Patient> criticalPatients = new ArrayDeque<Patient>();
    Queue<Patient> seriousPatients = new ArrayDeque<Patient>();
    Queue<Patient> fairPatients = new ArrayDeque<Patient>();

    Scanner userInput = new Scanner(System.in);
    int mainMenuSelect = 0;

    // while loop that runs as long as 4, or exit, isn't selected
    while (mainMenuSelect != 4)
    {
      //Collects main menu input
      System.out.println("Main Menu:\n1. Schedule a Patient\n2. Treat next patient\n3. Treat all patients\n4. Exit");
      System.out.print("Enter a number [1-4]: ");
      mainMenuSelect = userInput.nextInt();
      //If user schedules new patient
      if (mainMenuSelect == 1) 
      {
        //Creates new patient object using variables from user
        System.out.print("\n\nEnter the patient's name: ");
        patientName = userInput.nextLine();
        while (patientName.equals("")) 
        {
          // ensures there's no error in the name
          System.out.print("Please enter more than one character for the patient's name: ");
            patientName = userInput.nextLine();
        }
        System.out.print("CONDITION\n1. Critical\n2. Serious\n3. Fair\n");
        System.out.print("Enter a number [1-3]: ");
        patientCondition = userInput.nextInt();
        // ensure there's no error in the condition
        while (patientCondition != 1 && patientCondition != 2 && patientCondition != 3)
        {
          System.out.print("You entered a number that isn't included in the option of conditions given.\n Please enter a number between 1 and 3: ");
          patientCondition = userInput.nextInt();
        }
        //Creates instance of class Patient
        Patient newPatient = new Patient(patientName, patientCondition);
        // based off the value of the condition, the patient is added to the queue that it belongs to
        if (patientCondition == 1) 
        {
          criticalPatients.add(newPatient);
        }
        else if (patientCondition == 2) 
        {
          seriousPatients.add(newPatient);
        }
        else if (patientCondition == 3) 
        {
          fairPatients.add(newPatient);
        }
      }
      //If user selects to treat next patient
      else if(mainMenuSelect == 2)
      {
        //Will deque patient from respective condition queue with priority status on critical patients
        if(!criticalPatients.isEmpty())
        {
          //Uses getInfo to display the name and condition in a proper string format, and removes patient from queue
          Patient removedPatient = criticalPatients.remove();
          System.out.println(removedPatient.getInfo() + " is being treated\n");
        }
        else if(!seriousPatients.isEmpty())
        {
          Patient removedPatient = seriousPatients.remove();
          System.out.println(removedPatient.getInfo() + " is being treated\n");
        }
        else if(!fairPatients.isEmpty())
        {
          Patient removedPatient = fairPatients.remove();
          System.out.println(removedPatient.getInfo()+ " is being treated\n");
        }
        //Base condition if no patients are left
        else
        {
          System.out.print("No patients left to treat");
        }
      }
      else if(mainMenuSelect == 3)
      {
        // until there are no more patients left in critical patients queue
        while (!criticalPatients.isEmpty()) 
        {      
          System.out.println(criticalPatients.remove().getInfo());
        }
        // until there are no more patients left in serious patients queue
        while (!seriousPatients.isEmpty()) 
        {   
          System.out.println(seriousPatients.remove().getInfo());
        }
        // until there are no more patients left in fair patients queue
        while (!fairPatients.isEmpty()) 
        {
        System.out.println(fairPatients.remove().getInfo()); 
        }
        System.out.println("No patients left to treat");
      }
      // this is the exit option so it breaks out of the largest while loop
      else if(mainMenuSelect == 4)
      {
        break;
      }
      // makes sure user doesn't try to pick an option unavailable in the main menu
      else
      {
        System.out.print("Please enter ONLY a number [1 - 4]");
      }
      System.out.println("\n");
    }
    System.out.println("\nThank you!");
  }
}
/*
Test Cases:
Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 0
Please enter ONLY a number [1 - 4]

Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]:

-------------------------------
Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 2
No patients left to treat

Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]:
-------------------------------
Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1


Enter the patient's name: Please enter more than one character for the patient's name: Sam
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 2


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1


Enter the patient's name: Please enter more than one character for the patient's name: Max
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 3


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1 


Enter the patient's name: Please enter more than one character for the patient's name: Alex
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 1


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 2
Alex / Critical is being treated



Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 2
Sam / Serious is being treated



Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 2
Max / Fair is being treated



Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 2
No patients left to treat
-----------------------------------
Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1


Enter the patient's name: Please enter more than one character for the patient's name: Sam
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 2


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1


Enter the patient's name: Please enter more than one character for the patient's name: Max
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 2


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1


Enter the patient's name: Please enter more than one character for the patient's name: Alex
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 1


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1 


Enter the patient's name: Please enter more than one character for the patient's name: Karen
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 3


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1


Enter the patient's name: Please enter more than one character for the patient's name: Jackson
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 3


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1


Enter the patient's name: Please enter more than one character for the patient's name: Jason
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 1


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 3
Alex / Critical
Jason / Critical
Sam / Serious
Max / Serious
Karen / Fair
Jackson / Fair
No patients left to treat


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 4

Thank you!
---------------------------------
Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 1


Enter the patient's name: Please enter more than one character for the patient's name: 
Please enter more than one character for the patient's name: g
CONDITION
1. Critical
2. Serious
3. Fair
Enter a number [1-3]: 0
You entered a number that isn't included in the option of conditions given.
 Please enter a number between 1 and 3: 0
You entered a number that isn't included in the option of conditions given.
 Please enter a number between 1 and 3: 2


Main Menu:
1. Schedule a Patient
2. Treat next patient
3. Treat all patients
4. Exit
Enter a number [1-4]: 4

Thank you!
*/