package mvc.mc.dh.adaptater.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepositery extends JpaRepository<StoryJpaEntity, Long>{
    
}