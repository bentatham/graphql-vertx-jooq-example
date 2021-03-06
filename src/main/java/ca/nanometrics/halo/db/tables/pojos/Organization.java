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
public class Organization implements VertxPojo, Serializable {

    private static final long serialVersionUID = 2116685285;

    private Integer organizationId;
    private String  organizationName;
    private Instant createdAt;
    private Instant updatedAt;

    public Organization() {}

    public Organization(Organization value) {
        this.organizationId = value.organizationId;
        this.organizationName = value.organizationName;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Organization(
        Integer organizationId,
        String  organizationName,
        Instant createdAt,
        Instant updatedAt
    ) {
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public Organization setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public Organization setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Organization setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Organization setUpdatedAt(Instant updatedAt) {
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
        final Organization other = (Organization) obj;
        if (organizationId == null) {
            if (other.organizationId != null)
                return false;
        }
        else if (!organizationId.equals(other.organizationId))
            return false;
        if (organizationName == null) {
            if (other.organizationName != null)
                return false;
        }
        else if (!organizationName.equals(other.organizationName))
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
        result = prime * result + ((this.organizationId == null) ? 0 : this.organizationId.hashCode());
        result = prime * result + ((this.organizationName == null) ? 0 : this.organizationName.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Organization (");

        sb.append(organizationId);
        sb.append(", ").append(organizationName);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }

    public Organization(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public Organization fromJson(io.vertx.core.json.JsonObject json) {
        setOrganizationId(json.getInteger("organization_id"));
        setOrganizationName(json.getString("organization_name"));
        setCreatedAt(json.getInstant("created_at"));
        setUpdatedAt(json.getInstant("updated_at"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("organization_id",getOrganizationId());
        json.put("organization_name",getOrganizationName());
        json.put("created_at",getCreatedAt());
        json.put("updated_at",getUpdatedAt());
        return json;
    }

}
