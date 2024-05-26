package com.motorny.ss.chemistryservice.config;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Data {

    @Getter
    private static final List<ProductDto> productDtos = Arrays.asList(
            new ProductDto(65L, 9L, 11L, BigDecimal.valueOf(1), "Для делікатних тканин", LocalDate.of(2026, 5, 9)),
            new ProductDto(68L, 9L, 11L, BigDecimal.valueOf(33.20), "", LocalDate.of(2025, 1, 5)),
            new ProductDto(70L, 7L, 6L, BigDecimal.valueOf(53.05), "", LocalDate.of(2026, 1, 15)),
            new ProductDto(67L, 7L, 4L, BigDecimal.valueOf(85.52), "", LocalDate.of(2026, 2, 12)),
            new ProductDto(56L, 4L, 2L, BigDecimal.valueOf(96.00), "Для всіх типів тканин", LocalDate.of(2028, 2, 2)),
            new ProductDto(60L, 7L, 1L, BigDecimal.valueOf(103.48), "Для делікатних тканин", LocalDate.of(2024, 8, 20)),
            new ProductDto(63L, 11L, 1L, BigDecimal.valueOf(128.25), "Для делікатних тканин", LocalDate.of(2025, 6, 5)),
            new ProductDto(66L, 3L, 4L, BigDecimal.valueOf(129.00), "", LocalDate.of(2025, 12, 18)),
            new ProductDto(61L, 11L, 1L, BigDecimal.valueOf(129.00), "Для кольорових тканин", LocalDate.of(2027, 10, 30)),
            new ProductDto(2078L, 11L, 1L, BigDecimal.valueOf(129.00), "Для кольорових тканин", LocalDate.of(2027, 10, 30)),
            new ProductDto(62L, 7L, 1L, BigDecimal.valueOf(157.50), "Для делікатних тканин", LocalDate.of(2024, 12, 1)),
            new ProductDto(1071L, 2L, 2L, BigDecimal.valueOf(178.00), "Для всіх типів тканини", LocalDate.of(2025, 10, 1)),
            new ProductDto(57L, 9L, 2L, BigDecimal.valueOf(217.82), "Для всіх типів тканин", LocalDate.of(2025, 9, 30)),
            new ProductDto(1077L, 7L, 2L, BigDecimal.valueOf(235.95), "Для всіх типів тканин", LocalDate.of(2026, 8, 15)),
            new ProductDto(55L, 7L, 2L, BigDecimal.valueOf(288.00), "Для кольорових тканин", LocalDate.of(2025, 6, 6)),
            new ProductDto(1079L, 1L, 2L, BigDecimal.valueOf(300.11), "Для всіх типів тканин", LocalDate.of(2026, 6, 6)),
            new ProductDto(49L, 1L, 2L, BigDecimal.valueOf(350.29), "Для всіх типів тканин", LocalDate.of(2027, 3, 30)),
            new ProductDto(1080L, 2L, 4L, BigDecimal.valueOf(366.11), "Для всіх типів тканин", LocalDate.of(2027, 6, 6)),
            new ProductDto(1072L, 2L, 2L, BigDecimal.valueOf(374.00), "Для кольорової тканини", LocalDate.of(2025, 10, 1)),
            new ProductDto(58L, 5L, 1L, BigDecimal.valueOf(471.77), "Для кольорових тканин", LocalDate.of(2026, 3, 2)),
            new ProductDto(50L, 1L, 2L, BigDecimal.valueOf(483.08), "Для кольорових тканин", LocalDate.of(2027, 3, 20)),
            new ProductDto(1074L, 5L, 2L, BigDecimal.valueOf(564.00), "Для всіх типів тканини", LocalDate.of(2026, 2, 13)),
            new ProductDto(59L, 1L, 1L, BigDecimal.valueOf(775.15), "Для кольорових тканин", LocalDate.of(2024, 5, 2)),
            new ProductDto(1073L, 7L, 2L, BigDecimal.valueOf(837.00), "Для делікатних тканин", LocalDate.of(2026, 1, 23)),
            new ProductDto(64L, 1L, 3L, BigDecimal.valueOf(1017.53), "Для всіх типів тканин", LocalDate.of(2024, 5, 25))
    );
}
