package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class TypePrestationPageDTO {
    List<TypePrestationDTO> pages;
    long totalItems;

    public List<TypePrestationDTO> getPages() {
        return pages;
    }

    public void setPages(List<TypePrestationDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
