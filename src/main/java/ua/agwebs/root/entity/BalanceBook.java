package ua.agwebs.root.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BAL_BOOK")
public class BalanceBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "BAL_BOOK_ID")
    @TableGenerator(name = "BalanceBookIdGen",
            table = "KEY_GEN",
            pkColumnName = "KEY_NM",
            valueColumnName = "KEY_VAL",
            pkColumnValue = "BAL_BOOK_ID",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BalanceBookIdGen")
    private Long id;

    @Column(name = "BAL_BOOK_NM", nullable = false, length = 25)
    private String name;

    @Column(name = "BAL_BOOK_DESC", length = 60)
    private String desc;

    @Column(name = "BAL_BOOK_DEL", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean deleted;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<BalanceAccount> accounts = new HashSet<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<EntryHeader> entryHeaders = new HashSet<>();

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<BalanceAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BalanceAccount account) {
        this.accounts.add(account);
    }

    public Set<EntryHeader> getEntryHeaders() {
        return entryHeaders;
    }

    public void addEntryHeader(EntryHeader entryHeader) {
        this.entryHeaders.add(entryHeader);
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BalanceBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalanceBook that = (BalanceBook) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        return deleted != null ? deleted.equals(that.deleted) : that.deleted == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }
}
