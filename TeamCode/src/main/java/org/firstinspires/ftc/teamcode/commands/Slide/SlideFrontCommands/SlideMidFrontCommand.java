package org.firstinspires.ftc.teamcode.commands.Slide.SlideFrontCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.ClawMotors;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Slide;

public class SlideMidFrontCommand extends SequentialCommandGroup {
    public SlideMidFrontCommand(Slide slide, ClawMotors clawMotors, ClawServos clawServos) {
        addCommands(
                new InstantCommand(clawServos::clawClose),
                new InstantCommand(clawMotors::moveF, clawMotors),
                new WaitCommand(150),
                new InstantCommand(slide::slideMid, slide),
                new WaitCommand(150),
                new InstantCommand(clawServos::setFClawPos)
        );
    }
}