package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class ContactPageDto {
    List<ContactDTO> pages;
    long totalItems;

    public List<ContactDTO> getPages() {
        return pages;
    }

    public void setPages(List<ContactDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
