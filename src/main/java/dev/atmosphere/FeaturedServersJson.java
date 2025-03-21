package dev.atmosphere;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeaturedServersJson {
    @SerializedName("metadataJson")
    Metadata metadataJson;
    @SerializedName("responseJson")
    Response responseJson;
}

class Metadata {
    @SerializedName("acceptLanguage")
    String acceptLanguage;
    @SerializedName("cacheWriteDate")
    String cacheWriteDate;
    @SerializedName("clientVersion")
    String clientVersion;
    @SerializedName("requestedBy")
    String requestedBy;
}

class Entity {
    @SerializedName("Id")
    String id;
    @SerializedName("Type")
    String type;
    @SerializedName("TypeString")
    String typeString;
}

class Language {
    @SerializedName("NEUTRAL")
    String Neutral;
    @SerializedName("en-us")
    String en_us;
    @SerializedName("neutral")
    String neutral;
}

class KeywordsItem {
    @SerializedName("Values")
    List<Object> values;
}

class Keywords {
    @SerializedName("NEUTRAL")
    KeywordsItem Neutral;
    @SerializedName("en-us")
    KeywordsItem en_us;
    @SerializedName("neutral")
    KeywordsItem neutral;
}

class AvailableGames {
    @SerializedName("description")
    String description;
    @SerializedName("imageTag")
    String imageTag;
    @SerializedName("subtitle")
    String subtitle;
    @SerializedName("title")
    String title;
}

class DisplayProperties {
    @SerializedName("allowListUrl")
    String allowListUrl;
    @SerializedName("availableGames")
    List<AvailableGames> availableGames;
    @SerializedName("creatorName")
    String creatorName;
    @SerializedName("experienceId")
    String experienceId;
    @SerializedName("maxClientVersion")
    String maxClientVersion;
    @SerializedName("minClientVersion")
    String minClientVersion;
    @SerializedName("news")
    String news;
    @SerializedName("newsTitle")
    String newsTitle;
    @SerializedName("originalCreatorId")
    String originalCreatorId;
    @SerializedName("port")
    Integer port;
    @SerializedName("requireXBL")
    String requireXBL;
    @SerializedName("storePageId")
    String storePageId;
    @SerializedName("url")
    String url;
    @SerializedName("whitelistUrl")
    String whitelistUrl;
}

class Image {
    @SerializedName("Id")
    String id;
    @SerializedName("Tag")
    String tag;
    @SerializedName("Type")
    String type;
    @SerializedName("Url")
    String url;

    public Image(String id, String tag, String type, String url) {
        this.id = id;
        this.tag = tag;
        this.type = type;
        this.url = url;
    }
}

class Item {
    @SerializedName("AlternateIds")
    List<Object> AlternateIds;
    @SerializedName("ContentType")
    String ContentType;
    @SerializedName("Contents")
    List<Object> Contents;
    @SerializedName("CreationDate")
    String CreationDate;
    @SerializedName("CreatorEntity")
    Entity CreatorEntity;
    @SerializedName("CreatorEntityKey")
    Entity CreatorEntityKey;
    @SerializedName("DeepLinks")
    List<Object> DeepLinks;
    @SerializedName("Description")
    Language Description;
    @SerializedName("DisplayProperties")
    DisplayProperties DisplayProperties;
    @SerializedName("Id")
    String Id;
    @SerializedName("Images")
    List<Image> Images;
    @SerializedName("IsStackable")
    Boolean IsStackable;
    @SerializedName("ItemReferences")
    List<Object> ItemReferences;
    @SerializedName("Keywords")
    Keywords Keywords;
    @SerializedName("LastModifiedDate")
    String LastModifiedDate;
    @SerializedName("Platforms")
    List<String> Platforms;
    @SerializedName("SourceEntity")
    Entity SourceEntity;
    @SerializedName("SourceEntityKey")
    Entity SourceEntityKey;
    @SerializedName("Tags")
    List<String> Tags;
    @SerializedName("Title")
    Language Title;
    @SerializedName("Type")
    String Type;
}

class ResponseData {
    @SerializedName("ConfigurationName")
    String configurationName;
    @SerializedName("Count")
    Integer count;
    @SerializedName("Items")
    List<Item> items;
}

class Response {
    @SerializedName("code")
    Integer code;
    @SerializedName("data")
    ResponseData data;
    @SerializedName("status")
    String status;
}