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
public class Deployment implements VertxPojo, Serializable {

    private static final long serialVersionUID = 583143094;

    private Integer deploymentId;
    private String  deploymentName;
    private Integer organizationId;
    private Instant createdAt;
    private Instant updatedAt;

    public Deployment() {}

    public Deployment(Deployment value) {
        this.deploymentId = value.deploymentId;
        this.deploymentName = value.deploymentName;
        this.organizationId = value.organizationId;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Deployment(
        Integer deploymentId,
        String  deploymentName,
        Integer organizationId,
        Instant createdAt,
        Instant updatedAt
    ) {
        this.deploymentId = deploymentId;
        this.deploymentName = deploymentName;
        this.organizationId = organizationId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getDeploymentId() {
        return this.deploymentId;
    }

    public Deployment setDeploymentId(Integer deploymentId) {
        this.deploymentId = deploymentId;
        return this;
    }

    public String getDeploymentName() {
        return this.deploymentName;
    }

    public Deployment setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
        return this;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public Deployment setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Deployment setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Deployment setUpdatedAt(Instant updatedAt) {
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
        final Deployment other = (Deployment) obj;
        if (deploymentId == null) {
            if (other.deploymentId != null)
                return false;
        }
        else if (!deploymentId.equals(other.deploymentId))
            return false;
        if (deploymentName == null) {
            if (other.deploymentName != null)
                return false;
        }
        else if (!deploymentName.equals(other.deploymentName))
            return false;
        if (organizationId == null) {
            if (other.organizationId != null)
                return false;
        }
        else if (!organizationId.equals(other.organizationId))
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
        result = prime * result + ((this.deploymentId == null) ? 0 : this.deploymentId.hashCode());
        result = prime * result + ((this.deploymentName == null) ? 0 : this.deploymentName.hashCode());
        result = prime * result + ((this.organizationId == null) ? 0 : this.organizationId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Deployment (");

        sb.append(deploymentId);
        sb.append(", ").append(deploymentName);
        sb.append(", ").append(organizationId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }

    public Deployment(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public Deployment fromJson(io.vertx.core.json.JsonObject json) {
        setDeploymentId(json.getInteger("deployment_id"));
        setDeploymentName(json.getString("deployment_name"));
        setOrganizationId(json.getInteger("organization_id"));
        setCreatedAt(json.getInstant("created_at"));
        setUpdatedAt(json.getInstant("updated_at"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("deployment_id",getDeploymentId());
        json.put("deployment_name",getDeploymentName());
        json.put("organization_id",getOrganizationId());
        json.put("created_at",getCreatedAt());
        json.put("updated_at",getUpdatedAt());
        return json;
    }

}
