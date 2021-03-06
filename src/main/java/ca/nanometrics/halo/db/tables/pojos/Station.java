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
public class Station implements VertxPojo, Serializable {

    private static final long serialVersionUID = -584089751;

    private Integer stationId;
    private String  stationName;
    private Integer organizationId;
    private Integer deploymentId;
    private String  notes;
    private Instant createdAt;
    private Instant updatedAt;

    public Station() {}

    public Station(Station value) {
        this.stationId = value.stationId;
        this.stationName = value.stationName;
        this.organizationId = value.organizationId;
        this.deploymentId = value.deploymentId;
        this.notes = value.notes;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Station(
        Integer stationId,
        String  stationName,
        Integer organizationId,
        Integer deploymentId,
        String  notes,
        Instant createdAt,
        Instant updatedAt
    ) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.organizationId = organizationId;
        this.deploymentId = deploymentId;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getStationId() {
        return this.stationId;
    }

    public Station setStationId(Integer stationId) {
        this.stationId = stationId;
        return this;
    }

    public String getStationName() {
        return this.stationName;
    }

    public Station setStationName(String stationName) {
        this.stationName = stationName;
        return this;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public Station setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public Integer getDeploymentId() {
        return this.deploymentId;
    }

    public Station setDeploymentId(Integer deploymentId) {
        this.deploymentId = deploymentId;
        return this;
    }

    public String getNotes() {
        return this.notes;
    }

    public Station setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Station setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Station setUpdatedAt(Instant updatedAt) {
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
        final Station other = (Station) obj;
        if (stationId == null) {
            if (other.stationId != null)
                return false;
        }
        else if (!stationId.equals(other.stationId))
            return false;
        if (stationName == null) {
            if (other.stationName != null)
                return false;
        }
        else if (!stationName.equals(other.stationName))
            return false;
        if (organizationId == null) {
            if (other.organizationId != null)
                return false;
        }
        else if (!organizationId.equals(other.organizationId))
            return false;
        if (deploymentId == null) {
            if (other.deploymentId != null)
                return false;
        }
        else if (!deploymentId.equals(other.deploymentId))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        }
        else if (!notes.equals(other.notes))
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
        result = prime * result + ((this.stationId == null) ? 0 : this.stationId.hashCode());
        result = prime * result + ((this.stationName == null) ? 0 : this.stationName.hashCode());
        result = prime * result + ((this.organizationId == null) ? 0 : this.organizationId.hashCode());
        result = prime * result + ((this.deploymentId == null) ? 0 : this.deploymentId.hashCode());
        result = prime * result + ((this.notes == null) ? 0 : this.notes.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Station (");

        sb.append(stationId);
        sb.append(", ").append(stationName);
        sb.append(", ").append(organizationId);
        sb.append(", ").append(deploymentId);
        sb.append(", ").append(notes);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }

    public Station(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public Station fromJson(io.vertx.core.json.JsonObject json) {
        setStationId(json.getInteger("station_id"));
        setStationName(json.getString("station_name"));
        setOrganizationId(json.getInteger("organization_id"));
        setDeploymentId(json.getInteger("deployment_id"));
        setNotes(json.getString("notes"));
        setCreatedAt(json.getInstant("created_at"));
        setUpdatedAt(json.getInstant("updated_at"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("station_id",getStationId());
        json.put("station_name",getStationName());
        json.put("organization_id",getOrganizationId());
        json.put("deployment_id",getDeploymentId());
        json.put("notes",getNotes());
        json.put("created_at",getCreatedAt());
        json.put("updated_at",getUpdatedAt());
        return json;
    }

}
