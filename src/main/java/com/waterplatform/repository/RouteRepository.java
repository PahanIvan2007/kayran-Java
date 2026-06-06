package com.waterplatform.repository;

import com.waterplatform.model.Route;
import com.waterplatform.model.enums.RouteDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, String> {
    List<Route> findByDifficulty(RouteDifficulty d);
}
