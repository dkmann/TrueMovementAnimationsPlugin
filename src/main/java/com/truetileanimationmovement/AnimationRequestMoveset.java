package com.truetileanimationmovement;

import java.lang.reflect.Array;

import net.runelite.api.gameval.AnimationID;

public class AnimationRequestMoveset
{
// Juicy animations
// 868->Jog
// 870->Jumping jack (maybe crappy side step?)
// 846->knocked back (probably not useful?)
// 845->crawl, just kind of fun
// 839->turn style climb, maybe a jump?
// 822-> SIDE STEP RIGHT
// 821-> SIDE STEP LEFT
// 820-> WALK BACKWARDS
// 807-> JUMP FORWARD
// 759->SWING LEFT (swing off wall obstacle) (good for movement back diagonal 1 maybe?)
// 758->SWING RIGHT (swing off wall obstacle) (good for movement back diagonal 1 maybe?)
// 741-> Small hop
// 726->COVER HEAD, looks realllly nice for a charge forward 2 tiles
// 439->Spin move
// 424->block, maybe a move back one?
// 409->another cool spin move
// 246->charge forward punch
// 1206-> Walk backwards
// 1207-> Walk left
// 1208-> Walk right
// 1378-> dramatic jump
// 1441-> knock back
// 1,707->cool run forward (arms up)
// 1,706->side step left (arms up)
// 1,705->side step right (arms up)
// 1,704->walk forward (arms up)
// 1,745->stomping both feet
// 1,764->sick jump land
// 1,770-> lean WAY back
// 1,775->T pose flip, funny
// 1,834-> block, pretty good step back
// 1,852-> huge jump and land
//2,107 -> spin emote
//2,106 -> jig
// 2,109-> jump for joy
// 2,242->fell from the sky (funny)
// 2,387->Fist pump
// 2,390->Big jump back
// 2,588-> Very nice jump down animation (maybe end or start combat?)
// 2,750-> Super far jump forward
// 3,013-> back away slowly
// 3,039-> Drunk walk
// 3,067-> Big jump forward
// 3,178-> standard run
// 3,177->standard walk
// 4,003->land on your butt
// 4,772->tight rope walk
// 6529->shrinking animation from grim tales
// 10429->biggg push
// 9799->moons of peril, hit back
// REMEMBER YOU CAN ALSO PLAY THESE BACKWARDS

    // 2D grid array
    // (NOTE: THESE ARE ALWAYS BASED ON PLAYER'S ORIENTATION!)
    //    +-------+-------+-------+-------+-------+
    //    | 2NW   | 2NNW  | 2N    | 2NNE  | 2NE   |
    //    +-------+-------+-------+-------+-------+
    //    | 2WWN  | NW    | N     | NE    | 2EEN  |
    //    +-------+-------+-------+-------+-------+
    //    | 2W    | W     | X     | E     | 2E    |
    //    +-------+-------+-------+-------+-------+
    //    | 2WWS  | SW    | S     | SE    | 2EES  |
    //    +-------+-------+-------+-------+-------+
    //    | 2SW   | 2SSW  | 2S    | 2SSE  | 2SE   |
    //    +-------+-------+-------+-------+-------+
    //
    //    +-------+-------+-------+-------+-------+
    //    | 0,4   | 1,4   | 2,4   | 3,4   | 4,4   |
    //    +-------+-------+-------+-------+-------+
    //    | 0,3   | 1,3   | 2,3   | 3,3   | 4,3   |
    //    +-------+-------+-------+-------+-------+
    //    | 0,2   | 1,2   | 2,2 X | 3,2   | 4,2   |
    //    +-------+-------+-------+-------+-------+
    //    | 0,1   | 1,1   | 2,1   | 3,1   | 4,1   |
    //    +-------+-------+-------+-------+-------+
    //    | 0,0   | 1,0   | 2,0   | 3,0   | 4,0   |
    //    +-------+-------+-------+-------+-------+
    //

    public AnimationRequestDetails[][] MovesetArray = new AnimationRequestDetails[5][5]; // 5 by 5 grid around player

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
        EAST_2 = MovesetArray[4][2];
        EAST_1 = MovesetArray[3][2];
        CENTER = MovesetArray[2][2];
        WEST_1 = MovesetArray[1][2];
        WEST_2 = MovesetArray[0][2];

