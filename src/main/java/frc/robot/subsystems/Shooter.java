// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Shooter extends SubsystemBase {
  private Spark m_shooterMotor = new Spark(Constants.ShooterConstants.kShooterMotorPort);

  /** Creates a new Shooter. */
  public Shooter() {
  }

  public void setSpeed(double speed) {
    m_shooterMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
