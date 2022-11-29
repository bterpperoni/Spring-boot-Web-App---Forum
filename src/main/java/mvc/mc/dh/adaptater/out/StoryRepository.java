package mvc.mc.dh.adaptater.out;

//import mvc.mc.dh.adaptater.out.StoryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<StoryJpaEntity, Long>{
    /*
    List<StoryJpaEntity> findAll();
    StoryJpaEntity findById(int id);

     */
}