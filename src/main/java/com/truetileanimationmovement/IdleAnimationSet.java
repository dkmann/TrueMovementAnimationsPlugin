package com.truetileanimationmovement;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdleAnimationSet
{
    private int idleRotateLeft = 0;
    private int idleRotateRight = 0;
    private int walkAnimation = 0;
    private int walkRotateLeft = 0;
    private int walkRotateRight = 0;
    private int walkRotate180 = 0;
    private int idlePoseAnimation = 0;
    private int runAnimation = 0;

    @Setter(AccessLevel.NONE)
    private String uniqueLabel;

    public void cacheUniqueLabel()
    {
        uniqueLabel = String.valueOf(idleRotateLeft) +
                String.valueOf(idleRotateRight) +
                String.valueOf(walkAnimation) +
                String.valueOf(walkRotateLeft) +
                String.valueOf(walkRotateRight) +
                String.valueOf(walkRotate180) +
                String.valueOf(idlePoseAnimation) +
                String.valueOf(runAnimation);
    }

}
