package org.firstinspires.ftc.teamcode.commands.IntakeAndDropConeCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Slide;

public class PickConeCommand extends SequentialCommandGroup {

    public PickConeCommand(ClawServos clawServos, Slide slide){
        addCommands(
                  new InstantCommand(clawServos::clawClose, clawServos)
//                                new WaitCommand(800),
//                new InstantCommand(slide::slideMid, slide)


//                new InstantCommand(clawServos::intakeClaw),
//                new WaitCommand(4000),
//                new InstantCommand(clawServos::stopClaw)
        );
    }

}
