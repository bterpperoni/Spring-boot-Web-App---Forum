package mvc.mc.dh.adaptater.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<StoryJpaEntity, Long>{
    /*
        Inherits from JpaRepository which contains basic CRUD SQL operations
        No need to create them
     */
}