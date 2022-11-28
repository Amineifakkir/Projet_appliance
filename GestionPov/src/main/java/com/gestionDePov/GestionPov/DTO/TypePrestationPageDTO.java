package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class TypePrestationPageDTO {
    List<TypePageDTO> pages;
    long totalItems;

    public List<TypePageDTO> getPages() {
        return pages;
    }

    public void setPages(List<TypePageDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
