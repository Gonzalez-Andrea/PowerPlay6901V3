package org.firstinspires.ftc.teamcode.autons.PowerPlayCommands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.PickCone2Command;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.PickCone3Command;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.PickCone4Command;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.PickCone5Command;
import org.firstinspires.ftc.teamcode.commands.SlideBackCommands.SlideHighBackCommand;
import org.firstinspires.ftc.teamcode.subsystems.ClawMotors;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;


public class RightIThinkHighAutonCommand extends SequentialCommandGroup{
    public RightIThinkHighAutonCommand(Drivetrain drivetrain, Slide slide, ClawMotors clawMotors, ClawServos clawServos){
        addCommands(
                new DriveForwardCommand(drivetrain, 30),
                new TurnToCommand(drivetrain, 225),
                new SlideHighBackCommand(slide, clawMotors, clawServos),
                new TurnToCommand(drivetrain, 270),
                new DriveForwardCommand(drivetrain, 30),
                new PickCone5Command(slide, clawServos),


                new DriveForwardCommand(drivetrain, -30),
                new TurnToCommand(drivetrain, 225),
                new SlideHighBackCommand(slide, clawMotors, clawServos),
                new TurnToCommand(drivetrain, 270),
                new DriveForwardCommand(drivetrain, 30),
                new PickCone4Command(slide, clawServos),


                new DriveForwardCommand(drivetrain, -30),
                new TurnToCommand(drivetrain, 225),
                new SlideHighBackCommand(slide, clawMotors, clawServos),
                new TurnToCommand(drivetrain, 270),
                new DriveForwardCommand(drivetrain, 30),
                new PickCone3Command(slide, clawServos),

                new DriveForwardCommand(drivetrain, -30),
                new TurnToCommand(drivetrain, 225),
                new SlideHighBackCommand(slide, clawMotors, clawServos),
                new TurnToCommand(drivetrain, 270),
                new DriveForwardCommand(drivetrain, 30),
                new PickCone2Command(slide, clawServos)
        );
    }
}