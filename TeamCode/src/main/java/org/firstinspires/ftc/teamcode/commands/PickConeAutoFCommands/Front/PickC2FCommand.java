package org.firstinspires.ftc.teamcode.commands.PickConeAutoFCommands.Front;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;

public class PickC2FCommand extends SequentialCommandGroup{
    public PickC2FCommand(Slide slide, ClawServos clawServos, Arm arm, Drivetrain drivetrain){
        addCommands(
                new InstantCommand(slide::slideCone2),
                new InstantCommand(arm::moveIntakeF),
                new SlowDriveForwardCommand(drivetrain, 5),
                new InstantCommand(clawServos::clawClose),
                new WaitCommand(50),
                new InstantCommand(slide:: slideLow)
        );
    }
}