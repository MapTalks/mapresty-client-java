package org.maptalks.javasdk.db;

import org.maptalks.gis.core.geojson.CRS;
import org.maptalks.gis.core.geojson.GeoJSON;


/**
 * Created by fuzhen on 2015/8/11.
 */
public enum CoordinateType {
    wgs84("wgs84"), gcj02("gcj02"), cgcs2000("cgcs2000"), bd09ll("bd09ll"), pixel("pixel"),DEFAULT("gcj02");

    private final String type;

    CoordinateType(String type) {
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type;
    }

    public static CoordinateType getInstance(String t) {
        try {
            return CoordinateType.valueOf(t);
        } catch (Throwable e) {
            return null;
        }
    }

    /**
     * ��GeoJson�����л�ȡCoordinateType
     * @param geoJson
     * @return
     */
    public static CoordinateType getCoordinateTypeFromGeoJson(GeoJSON geoJson) {
        if (geoJson.getCrs() == null || geoJson.getCrs().getProperties() == null) {
            return null;
        }
        if (geoJson.getCrs().getType().equals("cnCoordinateType")) {
            Object s = geoJson.getCrs().getProperties().get("name");
            if (s != null) {
                return CoordinateType.getInstance(s.toString());
            }
        }
        return null;
    }

    /**
     * ����GeoJson�����CoordinateType
     * @param geoJson
     */
    public static void setCoordinateTypeToGeoJson(GeoJSON geoJson,CoordinateType coordinateType) {
        CRS crs = CRS.createCnCoordinateType(coordinateType.toString());
        geoJson.setCrs(crs);
    }


}
