/*
 * This file is generated by jOOQ.
 */
package ca.nanometrics.halo.db.tables.pojos;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;
import java.time.Instant;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetInstance implements VertxPojo, Serializable {

    private static final long serialVersionUID = 445675969;

    private Integer assetInstanceId;
    private Integer organizationId;
    private Integer assetId;
    private Integer templateId;
    private Object  additionalConfiguration;
    private Instant createdAt;
    private Instant updatedAt;

    public AssetInstance() {}

    public AssetInstance(AssetInstance value) {
        this.assetInstanceId = value.assetInstanceId;
        this.organizationId = value.organizationId;
        this.assetId = value.assetId;
        this.templateId = value.templateId;
        this.additionalConfiguration = value.additionalConfiguration;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public AssetInstance(
        Integer assetInstanceId,
        Integer organizationId,
        Integer assetId,
        Integer templateId,
        Object  additionalConfiguration,
        Instant createdAt,
        Instant updatedAt
    ) {
        this.assetInstanceId = assetInstanceId;
        this.organizationId = organizationId;
        this.assetId = assetId;
        this.templateId = templateId;
        this.additionalConfiguration = additionalConfiguration;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getAssetInstanceId() {
        return this.assetInstanceId;
    }

    public AssetInstance setAssetInstanceId(Integer assetInstanceId) {
        this.assetInstanceId = assetInstanceId;
        return this;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public AssetInstance setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public Integer getAssetId() {
        return this.assetId;
    }

    public AssetInstance setAssetId(Integer assetId) {
        this.assetId = assetId;
        return this;
    }

    public Integer getTemplateId() {
        return this.templateId;
    }

    public AssetInstance setTemplateId(Integer templateId) {
        this.templateId = templateId;
        return this;
    }


    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public Object getAdditionalConfiguration() {
        return this.additionalConfiguration;
    }


    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public AssetInstance setAdditionalConfiguration(Object additionalConfiguration) {
        this.additionalConfiguration = additionalConfiguration;
        return this;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public AssetInstance setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public AssetInstance setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final AssetInstance other = (AssetInstance) obj;
        if (assetInstanceId == null) {
            if (other.assetInstanceId != null)
                return false;
        }
        else if (!assetInstanceId.equals(other.assetInstanceId))
            return false;
        if (organizationId == null) {
            if (other.organizationId != null)
                return false;
        }
        else if (!organizationId.equals(other.organizationId))
            return false;
        if (assetId == null) {
            if (other.assetId != null)
                return false;
        }
        else if (!assetId.equals(other.assetId))
            return false;
        if (templateId == null) {
            if (other.templateId != null)
                return false;
        }
        else if (!templateId.equals(other.templateId))
            return false;
        if (additionalConfiguration == null) {
            if (other.additionalConfiguration != null)
                return false;
        }
        else if (!additionalConfiguration.equals(other.additionalConfiguration))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!createdAt.equals(other.createdAt))
            return false;
        if (updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        }
        else if (!updatedAt.equals(other.updatedAt))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.assetInstanceId == null) ? 0 : this.assetInstanceId.hashCode());
        result = prime * result + ((this.organizationId == null) ? 0 : this.organizationId.hashCode());
        result = prime * result + ((this.assetId == null) ? 0 : this.assetId.hashCode());
        result = prime * result + ((this.templateId == null) ? 0 : this.templateId.hashCode());
        result = prime * result + ((this.additionalConfiguration == null) ? 0 : this.additionalConfiguration.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AssetInstance (");

        sb.append(assetInstanceId);
        sb.append(", ").append(organizationId);
        sb.append(", ").append(assetId);
        sb.append(", ").append(templateId);
        sb.append(", ").append(additionalConfiguration);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }

    public AssetInstance(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public AssetInstance fromJson(io.vertx.core.json.JsonObject json) {
        setAssetInstanceId(json.getInteger("asset_instance_id"));
        setOrganizationId(json.getInteger("organization_id"));
        setAssetId(json.getInteger("asset_id"));
        setTemplateId(json.getInteger("template_id"));
        // Omitting unrecognized type java.lang.Object for column additional_configuration!
        setCreatedAt(json.getInstant("created_at"));
        setUpdatedAt(json.getInstant("updated_at"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("asset_instance_id",getAssetInstanceId());
        json.put("organization_id",getOrganizationId());
        json.put("asset_id",getAssetId());
        json.put("template_id",getTemplateId());
        // Omitting unrecognized type java.lang.Object for column additional_configuration!
        json.put("created_at",getCreatedAt());
        json.put("updated_at",getUpdatedAt());
        return json;
    }

}
