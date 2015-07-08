package com.edu.zju.bs.game.model.data;

import com.edu.zju.bs.game.util.PlatCoordinateRange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kehanyang on 15/7/8.
 */
public class Plat {

    List<Site> sites = new ArrayList<Site>();

    int centerX;
    int centerY;

    public static final int SIZE  = 5;

    private static final int CENTER_TOP = 335;

    private static final int CENTER_LEFT = 420;

    private static final int TOP_SCALE = 40;

    private static final int LEFT_SCALE = 80;

    public Plat(List<Site> sites, PlatCoordinateRange platCoordinateRange) {
        this.sites = sites;
        this.centerX = platCoordinateRange.getCenterX();
        this.centerY = platCoordinateRange.getCenterY();
        for (int i = 0; i < sites.size(); i++) {
            Site site = sites.get(i);
            site.setTop(((site.getY() - centerY) + (site.getX() - centerX)) * TOP_SCALE + CENTER_TOP);
            site.setLeft(((site.getX() - centerX) - (site.getY() - centerY)) * LEFT_SCALE + CENTER_LEFT);
            if (!site.getSiteType().equals("empty")) {
                site.setTop(site.getTop() - 5);
            }
        }
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}
