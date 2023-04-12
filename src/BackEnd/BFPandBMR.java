package BackEnd;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Alert.AlertType;

public class BFPandBMR {
    
    public double initialize(TextInputControl tfWeight, TextInputControl tfAge, int genderValue, int feetValue, int inchesValue, int activityValue, int currentIndex) {
        
        double temp = 0;
        double weight = 0;
        double age = 0;
        int gender = genderValue;
        int feet = feetValue;
        int inches = inchesValue;
        double activity = activityValue;
        int calc = currentIndex;

        try {
            age = Double.parseDouble(tfAge.getText());
            gender = genderCalculator(gender);
            feet = feetCalculator(feet);
            inches = inchesCalculator(inches);

            if (calc == 3) { //differentiates between BFP and BMR calculations
                weight = Double.parseDouble(tfWeight.getText()) / 2.205; //converts lbs to kg (which is needed in the BFP formula)
            } else if (calc == 5) {
                weight = Double.parseDouble(tfWeight.getText()); //keeps weight in lbs (which is needed in the BMR formula)
                activity = activityCalculator(activity);
            }
            
        } catch (Exception e) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Input must be a number");
            errorAlert.showAndWait();
        }

        if (calc == 3) {
            temp = BFPequations(gender, feet, inches, weight, age);
        } else if (calc == 5) {
            temp = BMR(gender, feet, inches, weight, age, activity);
        }
        return temp;
    }

    public double BFPequations(int gender, int feet, int inches, double weight, double age) {
        double BFP = 0, eq1 = 0, eq2 = 0, eq3 = 0, eq4 = 0, eq5 = 0;
        int g = gender;
        int f = feet;
        int i = inches;
        double heightmeters = ((f * 12) + i) / 39.37; //converts inches to meters (which is needed in the formula)
        double w = weight;
        double a = age;
        double BMI = w / (heightmeters * heightmeters);

        eq1 = (1.20 * BMI) + (0.23 * a) - (10.8 * g) - 5.4; //Deurenberg Formula (1991)
        eq2 = (1.29 * BMI) + (0.20 * a) - (11.4 * g) - 8.0; //Deurenberg Formula 2 (1998)
        eq3 = (1.46 * BMI) + (0.14 * a) - (11.6 * g) - 10.0; //Gallagher Formula
        eq4 = (1.61 * BMI) + (0.13 * a) - (12.1 * g) - 13.9; //Jackson-Pollock Formula
        eq5 = (1.39 * BMI) + (0.16 * a) - (10.34 * g) - 9.0; //Jackson AS Formula

        BFP = (eq1 + eq2 + eq3 + eq4 + eq5) / 5;
        return BFP;
    }

    public double BMR(int gender, int feet, int inches, double weight, double age, double activity) {
        double BMR = 0;
        int g = gender;
        int f = feet;
        int i = inches;
        double heightinches = (f * 12) + i;
        double w = weight;
        double a = age;
        double act = activity;
        

        if (g == 1) { //BMR calculation for males
            BMR = (66 + (6.2 * w) + (12.7 * heightinches) - (6.76 * a)) * act;
        } else if (g == 0) { //BMR calculation for females
            BMR = (655.1 + (4.35 * w) + (4.7 * heightinches) - (4.7 * a)) * act;
        }
        return BMR;
    }

    public int genderCalculator(int gender) {

        int g = gender;

        switch(g) {

            case 1:
            g = 1; //male
            break;

            case 2:
            g = 0; //female
            break;
        }
        return g;
    }

    public int feetCalculator(int feet) {
        
        int f = feet;

        switch(f) {

            case 1:
            f = 0;
            break;

            case 2:
            f = 1;
            break;

            case 3:
            f = 2;
            break;

            case 4:
            f = 3;
            break;

            case 5:
            f = 4;
            break;

            case 6:
            f = 5;
            break;

            case 7:
            f = 6;
            break;

            case 8:
            f = 7;
            break;

            case 9:
            f = 8;
            break;

            case 10:
            f = 9;
            break;

            case 11:
            f = 10;
            break;
        }
        return f;
    }

    public int inchesCalculator(int inches) {

        int i = inches;

        switch(i) {

            case 1:
            i = 0;
            break;

            case 2:
            i = 1;
            break;

            case 3:
            i = 2;
            break;

            case 4:
            i = 3;
            break;

            case 5:
            i = 4;
            break;

            case 6:
            i = 5;
            break;

            case 7:
            i = 6;
            break;

            case 8:
            i = 7;
            break;

            case 9:
            i = 8;
            break;

            case 10:
            i = 9;
            break;

            case 11:
            i = 10;
            break;

            case 12:
            i = 11;
            break;
        }
        return i;
    }

    public double activityCalculator(double act) {

        double a = act;

        if (a == 1) {
            a = 1.2;
        } else if (a == 2) {
            a = 1.37;
        } else if (a == 3) {
            a = 1.55;
        } else if (a == 4) {
            a = 1.725;
        } else if (a == 5) {
            a = 1.9;
        }
        return a;
    }
}
