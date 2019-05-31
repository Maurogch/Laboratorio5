package edu.utn.autos.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Connection;

@Data
@AllArgsConstructor
public abstract class BaseRepository {
    Connection connection;
}
