package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class TypePageDTO {
    List<TypeDTO> pages;
    long totalItems;

    public List<TypeDTO> getPages() {
        return pages;
    }

    public void setPages(List<TypeDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
