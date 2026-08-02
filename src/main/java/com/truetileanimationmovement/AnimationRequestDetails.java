package com.truetileanimationmovement;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimationRequestDetails
{
    private double movementSpeedMultiplier = 1;
    private int animationToPlay = -1;
    private int poseAnimationToPlay = -1;
    private int startingFrame = 0;
    private int endingFrame = 5000;
    private int animationSpeed = 1;
    private int orientationSpeed = 30;
    private boolean resetAnimationOnNewTile = false;
    private boolean useLinearTween = false;
    private boolean shouldTeleportToLocation = false;
    private boolean atDestinationLocation = false;
    private boolean allowAnimationLoop = true;

    private AnimationRequestDetails(final AnimationRequestDetails inDetails)
    {
        movementSpeedMultiplier = inDetails.movementSpeedMultiplier;
        animationToPlay = inDetails.animationToPlay;
        poseAnimationToPlay = inDetails.poseAnimationToPlay;
        startingFrame = inDetails.startingFrame;
        endingFrame = inDetails.endingFrame;
        animationSpeed = inDetails.animationSpeed;
        orientationSpeed = inDetails.orientationSpeed;
        resetAnimationOnNewTile = inDetails.resetAnimationOnNewTile;
        useLinearTween = inDetails.useLinearTween;
        shouldTeleportToLocation = inDetails.shouldTeleportToLocation;
        atDestinationLocation = inDetails.atDestinationLocation;
        allowAnimationLoop = inDetails.allowAnimationLoop;
    }

    public static AnimationRequestDetails copyOf(
            final AnimationRequestDetails inDetails)
    {
        return new AnimationRequestDetails(inDetails);
    }
}
