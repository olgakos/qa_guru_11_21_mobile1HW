package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:validation.properties"
})
public interface BrowserstackConfig extends Config // ValidationConfig
{
    @Key("user")
    String user();

    @Key("password")
    String password();

    @Key("app")
    String app();

    @Key("url")
    String url();
}