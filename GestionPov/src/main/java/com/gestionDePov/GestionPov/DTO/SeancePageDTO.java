package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class SeancePageDTO {
    List<SeanceDTO> pages;
    long totalItems;

    public List<SeanceDTO> getPages() {
        return pages;
    }

    public void setPages(List<SeanceDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
