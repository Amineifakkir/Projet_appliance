package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class SuiviPageDTO {

    List<SuiviDTO> pages;
    long totalItems;

    public List<SuiviDTO> getPages() {
        return pages;
    }

    public void setPages(List<SuiviDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
