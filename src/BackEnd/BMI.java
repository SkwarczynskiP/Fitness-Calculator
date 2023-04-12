package BackEnd;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Alert.AlertType;

public class BMI {

    public double BMICalc(TextInputControl tfWeight, int feetValue, int inchesValue ) {

        double BMI = 0;
        double weight = 0;
        int feet = feetValue;
        int inches = inchesValue;
        int f = 0;
        int i = 0;
        
        try {
            weight = Double.parseDouble(tfWeight.getText()) / 2.205; //converts lbs to kg (which is needed in the formula)
            f = feetCalculator(feet);
            i =inchesCalculator(inches);

        } catch (Exception e) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Input must be a number");
            errorAlert.showAndWait();
        }

        double heightmeters = ((f * 12) + i) / 39.37; //converts inches to meters (which is needed in the formula)
        BMI = (weight) / (heightmeters * heightmeters);
        return BMI;
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
}