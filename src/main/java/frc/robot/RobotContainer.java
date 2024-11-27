// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ElevatorPreset;
import frc.robot.commands.GoTurbo;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.ShootCube;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();
  private final XboxController m_controller = new XboxController(0);
  private final Elevator m_elevator = new Elevator();
  private final Shooter m_shooter = new Shooter();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_romiDrivetrain.setDefaultCommand(new RunCommand(
        () -> m_romiDrivetrain.arcadeDrive(m_controller.getLeftY(), m_controller.getLeftX()), m_romiDrivetrain));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_controller, XboxController.Button.kA.value).whileTrue(new ShootCube(m_shooter, 0.5));
    new JoystickButton(m_controller, XboxController.Button.kY.value).whileTrue(new ShootCube(m_shooter, -0.5));
    // Current test multiplier is in place to prevent the elevator from moving too fast
    new Trigger(() -> m_controller.getRightY() > 0.2).whileTrue(new MoveElevator(m_elevator, m_controller.getRightY() * 0.2));

    // Buttons to configure elevator presets
    //TODO: Add the correct end time for the elevator presets
    //TODO: Add a way to keep the elevator in the preset position instead of going back down to default position
    new JoystickButton(m_controller, XboxController.Button.kLeftBumper.value).whileTrue(new ElevatorPreset(m_elevator, 12.0));
    //add a way to go down in preset class
    new JoystickButton(m_controller, XboxController.Button.kRightBumper.value).whileTrue(new ElevatorPreset(m_elevator, 12.0, true));

    // Added a turbo button
    new Trigger( ()-> Math.abs(m_controller.getRightTriggerAxis()) > 0.2).whileTrue(new GoTurbo(m_romiDrivetrain));

    // new JoystickButton(m_controller, XboxController.Button.kX.value).whileTrue(new ElevatorPreset(m_elevator, 5.0));
    // new JoystickButton(m_controller, XboxController.Button.kA.value).whileTrue(new ElevatorPreset(m_elevator, 7.0));
    // new JoystickButton(m_controller, XboxController.Button.kB.value).whileTrue(new ElevatorPreset(m_elevator, 9.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
