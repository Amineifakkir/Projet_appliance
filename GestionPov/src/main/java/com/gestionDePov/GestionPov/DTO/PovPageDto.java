package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class PovPageDto {
    List<POVDTO> pages;
    long totalItems;

    public List<POVDTO> getPages() {
        return pages;
    }

    public void setPages(List<POVDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
