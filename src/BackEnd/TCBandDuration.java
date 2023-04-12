package BackEnd;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Alert.AlertType;

public class TCBandDuration {
        
    public double TCBandDurationCalc(TextInputControl tfDuration, TextInputControl tfTotalCalBurned, TextInputControl tfWeight, int metValue, int currentIndex) {

        double temp = 0;
        int index = currentIndex;
        double met = metValue;
        double weight = 0;
        double calories = 0;
        double duration = 0;

        try {
            if (index == 1) {
                duration = Double.parseDouble(tfDuration.getText());
            } else if (index == 2) {
                calories = Double.parseDouble(tfTotalCalBurned.getText());
            }
            weight = Double.parseDouble(tfWeight.getText()) / 2.205; //converts lbs to kg (which is needed in the formula)
            met = metCalculator(met);
        } catch (Exception e) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Input must be a number");
            errorAlert.showAndWait();
        }

        if (index == 1) {
            temp = (duration * (met * 3.5 * weight)) / 200;
        } else if (index == 2) {
            temp = (calories * 200) / (met * 3.5 * weight);
        }
        return temp;
    }

    public double metCalculator(double met) {

        double m = met;

        if (m == 1) {
            m = 1;
        } else if (m == 2) {
            m = 2.5;
        } else if (m == 3) {
            m = 3.5;
        } else if (m == 4) {
            m = 4;
        } else if (m == 5 || m == 6) {
            m = 5;
        } else if (m == 7 || m == 8 || m == 9 || m == 10 || m == 11) {
            m = 6;
        } else if (m == 12 || m == 13 || m == 14) {
            m = 7;
        } else if (m == 15 || m == 16 || m == 17 || m == 18 || m == 19 || m == 20) {
            m = 8;
        } else if (m == 21 || m == 22){
            m = 9;
        } else if (m == 23 || m == 24 || m == 25) {
            m = 10;
        } else if (m == 26 || m == 27) {
            m = 12;
        } else if (m == 28) {
            m = 13.5;
        } else if (m == 29) {
            m = 15;
        } else if (m == 30) {
            m = 16;
        } else if (m == 31) {
            m = 18;
        }
        
        return m;
    }
}