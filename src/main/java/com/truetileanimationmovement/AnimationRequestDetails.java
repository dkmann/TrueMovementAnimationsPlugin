package com.truetileanimationmovement;

import com.truetileanimationmovement.core.Copyable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public final class AnimationRequestDetails
        implements Copyable<AnimationRequestDetails>
{
    @Builder.Default
    private double movementSpeedMultiplier = 1;
    @Builder.Default
    private int animationToPlay = -1;
    @Builder.Default
    private int poseAnimationToPlay = -1;
    @Builder.Default
    private int startingFrame = 0;
    @Builder.Default
    private int endingFrame = 5000;
    @Builder.Default
    private int animationSpeed = 1;
    @Builder.Default
    private int orientationSpeed = 30;
    @Builder.Default
    private boolean resetAnimationOnNewTile = false;
    @Builder.Default
    private boolean useLinearTween = false;
    @Builder.Default
    private boolean shouldTeleportToLocation = false;
    @Builder.Default
    private boolean atDestinationLocation = false;
    @Builder.Default
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

    @Override
    public AnimationRequestDetails copy()
    {
        return new AnimationRequestDetails(this);
    }
}
