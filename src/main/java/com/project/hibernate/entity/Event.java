package com.project.hibernate.entity;



import org.codehaus.jackson.annotate.JsonSubTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

    @JsonSubTypes.Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Location location;

    @JsonSubTypes.Type(
            type = "jsonb",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = TypeReferenceFactory.FACTORY_CLASS,
                            value = "com.vladmihalcea.hibernate.type.json.PostgreSQLGenericJsonBinaryTypeTest$AlternativeLocationsTypeReference"
                    )
            }
    )
    @Column(columnDefinition = "jsonb")
    private List<Location> alternativeLocations = new ArrayList<Location>();

    //Getters and setters omitted for brevity
}