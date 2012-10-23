package com.specimen.inventory.model;

import java.io.Serializable;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class PostOperativeBehavior implements Serializable {

    private String behaviorTime;
    private String behaviorDescription;

    public String getBehaviorTime() {
        return behaviorTime;
    }

    public void setBehaviorTime(String behaviorTime) {
        this.behaviorTime = behaviorTime;
    }

    public String getBehaviorDescription() {
        return behaviorDescription;
    }

    public void setBehaviorDescription(String behaviorDescription) {
        this.behaviorDescription = behaviorDescription;
    }
}
