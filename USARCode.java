package org.firstinspires.ftc.teamcode.SearchAndRescue;

//import android.util.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.SearchAndRescue.MotorsHere;

//@Config
@TeleOp(name = "USAR_Code")
public class USARCode extends OpMode {

    public double boost = 1;
    public double wrist;
    public double folded = 3;
    public double shoulder;
    public double shoulder2;
    MotorsHere appleSauce = new MotorsHere();

    @Override
    public void init() {
        appleSauce.court(hardwareMap);
    }

    double squareInputWithSign(double input) {
        double output = input * input;
        if (input < 0) {
            output = output * -1;
        }
        return output;
    }

    @Override
    public void loop() {
        //boost speed control
        if (gamepad1.right_trigger > 0.25) {
            boost = 1;
        } else {
            boost = 0.45;
        }

        //drive code
        double motorSpeed = (-(gamepad1.left_stick_y)) * boost;//squareInputWithSign()
        double turnSpeed = (-(gamepad1.right_stick_x)) * boost;//squareInputWithSign()
        double crab = (gamepad1.left_stick_x) * boost;//squareInputWithSign()
        appleSauce.setMotorSpeed(motorSpeed, turnSpeed, crab);





        //gripper control
        if (gamepad1.right_bumper){             //butterford, wrist, claw, and thingy  ==  gripper, wrist, shoulder, shoulder2 (right)
          appleSauce.setButterFord(0.5);
        }
        else if (gamepad1.circle){
            appleSauce.setButterFord(0);
        } else appleSauce.setButterFord(0.222);




        //raising arm in unfolded state
        if (gamepad1.left_bumper && folded == 0){     //raise
            shoulder -= 0.0025;

            shoulder = clamp(shoulder, 0.44, 1);
        }
        
        
        if (gamepad1.left_trigger > 0.25 && folded == 0){     //lower
            shoulder += 0.0025;

            shoulder = clamp(shoulder, 0.44, 1);
        }



        //switching between folded and unfolded
        if (gamepad1.triangle){
            folded = 1;
        }
        if (gamepad1.cross){
            folded = 0;
        }





        //folded states
        if (folded == 0){
            appleSauce.setWristPos(mapRange(shoulder, 0.44, 1, 0.45, 0.97));
            appleSauce.setTheClaw(shoulder);
            appleSauce.setTheThingy(1.44 - shoulder);
        }

        if (folded == 1){
            appleSauce.setWristPos(0.18);
            appleSauce.setTheClaw(0.44);
            appleSauce.setTheThingy(1);
            shoulder = 0.44;
        }

        if (folded == 3){
            appleSauce.setWristPos(0.45);
            appleSauce.setTheClaw(0.44);
            appleSauce.setTheThingy(1);
            shoulder = 0.44;
        }
    }




    public double clamp(double value, double minValue, double maxValue){
        if (value < minValue) return minValue;
        if (value > maxValue) return maxValue;
        else return value;
    }
    
    public double mapRange(double value, double inMin, double inMax, double outMin, double outMax){
        return ((value - inMin) * (outMax - outMin) / (inMax - inMin)) + outMin;
}
}
