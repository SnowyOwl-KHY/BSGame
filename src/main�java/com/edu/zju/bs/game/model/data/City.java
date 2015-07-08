package com.edu.zju.bs.game.model.data;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kehanyang on 15/7/6.
 */
public class City {

    String username;

    ArrayList<Building> buildings = new ArrayList<Building>(Building.SIZE * Building.SIZE);

    Army army = new Army();

    Resources resources = new Resources();

    public City() {
        for (int i = 0; i < Building.SIZE * Building.SIZE; i++) {
            buildings.add(new Building(i));
        }
    }

    public City(String username) {
        this();
        this.username = username;
    }

    public City(String username, String buildingsInfo, String armyInfo, String resourcesInfo) {
        this();
        this.username = username;
        setBuildings(buildingsInfo);
        setArmy(armyInfo);
        setResources(resourcesInfo);
    }

    public void  increaseResources(int index, int number) {
        resources.increase(index, number);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBuildings() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < buildings.size(); i++) {
            result.append(buildings.get(i).getType().getName());
            result.append(":");
            result.append(buildings.get(i).getLevel());
            if (i < buildings.size() - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

    public String getArmy() {
        return army.getSoldiers();
    }

    public void setArmy(String armyInfo) {
        army.setSoldiers(armyInfo);
    }

    public List<Soldier> getSoldierList() {
        return army.getSoldierList();
    }

    public String getResources() {
        return resources.getResources();
    }

    public void setResources(String resourcesInfo) {
        resources.setResources(resourcesInfo);
    }

    public List<Resource> getResourceList() {
        return resources.getResourceList();
    }

    public List<Building> getBuildingList() {
        return buildings;
    }

    public void setBuildings(String buildingsInfo) {
        String[] strBuildingsInfo = buildingsInfo.split(",");
        for (int i = 0; i < strBuildingsInfo.length; i++) {
            String[] strBuilding = strBuildingsInfo[i].split(":");
            Building building = new Building(BuildingType.getType(strBuilding[0]), i, Integer.valueOf(strBuilding[1]));
            buildings.set(i, building);
        }
    }

    public void build(Building building) {
        buildings.set(building.getId(), building);
    }
}
