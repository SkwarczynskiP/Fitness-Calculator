import java.text.DecimalFormat;
import BackEnd.BMI;
import BackEnd.BFPandBMR;
import BackEnd.TCBandDuration;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

    private TextField tfDuration = new TextField();
    private TextField tfWeight = new TextField();
    private TextField tfAge = new TextField();
    private TextField tfTotalCalBurned = new TextField();
    private Button btCalculate = new Button("Calculate");
    private Button btReset = new Button("Reset Fields");
    private Button btRemove = new Button("Make A Different Calculation");
    private int currentIndex;
    private int metValue;
    private int genderValue;
    private int feetValue;
    private int inchesValue;
    private int activityValue;
    

    TCBandDuration newObj1 = new TCBandDuration();
    BFPandBMR newObj2 = new BFPandBMR();
    BMI newObj3 = new BMI();

    DecimalFormat df = new DecimalFormat("#.00");
    DecimalFormat d = new DecimalFormat("#.0");

    @Override
    public void start(Stage primaryStage) {

        BorderPane border = new BorderPane();

        HBox hboxtop = new HBox();
        border.setTop(hboxtop);
        hboxtop.setPadding(new Insets(20, 20, 20, 20));
        hboxtop.setSpacing(10);
        hboxtop.setAlignment(Pos.CENTER);
        hboxtop.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        Text calcOptionText = new Text("What would you like to calculate?");

        ComboBox<String> cmbCalcOption = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList
            ("", "Total Calories Burned", "Required Duration of Workout", "Body Fat Percentage", "Body Mass Index (BMI)", "Basal Metabolic Rate (BMR)");
        cmbCalcOption.getItems().addAll(items);
        cmbCalcOption.setValue(items.get(0));
        hboxtop.getChildren().addAll(calcOptionText, cmbCalcOption);

        HBox hboxbottom = new HBox();
        border.setBottom(hboxbottom);
        hboxbottom.setPadding(new Insets(15, 12, 15, 12));
        hboxbottom.setSpacing(10);
        hboxbottom.setAlignment(Pos.CENTER);
        hboxbottom.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        hboxbottom.getChildren().addAll(btReset, btRemove);

        GridPane gridPane = new GridPane(); //Center Grid Pane
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        border.setCenter(gridPane);

        GridPane rightPane = new GridPane(); //Right Grid Pane
        rightPane.setHgap(10);
        rightPane.setVgap(10);
        rightPane.setPadding(new Insets(15));

        //BMI Qualifications
        HBox BMI1 = new HBox();
        Text bmi1 = new Text("Underweight (Below 18.5)");
        BMI1.getChildren().addAll(bmi1);

        HBox BMI2 = new HBox();
        Text bmi2 = new Text("Healthy (18.5 - 24.9)");
        BMI2.getChildren().addAll(bmi2);

        HBox BMI3 = new HBox();
        Text bmi3 = new Text("Overweight (25.0 - 29.9)");
        BMI3.getChildren().addAll(bmi3);

        HBox BMI4 = new HBox();
        Text bmi4 = new Text("Obese (30.0 and Above)");
        BMI4.getChildren().addAll(bmi4);

        //Male BFP Qualifications
        HBox MaleBFP0 = new HBox();
        Text mbfp0 = new Text("Male Assessment:");
        MaleBFP0.getChildren().addAll(mbfp0);

        HBox MaleBFP1 = new HBox();
        Text mbfp1 = new Text("Essential Fat: 2 - 5%");
        MaleBFP1.getChildren().addAll(mbfp1);

        HBox MaleBFP2 = new HBox();
        Text mbfp2 = new Text("Athletes: 6 - 13%");
        MaleBFP2.getChildren().addAll(mbfp2);

        HBox MaleBFP3 = new HBox();
        Text mbfp3 = new Text("Fit: 14 - 17%");
        MaleBFP3.getChildren().addAll(mbfp3);

        HBox MaleBFP4 = new HBox();
        Text mbfp4 = new Text("Average: 18% - 24%");
        MaleBFP4.getChildren().addAll(mbfp4);

        HBox MaleBFP5 = new HBox();
        Text mbfp5 = new Text("Obese: 25% and Above");
        MaleBFP5.getChildren().addAll(mbfp5);

        //Female BFP Qualifications
        HBox FemaleBFP0 = new HBox();
        Text fbfp0 = new Text("Female Assessment:");
        FemaleBFP0.getChildren().addAll(fbfp0);

        HBox FemaleBFP1 = new HBox();
        Text fbfp1 = new Text("Essential Fat: 10 - 13%");
        FemaleBFP1.getChildren().addAll(fbfp1);

        HBox FemaleBFP2 = new HBox();
        Text fbfp2 = new Text("Athletes: 14 - 20%");
        FemaleBFP2.getChildren().addAll(fbfp2);

        HBox FemaleBFP3 = new HBox();
        Text fbfp3 = new Text("Fit: 21 - 24%");
        FemaleBFP3.getChildren().addAll(fbfp3);

        HBox FemaleBFP4 = new HBox();
        Text fbfp4 = new Text("Average: 25 - 31%");
        FemaleBFP4.getChildren().addAll(fbfp4);

        HBox FemaleBFP5 = new HBox();
        Text fbfp5 = new Text("Obese: 32% and Above");
        FemaleBFP5.getChildren().addAll(fbfp5);

        ComboBox<String> cmbMetValue = new ComboBox<>();
        ObservableList<String> metItems = FXCollections.observableArrayList
            ("", "Rest (1 MET)", "Mild Stretching (2.5 MET)", "Mild Walking (3.5 MET)", //Cases 0-3
            "Light Volleyball (4.0 MET)", "Brisk Walking (5.0 MET)", "Baseball/Softball (5.0 MET)", //Cases 4-6
            "Vigorous Effort Weightlifting (6.0 MET)", "Jog/Walk Combination (6.0 MET)", "Wrestling ~5 min (6.0 MET)", //Cases 7-9
            "Moderate Uphill Walking (6.0 MET)", "Leisurely Swimming (6.0 MET)", "Casual Soccer (7.0 MET)", //Cases 10-12
            "Tennis (7.0 MET)", "Light Effot Lap Swimming (7.0 MET)", "Basketball In-Game (8.0 MET)", //Cases 13-15
            "Beach Volleyball (8.0 MET)", "Intense Walking (8.0 MET)", "Continuous Jogging (8.0 MET)", //Cases 16-18
            "Minimal Rest Circuit Training (8.0 MET)", "Vigorous Calisthenics (8.0 MET)", //Cases 19-20
            "Stair-Treadmilll (9.0 MET)", "Competitive Football (9.0 MET)", //Cases 21-22
            "Judo/Jujitsu/Karate/Kickboxing/Taekwondo (10.0 MET)", "Moderate Rope Jumping (10.0 MET)", "Vigorous Lap Swimming (10.0 MET)", //Cases 23-25
            "Vigorous Rope Jumping (12.0 MET)", "Competitive Boxing (12.0 MET)", "Running 8 mph (13.5 MET)", //Cases 26-28
            "Running Up Stairs (15.0 MET)", "Running 10 mph (16.0 MET)", "Fast Running >10 mph (18.0 MET)"); //Cases 29-31

        cmbMetValue.getItems().addAll(metItems);
        cmbMetValue.setValue(metItems.get(0));

        ComboBox<String> cmbGender = new ComboBox<>();
        ObservableList<String> genderItems = FXCollections.observableArrayList("", "Male", "Female");
        cmbGender.getItems().addAll(genderItems);
        cmbGender.setValue(genderItems.get(0));

        ComboBox<String> cmbFeet = new ComboBox<>();
        ObservableList<String> feetItems = FXCollections.observableArrayList("", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        cmbFeet.getItems().addAll(feetItems);
        cmbFeet.setValue(feetItems.get(0));

        ComboBox<String> cmbInches = new ComboBox<>();
        ObservableList<String> inchesItems = FXCollections.observableArrayList("", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        cmbInches.getItems().addAll(inchesItems);
        cmbInches.setValue(inchesItems.get(0));
        
        ComboBox<String> cmbActivity = new ComboBox<>();
        ObservableList<String> activityItems = FXCollections.observableArrayList("", "Little to no exercise", "Light Exercise 1-3 Days a Week", 
            "Moderate Exercise 3-5 Days a Week", "Hard Exercise 6-7 Days a Week", "Intense Daily Exercise Routine");
        cmbActivity.getItems().addAll(activityItems);
        cmbActivity.setValue(activityItems.get(0));
  
        // Adds Appropriate Text Fields
        cmbCalcOption.setOnAction(a -> {
            currentIndex = items.indexOf(cmbCalcOption.getValue());
            cmbCalcOption.setDisable(true);

            switch(currentIndex) {

                case 1, 2: // Calculate Total Calories Burned or Required Duration of Workout

                if (currentIndex == 1) {
                    gridPane.add(new Label("Duration of Workout (min)"), 0, 1);
                    gridPane.add(tfDuration, 1, 1 );
                    tfDuration.setEditable(true);
                } else if (currentIndex == 2) {
                    gridPane.add(new Label("Desired Amount of Calories Burned (cal)"), 0, 1);
                    gridPane.add(tfTotalCalBurned, 1, 1);
                    tfTotalCalBurned.setEditable(true);
                }
                gridPane.add(new Label("Intensity Level (Determined by choice of activity)"), 0, 2);
                gridPane.add(cmbMetValue, 1, 2);
                cmbMetValue.setDisable(false);
                gridPane.add(new Label("Weight (lbs)"), 0, 3);
                gridPane.add(tfWeight, 1, 3);
                tfWeight.setEditable(true);
                gridPane.add(btCalculate, 1, 4);
                btCalculate.setDisable(false);
                btReset.setDisable(false);

                btCalculate.setOnAction(b -> {
                    metValue = metItems.indexOf(cmbMetValue.getValue());
                    double finalvalue = newObj1.TCBandDurationCalc(tfDuration, tfTotalCalBurned, tfWeight, metValue, currentIndex);

                    if (currentIndex == 1) {
                        gridPane.add(new Label("For this workout, you will burn " + d.format(finalvalue) + " calories"), 0, 4);
                        tfDuration.setEditable(false);
                        cmbMetValue.setDisable(true);
                        tfWeight.setEditable(false);
                        btCalculate.setDisable(true);

                    } else if (currentIndex == 2) {
                        int temp = (int) Math.round(finalvalue);

                        if (temp > 60) {

                            int finalHours = temp / 60;
                            int finalMinutes = temp % 60;
    
                            if (finalHours > 1 && finalMinutes > 1) {
                                gridPane.add(new Label("You will have to workout for " + finalHours + " hours and " + finalMinutes + " minutes"), 0, 4);
                            } else if (finalHours > 1 && finalMinutes == 0) {
                                gridPane.add(new Label("You will have to workout for " + finalHours + " hours"), 0, 4);
                            } else if (finalHours == 1 && finalMinutes == 0 ) {
                                gridPane.add(new Label("You will have to workout for " + finalHours + " hour"), 0, 4);
                            } else if (finalHours == 1 && finalMinutes > 1) {
                                gridPane.add(new Label("You will have to workout for " + finalHours + " hour and " + finalMinutes + " minutes"), 0, 4);
                            } else if (finalHours == 1 && finalMinutes == 1) {
                                gridPane.add(new Label("You will have to workout for " + finalHours + " hour and " + finalMinutes + " minute"), 0, 4);
                            }
                        } else {
    
                            int finalTotal = (int) temp;
                                
                            if (finalTotal == 1) {
                                gridPane.add(new Label("You will have to workout for " + finalTotal + " minute"), 0, 4);
                            } else if (finalTotal > 1) {
                                gridPane.add(new Label("You will have to workout for " + finalTotal + " minutes"), 0, 4);
                            } else if (finalTotal == 0) {
                                gridPane.add(new Label("You do not have to workout"), 0, 4);
                            }
                        }
                        tfTotalCalBurned.setEditable(false);
                        cmbMetValue.setDisable(true);
                        tfWeight.setEditable(false);
                        btCalculate.setDisable(true);
                    }
                });

                //Allows user to select a new calculation
                btRemove.setOnAction(z -> {
                    tfWeight.clear();
                    cmbMetValue.getSelectionModel().clearSelection();
                    cmbCalcOption.getSelectionModel().clearSelection();
                    if (currentIndex == 1) {
                        tfDuration.clear();
                    } else if (currentIndex == 2) {
                        tfTotalCalBurned.clear();
                    }

                    gridPane.getChildren().clear();
                    cmbCalcOption.setDisable(false);
                    btReset.setDisable(true);
                });

                //Allows user to input a new set of variables
                btReset.setOnAction(y -> {

                    tfWeight.clear();
                    cmbMetValue.getSelectionModel().clearSelection();

                    if (currentIndex == 1) {
                        tfDuration.clear();
                        tfDuration.setEditable(true);
                    } else if (currentIndex == 2) {
                        tfTotalCalBurned.clear();
                        tfTotalCalBurned.setEditable(true);
                    }
                    gridPane.getChildren().clear();

                    if (currentIndex == 1) {
                        gridPane.add(new Label("Duration of Workout (min)"), 0, 1);
                        gridPane.add(tfDuration, 1, 1 );
                        tfDuration.setEditable(true);
                    } else if (currentIndex == 2) {
                        gridPane.add(new Label("Desired Amount of Calories Burned (cal)"), 0, 1);
                        gridPane.add(tfTotalCalBurned, 1, 1);
                        tfTotalCalBurned.setEditable(true);
                    }
                    gridPane.add(new Label("Intensity Level (Determined by choice of activity)"), 0, 2);
                    gridPane.add(cmbMetValue, 1, 2);
                    cmbMetValue.setDisable(false);
                    gridPane.add(new Label("Weight (lbs)"), 0, 3);
                    gridPane.add(tfWeight, 1, 3);
                    tfWeight.setEditable(true);
                    gridPane.add(btCalculate, 1, 4);
                    btCalculate.setDisable(false);
                    btReset.setDisable(false);
                
                });
                break;
            
                case 3, 5: // Calculate Body Fat Percentage & BMR

                if (currentIndex == 3) { //differentiaties between BFP and BMR calculations
                    gridPane.add(new Label("Weight (lbs)"), 0, 1);
                    gridPane.add(tfWeight, 1, 1);
                    tfWeight.setEditable(true);
                    gridPane.add(new Label("Age"), 0, 2);
                    gridPane.add(tfAge, 1, 2);
                    tfAge.setEditable(true);
                    gridPane.add(new Label("Gender"), 0, 3);
                    gridPane.add(cmbGender, 1, 3);
                    cmbGender.setDisable(false);
                    gridPane.add(new Label("Height:"), 0, 4);
                    gridPane.add(new Label("        Feet"), 0, 5);
                    gridPane.add(cmbFeet, 1, 5);
                    cmbFeet.setDisable(false);
                    gridPane.add(new Label("        Inches"), 0, 6);
                    gridPane.add(cmbInches, 1, 6);
                    cmbInches.setDisable(false);
                    gridPane.add(btCalculate, 1, 7);
                    btCalculate.setDisable(false);
                    btReset.setDisable(false);

                } else if (currentIndex == 5) {
                    gridPane.add(new Label("Weight (lbs)"), 0, 1);
                    gridPane.add(tfWeight, 1, 1);
                    tfWeight.setEditable(true);
                    gridPane.add(new Label("Age"), 0, 2);
                    gridPane.add(tfAge, 1, 2);
                    tfAge.setEditable(true);
                    gridPane.add(new Label("Activity Level"), 0, 3);
                    gridPane.add(cmbActivity, 1, 3);
                    cmbActivity.setDisable(false);
                    gridPane.add(new Label("Gender"), 0, 4);
                    gridPane.add(cmbGender, 1, 4);
                    cmbGender.setDisable(false);
                    gridPane.add(new Label("Height:"), 0, 5);
                    gridPane.add(new Label("        Feet"), 0, 6);
                    gridPane.add(cmbFeet, 1, 6);
                    cmbFeet.setDisable(false);
                    gridPane.add(new Label("        Inches"), 0, 7);
                    gridPane.add(cmbInches, 1, 7);
                    cmbInches.setDisable(false);
                    gridPane.add(btCalculate, 1, 8);
                    btCalculate.setDisable(false);
                    btReset.setDisable(false);

                    border.setRight(rightPane);
                    rightPane.setAlignment(Pos.CENTER);

                    Text BMRdef1 = new Text("Basal Metabolic Rate (BMR):");
                    Text BMRdef2 = new Text("A measure of the total amount");
                    Text BMRdef3 = new Text("of calories one will burn in a"); 
                    Text BMRdef4 = new Text("single day.");

                    rightPane.add(BMRdef1, 0, 0);
                    rightPane.add(BMRdef2, 0, 1);
                    rightPane.add(BMRdef3, 0, 2);
                    rightPane.add(BMRdef4, 0, 3);
                }
                
                btCalculate.setOnAction(e -> {
                    genderValue = genderItems.indexOf(cmbGender.getValue());
                    feetValue = feetItems.indexOf(cmbFeet.getValue());
                    inchesValue = inchesItems.indexOf(cmbInches.getValue());
                    activityValue = activityItems.indexOf(cmbActivity.getValue());
                    double initvalue = newObj2.initialize(tfWeight, tfAge, genderValue, feetValue, inchesValue, activityValue, currentIndex);
                    int finalv = (int) Math.round(initvalue);


                    tfWeight.setEditable(false);
                    tfAge.setEditable(false);
                    cmbFeet.setDisable(true);
                    cmbInches.setDisable(true);
                    cmbGender.setDisable(true);
                    btCalculate.setDisable(true);

                    if (currentIndex == 3) { //differentiaties between BFP and BMR calculations
                        gridPane.add(new Label("Your body fat pecentage is " + finalv + "%"), 0, 7);

                        rightPane.add(MaleBFP0, 0, 0);
                        rightPane.add(MaleBFP1, 0, 1);
                        rightPane.add(MaleBFP2, 0, 2);
                        rightPane.add(MaleBFP3, 0, 3);
                        rightPane.add(MaleBFP4, 0, 4);
                        rightPane.add(MaleBFP5, 0, 5);
                        rightPane.add(FemaleBFP0, 0, 7);
                        rightPane.add(FemaleBFP1, 0, 8);
                        rightPane.add(FemaleBFP2, 0, 9);
                        rightPane.add(FemaleBFP3, 0, 10);
                        rightPane.add(FemaleBFP4, 0, 11);
                        rightPane.add(FemaleBFP5, 0, 12);

                        border.setRight(rightPane);
                        rightPane.setAlignment(Pos.CENTER);

                        if (genderValue == 1) {
                            if (finalv >= 2 && finalv < 6) {
                                MaleBFP1.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
                            } else if (finalv >= 6 && finalv < 14) {
                                MaleBFP2.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
                            } else if (finalv >= 15 && finalv < 18) {
                                MaleBFP3.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
                            } else if (finalv >= 18 && finalv < 25) {
                                MaleBFP4.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
                            } else if (finalv >= 25) {
                                MaleBFP5.setBackground(new Background(new BackgroundFill(Color.ORANGERED, null, null)));
                            }
                        } else if (genderValue == 2) {
                            if (finalv >= 10 && finalv < 14) {
                                FemaleBFP1.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
                            } else if (finalv >= 14 && finalv < 21) {
                                FemaleBFP2.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
                            } else if (finalv >= 21 && finalv < 25) {
                                FemaleBFP3.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
                            } else if (finalv >= 25 && finalv < 32) {
                                FemaleBFP4.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
                            } else if (finalv >= 32) {
                                FemaleBFP5.setBackground(new Background(new BackgroundFill(Color.ORANGERED, null, null)));
                            }
                        }

                    } else if (currentIndex == 5) {
                        gridPane.add(new Label("Your Basal Metabolic Rate (BMR) is " + finalv), 0, 8);
                        cmbActivity.setDisable(true);
                    }
                });

                //Allows user to select a new calculation
                btRemove.setOnAction(z -> {
                    tfWeight.clear();
                    tfAge.clear();
                    cmbFeet.getSelectionModel().clearSelection();
                    cmbInches.getSelectionModel().clearSelection();
                    cmbGender.getSelectionModel().clearSelection();
                    cmbCalcOption.getSelectionModel().clearSelection();
                    gridPane.getChildren().clear();
                    cmbCalcOption.setDisable(false);
                    MaleBFP1.setBackground(null);
                    MaleBFP2.setBackground(null);
                    MaleBFP3.setBackground(null);
                    MaleBFP4.setBackground(null);
                    MaleBFP5.setBackground(null);
                    FemaleBFP1.setBackground(null);
                    FemaleBFP2.setBackground(null);
                    FemaleBFP3.setBackground(null);
                    FemaleBFP4.setBackground(null);
                    FemaleBFP5.setBackground(null);
                    if (currentIndex == 5) {
                        cmbActivity.getSelectionModel().clearSelection();
                    }

                    rightPane.getChildren().clear();
                    btReset.setDisable(true);
                });
                
                //Allows user to input a new set of variables
                btReset.setOnAction(y -> {
                    tfWeight.clear();
                    tfAge.clear();
                    cmbFeet.getSelectionModel().clearSelection();
                    cmbInches.getSelectionModel().clearSelection();
                    cmbGender.getSelectionModel().clearSelection();
                    MaleBFP1.setBackground(null);
                    MaleBFP2.setBackground(null);
                    MaleBFP3.setBackground(null);
                    MaleBFP4.setBackground(null);
                    MaleBFP5.setBackground(null);
                    FemaleBFP1.setBackground(null);
                    FemaleBFP2.setBackground(null);
                    FemaleBFP3.setBackground(null);
                    FemaleBFP4.setBackground(null);
                    FemaleBFP5.setBackground(null);

                    if (currentIndex == 5) {
                        cmbActivity.getSelectionModel().clearSelection();
                    }

                    rightPane.getChildren().clear();
                    gridPane.getChildren().clear();

                    if (currentIndex == 3) {
                        gridPane.add(new Label("Weight (lbs)"), 0, 1);
                        gridPane.add(tfWeight, 1, 1);
                        tfWeight.setEditable(true);
                        gridPane.add(new Label("Age"), 0, 2);
                        gridPane.add(tfAge, 1, 2);
                        tfAge.setEditable(true);
                        gridPane.add(new Label("Gender"), 0, 3);
                        gridPane.add(cmbGender, 1, 3);
                        cmbGender.setDisable(false);
                        gridPane.add(new Label("Height:"), 0, 4);
                        gridPane.add(new Label("        Feet"), 0, 5);
                        gridPane.add(cmbFeet, 1, 5);
                        cmbFeet.setDisable(false);
                        gridPane.add(new Label("        Inches"), 0, 6);
                        gridPane.add(cmbInches, 1, 6);
                        cmbInches.setDisable(false);
                        gridPane.add(btCalculate, 1, 7);
                        btCalculate.setDisable(false);
                        btReset.setDisable(false);
    
                    } else if (currentIndex == 5) {
                        gridPane.add(new Label("Weight (lbs)"), 0, 1);
                        gridPane.add(tfWeight, 1, 1);
                        tfWeight.setEditable(true);
                        gridPane.add(new Label("Age"), 0, 2);
                        gridPane.add(tfAge, 1, 2);
                        tfAge.setEditable(true);
                        gridPane.add(new Label("Activity Level"), 0, 3);
                        gridPane.add(cmbActivity, 1, 3);
                        cmbActivity.setDisable(false);
                        gridPane.add(new Label("Gender"), 0, 4);
                        gridPane.add(cmbGender, 1, 4);
                        cmbGender.setDisable(false);
                        gridPane.add(new Label("Height:"), 0, 5);
                        gridPane.add(new Label("        Feet"), 0, 6);
                        gridPane.add(cmbFeet, 1, 6);
                        cmbFeet.setDisable(false);
                        gridPane.add(new Label("        Inches"), 0, 7);
                        gridPane.add(cmbInches, 1, 7);
                        cmbInches.setDisable(false);
                        gridPane.add(btCalculate, 1, 8);
                        btCalculate.setDisable(false);
                        btReset.setDisable(false);
    
                        border.setRight(rightPane);
                        rightPane.setAlignment(Pos.CENTER);
    
                        Text BMRdef1 = new Text("Basal Metabolic Rate (BMR):");
                        Text BMRdef2 = new Text("A measure of the total amount");
                        Text BMRdef3 = new Text("of calories one will burn in a"); 
                        Text BMRdef4 = new Text("single day.");
    
                        rightPane.add(BMRdef1, 0, 0);
                        rightPane.add(BMRdef2, 0, 1);
                        rightPane.add(BMRdef3, 0, 2);
                        rightPane.add(BMRdef4, 0, 3);
                }
                });
                break;

                case 4: // Calculate BMI
                gridPane.add(new Label("Weight (lbs)"), 0, 1);
                gridPane.add(tfWeight, 1, 1);
                tfWeight.setEditable(true);
                gridPane.add(new Label("Height:"), 0, 2);
                gridPane.add(new Label("        Feet"), 0, 3);
                gridPane.add(cmbFeet, 1, 3);
                cmbFeet.setDisable(false);
                gridPane.add(new Label("        Inches"), 0, 4);
                gridPane.add(cmbInches, 1, 4);
                cmbInches.setDisable(false);
                gridPane.add(btCalculate, 1, 5);
                btCalculate.setDisable(false);
                btReset.setDisable(false);

                btCalculate.setOnAction(g ->  {
                    feetValue = feetItems.indexOf(cmbFeet.getValue());
                    inchesValue = inchesItems.indexOf(cmbInches.getValue());
                    double initialBMI = newObj3.BMICalc(tfWeight, feetValue, inchesValue);
                    double finalBMI = Math.round((initialBMI) * 10.0) / 10.0;

                    gridPane.add(new Label("Your Body Mass Index (BMI) is " + finalBMI), 0, 5);

                    rightPane.add(BMI1, 0, 0);
                    rightPane.add(BMI2, 0, 1);
                    rightPane.add(BMI3, 0, 2);
                    rightPane.add(BMI4, 0, 3);

                    border.setRight(rightPane);
                    rightPane.setAlignment(Pos.CENTER);

                    if (finalBMI >= 30) {
                        BMI4.setBackground(new Background(new BackgroundFill(Color.ORANGERED, null, null)));
                    } else if (finalBMI <= 29.9 && finalBMI >= 25.0) {
                        BMI3.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
                    } else if (finalBMI <= 24.9 && finalBMI >= 18.5) {
                        BMI2.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
                    } else {
                        BMI1.setBackground(new Background(new BackgroundFill(Color.ORANGERED, null, null)));
                    }

                    tfWeight.setEditable(false);
                    cmbFeet.setDisable(true);
                    cmbInches.setDisable(true);
                    btCalculate.setDisable(true);
                });

                //Allows user to select a new calculation
                btRemove.setOnAction(z -> {
                    tfWeight.clear();
                    cmbFeet.getSelectionModel().clearSelection();
                    cmbInches.getSelectionModel().clearSelection();
                    cmbCalcOption.getSelectionModel().clearSelection();
                    BMI1.setBackground(null);
                    BMI2.setBackground(null);
                    BMI3.setBackground(null);
                    BMI4.setBackground(null);
                    cmbCalcOption.setDisable(false);

                    gridPane.getChildren().clear();
                    rightPane.getChildren().clear();

                    btReset.setDisable(true);
                });

                //Allows user to input a new set of variables
                btReset.setOnAction(y -> {
                    tfWeight.clear();
                    cmbFeet.getSelectionModel().clearSelection();
                    cmbInches.getSelectionModel().clearSelection();
                    BMI1.setBackground(null);
                    BMI2.setBackground(null);
                    BMI3.setBackground(null);
                    BMI4.setBackground(null);

                    gridPane.getChildren().clear();
                    rightPane.getChildren().clear();

                    gridPane.add(new Label("Weight (lbs)"), 0, 1);
                    gridPane.add(tfWeight, 1, 1);
                    tfWeight.setEditable(true);
                    gridPane.add(new Label("Height:"), 0, 2);
                    gridPane.add(new Label("        Feet"), 0, 3);
                    gridPane.add(cmbFeet, 1, 3);
                    cmbFeet.setDisable(false);
                    gridPane.add(new Label("        Inches"), 0, 4);
                    gridPane.add(cmbInches, 1, 4);
                    cmbInches.setDisable(false);
                    gridPane.add(btCalculate, 1, 5);
                    btCalculate.setDisable(false);
                    btReset.setDisable(false);
                });
                break;
            }
        });

        gridPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(border, 700, 500);
        primaryStage.setTitle("Fitness Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}