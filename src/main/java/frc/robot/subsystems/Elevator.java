// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  //TODO: Get the right port for the elevator and switch
  private PWMSparkMax m_motor = new PWMSparkMax(Constants.ElevatorConstants.kElevatorMotorPort);
  private double m_outputSpeed = 0.0;
  
  public Elevator() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Elevator Speed", m_outputSpeed);
  }

  public void setSpeed(double speed) {
    m_motor.set(speed);
    m_outputSpeed = speed;
  }

}
