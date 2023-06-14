package info.kcdc.runnerz.repository;

import info.kcdc.runnerz.model.Location;
import info.kcdc.runnerz.model.Run;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RunRepository extends ListCrudRepository<Run,Integer> {

    List<Run> findRunsByTitleStartingWith(String title);
    List<Run> findRunsByLocation(Location location);
    List<Run> findRunsByMilesIsAndLocationIs(Integer miles, Location location);
    List<Run> findRunsByStartedOnAfterAndMilesGreaterThan(LocalDateTime d, Integer miles);
    List<Run> findRunsByStartedOnAfterAndMilesGreaterThanEqual(LocalDateTime d, Integer miles);

    @Query("""
        SELECT * FROM Run
        where miles = :miles
    """)
    List<Run> listRunsWhereMilesEquals(@Param("miles") Integer miles);

}