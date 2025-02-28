package org.firstinspires.ftc.teamcode.SearchAndRescue;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;


import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;


public class MotorsHere {

    private TouchSensor touchSensor;
    private Servo theClaw;
    private Servo butterFord;
    private DcMotor backL;
    private DcMotor backR;
    private DcMotor frontL;
    private DcMotor frontR;
    private DcMotor sampleIntake;
    private DcMotor linearArm;
    private CRServo spinTake;
    private CRServo spinTakeR;
    private Servo wristServo;
    private DcMotor boxArm;

    private Servo theThingy;


    public void court(HardwareMap hwMap) {
       /*
       assign DcMotor types
       here
        */
        backL = hwMap.get(DcMotor.class, "leftBack");
        backR = hwMap.get(DcMotor.class, "rightBack");
        frontL = hwMap.get(DcMotor.class, "leftFront");
        frontR = hwMap.get(DcMotor.class, "rightFront");
        //sampleIntake = hwMap.get(DcMotor.class, "sampleIntake");
        //linearArm = hwMap.get(DcMotor.class, "linearArm");
        //boxArm = hwMap.get(DcMotor.class, "boxArm");



        //touchSensor = hwMap.get(TouchSensor.class, "touchSensor");


       /*
       assign servo types
       here
        */
        //spinTake = hwMap.get(CRServo.class, "spinTake");
        //spinTakeR = hwMap.get(CRServo.class, "spinTakeR");
        wristServo = hwMap.get(Servo.class, "wristServo");
        butterFord = hwMap.get(Servo.class, "butterFord");
        theClaw = hwMap.get(Servo.class, "theClaw");
        theThingy = hwMap.get(Servo.class, "theThingy");


       /*
       Reset encoders first,
       then give them speed/pos
        */
        backL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //sampleIntake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //linearArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //boxArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);




       /*
       set motor mode
        */
        backR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //sampleIntake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //linearArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //boxArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


       /*
       set direction of
       left two motors
       becuz they will go backwards
       otherwise
        */
        backL.setDirection(DcMotorSimple.Direction.REVERSE);
        frontL.setDirection(DcMotorSimple.Direction.REVERSE);
        //theThingy.setDirection(Servo.Direction.REVERSE);
        //butterFord.setDirection(Servo.Direction.REVERSE);
        //wristServo.setDirection(Servo.Direction.REVERSE);
        //boxArm.setDirection(DcMotorSimple.Direction.REVERSE);



       /*
       set behaviour
       for when power is 0 to brake
        */
        backL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //sampleIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //linearArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        //boxArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //set to run to pos
        //linearArm.setTargetPosition(0);
        //linearArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //set to run to pos





    }






    /*
    get pos of
    all of the wheels
     */
    public int getBackLeftMotorPos() {
        return backL.getCurrentPosition();
    }


    public int getBackRightPos() {
        return backR.getCurrentPosition();
    }


    public int getFrontLeftPos() {
        return frontL.getCurrentPosition();
    }


    public int getFrontRightPos() {
        return frontR.getCurrentPosition();
    }


   


    
    public double getWristPos() {
        return wristServo.getPosition();
    }


    





   /*
   for setting pos of
   the servos
    */


    
    public void setTheThingy(double goTo){ theThingy.setPosition(goTo);}


    public void setWristPos(double moveHere) {
        wristServo.setPosition(moveHere);
    }


    public void setButterFord(double butterPos) {
        butterFord.setPosition(butterPos);
    }


    public void setTheClaw(double clawPos){
        theClaw.setPosition(clawPos);
    }


   /*
   for setting the
   speed of the motors
    */







    public void setMotorSpeed(double speed, double power, double crab) {
        backR.setPower((speed + power) + crab);
        backL.setPower((speed - power) - crab);
        frontR.setPower((speed + power) - crab);
        frontL.setPower((speed - power) + crab);
    }
}
