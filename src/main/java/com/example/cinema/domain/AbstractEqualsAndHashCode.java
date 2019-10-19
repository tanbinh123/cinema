package com.example.cinema.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public abstract class AbstractEqualsAndHashCode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public AbstractEqualsAndHashCode(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof AbstractEqualsAndHashCode )) return false;

        AbstractEqualsAndHashCode other = (AbstractEqualsAndHashCode) obj;
        return id != null && id.equals(other.getId());

    }
    @Override
    public int hashCode(){ return 31;}
}
