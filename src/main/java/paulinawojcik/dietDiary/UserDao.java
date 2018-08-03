package paulinawojcik.dietDiary;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User,Long> {


}
