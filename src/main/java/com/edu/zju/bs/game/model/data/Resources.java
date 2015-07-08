package com.edu.zju.bs.game.model.data;

import com.edu.zju.bs.game.exception.ResourceNotEnoughException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kehanyang on 15/7/8.
 */
public class Resources {

    static final ResourceType[] resourceTypes = ResourceType.values();

    List<Resource> resourceList = new ArrayList<Resource>(resourceTypes.length);

    public Resources() {
        for (int i = 0; i < resourceTypes.length; i++) {
            resourceList.add(null);
        }
        int[] numbers = new int[resourceTypes.length];
        setResources(numbers);
    }

    private void setResources(int[] numbers) {
        int i = 0;
        for (; i < numbers.length && i < resourceTypes.length; i++) {
            resourceList.set(i, new Resource(resourceTypes[i], numbers[i]));
        }
        for (; i < resourceTypes.length; i++) {
            resourceList.set(i, new Resource(resourceTypes[i]));
        }
    }

    public void increase(int index, int number) throws ResourceNotEnoughException {
        Resource resource = resourceList.get(index);
        resource.increase(number);
    }

    public String getResources() {
        return toString();
    }

    public void setResources(String resourceInfo) {
        String[] temp = resourceInfo.split(",");
        int[] numbers = new int[resourceTypes.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.valueOf(temp[i]);
        }
        setResources(numbers);
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < resourceList.size(); i++) {
            result.append(resourceList.get(i).getNumber());
            if (i < resourceList.size() - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }
}
