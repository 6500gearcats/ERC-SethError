// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.RomiDrivetrain;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Autonomous extends SequentialCommandGroup {
  /** Creates a new Autonomous. */
  public Autonomous(Elevator theElevator, RomiDrivetrain theRomiDrivetrain, Shooter theShooter) {

    addCommands(
      //TODO: add real numbers
        new ShootCube(theShooter, 4).withTimeout(1),
        new ParallelDeadlineGroup(new RunCommand(() -> theRomiDrivetrain.arcadeDrive(0, 0.5), theRomiDrivetrain),
            new MoveElevator(theElevator, -2)).withTimeout(2),
        new RunCommand(() -> theRomiDrivetrain.arcadeDrive(0,0.5)).withTimeout(2),
        new ParallelDeadlineGroup(new RunCommand(() -> theRomiDrivetrain.arcadeDrive(0, 0.5), theRomiDrivetrain),
            new ShootCube(theShooter, -1)),
        new RunCommand(() -> theRomiDrivetrain.arcadeDrive(0, 0), theRomiDrivetrain)

    );

  }
}
