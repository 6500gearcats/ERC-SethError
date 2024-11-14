// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends SubsystemBase {
  private Spark m_shooterMotor = new Spark(Constants.ShooterConstants.kShooterMotorPort);

  double m_simSpeed;

  /** Creates a new Shooter. */
  public Shooter() {
    m_simSpeed = 0;
  }

  public void setSpeed(double speed) {
    m_shooterMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Speed", m_simSpeed);
  }
}
