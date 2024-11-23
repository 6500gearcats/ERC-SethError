// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.RomiDrivetrain;

public class TurnDegrees extends Command {
  /** Creates a new TurnDegrees. */

  private final RomiDrivetrain m_drive;
  private final double m_degrees;

  public TurnDegrees(double degrees, RomiDrivetrain romiDrivetrain) {
    m_degrees = degrees;
    m_drive = romiDrivetrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    m_drive.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(0, Constants.DriveConstants.defaultTurnSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_drive.getGyroAngleZ()) > m_degrees-15;
  }
}
