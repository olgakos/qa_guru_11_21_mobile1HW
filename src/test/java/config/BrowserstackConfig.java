package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        //!!!
        "classpath:BrowserstackCredentials.properties"
})
public interface BrowserstackConfig extends Config
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