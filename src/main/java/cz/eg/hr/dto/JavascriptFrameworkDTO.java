package cz.eg.hr.dto;

import cz.eg.hr.mapper.JavascriptFrameworkMapper;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor

public class JavascriptFrameworkDTO {
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavascriptFrameworkDTO that))
            return false;
        return getReating() == that.getReating() && Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getVersion(), getDate(), getReating());
    }

    private Long version;
    private LocalDateTime date;
    private int reating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getReating() {
        return reating;
    }

    public void setReating(int reating) {
        this.reating = reating;
    }
}

