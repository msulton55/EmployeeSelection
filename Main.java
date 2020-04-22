import java.util.Arrays;
/* Nextgencoder Challenge #40
 * Employee Selector
 * by msultont(IG), msulton55@gmail.com(Email)
 * 
 * I choose to use static array because of fix initial value of array. The program consist of
 * 3 main function: random number function, sorting function and filtering function.  
 */
public class Main {

    public static void main(String[] args) {
        int[][] employee = new int[2][5];
        // For every coders employee, I set to max default value indicating this can be changed to the
        // lowest value possible. 
        int employeeFrontendFixValue = 10;
        int employeeBackendFixValue = 10;
        int employeeFrontendBackendFixValue;
        int employeeFullStackFixValue = 10;

        /*
        Using manual input for the coders employee.
        employee[0][0] = 2;
        employee[0][1] = 1;
        employee[0][2] = 3;
        employee[0][3] = 3;
        employee[0][4] = 1;
        */

        // Function to random generate coders employee.
        for (int i = 0; i < 5; i++) {
            // Array of coders employee
            employee[0][i] = (int)(Math.random() * ((3-1)+1)) + 1; // Set max = 3, min = 1
            // Array of coders employee coins/value
            employee[1][i] = (int)(Math.random() * ((9-1)+1)) + 1; // Set max = 9, min = 1
        }
        System.out.println("Before Sorting: " + Arrays.deepToString(employee));

        // Function to sort coders employee based on their value. Lowest to highest.
        for (int i = 0; i < 5; i++) {
            int temp;
            for (int j = 0; j < 4; j++) {    
                if (employee[1][j] > employee[1][j+1]) {
                    temp = employee[1][j];
                    employee[1][j] = employee[1][j+1];
                    employee[1][j+1] = temp;
                    temp = employee[0][j];
                    employee[0][j] = employee[0][j+1];
                    employee[0][j+1] = temp;
                }
            }
        }
        System.out.println("After Sorting: " + Arrays.deepToString(employee));

        // Function to pick the lowest value among the coders employee.
        for (int i = 0; i < 5; i++) {
            // Select fullstack coders employee.
            if (employee[0][i] == 3) {
                if (employeeFullStackFixValue > employee[1][i]) {
                    employeeFullStackFixValue = employee[1][i]; 
                }
            // Select frontend coders employee.
            } else if (employee[0][i] == 1){
                if (employeeFrontendFixValue > employee[1][i]) {
                    employeeFrontendFixValue = employee[1][i]; 
                }
            // Select backend coders employee.
            } else if (employee[0][i] == 2){
                if (employeeBackendFixValue > employee[1][i]) {
                    employeeBackendFixValue = employee[1][i]; 
                }
            }
        
        }     
        // The total value between frontend and backend coders employee.
        employeeFrontendBackendFixValue = employeeFrontendFixValue + employeeBackendFixValue;

        // Printing result section.
        System.out.println("Frontend Value: " + employeeFrontendFixValue);
        System.out.println("Backend Value: " + employeeBackendFixValue);
        System.out.println("Frontend + Backend Value: " + employeeFrontendBackendFixValue);
        if (employeeFullStackFixValue == 10)
            System.out.print("");
        else
            System.out.println("Fullstack value: " + employeeFullStackFixValue);        

        if (employeeFullStackFixValue < employeeFrontendBackendFixValue) {
            System.out.println("Welcome fullstack engineer! Your value is " + employeeFullStackFixValue);
        } else {
            System.out.printf("Welcome frontend and backend engineer! Your value, consecutive, %d and %d", employeeFrontendFixValue, employeeBackendFixValue);
        }
    }
}