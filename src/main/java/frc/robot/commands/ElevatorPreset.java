// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class ElevatorPreset extends Command {
  Elevator m_elevator;
  double m_speed = Constants.ElevatorConstants.defaultElevatorSpeed;
  double m_time;
  boolean m_down;
  Timer m_currentTimer = new Timer();

  /** Creates a new ElevatorPreset. */
  public ElevatorPreset(Elevator theElevator, double theTime) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevator = theElevator;
    m_time = theTime;
    m_down = false;

    addRequirements(m_elevator);
  }

  public ElevatorPreset(Elevator theElevator, double theTime, boolean down) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevator = theElevator;
    m_time = theTime;
    m_down = down;

    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_currentTimer.reset();
    m_currentTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!m_down) {
      m_elevator.setSpeed(m_speed);
    } else {
      m_elevator.setSpeed(-m_speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_currentTimer.hasElapsed(m_time);
  }
}
