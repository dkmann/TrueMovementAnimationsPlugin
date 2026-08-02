package com.truetileanimationmovement;

import java.lang.reflect.Array;

import com.truetileanimationmovement.movement.Animations;
import com.truetileanimationmovement.movement.SpecialAnimationPreset;

public class AnimationRequestMoveset
{
    /**
     * 2D grid array: 5 by 5 grid around player.
     * <p>
     * NOTE: THESE ARE ALWAYS BASED ON PLAYER'S ORIENTATION!
     *
     * <pre>
     * +-------+-------+-------+-------+-------+
     * | 2NW   | 2NNW  | 2N    | 2NNE  | 2NE   |
     * +-------+-------+-------+-------+-------+
     * | 2WWN  | NW    | N     | NE    | 2EEN  |
     * +-------+-------+-------+-------+-------+
     * | 2W    | W     | X     | E     | 2E    |
     * +-------+-------+-------+-------+-------+
     * | 2WWS  | SW    | S     | SE    | 2EES  |
     * +-------+-------+-------+-------+-------+
     * | 2SW   | 2SSW  | 2S    | 2SSE  | 2SE   |
     * +-------+-------+-------+-------+-------+
     * </pre>
     *
     * <pre>
     * +-------+-------+-------+-------+-------+
     * | 0,4   | 1,4   | 2,4   | 3,4   | 4,4   |
     * +-------+-------+-------+-------+-------+
     * | 0,3   | 1,3   | 2,3   | 3,3   | 4,3   |
     * +-------+-------+-------+-------+-------+
     * | 0,2   | 1,2   | 2,2 X | 3,2   | 4,2   |
     * +-------+-------+-------+-------+-------+
     * | 0,1   | 1,1   | 2,1   | 3,1   | 4,1   |
     * +-------+-------+-------+-------+-------+
     * | 0,0   | 1,0   | 2,0   | 3,0   | 4,0   |
     * +-------+-------+-------+-------+-------+
     * </pre>
     */
    private final AnimationRequestDetails[][] movesetArray =
            new AnimationRequestDetails[5][5];

    public AnimationRequestDetails EAST_2;
    public AnimationRequestDetails EAST_1;
    public AnimationRequestDetails CENTER;
    public AnimationRequestDetails WEST_1;
    public AnimationRequestDetails WEST_2;

    public AnimationRequestDetails NORTHEAST_1;
    public AnimationRequestDetails NORTHWEST_1;
    public AnimationRequestDetails NORTHEAST_2;
    public AnimationRequestDetails NORTHWEST_2;

    public AnimationRequestDetails SOUTHEAST_1;
    public AnimationRequestDetails SOUTHWEST_1;
    public AnimationRequestDetails SOUTHEAST_2;
    public AnimationRequestDetails SOUTHWEST_2;

    public AnimationRequestDetails FORWARD_1;
    public AnimationRequestDetails FORWARD_2;
    public AnimationRequestDetails BACK_1;
    public AnimationRequestDetails BACK_2;

    public AnimationRequestDetails NORTHEASTEAST;
    public AnimationRequestDetails NORTHWESTWEST;
    public AnimationRequestDetails NORTHNORTHEAST;
    public AnimationRequestDetails NORTHNORTHWEST;

    public AnimationRequestDetails SOUTHEASTEAST;
    public AnimationRequestDetails SOUTHWESTWEST;
    public AnimationRequestDetails SOUTHSOUTHEAST;
    public AnimationRequestDetails SOUTHSOUTHWEST;

