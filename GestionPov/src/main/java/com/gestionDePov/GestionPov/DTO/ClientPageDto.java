package com.gestionDePov.GestionPov.DTO;

import java.util.List;

public class ClientPageDto {

    List<ClientDTO> pages;
    long totalItems;

    public List<ClientDTO> getPages() {
        return pages;
    }

    public void setPages(List<ClientDTO> pages) {
        this.pages = pages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
