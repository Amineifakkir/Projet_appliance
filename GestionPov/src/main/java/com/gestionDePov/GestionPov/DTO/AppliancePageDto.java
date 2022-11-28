package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class AppliancePageDto {
    List<ApplianceDTO> pages;
    long totalItems;

    public List<ApplianceDTO> getPages() {
        return pages;
    }

    public void setPages(List<ApplianceDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
