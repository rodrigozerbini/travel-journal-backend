package com.guerrero.traveljournal.mapper.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * Central configuration interface for all MapStruct mappers across the Travel Journal application.
 * Architectural Decisions:
 * 1. componentModel = MappingConstants.ComponentModel.SPRING:
 *    Registers generated mapper implementations as Spring Beans (@Component), allowing seamless
 *    dependency injection in Spring services.
 * 2. unmappedTargetPolicy = ReportingPolicy.IGNORE:
 *    Prevents compiler warnings for target fields that are deliberately not provided by incoming DTOs
 *    (e.g., database-generated IDs, audit timestamps like createdAt/updatedAt, or version fields).
 *    This reduces annotation noise while keeping builds clean.
 */
@MapperConfig(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CentralMapperConfig {
}