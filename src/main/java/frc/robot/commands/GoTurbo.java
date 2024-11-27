// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RomiDrivetrain;

public class GoTurbo extends Command {
  private RomiDrivetrain m_drivetrain;
  private boolean turboActive = false;

  /** Creates a new GoTurbo. */
  public GoTurbo(RomiDrivetrain theDrivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = theDrivetrain;

    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turboActive = true;
    SmartDashboard.putBoolean("Turbo", turboActive);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(1, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
    turboActive = false;
    SmartDashboard.putBoolean("Turbo", turboActive);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
