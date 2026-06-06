package com.waterplatform.repository;

import com.waterplatform.model.RoutePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoutePointRepository extends JpaRepository<RoutePoint, String> {
    List<RoutePoint> findByRouteIdOrderByOrderIndex(String routeId);
}
