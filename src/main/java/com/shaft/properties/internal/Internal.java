package com.shaft.properties.internal;

import org.aeonbits.owner.Config.Sources;

@SuppressWarnings("unused")
@Sources({"system:properties",
        "file:src/main/resources/properties/internal.properties",
        "file:src/main/resources/properties/default/internal.properties",
        "classpath:internal.properties",
})
public interface Internal extends EngineProperties {
    @Key("shaftEngineVersion")
    @DefaultValue("7.4.20231015")
    String shaftEngineVersion();

    @Key("watermarkImagePath")
    @DefaultValue("https://raw.githubusercontent.com/ShaftHQ/SHAFT_ENGINE/main/src/main/resources/images/shaft_white_bg.png")
    String watermarkImagePath();

    @Key("allureVersion")
    @DefaultValue("2.21.0")
    String allureVersion();
}
