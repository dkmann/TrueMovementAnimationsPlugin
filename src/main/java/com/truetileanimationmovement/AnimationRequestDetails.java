package com.truetileanimationmovement;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnimationRequestDetails
{
    private double MovementSpeedMultiplier = 1;
    private int AnimationToPlay = -1;
    private int PoseAnimationToPlay = -1;
    private int StartingFrame = 0;
    private int EndingFrame = 5000;
    private int AnimationSpeed = 1;
    private int OrientationSpeed = 30;
    private boolean ResetAnimationOnNewTile = false;
    private boolean UseLinearTween = false;
    private boolean ShouldTeleportToLocation = false;
    private boolean AtDestinationLocation = false;
    private boolean AllowAnimationLoop = true;

    static AnimationRequestDetails NewObject(AnimationRequestDetails InDetails)
    {
        AnimationRequestDetails newObject = new AnimationRequestDetails();

        newObject.MovementSpeedMultiplier = InDetails.MovementSpeedMultiplier;
        newObject.AnimationToPlay = InDetails.AnimationToPlay;
        newObject.PoseAnimationToPlay = InDetails.PoseAnimationToPlay;
        newObject.StartingFrame = InDetails.StartingFrame;
        newObject.EndingFrame = InDetails.EndingFrame;
        newObject.AnimationSpeed = InDetails.AnimationSpeed;
        newObject.OrientationSpeed = InDetails.OrientationSpeed;
        newObject.ResetAnimationOnNewTile = InDetails.ResetAnimationOnNewTile;
        newObject.UseLinearTween = InDetails.UseLinearTween;
        newObject.ShouldTeleportToLocation = InDetails.ShouldTeleportToLocation;
        newObject.AtDestinationLocation = InDetails.AtDestinationLocation;
        newObject.AllowAnimationLoop = InDetails.AllowAnimationLoop;

        return newObject;
    }
}
