import java.util.*;

public class Payroll {
    public static void main(String args[]) {
        char choice = 'Y';
        while (choice == 'Y' || choice == 'y') {

            Scanner input = new Scanner(System.in);
            Scanner strScanner = new Scanner(System.in);
            PayrollCalc data = new PayrollCalc();

            System.out.println("Enter your First Name: ");
            data.setName(input.nextLine());

            System.out.println("Enter your Surname: ");
            data.setSurname(input.nextLine());

            System.out.println("Enter your Address: ");
            data.setAddress(strScanner.nextLine());

            System.out.println("Enter your Employee ID: ");
            data.setEmployeeID(input.nextLine());

            System.out.println("Enter your Birthday: (mm-dd-yyyy) ");
            data.setBirthday(input.nextLine());

            System.out.println("Enter your Phone Number: ");
            data.setPhonenumber(input.nextLine());

            System.out.println("Enter your SSS No: ");
            data.setSSSno(input.nextLine());

            System.out.println("Enter your Philhealth No: ");
            data.setPhilhealthno(input.next());

            System.out.println("Enter your Tin No.");
            data.setTinno(input.next());

            System.out.println("Enter your Pagibig No: ");
            data.setPagibigno(input.next());

            System.out.println("Enter your Immediate Supervisor: ");
            data.setImmediatesupervisor(strScanner.nextLine());

            boolean validStatus = false;
            while (!validStatus) {
                System.out.println("Enter your Status (Regular/Non-regular): ");
                String status = input.next();

                if (status.equalsIgnoreCase("Regular") || status.equalsIgnoreCase("Non-regular")) {
                    data.setStatus(status);
                    validStatus = true;
                } else {
                    System.out.println("---------------------------------");
                    System.out.println("Invalid status. Please try again.");
                    System.out.println("");
                }
            }

            boolean validPosition = false;
            String position = "";

            while (!validPosition) {
                System.out.println("Enter your Position (Manager/Team leader/Rank and file): ");
                position = strScanner.nextLine();

                if (position.equalsIgnoreCase("Manager")) {
                    data.setPosition("Manager");
                    validPosition = true;
                } else if (position.equalsIgnoreCase("Team leader")) {
                    data.setPosition("Team Leader");
                    validPosition = true;
                } else if (position.equalsIgnoreCase("Rank and file")) {
                    data.setPosition("Rank and File");
                    validPosition = true;
                } else {
                    System.out.println("---------------------------------");
                    System.out.println("Invalid Attempt. Please try again.");
                    System.out.println("");
                }
            }

            System.out.println("Number of Hours Worked: ");
            data.setHoursWorked(Double.parseDouble(input.next()));

            System.out.println("Hourly Pay Rate: ");
            data.setHourlyPayRate(Double.parseDouble(input.next()));

            System.out.println("Daily Hours Worked: ");
            data.setDailyhoursworked(Double.parseDouble(input.next()));

            System.out.println("Daily Pay Rate: ");
            data.setDailypayrate(Double.parseDouble(input.next()));

            double grossAmount = data.grossPay(data.getHourlyPayRate(), data.getHoursWorked());

            System.out.println("First Name: " + data.getName());
            System.out.println("Surname: " + data.getSurname());
            System.out.println("Address: " + data.getAddress());
            System.out.println("Employee ID: " + data.getEmployeeID());
            System.out.println("Birthday: " + data.getBirthday());
            System.out.println("Phone Number: " + data.getPhonenumber());
            System.out.println("SSS no: " + data.getSSSno());
            System.out.println("Philhealth No: " + data.getPhilhealthno());
            System.out.println("Tin No: " + data.getTinno());
            System.out.println("Pagibig No: " + data.getPagibigno());
            System.out.println("Immediate Supervisor: " + data.getImmediatesupervisor());
            System.out.println("Enter your Status: " + data.getStatus());
            System.out.println("Position: " + data.getPosition());

            System.out.println("");
            System.out.println("-----------------------");
            System.out.println("WORK DATA CALC");

            System.out.println("Hours Worked: " + data.getHoursWorked() + "hrs");
            System.out.println("Pay Rate: " + data.getHourlyPayRate());
            System.out.println("Daily Hours Worked: " + data.getDailyhoursworked() + "hrs");
            System.out.println("Daily Pay Rate: " + data.getDailypayrate());

            double pagibig = data.pagibig(grossAmount);
            double sss = data.sss(grossAmount);
            double philhealth = data.philhealth(grossAmount);

            String positionValue = data.getPosition();
            String statusValue = data.getStatus();

            double ricesubsidyallowance = data.ricesubsidyallowance(grossAmount);
            double phoneAllowance = PayrollCalc.calculatePhoneAllowance(positionValue, statusValue);
            double clothingAllowance = data.calculateClothingAllowance(positionValue, statusValue);

            double Grosswithdeduction = grossAmount - philhealth - pagibig - sss;
            double Grosspay = Grosswithdeduction + ricesubsidyallowance + phoneAllowance + clothingAllowance;
            double Allowance = ricesubsidyallowance + phoneAllowance + clothingAllowance;
            double totalDeduction = sss + philhealth + pagibig;
            double tax = data.getTax(Grosswithdeduction);
            double incomeTax = Grosswithdeduction - tax;
            double netPay = incomeTax + Allowance;

            System.out.println("----------------------------");
            System.out.println("DEDUCTIONS");
            System.out.println("SSS Deduction: " + sss);
            System.out.println("Philhealth Deduction:" + philhealth);
            System.out.println("Pagibig Deduction: " + pagibig);
            System.out.println("-----------------------------");
            System.out.println("TOTAL GROSSPAY");

            System.out.println("-----------------------------");
            System.out.println("TAX");
            System.out.println("Income: " + grossAmount);
            System.out.println("Tax Withholding: " + tax);
            System.out.println("Income with tax: " + incomeTax);
            System.out.println("TOTAL DEDUCTIONS: " + (tax + philhealth + pagibig + sss));

            System.out.println("-----------------------------");
            System.out.println("ALLOWANCE");
            System.out.println("Rice Subsidy Allowance: " + ricesubsidyallowance);
            System.out.println("Phone Allowance: " + phoneAllowance);
            System.out.println("Clothing Allowance: " + clothingAllowance);
            System.out.println("-----------------------------");
            System.out.println("NETPAY");
            System.out.println("Netpay: " + netPay);

            System.out.println("Do you want to continue? [Y | N]: ");
            choice = strScanner.nextLine().charAt(0);
        }
    }
}