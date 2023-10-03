package cz.eg.hr.data;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JavascriptFramework {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

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

    @Column(nullable = false)
    private Long version;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private int reating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavascriptFramework that))
            return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "JavaScriptFramework [id=" + id + ", name=" + name + "]";
    }

}

