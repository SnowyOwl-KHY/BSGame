package com.edu.zju.bs.game.model.data;

import com.edu.zju.bs.game.exception.ResourceNotEnoughException;

/**
 * Created by kehanyang on 15/7/8.
 */
public class Resource {

    ResourceType type;
    int number;

    public Resource(ResourceType type) {
        this.type = type;
    }

    public Resource(ResourceType type, int number) {
        this.type = type;
        this.number = number;
    }

    public void increase(int number) throws ResourceNotEnoughException {
        if (this.number + number < 0) {
            throw new ResourceNotEnoughException("You need more " + type.getName());
        }
        this.number += number;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
