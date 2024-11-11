package ru.learning.managerapp.controller.payload;

public record UpdateProductPayload(
        String title,
        String details
) {
}
