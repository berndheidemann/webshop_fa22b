package de.szut.webshop_fa22b.supplier;


import de.szut.webshop_fa22b.article.ArticleEntity;
import de.szut.webshop_fa22b.contact.ContactEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @NotBlank
    @Size(max = 50, message = "Name must be less than 50 characters")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ContactEntity contact;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ArticleEntity> articles;
}
