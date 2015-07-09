package com.edu.zju.bs.game.model.database;

import com.edu.zju.bs.game.model.data.*;
import com.edu.zju.bs.game.util.PlatCoordinateRange;
import com.ibatis.sqlmap.client.SqlMapClient;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by kehanyang on 15/7/8.
 */
public class PlatTable {

    private SqlMapClient sqlMapClient;

    public PlatTable(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public void initial() {
        try {
            sqlMapClient.update("createPlat");
            List list = sqlMapClient.queryForList("selectSiteByPlatCoordinateRange", new PlatCoordinateRange(0, 0));
            if (list.size() == 0) {
                for (int x = 0; x < PlatCoordinateRange.MAX_RANGE; x++) {
                    for (int y = 0; y < PlatCoordinateRange.MAX_RANGE; y++) {
                        Site site = new Site(x, y);
                        double r = Math.random();
                        if (r < 0.15) {
                            site.setSiteType("npcCity");
                            SoldierType[] soldierTypes = SoldierType.values();
                            StringBuilder temp = new StringBuilder();
                            for (int i = 0; i < soldierTypes.length; i++) {
                                temp.append((int)((soldierTypes[soldierTypes.length - 1].getHealth() * soldierTypes[0].getHealth() / soldierTypes[i].getHealth()) * Math.random()));
                                if (i < soldierTypes.length - 1) {
                                    temp.append(",");
                                }
                            }
                            site.setArmy(temp.toString());
                            temp = new StringBuilder();
                            ResourceType[] resourceType = ResourceType.values();
                            for (int i = 0; i < resourceType.length; i++) {
                                temp.append((int)(10000 * Math.random()));
                                if (i < resourceType.length - 1) {
                                    temp.append(",");
                                }
                            }
                            site.setResources(temp.toString());
                        } else {
                            site.setSiteType("empty");
                        }
                        insertSite(site);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Site getSite(int playerCityId) {
        try {
            return (Site) sqlMapClient.queryForObject("selectSiteByPlayerCityId", playerCityId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Site getSite(int x, int y) {
        try {
            return (Site) sqlMapClient.queryForObject("selectSiteByCoordinate", new Site(x, y));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Plat getPlat(PlatCoordinateRange platCoordinateRange) {
        try {
            return new Plat(sqlMapClient.queryForList("selectSiteByPlatCoordinateRange", platCoordinateRange), platCoordinateRange);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int insertSite(Site site) {
        try {
            sqlMapClient.insert("insertSite", site);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void update(Site site) {
        try {
            sqlMapClient.update("updatePlatBySite", site);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}