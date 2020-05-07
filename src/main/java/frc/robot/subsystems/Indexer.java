/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexerConstants;

public class Indexer extends SubsystemBase {
    WPI_VictorSPX verticalIndexerLeft;
    WPI_TalonSRX verticalIndexerRight, flatIndexer;
    SpeedControllerGroup verticalIndexer;

    public Indexer() {
        // Set Motors
        verticalIndexerLeft = new WPI_VictorSPX(IndexerConstants.VERTICAL_INDEXER_LEFT);
        verticalIndexerRight = new WPI_TalonSRX(IndexerConstants.VERTICAL_INDEXER_RIGHT);
        flatIndexer = new WPI_TalonSRX(IndexerConstants.FLAT_INDEXER);

        // Inverts Motors where Required
        verticalIndexerLeft.setInverted(true);

        // Creates Speed Controller Groups
        verticalIndexer = new SpeedControllerGroup(verticalIndexerLeft, verticalIndexerRight);
    }

    public void forward() {
        verticalIndexer.set(IndexerConstants.VERTICAL_INDEXER_SPEED);
        flatIndexer.set(IndexerConstants.FLAT_INDEXER_SPEED);
    }
    public void reverse() {
        verticalIndexer.set(-IndexerConstants.VERTICAL_INDEXER_SPEED);
        flatIndexer.set(-IndexerConstants.FLAT_INDEXER_SPEED);
    }
    
    public void stop() {
        verticalIndexer.set(0);
        flatIndexer.set(0);
    }
}