        NORTHEAST_1 = MovesetArray[3][3];
        NORTHWEST_1 = MovesetArray[1][3];
        NORTHEAST_2 = MovesetArray[0][4];
        NORTHWEST_2 = MovesetArray[4][4];

        SOUTHEAST_1 = MovesetArray[3][1];
        SOUTHWEST_1 = MovesetArray[1][1];
        SOUTHEAST_2 = MovesetArray[0][0];
        SOUTHWEST_2 = MovesetArray[4][0];

        FORWARD_1 = MovesetArray[2][3];
        FORWARD_2 = MovesetArray[2][4];
        BACK_1 = MovesetArray[2][1];
        BACK_2 = MovesetArray[2][0];

        NORTHEASTEAST = MovesetArray[4][3];
        NORTHWESTWEST = MovesetArray[0][3];
        NORTHNORTHEAST = MovesetArray[1][4];
        NORTHNORTHWEST = MovesetArray[3][4];

        SOUTHEASTEAST = MovesetArray[4][1];
        SOUTHWESTWEST = MovesetArray[0][1];
        SOUTHSOUTHEAST = MovesetArray[1][0];
        SOUTHSOUTHWEST = MovesetArray[3][0];

    }
    static public AnimationRequestDetails GetDefaultSpecialMoveAnimationRequest()
    {
        AnimationRequestDetails NewRequest = new AnimationRequestDetails();

        NewRequest.setResetAnimationOnNewTile(true);
        NewRequest.setAnimationToPlay(-1);
        NewRequest.setPoseAnimationToPlay(-1);
        NewRequest.setStartingFrame(0);
        NewRequest.setEndingFrame(100000);
        NewRequest.setAnimationSpeed(1);
        NewRequest.setMovementSpeedMultiplier(0);
        NewRequest.setUseLinearTween(false);
        NewRequest.setShouldTeleportToLocation(false);
        NewRequest.setAtDestinationLocation(false);
        NewRequest.setOrientationSpeed(60);
        NewRequest.setAllowAnimationLoop(false);

        return NewRequest;
    }

    static public AnimationRequestDetails GetDefaultIdleMoveAnimationRequest( TrueTileMovementConfig config)
    {
        AnimationRequestDetails NewRequest = new AnimationRequestDetails();

        NewRequest.setResetAnimationOnNewTile(false);
        NewRequest.setAnimationToPlay(-1);
        NewRequest.setPoseAnimationToPlay(-1);
        NewRequest.setStartingFrame(0);
        NewRequest.setEndingFrame(5000);
        NewRequest.setAnimationSpeed(1);
        NewRequest.setMovementSpeedMultiplier(1.0);
        NewRequest.setUseLinearTween(true);
        NewRequest.setShouldTeleportToLocation(false);
        NewRequest.setAtDestinationLocation(false);
        NewRequest.setOrientationSpeed(config.OrientationRotationSpeed());
        return NewRequest;
    }

    public void ConstructFromSpecialAnimationSet(IdleAnimationSet AnimSet, String SpecialAnimationKey, TrueTileMovementConfig config) {
        if (SpecialAnimationKey.equals("SpecialMoves")) {
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    MovesetArray[i][j] = GetDefaultSpecialMoveAnimationRequest();
                }
            }
            Initialize();

            // SOUTHEAST_2;
            SOUTHEAST_2.setAnimationToPlay(AnimationID.MDAUGHTER_ABSAIL_JUMP); // lean WAY back. 1770
            SOUTHEAST_2.setUseLinearTween(false);
            SOUTHEAST_2.setMovementSpeedMultiplier(1.5);
            SOUTHEAST_2.setAnimationSpeed(1);
            SOUTHEAST_2.setStartingFrame(0);
            SOUTHEAST_2.setAllowAnimationLoop(false);


            // SOUTHSOUTHWEST;
            SOUTHWESTWEST.setAnimationToPlay(AnimationID.MDAUGHTER_TREE_CLIMB3); // sick jump land. 1764
            SOUTHWESTWEST.setUseLinearTween(false);
            SOUTHWESTWEST.setMovementSpeedMultiplier(1.5);
            SOUTHWESTWEST.setAnimationSpeed(1);
            SOUTHWESTWEST.setStartingFrame(0);
            SOUTHWESTWEST.setAllowAnimationLoop(false);


            // WEST_2;
            WEST_2.setAnimationToPlay(AnimationID.EMOTE_DANCE_SPIN); // Side step 2, spin emote. 2107
            WEST_2.setMovementSpeedMultiplier(2);
            WEST_2.setAnimationSpeed(1);
            WEST_2.setStartingFrame(4);
            WEST_2.setAllowAnimationLoop(false);

            // NORTHWESTWEST;
            NORTHWESTWEST.setAnimationToPlay(AnimationID.HUMAN_DHSWORD_SPIN); // another cool spin move. 409
            NORTHWESTWEST.setMovementSpeedMultiplier(2);
            NORTHWESTWEST.setAnimationSpeed(1);
            NORTHWESTWEST.setStartingFrame(0);
            NORTHWESTWEST.setAllowAnimationLoop(false);


            // NORTHEAST_2;
            NORTHEAST_2.setAnimationToPlay(AnimationID.DWARFROCK_CANNON_FLY_GETUP); // huge jump land. 1852
            NORTHEAST_2.setUseLinearTween(false);
            NORTHEAST_2.setMovementSpeedMultiplier(1.5);
            NORTHEAST_2.setAnimationSpeed(1);
            NORTHEAST_2.setStartingFrame(0);
            NORTHEAST_2.setAllowAnimationLoop(false);


            // SOUTHSOUTHEAST;
            SOUTHSOUTHEAST.setAnimationToPlay(AnimationID.MDAUGHTER_TREE_CLIMB3); // sick jump land. 1764
            SOUTHSOUTHEAST.setUseLinearTween(false);
            SOUTHSOUTHEAST.setMovementSpeedMultiplier(1.5);
            SOUTHSOUTHEAST.setAnimationSpeed(1);
            SOUTHSOUTHEAST.setStartingFrame(0);
            SOUTHSOUTHEAST.setAllowAnimationLoop(false);


            // SOUTHWEST_1;
            SOUTHWEST_1.setAnimationToPlay(AnimationID.HUMAN_ZAMORAKSPEAR_TURNONSPOT); // side step small. 1702
            SOUTHWEST_1.setUseLinearTween(true);
            SOUTHWEST_1.setMovementSpeedMultiplier(1.0);
            SOUTHWEST_1.setAnimationSpeed(1);
            SOUTHWEST_1.setStartingFrame(0);
            SOUTHWEST_1.setAllowAnimationLoop(false);

            // WEST_1;
            WEST_1.setAnimationToPlay(AnimationID.HUMAN_WALK_L); // SIDE STEP LEFT. 821
            WEST_1.setMovementSpeedMultiplier(1.5);
            WEST_1.setAnimationSpeed(2);
            WEST_1.setStartingFrame(0);
            WEST_1.setAllowAnimationLoop(false);

            // NORTHWEST_1;
            NORTHWEST_1.setAnimationToPlay(AnimationID.HUMAN_LONGJUMP); // Small hop. 807
            NORTHWEST_1.setMovementSpeedMultiplier(3.0);
            NORTHWEST_1.setStartingFrame(7);
            NORTHWEST_1.setAnimationSpeed(1);
            NORTHWEST_1.setAllowAnimationLoop(false);


            // NORTHNORTHEAST;
            NORTHNORTHEAST.setAnimationToPlay(AnimationID.OVERLOG); // Super far jump forward. 2750
            NORTHNORTHEAST.setUseLinearTween(false);
            NORTHNORTHEAST.setMovementSpeedMultiplier(1.6);
            NORTHNORTHEAST.setAnimationSpeed(2);
            NORTHNORTHEAST.setStartingFrame(2);
            NORTHNORTHEAST.setAllowAnimationLoop(false);

            // BACK_2;
            BACK_2.setAnimationToPlay(AnimationID.TBW_CLEANUP_PLAYER_SURPRISE_STEPBACK); // big knockback. 2390
            BACK_2.setUseLinearTween(false);
            BACK_2.setMovementSpeedMultiplier(2);
            BACK_2.setAnimationSpeed(1);
            BACK_2.setStartingFrame(0);
            BACK_2.setAllowAnimationLoop(false);

            // BACK_1;
            BACK_1.setAnimationToPlay(AnimationID.HUMAN_STUMBLE_BACK_CONTINUOUS); // knockback. 1441
            BACK_1.setUseLinearTween(true);
            BACK_1.setMovementSpeedMultiplier(1);
            BACK_1.setAnimationSpeed(1);
            BACK_1.setStartingFrame(0);
            BACK_1.setAllowAnimationLoop(false);

            CENTER.setAnimationToPlay(AnimSet.IdleRotateRight); // Center

            FORWARD_1.setAnimationToPlay(AnimationID.HUMAN_DRAGON_SWORD_SPEC); // Jab forward. 7515
            FORWARD_1.setMovementSpeedMultiplier(2.0);
            FORWARD_1.setStartingFrame(0);
            FORWARD_1.setAnimationSpeed(1);
            FORWARD_1.setAllowAnimationLoop(false);

            // FORWARD_2;
            FORWARD_2.setAnimationToPlay(AnimationID.AGILITY_PYRAMID_GAP_JUMP); // Big jump forward. 3067
            FORWARD_2.setMovementSpeedMultiplier(2);
            FORWARD_2.setAnimationSpeed(2);
            FORWARD_2.setStartingFrame(2);
            FORWARD_2.setEndingFrame(7);
            FORWARD_2.setAllowAnimationLoop(false);

            // SOUTHWESTWEST;
            SOUTHSOUTHWEST.setAnimationToPlay(AnimationID.EMOTE_STARJUMP_5); // Jumping Jack. 870
            SOUTHSOUTHWEST.setUseLinearTween(false);
            SOUTHSOUTHWEST.setMovementSpeedMultiplier(2);
            SOUTHSOUTHWEST.setAnimationSpeed(1);
            SOUTHSOUTHWEST.setStartingFrame(0);
            SOUTHSOUTHWEST.setAllowAnimationLoop(false);


            // SOUTHEAST_1;
            SOUTHEAST_1.setAnimationToPlay(AnimationID.HUMAN_ZAMORAKSPEAR_TURNONSPOT); // side step small. 1702
            SOUTHEAST_1.setUseLinearTween(true);
            SOUTHEAST_1.setMovementSpeedMultiplier(1.0);
            SOUTHEAST_1.setAnimationSpeed(1);
            SOUTHEAST_1.setStartingFrame(0);
            SOUTHEAST_1.setAllowAnimationLoop(false);


            // EAST_2;
            EAST_1.setAnimationToPlay(AnimationID.HUMAN_WALK_R); // SIDE STEP RIGHT. 822
            EAST_1.setMovementSpeedMultiplier(1.5);
            EAST_1.setAnimationSpeed(2);
            EAST_1.setAllowAnimationLoop(false);

            // NORTHEAST_1;
            NORTHEAST_1.setAnimationToPlay(AnimationID.HUMAN_LONGJUMP); // North-east. 807
            NORTHEAST_1.setMovementSpeedMultiplier(3.0);
            NORTHEAST_1.setStartingFrame(7);
            NORTHEAST_1.setAnimationSpeed(1);
            NORTHEAST_1.setAllowAnimationLoop(false);

            // NORTHNORTHWEST;
            NORTHNORTHWEST.setAnimationToPlay(AnimationID.OVERLOG); // Super far jump forward. 2750
            NORTHNORTHWEST.setUseLinearTween(false);
            NORTHNORTHWEST.setMovementSpeedMultiplier(1.6);
            NORTHNORTHWEST.setAnimationSpeed(2);
            NORTHNORTHWEST.setStartingFrame(2);
            NORTHNORTHWEST.setAllowAnimationLoop(false);

            // SOUTHWEST_2;
            SOUTHWEST_2.setAnimationToPlay(AnimationID.MDAUGHTER_ABSAIL_JUMP); // lean WAY back. 1770
            SOUTHWEST_2.setUseLinearTween(false);
            SOUTHWEST_2.setMovementSpeedMultiplier(1.5);
            SOUTHWEST_2.setAnimationSpeed(1);
            SOUTHWEST_2.setStartingFrame(0);
            SOUTHWEST_2.setAllowAnimationLoop(false);

            // SOUTHEASTEAST;
            SOUTHEASTEAST.setAnimationToPlay(AnimationID.EMOTE_STARJUMP_5); // Jumping Jack. 870
            SOUTHEASTEAST.setUseLinearTween(false);
            SOUTHEASTEAST.setMovementSpeedMultiplier(2);
            SOUTHEASTEAST.setAnimationSpeed(1);
            SOUTHEASTEAST.setStartingFrame(0);
            SOUTHEASTEAST.setAllowAnimationLoop(false);

            // EAST_2
            EAST_2.setAnimationToPlay(AnimationID.EMOTE_DANCE_SPIN); // SIDE_STEP 2 - spin emote. 2107
            EAST_2.setMovementSpeedMultiplier(2);
            EAST_2.setAnimationSpeed(1);
            EAST_2.setStartingFrame(4);
            EAST_2.setAllowAnimationLoop(false);

            // NORTHEASTEAST;
            NORTHEASTEAST.setAnimationToPlay(AnimationID.HUMAN_DHSWORD_SPIN); // another cool spin move. 409
            NORTHEASTEAST.setMovementSpeedMultiplier(2);
            NORTHEASTEAST.setAnimationSpeed(1);
            NORTHEASTEAST.setStartingFrame(0);
            NORTHEASTEAST.setAllowAnimationLoop(false);


            // NORTHWEST_2;
            NORTHWEST_2.setAnimationToPlay(AnimationID.DWARFROCK_CANNON_FLY_GETUP); // huge jump land. 1852
            NORTHWEST_2.setUseLinearTween(false);
            NORTHWEST_2.setMovementSpeedMultiplier(1.5);
            NORTHWEST_2.setAnimationSpeed(1);
            NORTHWEST_2.setStartingFrame(0);
            NORTHWEST_2.setAllowAnimationLoop(false);
        }
        else if (SpecialAnimationKey.equals("WooxWalk"))
        {
            for (int i = 0; i < 5; ++i)
            {
                for (int j = 0; j < 5; ++j)
                {
                    MovesetArray[i][j] = GetDefaultSpecialMoveAnimationRequest();

                    // 2 Tiles
                    if (i == 0 || j == 0 || i == 4 || j == 4)
                    {
                        MovesetArray[i][j].setResetAnimationOnNewTile(true);
                        MovesetArray[i][j].setAnimationToPlay(AnimationID.HUMAN_JUMP_STONES); // 1604
                        MovesetArray[i][j].setUseLinearTween(false);
                        MovesetArray[i][j].setMovementSpeedMultiplier(1.5);
                        MovesetArray[i][j].setAnimationSpeed(1);
                        MovesetArray[i][j].setStartingFrame(2);
                        MovesetArray[i][j].setEndingFrame(7);
                        MovesetArray[i][j].setAllowAnimationLoop(false);
                    }
                    // 1 Tile
                    else if (i == 1 || j == 1 || i == 3 || j == 3)
                    {
                        MovesetArray[i][j].setAnimationToPlay(AnimationID.HUMAN_SPOT_JUMP); // Little jump. 741
                        MovesetArray[i][j].setMovementSpeedMultiplier(2.0);
                        MovesetArray[i][j].setUseLinearTween(false);
                        MovesetArray[i][j].setStartingFrame(2);
                        MovesetArray[i][j].setAnimationSpeed(1);
                        MovesetArray[i][j].setEndingFrame(7);
                        MovesetArray[i][j].setAllowAnimationLoop(false);
                    }
                }
            }
            Initialize();
        }
        else if (SpecialAnimationKey.equals("TickPerfectMovement"))
        {
            for (int i = 0; i < 5; ++i)
            {
                for (int j = 0; j < 5; ++j)
                {
                    MovesetArray[i][j] = GetDefaultSpecialMoveAnimationRequest();

                    // 2 Tiles
                    if (i == 0 || j == 0 || i == 4 || j == 4)
                    {
                        MovesetArray[i][j].setResetAnimationOnNewTile(true);
                        MovesetArray[i][j].setAnimationToPlay(AnimationID.HUMAN_JUMP_STONES); // 1604
                        MovesetArray[i][j].setUseLinearTween(false);
                        MovesetArray[i][j].setMovementSpeedMultiplier(1.5);
                        MovesetArray[i][j].setAnimationSpeed(1);
                        MovesetArray[i][j].setStartingFrame(2);
                        MovesetArray[i][j].setEndingFrame(7);
                        MovesetArray[i][j].setAllowAnimationLoop(false);
                    }
                    // 1 Tile
                    else if (i == 1 || j == 1 || i == 3 || j == 3)
                    {
                        MovesetArray[i][j].setAnimationToPlay(AnimationID.HUMAN_SPOT_JUMP); // Little jump. 741
                        MovesetArray[i][j].setMovementSpeedMultiplier(2.0);
                        MovesetArray[i][j].setUseLinearTween(false);
                        MovesetArray[i][j].setStartingFrame(2);
                        MovesetArray[i][j].setAnimationSpeed(1);
                        MovesetArray[i][j].setEndingFrame(7);
                        MovesetArray[i][j].setAllowAnimationLoop(false);
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
                MovesetArray[i][j] = GetDefaultIdleMoveAnimationRequest(config);
            }
        }
        Initialize();

        SOUTHEAST_2.setPoseAnimationToPlay(AnimSet.WalkRotate180); SOUTHEAST_2.setAnimationSpeed(2); // Backwards 2, side step 2
        SOUTHWESTWEST.setPoseAnimationToPlay(AnimSet.WalkRotateRight); // South, side step 2
        WEST_2.setPoseAnimationToPlay(AnimSet.WalkRotateLeft); // Side step 2
        NORTHWESTWEST.setPoseAnimationToPlay(AnimSet.WalkRotateLeft); // North, Side step 2
        NORTHEAST_2.setPoseAnimationToPlay(AnimSet.RunAnimation); // North-west 2

        SOUTHSOUTHEAST.setPoseAnimationToPlay(AnimSet.WalkRotate180); SOUTHSOUTHEAST.setAnimationSpeed(2); // Backwards 2, side step 1
        SOUTHWEST_1.setPoseAnimationToPlay(AnimSet.WalkRotate180); // South-west
        WEST_1.setPoseAnimationToPlay(AnimSet.WalkRotateLeft); // Side step 1
        NORTHWEST_1.setPoseAnimationToPlay(AnimSet.WalkAnimation); // North-west
        NORTHNORTHEAST.setPoseAnimationToPlay(AnimSet.RunAnimation); // West, forward 2

        BACK_2.setPoseAnimationToPlay(AnimSet.WalkRotate180); BACK_2.setAnimationSpeed(2); // Backwards 2
        BACK_1.setPoseAnimationToPlay(AnimSet.WalkRotate180); // Backwards
        CENTER.setPoseAnimationToPlay(AnimSet.IdleRotateRight); // Center
        FORWARD_1.setPoseAnimationToPlay(AnimSet.WalkAnimation); // Forward
        FORWARD_2.setPoseAnimationToPlay(AnimSet.RunAnimation); // 2 Forward

        SOUTHSOUTHWEST.setPoseAnimationToPlay(AnimSet.WalkRotate180); SOUTHSOUTHWEST.setAnimationSpeed(2); // Backwards 2, side step 1
        SOUTHEAST_1.setPoseAnimationToPlay(AnimSet.WalkRotate180); // South-east
        EAST_1.setPoseAnimationToPlay(AnimSet.WalkRotateRight); // Side step 1
        NORTHEAST_1.setPoseAnimationToPlay(AnimSet.WalkAnimation); // North-east
        NORTHNORTHWEST.setPoseAnimationToPlay(AnimSet.RunAnimation); // East, forward 2

        SOUTHWEST_2.setPoseAnimationToPlay(AnimSet.WalkRotate180); SOUTHWEST_2.setAnimationSpeed(2); // Backwards 2, side step 2
        SOUTHEASTEAST.setPoseAnimationToPlay(AnimSet.WalkRotateRight); // South, side step 2
        EAST_2.setPoseAnimationToPlay(AnimSet.WalkRotateRight); // Side step 2
        NORTHEASTEAST.setPoseAnimationToPlay(AnimSet.WalkRotateRight); // North, Side step 2
        NORTHWEST_2.setPoseAnimationToPlay(AnimSet.RunAnimation); // North-east 2
    }
}
