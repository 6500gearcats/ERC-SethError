// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  //TODO: Get the right port for the elevator and switch
  public Spark m_motor = new Spark(0);
  public DigitalInput m_switch = new DigitalInput(0);
  
  public Elevator() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
    m_motor.set(speed);
  }

  public boolean getSwitch() {
    return m_switch.get();
  }

}
