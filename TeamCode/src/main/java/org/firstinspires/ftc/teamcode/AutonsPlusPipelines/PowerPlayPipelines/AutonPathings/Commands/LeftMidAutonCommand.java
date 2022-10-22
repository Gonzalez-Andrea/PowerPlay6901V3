package org.firstinspires.ftc.teamcode.AutonsPlusPipelines.PowerPlayPipelines.AutonPathings.Commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeAndDropConeCommands.DropConeCommand;
import org.firstinspires.ftc.teamcode.commands.SlideBackCommands.SlideMidBackCommand;
import org.firstinspires.ftc.teamcode.commands.SlideFrontCommands.SlideMidFrontCommand;
import org.firstinspires.ftc.teamcode.commands.SlideFrontCommands.SlideResetFrontCommandT;
import org.firstinspires.ftc.teamcode.subsystems.ClawMotors;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;


public class LeftMidAutonCommand extends SequentialCommandGroup{
    public LeftMidAutonCommand(Drivetrain drivetrain, Slide slide, ClawMotors clawMotors, ClawServos clawServos){
        addCommands(
                new DriveForwardCommand(drivetrain, 70),
                new TurnToCommand(drivetrain, 315, true),
                new SlideMidFrontCommand(slide, clawMotors, clawServos),
                new WaitCommand(1200),
                new DropConeCommand(clawServos),
                new WaitCommand(1100),
                new SlideResetFrontCommandT(slide, clawMotors, clawServos),
                new TurnToCommand(drivetrain, 90),
                new DriveForwardCommand(drivetrain, 30),
                new TurnToCommand(drivetrain, 360),
                new DriveForwardCommand(drivetrain, 30)

        );
    }
}