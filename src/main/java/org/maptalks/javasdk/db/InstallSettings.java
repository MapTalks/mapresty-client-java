package org.maptalks.javasdk.db;

import com.alibaba.fastjson.annotation.JSONField;
import org.maptalks.geojson.CRS;

/**
 * Created by fuzhen on 2015/9/21.
 */
public class InstallSettings {
    private CRS crs;

    public InstallSettings() {

    }

    public InstallSettings(CRS crs) {
        this.crs = crs;
    }

    @JSONField(name="crs")
    public CRS getCRS() {
        return crs;
    }

    @JSONField(name="crs")
    public void setCRS(CRS crs) {
        this.crs = crs;
    }
}
