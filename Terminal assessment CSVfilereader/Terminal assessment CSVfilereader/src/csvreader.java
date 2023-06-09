import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvreader {
    public static void main(String[] args) {
        String csvFile = "src/MotorPH.csv";
        String line;
        String csvSplitBy = ",";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                Employee employee = new Employee();
                employee.setEmployeeID(Integer.parseInt(data[0]));
                employee.setLastName(data[1]);
                employee.setFirstName(data[2]);
                employee.setDateOfBirth(data[3]);
                employee.setAddress(data[4]);
                employee.setPhoneNumber(data[5]);
                employee.setSSN(data[6]);
                employee.setPhilhealthNumber(data[7]);
                employee.setTaxID(data[8]);
                employee.setPagibigNumber(data[9]);
                employee.setEmploymentType(data[10]);
                employee.setPosition(data[11]);
                employee.setSupervisor(data[12]);
               
                employee.setSalary(parseDoubleValue(data[13]));
                employee.setBonus1(parseDoubleValue(data[14]));
                employee.setBonus2(parseDoubleValue(data[15]));
                employee.setBonus3(parseDoubleValue(data[16]));
                employee.setDeduction(parseDoubleValue(data[17]));
                employee.setNetSalary(parseDoubleValue(data[18]));
                employee.setHourlyRate(parseDoubleValue(data[19]));
                

                employees.add(employee);
            }

            for (Employee employee : employees) {
                System.out.println("Employee ID: " + employee.getEmployeeID());
                System.out.println("Last Name: " + employee.getLastName());
                System.out.println("First Name: " + employee.getFirstName());
                System.out.println("Birthday: " + employee.getDateOfBirth());
                System.out.println("Address: " + employee.getAddress());
                System.out.println("Phone Number: " + employee.getPhoneNumber());
                System.out.println("SSN: " + employee.getSSN());
                System.out.println("Philhealth #: " + employee.getPhilhealthNumber());
                System.out.println("TIN: " + employee.getTaxID());
                System.out.println("Pag-IBIG #: " + employee.getPagibigNumber());
                System.out.println("Status: " + employee.getEmploymentType());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Immediate Supervisor: " + employee.getSupervisor());
                System.out.println("Basic Salary: " + employee.getSalary());
                System.out.println("Rice Subsidy: " + employee.getBonus1());
                System.out.println("Phone Allowance: " + employee.getBonus2());
                System.out.println("Clothing Allowance: " + employee.getBonus3());
                System.out.println("Gross Semi-monthly: " + employee.getDeduction());
                System.out.println("Hourly Rate: " + employee.getNetSalary());
                System.out.println("---------------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double parseDoubleValue(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}