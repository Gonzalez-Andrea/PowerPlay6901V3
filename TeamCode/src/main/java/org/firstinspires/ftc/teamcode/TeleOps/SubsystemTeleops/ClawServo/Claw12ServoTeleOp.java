package org.firstinspires.ftc.teamcode.TeleOps.SubsystemTeleops.ClawServo;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GamepadTrigger;
import org.firstinspires.ftc.teamcode.driveTrainAuton.MatchOpMode;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
@Disabled
@Config
@TeleOp(name = "Bad Claw1/2 Servo Teleop")
public class Claw12ServoTeleOp extends MatchOpMode {

    private static double startPoseX = 0;
    private static double startPoseY = 0;
    private static double startPoseHeading = 0;

    //Motors and Servos
    private MotorEx clawMotor;

    private ServoEx clawS1, clawS3;
        private ServoEx clawS2;
//    private CRServo clawS2;

    // Gamepad
    private GamepadEx driverGamepad, operatorGamepad;


    // Subsystems
    private ClawServos clawServos;
//    private ClawMotors clawMotors;




    @Override
    public void robotInit() {
        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);
//        clawMotors = new ClawMotors(clawMotor, telemetry, hardwareMap);

        clawServos = new ClawServos(clawS1, clawS2, clawS3, telemetry, hardwareMap);
    }

    //Buttons
    private Button intakeTrigger, outtakeTrigger;
    private Button slowModeBumper;
    public Button resetFrontButton, resetBackButton;
    public Button plusClaw3Button, subClaw3Button;
    public Button plusClaw1Button, subClaw1Button;
    public Button s3FButton, s3BButton;


    public Button slideUpButton, slideDownButton, clawRaiseButton, clawLowerButton;
    public Button groundBSlideButton, lowBSlideButton, midBSlideButton, highBSlideButton;
    public Button groundFSlideButton, lowFSlideButton, midFSlideButton, highFSlideButton;
    public Button clawMotorResetButton, slideEncoderResetButton;

    public Button one, two, three, four, five;


    @Override
    public void configureButtons() {
        one = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER))
                .whenPressed(new InstantCommand(clawServos::clawClose));
//                .whenPressed(new PickConeCommand(clawServos));
//                .whenPressed(new InstantCommand(clawMotors::moveClawLowFront));
        two = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.LEFT_TRIGGER))
                .whenPressed(new InstantCommand(clawServos::clawOpen));

//                .whenPressed(new DropConeCommand(clawServos));
//                .whenPressed(new InstantCommand(clawMotors::moveClawLowFront));



//        //Claw Servo Intake/Outtake - D1
//            intakeTrigger = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER))
//                    .whenPressed(new PickConeCommand(clawServos));
//            outtakeTrigger = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.LEFT_TRIGGER))
//                    .whenPressed(new DropConeCommand(clawServos));
//        //Claw Servo 3 Buttons - D1
//            s3FButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.X))
//                    .whenPressed(clawServos::setFClawPos);
//            s3BButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.B))
//                    .whenPressed(clawServos::setBClawPos);
//
//        //Claw Servo Manual Rotation
//            plusClaw3Button = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_UP))
//                    .whenPressed(clawServos::addClaw3Pos);
//            subClaw3Button = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_DOWN))
//                    .whenPressed(clawServos::subClaw3Pos);
//        //Claw Servo Manual In/Out
//            plusClaw1Button = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_RIGHT))
//                    .whenPressed(clawServos::addClaw1Pos);
//            subClaw1Button = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_LEFT))
//                    .whenPressed(clawServos::subClaw1Pos);

    }

    @Override
    public void matchLoop() { }
    @Override
    public void disabledPeriodic() { }
    @Override
    public void matchStart() { }
    @Override
    public void robotPeriodic(){ }
}
