package org.firstinspires.ftc.teamcode.subsystems.Misc;


import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;

import java.util.logging.Level;

@Config
public class MotorSubsystem extends SubsystemBase {


    public static double UP_SPEED = 1;
    public static double DOWN_SPEED = -1;

    private int clawPos = 0;

    Telemetry telemetry;
    private MotorEx testMotor;

    public MotorSubsystem(MotorEx testMotor, Telemetry tl, HardwareMap hw) {
        this.testMotor = testMotor;
        this.testMotor = new MotorEx(hw, "rightFront");

        //Reverse claw motor
//        testMotor.setDirection(REVERSE);

//        this.testMotor.setInverted(true);


        this.telemetry = tl;
    }

    @Override
    public void periodic() {
        Util.logger(this, telemetry, Level.INFO, "speed ", testMotor.getAcceleration());
//        Util.logger(this, telemetry, Level.INFO, "Claw Pos: ", clawPos);
    }



    /****************************************************************************************/

    public void setUpSpeed() {
        testMotor.set(UP_SPEED);
    }
    public void setDownSpeed() {
        testMotor.set(DOWN_SPEED);
    }

    public void stopClaw() {
        testMotor.stopMotor();
    }

    /****************************************************************************************/

    public void encoderReset() {
        testMotor.resetEncoder();
    }

    /****************************************************************************************/


//    public void setLift(double angle) {
//        automatic = true;
//        controller.setSetPoint(angle);
//    }
}