    public void Initialize()
    {
        EAST_2 = movesetArray[4][2];
        EAST_1 = movesetArray[3][2];
        CENTER = movesetArray[2][2];
        WEST_1 = movesetArray[1][2];
        WEST_2 = movesetArray[0][2];

        NORTHEAST_1 = movesetArray[3][3];
        NORTHWEST_1 = movesetArray[1][3];
        NORTHEAST_2 = movesetArray[0][4];
        NORTHWEST_2 = movesetArray[4][4];

        SOUTHEAST_1 = movesetArray[3][1];
        SOUTHWEST_1 = movesetArray[1][1];
        SOUTHEAST_2 = movesetArray[0][0];
        SOUTHWEST_2 = movesetArray[4][0];

        FORWARD_1 = movesetArray[2][3];
        FORWARD_2 = movesetArray[2][4];
        BACK_1 = movesetArray[2][1];
        BACK_2 = movesetArray[2][0];

        NORTHEASTEAST = movesetArray[4][3];
        NORTHWESTWEST = movesetArray[0][3];
        NORTHNORTHEAST = movesetArray[1][4];
        NORTHNORTHWEST = movesetArray[3][4];

        SOUTHEASTEAST = movesetArray[4][1];
        SOUTHWESTWEST = movesetArray[0][1];
        SOUTHSOUTHEAST = movesetArray[1][0];
        SOUTHSOUTHWEST = movesetArray[3][0];

    }
    static public AnimationRequestDetails GetDefaultSpecialMoveAnimationRequest()
    {
        return AnimationRequestDetails.builder()
                .resetAnimationOnNewTile(true)
                .animationToPlay(-1)
                .poseAnimationToPlay(-1)
                .startingFrame(0)
                .endingFrame(100000)
                .animationSpeed(1)
                .movementSpeedMultiplier(0)
                .useLinearTween(false)
                .shouldTeleportToLocation(false)
                .atDestinationLocation(false)
                .orientationSpeed(60)
                .allowAnimationLoop(false)
                .build();
    }

    static public AnimationRequestDetails GetDefaultIdleMoveAnimationRequest( TrueTileMovementConfig config)
    {
        return AnimationRequestDetails.builder()
                .resetAnimationOnNewTile(false)
                .animationToPlay(-1)
                .poseAnimationToPlay(-1)
                .startingFrame(0)
                .endingFrame(5000)
                .animationSpeed(1)
                .movementSpeedMultiplier(1.0)
                .useLinearTween(true)
                .shouldTeleportToLocation(false)
                .atDestinationLocation(false)
                .orientationSpeed(config.OrientationRotationSpeed())
                .build();
    }

    public void ConstructFromSpecialAnimationSet(
            final IdleAnimationSet AnimSet,
            final SpecialAnimationPreset preset,
            final TrueTileMovementConfig config)
    {
        if (preset == SpecialAnimationPreset.SPECIAL_MOVES) {
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    movesetArray[i][j] = GetDefaultSpecialMoveAnimationRequest();
                }
            }
            Initialize();

            // SOUTHEAST_2;
            Animations.applyLeanBack(SOUTHEAST_2);

            // SOUTHSOUTHWEST;
            Animations.applyJumpLand(SOUTHWESTWEST);

            // WEST_2;
            Animations.applySideStepWithSpin(WEST_2);

            // NORTHWESTWEST;
            Animations.applySpinMove(NORTHWESTWEST);

            // NORTHEAST_2;
            Animations.applyHugeJumpLand(NORTHEAST_2);

            // SOUTHSOUTHEAST;
            Animations.applyJumpLand(SOUTHSOUTHEAST);

            // SOUTHWEST_1;
            Animations.applySmallSideStep(SOUTHWEST_1);

            // WEST_1;
            Animations.applySideStepLeft(WEST_1);

            // NORTHWEST_1;
            Animations.applySmallHop(NORTHWEST_1);

            // NORTHNORTHEAST;
            Animations.applyFarJumpForward(NORTHNORTHEAST);

            // BACK_2;
            Animations.applyBigKnockback(BACK_2);

            // BACK_1;
            Animations.applyKnockback(BACK_1);

            CENTER.setAnimationToPlay(AnimSet.getIdleRotateRight()); // Center

            Animations.applyJabForward(FORWARD_1);

            // FORWARD_2;
            Animations.applyBigJumpForward(FORWARD_2);

            // SOUTHWESTWEST;
            Animations.applyJumpingJack(SOUTHSOUTHWEST);

            // SOUTHEAST_1;
            Animations.applySmallSideStep(SOUTHEAST_1);

            // EAST_2;
            Animations.applySideStepRight(EAST_1);

            // NORTHEAST_1;
            Animations.applySmallHop(NORTHEAST_1);

            // NORTHNORTHWEST;
            Animations.applyFarJumpForward(NORTHNORTHWEST);

            // SOUTHWEST_2;
            Animations.applyLeanBack(SOUTHWEST_2);

            // SOUTHEASTEAST;
            Animations.applyJumpingJack(SOUTHEASTEAST);

            // EAST_2
            Animations.applySideStepWithSpin(EAST_2);

            // NORTHEASTEAST;
            Animations.applySpinMove(NORTHEASTEAST);

