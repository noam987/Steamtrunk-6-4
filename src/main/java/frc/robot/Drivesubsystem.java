// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivesubsystem extends SubsystemBase {
  /** Creates a new Drivesubsystem. */
  private final WPI_TalonSRX m_bottomRightDrive = new WPI_TalonSRX(1);
  private final WPI_TalonSRX m_topRightDrive = new WPI_TalonSRX(2);
  private final SpeedControllerGroup m_rightDriveGroup = new SpeedControllerGroup(m_bottomRightDrive, m_topRightDrive);

  private final WPI_TalonSRX m_bottomLeftDrive = new WPI_TalonSRX(4);
  private final WPI_TalonSRX m_topLeftDrive = new WPI_TalonSRX(5);
  private final SpeedControllerGroup m_leftDriveGroup = new SpeedControllerGroup(m_bottomLeftDrive, m_topLeftDrive);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftDriveGroup, m_rightDriveGroup);

  private double m_xspeed;
  private double m_zspeed;

  public Drivesubsystem() {

  }

  public void setXSpeed(double x_speed) {
    m_xspeed = x_speed;

  }

  public void setZSpeed(double z_speed) {
    m_zspeed = z_speed;

  }

  @Override
  public void periodic() {

    m_robotDrive.arcadeDrive(m_xspeed, m_zspeed);

  }
}
