package org.firstinspires.ftc.teamcode.subsystems;


import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;

import java.util.logging.Level;

@Config
public class ClawMotors extends SubsystemBase {

    public static PIDFCoefficients pidfCoefficients = new PIDFCoefficients(0.002, 1, 0, 0);
    //I = 0.0008
    private PIDFController controller;
    private boolean automatic;

    public static double CPR = 384.5;
    public static double UP_SPEED = -0.5;
    public static double DOWN_SPEED = 0.5;

    private double encoderOffset = 0;
    public static int INIT_POS = 0;

    public static int INTAKE_POS_BACK = -273;
    public static int GROUND_POS_BACK = -267;
    public static int LOW_POS_BACK = -270;
    public static int MID_POS_BACK = -240;
    public static int HIGH_POS_BACK = -200;

    public static int INTAKE_POS_FRONT = -INTAKE_POS_BACK;
    public static int GROUND_POS_FRONT = -GROUND_POS_BACK;
    public static int LOW_POS_FRONT = -LOW_POS_BACK;
    public static int MID_POS_FRONT = -MID_POS_BACK;
    public static int HIGH_POS_FRONT = -HIGH_POS_BACK;

    private int clawPos = 0;

    Telemetry telemetry;
    private MotorEx clawMotor;

    public ClawMotors(MotorEx clawMotor, Telemetry tl, HardwareMap hw) {
        this.clawMotor = clawMotor;
        this.clawMotor = new MotorEx(hw, "clawM");

        //Reverse claw motor
        this.clawMotor.setInverted(true);

        this.clawMotor.resetEncoder();

        this.clawMotor.setDistancePerPulse(360 / CPR);

        controller = new PIDFController(pidfCoefficients.p, pidfCoefficients.i, pidfCoefficients.d, pidfCoefficients.f, getAngle(), getAngle());
        controller.setTolerance(10);

        this.telemetry = tl;
        automatic = false;
        setOffset();
    }

    @Override
    public void periodic() {
        if (automatic) {
            controller.setF(pidfCoefficients.f * Math.cos(Math.toRadians(controller.getSetPoint())));

            double output = controller.calculate(getAngle());

            clawMotor.set(output);
        }
        Util.logger(this, telemetry, Level.INFO, "Claw Encoder Pos: ", clawMotor.getCurrentPosition());
        Util.logger(this, telemetry, Level.INFO, "Claw Pos: ", clawPos);
    }


    private double getEncoderDistance() {
        return clawMotor.getDistance() - encoderOffset;
    }
    public void setAutomatic(boolean auto) {
        this.automatic = auto;
    }
    public double getAngle() {
        return getEncoderDistance();
    }

    /****************************************************************************************/

    public void raiseClawManual() {
        automatic = false;
        clawMotor.set(UP_SPEED);
    }
    public void lowerClawManual() {
        automatic = false;
        clawMotor.set(DOWN_SPEED);
    }

    public void stopClaw() {
        clawMotor.stopMotor();
        controller.setSetPoint(getAngle());
        automatic = false;
    }

    /****************************************************************************************/

    public void moveClawIntakeFront() {
        automatic = true;
        controller.setSetPoint(INTAKE_POS_FRONT);
        clawPos = 0;
    }
    public void moveClawGroundFront() {
        automatic = true;
        controller.setSetPoint(GROUND_POS_FRONT);
        clawPos = 1;
    }
    public void moveClawLowFront() {
        automatic = true;
        controller.setSetPoint(LOW_POS_FRONT);
        clawPos = 2;
    }
    public void moveClawMidFront() {
        automatic = true;
        controller.setSetPoint(MID_POS_FRONT);
        clawPos = 3;
    }
    public void moveClawHighFront() {
        automatic = true;
        controller.setSetPoint(HIGH_POS_FRONT);
        clawPos = 4;
    }

    public void moveClawIntakeBack() {
        automatic = true;
        controller.setSetPoint(INTAKE_POS_BACK);
        clawPos = 5;
    }
    public void moveClawGroundBack() {
        automatic = true;
        controller.setSetPoint(GROUND_POS_BACK);
        clawPos = 6;
    }
    public void moveClawLowBack() {
        automatic = true;
        controller.setSetPoint(LOW_POS_BACK);
        clawPos = 7;
    }
    public void moveClawMidBack() {
        automatic = true;
        controller.setSetPoint(MID_POS_BACK);
        clawPos = 8;
    }
    public void moveClawHighBack() {
        automatic = true;
        controller.setSetPoint(HIGH_POS_BACK);
        clawPos = 9;
    }
    public void encoderReset() {
        clawMotor.resetEncoder();
    }

    /****************************************************************************************/


//    public void setLift(double angle) {
//        automatic = true;
//        controller.setSetPoint(angle);
//    }

    public boolean atTargetAngle() {
        return controller.atSetPoint();
    }

    public void setPower(){
        clawMotor.set(5);
    }

    public void setOffset() {
        resetEncoder();
        controller.setSetPoint(getAngle());
    }
    public void clawEncoderReset() {
        clawPos = 0;
    }
    public void resetEncoder() {
        clawEncoderReset();
    }

    public void moveClawToCorrectHeight() {
        if(clawPos == 0) {
            moveClawIntakeFront();
        } else if(clawPos == 1) {
            moveClawGroundFront();
        } else if(clawPos == 2) {
            moveClawLowFront();
        } else if(clawPos == 3) {
            moveClawMidFront();
        } else if(clawPos == 4) {
            moveClawHighFront();
        } else if(clawPos == 5) {
            moveClawIntakeBack();
        } else if(clawPos == 6) {
            moveClawGroundBack();
        } else if(clawPos == 7) {
            moveClawLowBack();
        } else if(clawPos == 8) {
            moveClawMidBack();
        } else if(clawPos == 9) {
            moveClawHighBack();
        }
    }
}
