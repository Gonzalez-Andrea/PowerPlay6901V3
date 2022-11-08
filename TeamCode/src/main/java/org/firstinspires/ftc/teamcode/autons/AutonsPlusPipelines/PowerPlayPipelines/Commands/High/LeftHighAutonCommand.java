package org.firstinspires.ftc.teamcode.autons.AutonsPlusPipelines.PowerPlayPipelines.Commands.High;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeAndDropConeCommands.DropConeCommand;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoFCommands.Back.PickC3BCommand;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoFCommands.Back.PickC4BCommand;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoFCommands.Back.PickC5BCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideBackCommands.SlideLowBackCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideFrontCommands.SlideHighFrontCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideFrontCommands.SlideLowFrontCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideFrontCommands.SlideResetFrontCommandT;
import org.firstinspires.ftc.teamcode.subsystems.ClawMotors;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;


public class LeftHighAutonCommand extends SequentialCommandGroup{
    public LeftHighAutonCommand(Drivetrain drivetrain, Slide slide, ClawMotors clawMotors, ClawServos clawServos){
        addCommands(
                new DriveForwardCommand(drivetrain, 75),
                new TurnToCommand(drivetrain, 152, true),
                new SlideHighFrontCommand(slide, clawMotors, clawServos),
                new DriveForwardCommand(drivetrain ,3),
                new WaitCommand(1000),
                new DropConeCommand(clawServos, slide),
                new WaitCommand(600),
                new SlideLowBackCommand(slide, clawMotors, clawServos),
                new TurnToCommand(drivetrain, 270),
                new DriveForwardCommand(drivetrain, -46),

                new PickC5BCommand(slide, clawServos, clawMotors, drivetrain),
                new TurnToCommand(drivetrain, 220),
                new SlideLowFrontCommand(slide, clawMotors, clawServos),
                new InstantCommand(clawServos::clawOpen, clawServos),
                new WaitCommand(600),
                new TurnToCommand(drivetrain, 270),

                new PickC4BCommand(slide, clawServos, clawMotors, drivetrain),
                new TurnToCommand(drivetrain, 135),
                new SlideLowFrontCommand(slide, clawMotors, clawServos),
                new InstantCommand(clawServos::clawOpen, clawServos),
                new WaitCommand(600),
                new TurnToCommand(drivetrain, 270),

                new PickC3BCommand(slide, clawServos, clawMotors, drivetrain),
                new TurnToCommand(drivetrain, 140),
                new SlideLowFrontCommand(slide, clawMotors, clawServos),
                new InstantCommand(clawServos::clawOpen, clawServos),
                new WaitCommand(600),
                new TurnToCommand(drivetrain, 270),

                new SlideResetFrontCommandT(slide, clawMotors, clawServos),
                new WaitCommand(200),
                new InstantCommand(clawMotors::moveReset, clawMotors),
                new DriveForwardCommand(drivetrain, 50)
        );
    }
}