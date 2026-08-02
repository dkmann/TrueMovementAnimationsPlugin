package com.truetileanimationmovement.movement;

import com.truetileanimationmovement.AnimationRequestDetails;
import net.runelite.api.gameval.AnimationID;

/**
 * The {@code Animations} class provides a set of predefined animation effects
 * that can be applied to {@link AnimationRequestDetails} objects.
 * <p>
 * It offers methods to apply various animations, such as sidestepping, jumping,
 * spinning, and other dynamic movements, to an existing
 * {@link AnimationRequestDetails animation request}.
 *
 * @apiNote Remember that animations can also be played in reverse for
 * additional effects.
 * @see AnimationRequestDetails
 */
public final class Animations
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
    // 2,107 -> spin emote
    // 2,106 -> jig
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
    private Animations()
    {
    }

    /**
     * Applies a lean back animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#MDAUGHTER_ABSAIL_JUMP} animation
     */
    public static void applyLeanBack(
            final AnimationRequestDetails animationRequest)
    {
        // lean WAY back. 1770
        animationRequest.setAnimationToPlay(AnimationID.MDAUGHTER_ABSAIL_JUMP);
        animationRequest.setUseLinearTween(false);
        animationRequest.setMovementSpeedMultiplier(1.5);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a jump and land animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#MDAUGHTER_TREE_CLIMB3} animation
     */
    public static void applyJumpLand(
            final AnimationRequestDetails animationRequest)
    {
        // sick jump land. 1764
        animationRequest.setAnimationToPlay(AnimationID.MDAUGHTER_TREE_CLIMB3);
        animationRequest.setUseLinearTween(false);
        animationRequest.setMovementSpeedMultiplier(1.5);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a side-step with spin animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#EMOTE_DANCE_SPIN} animation
     */
    public static void applySideStepWithSpin(
            final AnimationRequestDetails animationRequest)
    {
        // Side step 2, spin emote. 2107
        animationRequest.setAnimationToPlay(AnimationID.EMOTE_DANCE_SPIN);
        animationRequest.setMovementSpeedMultiplier(2.0);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(4);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a spin move animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_DHSWORD_SPIN} animation
     */
    public static void applySpinMove(
            final AnimationRequestDetails animationRequest)
    {
        // another cool spin move. 409
        animationRequest.setAnimationToPlay(AnimationID.HUMAN_DHSWORD_SPIN);
        animationRequest.setMovementSpeedMultiplier(2.0);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a huge jump and land animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#DWARFROCK_CANNON_FLY_GETUP}
     * animation
     */
    public static void applyHugeJumpLand(
            final AnimationRequestDetails animationRequest)
    {
        // huge jump land. 1852
        animationRequest.setAnimationToPlay(
                AnimationID.DWARFROCK_CANNON_FLY_GETUP);
        animationRequest.setUseLinearTween(false);
        animationRequest.setMovementSpeedMultiplier(1.5);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a side-step right animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_WALK_R} animation
     */
    public static void applySideStepRight(
            final AnimationRequestDetails animationRequest)
    {
        // SIDE STEP RIGHT. 822
        animationRequest.setAnimationToPlay(AnimationID.HUMAN_WALK_R);
        animationRequest.setMovementSpeedMultiplier(1.5);
        animationRequest.setAnimationSpeed(2);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a jab forward animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_DRAGON_SWORD_SPEC} animation
     */
    public static void applyJabForward(
            final AnimationRequestDetails animationRequest)
    {
        // Jab forward. 7515
        animationRequest.setAnimationToPlay(
                AnimationID.HUMAN_DRAGON_SWORD_SPEC);
        animationRequest.setMovementSpeedMultiplier(2.0);
        animationRequest.setStartingFrame(0);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a big jump forward animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#AGILITY_PYRAMID_GAP_JUMP} animation
     */
    public static void applyBigJumpForward(
            final AnimationRequestDetails animationRequest)
    {
        // Big jump forward. 3067
        animationRequest.setAnimationToPlay(
                AnimationID.AGILITY_PYRAMID_GAP_JUMP);
        animationRequest.setMovementSpeedMultiplier(2.0);
        animationRequest.setAnimationSpeed(2);
        animationRequest.setStartingFrame(2);
        animationRequest.setEndingFrame(7);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a knockback animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_STUMBLE_BACK_CONTINUOUS}
     * animation
     */
    public static void applyKnockback(
            final AnimationRequestDetails animationRequest)
    {
        // knockback. 1441
        animationRequest.setAnimationToPlay(
                AnimationID.HUMAN_STUMBLE_BACK_CONTINUOUS);
        animationRequest.setUseLinearTween(true);
        animationRequest.setMovementSpeedMultiplier(1.0);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a big knockback animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the
     * {@link AnimationID#TBW_CLEANUP_PLAYER_SURPRISE_STEPBACK} animation
     */
    public static void applyBigKnockback(
            final AnimationRequestDetails animationRequest)
    {
        // big knockback. 2390
        animationRequest.setAnimationToPlay(
                AnimationID.TBW_CLEANUP_PLAYER_SURPRISE_STEPBACK);
        animationRequest.setUseLinearTween(false);
        animationRequest.setMovementSpeedMultiplier(2.0);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a jumping jack animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#EMOTE_STARJUMP_5} animation
     */
    public static void applyJumpingJack(
            final AnimationRequestDetails animationRequest)
    {
        // Jumping Jack. 870
        animationRequest.setAnimationToPlay(AnimationID.EMOTE_STARJUMP_5);
        animationRequest.setUseLinearTween(false);
        animationRequest.setMovementSpeedMultiplier(2.0);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a small hop animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_LONGJUMP} animation
     */
    public static void applySmallHop(
            final AnimationRequestDetails animationRequest)
    {
        // Small hop. 807
        animationRequest.setAnimationToPlay(AnimationID.HUMAN_LONGJUMP);
        animationRequest.setMovementSpeedMultiplier(3.0);
        animationRequest.setStartingFrame(7);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a side-step left animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_WALK_L} animation
     */
    public static void applySideStepLeft(
            final AnimationRequestDetails animationRequest)
    {
        // SIDE STEP LEFT. 821
        animationRequest.setAnimationToPlay(AnimationID.HUMAN_WALK_L);
        animationRequest.setMovementSpeedMultiplier(1.5);
        animationRequest.setAnimationSpeed(2);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a small side-step animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_ZAMORAKSPEAR_TURNONSPOT}
     * animation
     */
    public static void applySmallSideStep(
            final AnimationRequestDetails animationRequest)
    {
        // side step small. 1702
        animationRequest.setAnimationToPlay(
                AnimationID.HUMAN_ZAMORAKSPEAR_TURNONSPOT);
        animationRequest.setUseLinearTween(true);
        animationRequest.setMovementSpeedMultiplier(1.0);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(0);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a far jump forward animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#OVERLOG} animation
     */
    public static void applyFarJumpForward(
            final AnimationRequestDetails animationRequest)
    {
        // Super far jump forward. 2750
        animationRequest.setAnimationToPlay(AnimationID.OVERLOG);
        animationRequest.setUseLinearTween(false);
        animationRequest.setMovementSpeedMultiplier(1.6);
        animationRequest.setAnimationSpeed(2);
        animationRequest.setStartingFrame(2);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a big jump animation to the provided
     * {@link AnimationRequestDetails}.
     * <p>
     * Note {@link AnimationRequestDetails#setResetAnimationOnNewTile(boolean)}
     * is called with {@code true} as a side effect of applying this animation.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_JUMP_STONES} animation
     */
    public static void applyBigJump(
            final AnimationRequestDetails animationRequest)
    {
        animationRequest.setResetAnimationOnNewTile(true);
        // 1604
        animationRequest.setAnimationToPlay(AnimationID.HUMAN_JUMP_STONES);
        animationRequest.setUseLinearTween(false);
        animationRequest.setMovementSpeedMultiplier(1.5);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setStartingFrame(2);
        animationRequest.setEndingFrame(7);
        animationRequest.setAllowAnimationLoop(false);
    }

    /**
     * Applies a little jump animation to the provided
     * {@link AnimationRequestDetails}.
     *
     * @param animationRequest the animation request to apply changes to
     * @apiNote Uses the {@link AnimationID#HUMAN_SPOT_JUMP} animation
     */
    public static void applyLittleJump(
            final AnimationRequestDetails animationRequest)
    {
        // Little jump. 741
        animationRequest.setAnimationToPlay(AnimationID.HUMAN_SPOT_JUMP);
        animationRequest.setMovementSpeedMultiplier(2.0);
        animationRequest.setUseLinearTween(false);
        animationRequest.setStartingFrame(2);
        animationRequest.setAnimationSpeed(1);
        animationRequest.setEndingFrame(7);
        animationRequest.setAllowAnimationLoop(false);
    }
}
