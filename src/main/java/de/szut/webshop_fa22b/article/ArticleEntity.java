package de.szut.webshop_fa22b.article;

import de.szut.webshop_fa22b.supplier.SupplierEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @NotNull
    private String designation;

    private Double price;

    @Column(name="create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name="update_date", nullable = false)
    private LocalDateTime updateDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private SupplierEntity supplier;
}
