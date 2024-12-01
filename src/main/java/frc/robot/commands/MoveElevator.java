// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;


public class MoveElevator extends Command {
  /** Creates a new MoveElevator. */
  public Elevator m_elevator;
  public DoubleSupplier m_speed;

  public MoveElevator(Elevator theElevator, DoubleSupplier speed) {
    //Added a DoubleSupplier to the MoveElevator so it can get continuous input from the controller instead of getting the first static value 

    // Use addRequirements() here to declare subsystem dependencies.
    m_elevator = theElevator;
    m_speed = speed;
    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_speed.getAsDouble() == 0) {
      m_elevator.setSpeed(-0.1);
    }
    else {
     m_elevator.setSpeed(m_speed.getAsDouble());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.setSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
