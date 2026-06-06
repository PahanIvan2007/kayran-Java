package com.waterplatform.repository;

import com.waterplatform.model.Point;
import com.waterplatform.model.enums.PointType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, String> {
    List<Point> findByType(PointType type);
    List<Point> findByFranchiseId(String franchiseId);
}