            // NORTHWEST_2;
            Animations.applyHugeJumpLand(NORTHWEST_2);
        }
        else if (preset == SpecialAnimationPreset.WOOX_WALK ||
                preset == SpecialAnimationPreset.TICK_PERFECT_MOVEMENT)
        {
            for (int i = 0; i < 5; ++i)
            {
                for (int j = 0; j < 5; ++j)
                {
                    movesetArray[i][j] = GetDefaultSpecialMoveAnimationRequest();

                    // 2 Tiles
                    if (i == 0 || j == 0 || i == 4 || j == 4)
                    {
                        Animations.applyBigJump(movesetArray[i][j]);
                    }
                    // 1 Tile
                    else if (i == 1 || j == 1 || i == 3 || j == 3)
                    {
                        Animations.applyLittleJump(movesetArray[i][j]);
                    }
                }
            }
            Initialize();
        }
    }

    // Idle animation set mapping
    public void ConstructFromIdleAnimationSet(IdleAnimationSet AnimSet, TrueTileMovementConfig config)
    {
        for (int i = 0; i < 5; ++i)
        {
            for (int j = 0; j < 5; ++j)
            {
                movesetArray[i][j] = GetDefaultIdleMoveAnimationRequest(config);
            }
        }
        Initialize();

        SOUTHEAST_2.setPoseAnimationToPlay(AnimSet.getWalkRotate180()); SOUTHEAST_2.setAnimationSpeed(2); // Backwards 2, side step 2
        SOUTHWESTWEST.setPoseAnimationToPlay(AnimSet.getWalkRotateRight()); // South, side step 2
        WEST_2.setPoseAnimationToPlay(AnimSet.getWalkRotateLeft()); // Side step 2
        NORTHWESTWEST.setPoseAnimationToPlay(AnimSet.getWalkRotateLeft()); // North, Side step 2
        NORTHEAST_2.setPoseAnimationToPlay(AnimSet.getRunAnimation()); // North-west 2

        SOUTHSOUTHEAST.setPoseAnimationToPlay(AnimSet.getWalkRotate180()); SOUTHSOUTHEAST.setAnimationSpeed(2); // Backwards 2, side step 1
        SOUTHWEST_1.setPoseAnimationToPlay(AnimSet.getWalkRotate180()); // South-west
        WEST_1.setPoseAnimationToPlay(AnimSet.getWalkRotateLeft()); // Side step 1
        NORTHWEST_1.setPoseAnimationToPlay(AnimSet.getWalkAnimation()); // North-west
        NORTHNORTHEAST.setPoseAnimationToPlay(AnimSet.getRunAnimation()); // West, forward 2

        BACK_2.setPoseAnimationToPlay(AnimSet.getWalkRotate180()); BACK_2.setAnimationSpeed(2); // Backwards 2
        BACK_1.setPoseAnimationToPlay(AnimSet.getWalkRotate180()); // Backwards
        CENTER.setPoseAnimationToPlay(AnimSet.getIdleRotateRight()); // Center
        FORWARD_1.setPoseAnimationToPlay(AnimSet.getWalkAnimation()); // Forward
        FORWARD_2.setPoseAnimationToPlay(AnimSet.getRunAnimation()); // 2 Forward

        SOUTHSOUTHWEST.setPoseAnimationToPlay(AnimSet.getWalkRotate180()); SOUTHSOUTHWEST.setAnimationSpeed(2); // Backwards 2, side step 1
        SOUTHEAST_1.setPoseAnimationToPlay(AnimSet.getWalkRotate180()); // South-east
        EAST_1.setPoseAnimationToPlay(AnimSet.getWalkRotateRight()); // Side step 1
        NORTHEAST_1.setPoseAnimationToPlay(AnimSet.getWalkAnimation()); // North-east
        NORTHNORTHWEST.setPoseAnimationToPlay(AnimSet.getRunAnimation()); // East, forward 2

        SOUTHWEST_2.setPoseAnimationToPlay(AnimSet.getWalkRotate180()); SOUTHWEST_2.setAnimationSpeed(2); // Backwards 2, side step 2
        SOUTHEASTEAST.setPoseAnimationToPlay(AnimSet.getWalkRotateRight()); // South, side step 2
        EAST_2.setPoseAnimationToPlay(AnimSet.getWalkRotateRight()); // Side step 2
        NORTHEASTEAST.setPoseAnimationToPlay(AnimSet.getWalkRotateRight()); // North, Side step 2
        NORTHWEST_2.setPoseAnimationToPlay(AnimSet.getRunAnimation()); // North-east 2
    }

    public AnimationRequestDetails lookupAnimationRequest(
            final int x, final int y)
    {
        return movesetArray[x][y];
    }
}
